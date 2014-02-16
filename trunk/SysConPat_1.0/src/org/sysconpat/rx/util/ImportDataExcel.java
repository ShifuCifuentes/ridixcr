package org.sysconpat.rx.util;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.filechooser.FileFilter;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.rx.cr.util.Utilitarios;
import org.sysconpat.rx.be.BECatalogo;
import org.sysconpat.rx.be.BEClase;
import org.sysconpat.rx.be.BECuentaContable;
import org.sysconpat.rx.be.BEGrupoGenerico;
import org.sysconpat.rx.bl.BLCatalogo;
import org.sysconpat.rx.bl.BLClase;
import org.sysconpat.rx.bl.BLCuentaContable;
import org.sysconpat.rx.bl.BLGrupoGenerico;
import org.sysconpat.rx.gui.principal.*;

public class ImportDataExcel implements Runnable{
    private JFileChooser jfc = null;
    private File fuenteData=null;    
    private Workbook archivoExcel;
    private Sheet hoja_libro=null;
    //private Cell celda=null;
    private JProgressBar progess_bar;
    private JButton jbt1=null;
    private boolean isExporting=false;
    private boolean isInitExport=false;    
    private int cont_items=1;
    private JF_Principal root;
    private Thread hilo = null;
    
    private BECatalogo be=null;
    private BLCatalogo bl=null;
    private BECuentaContable be2=null;
    private BLCuentaContable bl2=null;
    private BEGrupoGenerico be3=null;
    private BLGrupoGenerico bl3=null;
    private BEClase be4=null;
    private BLClase bl4=null;

    public ImportDataExcel(JF_Principal root,JProgressBar jpb,JButton jb1) {   
     this.root=root;
     this.progess_bar=jpb;
     this.jbt1=jb1;    
     jfc = new JFileChooser(Utilitarios.getCurentPath());
     jfc.setDialogType(JFileChooser.OPEN_DIALOG);
     jfc.setDialogTitle("Seleccione el archivo Excel con la fuente de datos.");
     jfc.setMultiSelectionEnabled(false);
     jfc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }else{
                    if(f.isFile() && Utilitarios.fileExtencion(f).endsWith("xls")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            @Override
            public String getDescription() {
                return "Archivos Excel 97-2003";
            }
        });
     jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);   
     bl = new BLCatalogo(root.getConfig());
     bl2 = new BLCuentaContable(root.getConfig());
     bl3 = new BLGrupoGenerico(root.getConfig());
     bl4 = new BLClase(root.getConfig());
     ///Hilo de ejecucion
     hilo = new Thread(this);
     hilo.start();
    }
    
    public File selectDataFile(Component parent){
        try {
            int op = jfc.showDialog(parent,"Seleccionar");
            if (op==JFileChooser.APPROVE_OPTION) {
              fuenteData = jfc.getSelectedFile();              
            }else{
              fuenteData = null;
            }
        } catch (Exception e) {}
        return fuenteData;
    }
     
    public void iniciar_importacion_datos(){
        isExporting=true;
        isInitExport=true;
    }
    @Override
    public void run() {
        while (true) {      
            if (isExporting) {
              if(fuenteData!=null && isInitExport){
                    try {
                        archivoExcel = Workbook.getWorkbook(fuenteData);
                        hoja_libro = archivoExcel.getNumberOfSheets()>0?archivoExcel.getSheet(0):null;
                        int nc = hoja_libro!=null?hoja_libro.getColumns():0;
                        int nf = hoja_libro!=null && nc>=3?hoja_libro.getRows():0;            
                        progess_bar.setMaximum(nf); 
                        progess_bar.setMinimum(0);  
                        isInitExport=false;
                    } catch (IOException ex) {
                        Logger.getLogger(ImportDataExcel.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (BiffException ex) {
                        Logger.getLogger(ImportDataExcel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{   
                  try {
                    if (cont_items<progess_bar.getMaximum()) {
                        be = new BECatalogo();                
                        be2 = new BECuentaContable();
                        be3 = new BEGrupoGenerico();
                        be4 = new BEClase();
                        //CATALOGO BIEN           
                        be.setCodigo_patrimonial(hoja_libro.getCell(0,cont_items).getContents().trim());
                        be.setDenominacion(hoja_libro.getCell(1,cont_items).getContents().trim());
                        be.setClasificador(hoja_libro.getCell(4,cont_items).getContents().trim());
                        be.setCod_grupogenerico(Integer.parseInt(hoja_libro.getCell(5,cont_items).getContents().trim()));
                        be.setCodigo_clase(Integer.parseInt(hoja_libro.getCell(7,cont_items).getContents().trim()));
                        be.setAnio_vida(Integer.parseInt(hoja_libro.getCell(9,cont_items).getContents().trim()));
                        //CUENTA 
                        be2.setNro_cuenta_contable(hoja_libro.getCell(2,cont_items).getContents().trim());
                        be2.setNombre_cuenta_contable(hoja_libro.getCell(3,cont_items).getContents().trim());
                        be.setId_cuenta_contable(bl2.buscar(be2));
                        // GRUPO GENERICO
                        be3.setDenominacion(hoja_libro.getCell(6,cont_items).getContents().trim());
                        be.setId_grupogenerico(bl3.buscar(be3));
                        //CLASE
                        be4.setDenominacion(hoja_libro.getCell(8,cont_items).getContents().trim());
                        be.setId_clase(bl4.buscar(be4));
                        //CUENTA CO
                        be2.setNro_cuenta_contable(hoja_libro.getCell(10,cont_items).getContents().trim());
                        be2.setNombre_cuenta_contable(hoja_libro.getCell(11,cont_items).getContents().trim());
                        be.setId_cuenta_contable_co(bl2.buscar(be2));
                        bl.actualizar(be);
                        cont_items++;                        
                        progess_bar.setValue(cont_items);
                    }else{
                        isExporting=false;                        
                        cont_items=1;
                        //fuenteData=null;
                        archivoExcel=null;
                        hoja_libro=null;
                        JOptionPane.showMessageDialog(root,"Actualizacion de Catalogo Exitoso.","Atencion",JOptionPane.INFORMATION_MESSAGE);
                        progess_bar.setValue(0);
                        jbt1.setEnabled(true);
                    }
                  } catch (Exception e) {
                      Logger.getLogger(ImportDataExcel.class.getName()).log(Level.SEVERE, null, e);
                  }
                }   
               
            }
            try {Thread.sleep(100);} catch (InterruptedException ex) {}
        }
    }

    public void setProgessBar(JProgressBar progess_bar) {
        this.progess_bar = progess_bar;
    }
}
