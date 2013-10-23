package org.sysconpat.rx.util;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.rx.cr.conf.Config;
import org.rx.cr.util.Utilitarios;
import org.sysconpat.rx.be.BEUbigeo;
import org.sysconpat.rx.bl.BLUbigeo;

public class UtilUbigeo {
    private String defaultRegion;
    private String defaultProvincia;
    private String defaultDistrito;
    private Config conf;
    public UtilUbigeo(Config conf) {
        this.conf = conf;
    }

    
    public void recuperDatosUbigeo(int id_ubigeo,JComboBox cbxr,JComboBox cbxp,JComboBox cbxd){
            BEUbigeo bean=null;            
            BLUbigeo dao=null;
        try {
            dao = new BLUbigeo(conf);
            bean = dao.buscar(id_ubigeo);
            defeaultSelectedUbigeo(bean.getNombre_region().trim(),bean.getNombre_provincia().trim(),bean.getNombre_distrito().trim(),cbxr,cbxp,cbxd);             
        } catch (Exception ex) {
            Logger.getLogger(UtilUbigeo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void defeaultSelectedUbigeo(String reg,String prob, String dist,JComboBox cbxr,JComboBox cbxp,JComboBox cbxd){
        setDefaultRegion(reg);
        setDefaultProvincia(prob);
        setDefaultDistrito(dist);
        rellenaDepartamentos(cbxr, cbxp, cbxd,getDefaultRegion(),getDefaultProvincia(),getDefaultDistrito());  
    }
    
    public void selectDefaultRegion(JComboBox cbxr,JComboBox cbxp,JComboBox cbxd,String reg,String prob, String dist){
        for (int i = 0; i < cbxr.getItemCount(); i++) {
            BEUbigeo object = (BEUbigeo)cbxr.getItemAt(i);            
            if (i>0 && object.toString().toLowerCase().trim().equals(reg.toLowerCase().trim())) {                
                //cbxr.setSelectedIndex(i); o
                cbxr.setSelectedItem(object);
                
            }
        }       
    }
    public void selectDefaultProvincia(JComboBox cbxr,JComboBox cbxp,JComboBox cbxd,String reg,String prob, String dist){
        for (int i = 0; i < cbxp.getItemCount(); i++) {
                BEUbigeo object = (BEUbigeo)cbxp.getItemAt(i);                
                if (i>0 && object.toString().toLowerCase().trim().equals(prob.toLowerCase().trim())) {                   
                    //cbxp.setSelectedIndex(i); o
                    cbxp.setSelectedItem(object);
                    
                }                         
        }              
    }
    public void selectDefaultDistrito(JComboBox cbxr,JComboBox cbxp,JComboBox cbxd,String reg,String prob, String dist){
        for (int i = 0; i < cbxd.getItemCount(); i++) {
            BEUbigeo object = (BEUbigeo)cbxd.getItemAt(i);                        
            if (object.toString().toLowerCase().trim().equals(dist.toLowerCase().trim())) {               
                //cbxd.setSelectedIndex(i); o
                cbxd.setSelectedItem(object);
                
            }
        }
        
    }
    
    public void eventoComboRegion(JComboBox cbxr,JComboBox cbxp,JComboBox cbxd,JTextField txfcr,JTextField txfcp,JTextField txfcd){
     if (!cbxp.isPopupVisible()) {
            if (cbxr.getItemCount()>1) {
              if (cbxr.getSelectedIndex()>0) {
                  BEUbigeo obj = (BEUbigeo)cbxr.getSelectedItem();  
                  txfcp.setText("");
                  txfcd.setText("");
                  txfcr.setText(Utilitarios.numberFormat(obj.getCodigo_region(),"##"));                   
                  rellenaProvincias(cbxr,cbxp,cbxd,getDefaultRegion(),getDefaultProvincia(),getDefaultDistrito());   
              }else if(cbxr.getSelectedIndex()==0){ 
                cbxp.removeAllItems();
                cbxd.removeAllItems(); 
                cbxp.addItem(new BEUbigeo());
                cbxd.addItem(new BEUbigeo());
               txfcr.setText("");
               txfcp.setText("");
               txfcd.setText("");            
              }                    
              
            }
        }
    }
    public void eventoComboProvincia(JComboBox cbxr,JComboBox cbxp,JComboBox cbxd,JTextField txfcr,JTextField txfcp,JTextField txfcd){
     if(!cbxd.isPopupVisible()){
            if (cbxp.getItemCount()>1) {                     
              if (cbxp.getSelectedIndex()>0 && cbxr.getSelectedIndex()>0) {   
                  BEUbigeo obj = (BEUbigeo)cbxp.getSelectedItem();   
                  txfcd.setText("");
                  //txf_ubigeo.setText("");   
                  txfcp.setText(Utilitarios.numberFormat(obj.getCodigo_provincia(),"##")); 
                  rellenaDistritos(cbxr,cbxp,cbxd,getDefaultRegion(),getDefaultProvincia(),getDefaultDistrito());                                
              }else if(cbxp.getSelectedIndex()==0){   
               cbxd.removeAllItems();
               cbxd.addItem(new BEUbigeo());
               txfcp.setText("");
               //txf_ubigeo.setText("");
               txfcd.setText("");
               //txf_ubigeo.setText(""); 
              }          
              
            }                  
       }  
    }
    public void eventoComboDistrito(JComboBox cbxr,JComboBox cbxp,JComboBox cbxd,JTextField txfcr,JTextField txfcp,JTextField txfcd){
     if(!cbxp.isPopupVisible()){
            if (cbxd.getItemCount()>1) {                     
              if (cbxr.getSelectedIndex()>0 && cbxp.getSelectedIndex()>0 && cbxd.getSelectedIndex()>0) {  
                  BEUbigeo obj = (BEUbigeo)cbxd.getSelectedItem();                  
                  txfcd.setText(Utilitarios.numberFormat(obj.getCodigo_distrito(),"##"));
                  //txf_ubigeo.setText(""+obj.getId_ubigeo());                    
              }else if(cbxd.getSelectedIndex()==0){
               txfcd.setText("");
               //txf_ubigeo.setText("");
              }
            }                   
       }  
    }
    
    public void rellenaDepartamentos(JComboBox cbxr,JComboBox cbxp,JComboBox cbxd,String reg,String prob, String dist){
      if (conf!=null) {
           BEUbigeo bean=null;            
            BLUbigeo dao=null;
        try {
            dao = new BLUbigeo(conf);
            cbxr.removeAllItems();
            cbxp.removeAllItems();            
            cbxd.removeAllItems(); 
            cbxp.addItem(new BEUbigeo());
            cbxd.addItem(new BEUbigeo());
            cbxr.addItem(new BEUbigeo());            
            ArrayList<BEUbigeo> list = dao.listar_regiones();
             for (int i = 0; i < list.size(); i++) {
                 bean = list.get(i);
                 bean.setTipo_item(BEUbigeo.REGIONES);
                 cbxr.addItem(bean);
             }
             cbxr.setSelectedIndex(0);
             selectDefaultRegion(cbxr,cbxp,cbxd,reg,prob,dist);              
        } catch (Exception ex) {
            Logger.getLogger(UtilUbigeo.class.getName()).log(Level.SEVERE, null, ex);
        }    
      }         
    }
    public void rellenaProvincias(JComboBox cbxr,JComboBox cbxp,JComboBox cbxd,String reg,String prob, String dist){          
            BEUbigeo bean=null;            
            BLUbigeo dao=null;            
        try {
            cbxp.removeAllItems();            
            dao = new BLUbigeo(conf);
            bean = (BEUbigeo)cbxr.getSelectedItem();                      
            cbxp.removeAllItems(); 
            cbxp.addItem(new BEUbigeo());
            ArrayList<BEUbigeo> list = dao.listar_provincias_region(bean.getCodigo_region()); 
            for (int i = 0; i < list.size(); i++) {
                bean = list.get(i);
                bean.setTipo_item(BEUbigeo.PROVINCIAS);
                cbxp.addItem(bean);
            }
            cbxd.removeAllItems(); 
            cbxd.addItem(new BEUbigeo());
            cbxp.setSelectedIndex(0);
            selectDefaultProvincia(cbxr,cbxp,cbxd,reg,prob,dist);            
        } catch (Exception ex) {
            Logger.getLogger(UtilUbigeo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rellenaDistritos(JComboBox cbxr,JComboBox cbxp,JComboBox cbxd,String reg,String prob, String dist){         
            BEUbigeo bean=null;
            BEUbigeo bean2=null;
        try {
            cbxd.removeAllItems();
            BLUbigeo dao = new BLUbigeo(conf);       
            bean = (BEUbigeo)cbxr.getSelectedItem();
            bean2 = (BEUbigeo)cbxp.getSelectedItem();            
            cbxd.removeAllItems();      
            cbxd.addItem(new BEUbigeo());
            ArrayList<BEUbigeo> list = dao.listar_distritos_provincia_region(bean.getCodigo_region(),bean2.getCodigo_provincia());
            for (int i = 0; i < list.size(); i++) {
                bean = list.get(i);
                bean.setTipo_item(BEUbigeo.DISTRITOS);
                cbxd.addItem(list.get(i));
            }
            cbxd.setSelectedIndex(0);
            selectDefaultDistrito(cbxr,cbxp,cbxd,reg,prob,dist);
        } catch (Exception ex) {
            Logger.getLogger(UtilUbigeo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rellenaNaturalDeProvincia(int id,JTextField txf){          
            BEUbigeo bean=null;            
            BLUbigeo dao=null;            
        try {
            dao = new BLUbigeo(conf);
            bean = (BEUbigeo)dao.buscar(id);
            txf.setText(bean.getNombre_provincia());
        } catch (Exception ex) {
            Logger.getLogger(UtilUbigeo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getDefaultRegion() {
        return defaultRegion;
    }

    public void setDefaultRegion(String defaultRegion) {
        this.defaultRegion = defaultRegion;
    }

    public String getDefaultProvincia() {
        return defaultProvincia;
    }

    public void setDefaultProvincia(String defaultProvincia) {
        this.defaultProvincia = defaultProvincia;
    }

    public String getDefaultDistrito() {
        return defaultDistrito;
    }

    public void setDefaultDistrito(String defaultDistrito) {
        this.defaultDistrito = defaultDistrito;
    }
}
