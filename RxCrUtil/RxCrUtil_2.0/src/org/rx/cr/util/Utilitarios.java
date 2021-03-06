package org.rx.cr.util;

//<editor-fold defaultstate="collapsed" desc="Importaciones">
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.*;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.xml.bind.DatatypeConverter;
import org.rx.cr.util.gui.AWTUtilitiesWrapper;
import org.rx.cr.util.gui.JHourChooser;
import org.rx.cr.util.gui.ShapeDecorated;
import org.rx.cr.util.gui.UndecoratedMove;
//</editor-fold>

public final class Utilitarios extends JLabel implements Runnable{
    //<editor-fold defaultstate="collapsed" desc="Varibles Declaradas">    
    public static final String RidixCr="NTU2RTY3NzU2NTMyNkM3NDYzNDczOTc5NjQ0MzQyNzE1OTU4NUE2ODRDNjk3MDM5";
    public static String AUTOR=RidixCr;
    private static final String[] UNIDADES = {"", "uno ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
    private static final String[] DECENAS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ","diecisiete ",
                                             "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ","cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
    private static final String[] CENTENAS = {"", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
                                              "setecientos ", "ochocientos ", "novecientos "};
    
    public static String[] Dias_Semana = {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
    public static String[] Meses_Anio = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Setiembre","Octubre","Noviembre","Diciembre"};
    public static int[] Hora = {12,1,2,3,4,5,6,7,8,9,10,11,12,1,2,3,4,5,6,7,8,9,10,11};
    public static String[] Horario = {"a.m.","p.m."};
    public static final int HORA_SISTEMA=0;
    public static final int FECHA_SISTEMA=1;
  
    private int op=-1;    
    private Thread hilo;
    
    public static int ALFABETICO_NUMERICO=1,ALFABETICO=2,ALFABETICO_CM=3,ALFABETICO_NUMERICO_SPB=4,NUMERICO_REAL=5,NUMERICO=6,CARACTERES_COMPLETOS=7;
    //</editor-fold>   
    //<editor-fold defaultstate="collapsed" desc="Constructor">   
    static{AUTOR=decodeRx(AUTOR);}
    public Utilitarios(int util) {
        this.op=util;
        setHorizontalAlignment(JLabel.CENTER);
        setForeground(Color.WHITE);
        setFont(new java.awt.Font("Tahoma", 1, 11));
        hilo = new Thread(this);
        hilo.start();
    }    
    public Utilitarios() {}
    //</editor-fold>  
    //<editor-fold defaultstate="collapsed" desc="Funciones Base">
    //<editor-fold defaultstate="collapsed" desc="RUN">
    @Override
    public void run() {
        while (true) {            
            if (op!=-1) {
                Date hoy= new Date();    	
                if (op==HORA_SISTEMA) {
                    SimpleDateFormat hora= new SimpleDateFormat("h:mm:ss a");       
                setText(hora.format(hoy));  
                }else if(op==FECHA_SISTEMA){                 
                    SimpleDateFormat fecha= new SimpleDateFormat("E dd/MM/yyyy ");
                setText(fecha.format(hoy).toUpperCase());  
                }    
            }  
            try {Thread.sleep(100);} 
            catch (InterruptedException ex) {}
        }
    }  
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Number Format Util">
    public static String numberFormat(double src,String fmt){//Format : ###.####        
        fmt=fmt.replaceAll("#","0");
        DecimalFormat df = new DecimalFormat(fmt);
        return df.format(src);
    }
    public static String numberFormat(long  src,String fmt){//Format : ###.####        
        fmt=fmt.replaceAll("#","0");
        DecimalFormat df = new DecimalFormat(fmt);
        return df.format(src);
    }
    //</editor-fold>   
    //<editor-fold defaultstate="collapsed" desc="GUI Table Util">
    public static void inmovilizaColumnas(JTable table){
          table.getTableHeader().disable();
          /*table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);*/
         //table.setRowSelectionAllowed(false);
         table.getTableHeader().setReorderingAllowed(false);
    }
    public static void desabilitaCabecerasColumnas(JTable table){
          table.getTableHeader().disable();
    }
      public static void formateaAnchoColumnaTabla(int index,JTable table,int size){
          table.getColumnModel().getColumn(index).setResizable(false);
          table.getColumnModel().getColumn(index).setMinWidth(size);
          table.getColumnModel().getColumn(index).setWidth(size); 
          table.getColumnModel().getColumn(index).setMaxWidth(size);
      }
      public static void formateaAlturaCabecerasTabla(JTable table,int size){
          table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(),size));
      }
      public static void formateaColumnaRedimencionable(int index,JTable table,int size){
          table.getColumnModel().getColumn(index).setResizable(true);
          table.getColumnModel().getColumn(index).setMinWidth(size);       
          table.getColumnModel().getColumn(index).setMaxWidth(size+100);
      }   
      public static void alinearTextoCabeceraColumnaDerecha(int index,JTable table){
       //JTableHeader tch = new JTableHeader(table.getColumnModel());
       //tch.setDefaultRenderer(new DefaultTableCellHeaderRenderer());
       //TableCellRenderer rnd = new DefaultTableCellHeaderRenderer();
       TableCellRenderer render = new DefaultTableCellRenderer() {
         @Override
         public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
          JLabel componet = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                 componet.setHorizontalAlignment(SwingConstants.RIGHT); 
                 componet.setFont(new Font("Tahoma",Font.BOLD,11));
                 componet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
          return componet;
         }
        };
        table.getColumnModel().getColumn(index).setHeaderRenderer(render);
      }
      public static void alinearTextoCabeceraColumnaIzquierda(int index,JTable table){
       TableCellRenderer render = new DefaultTableCellRenderer() {
         @Override
         public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
          JLabel componet = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                 componet.setHorizontalAlignment(SwingConstants.LEFT);
                 componet.setFont(new Font("Tahoma",Font.BOLD,11));
                 componet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
          return componet;
         }
        };
        table.getColumnModel().getColumn(index).setHeaderRenderer(render);
      }
      public static void alinearTextoCabeceraColumnaCentro(int index,JTable table){
       TableCellRenderer render = new DefaultTableCellRenderer() {
         @Override
         public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
          JLabel componet = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                 componet.setHorizontalAlignment(SwingConstants.CENTER);  
                 componet.setFont(new Font("Tahoma",Font.BOLD,11));
                 componet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
          return componet;
         }
        };

        table.getColumnModel().getColumn(index).setHeaderRenderer(render);      
      }
      public static void alinearDatosColumnaTablaDerecha(int index,JTable table){
         TableCellRenderer render = new DefaultTableCellRenderer() {
         @Override
         public Component getTableCellRendererComponent(final JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
          final JLabel componet = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                 componet.setHorizontalAlignment(SwingConstants.RIGHT);   
                 componet.setOpaque(true);
                 componet.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        componet.setBackground(table.getSelectionBackground());
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        componet.setBackground(table.getBackground());
                    }
                 });
          return componet;
         }
        };
        table.getColumnModel().getColumn(index).setCellRenderer(render);
      }
 public static void alinearDatosColumnaTablaIzquierda(int index,JTable table){
       TableCellRenderer render = new DefaultTableCellRenderer() {
         @Override
         public Component getTableCellRendererComponent(final JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
          final JLabel componet = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                 componet.setHorizontalAlignment(SwingConstants.LEFT); 
                 componet.setOpaque(true);
                 componet.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        componet.setBackground(table.getSelectionBackground());
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        componet.setBackground(table.getBackground());
                    }
                 });
          return componet;
         }
        };
        table.getColumnModel().getColumn(index).setCellRenderer(render);
      }
  public static void alinearDatosColumnaTablaCentro(int index,JTable table){
       TableCellRenderer render = new DefaultTableCellRenderer() {
         @Override
         public Component getTableCellRendererComponent(final JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
          final JLabel componet = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                 componet.setHorizontalAlignment(SwingConstants.CENTER);
                 componet.setOpaque(true);
                 componet.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        componet.setBackground(table.getSelectionBackground());
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        componet.setBackground(table.getBackground());
                    }
                 });
          return componet;
         }
        };
        table.getColumnModel().getColumn(index).setCellRenderer(render);
      }
    public static TableRowSorter filtradorBusqueda(JTable tb,JTextField txt,int... index){  
        javax.swing.table.AbstractTableModel tbm = (javax.swing.table.AbstractTableModel)tb.getModel();
        TableRowSorter trs = new TableRowSorter<javax.swing.table.AbstractTableModel>(tbm);
        tb.setRowSorter(trs); 
        aplicarFiltrador(txt,trs,index);
        return trs;
    }
    
    public static void aplicarFiltrador(final JTextField txt,final TableRowSorter trs,final int... index){
        txt.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        nuevoFiltradoFilas(txt.getText(),trs,index);                        
                    }
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        nuevoFiltradoFilas(txt.getText(),trs,index);
                    }
                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        nuevoFiltradoFilas(txt.getText(),trs,index);
                    }
                });            
   }    
    
    public static TableRowSorter filtradorBusqueda(JTable tb,JComboBox cbx,int... index){  
        javax.swing.table.AbstractTableModel tbm = (javax.swing.table.AbstractTableModel)tb.getModel();
        TableRowSorter trs = new TableRowSorter<javax.swing.table.AbstractTableModel>(tbm);
        tb.setRowSorter(trs); 
        aplicarFiltrador(cbx,trs,index);
        return trs;
    }
    public static void aplicarFiltrador(final JComboBox cbx,final TableRowSorter trs,final int... index){
        cbx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevoFiltradoFilas(cbx.getSelectedItem().toString(),trs,index);
            }
        });             
   }
    
    private static void nuevoFiltradoFilas(String msg,TableRowSorter trs,int... index) {
        RowFilter<javax.swing.table.AbstractTableModel,Object> rf;
        try {
            rf = RowFilter.regexFilter("(?i)"+msg,index);            
           // rf = RowFilter.regexFilter(Pattern.compile(txt.getText(),Pattern.CASE_INSENSITIVE).toString(),index);            
            trs.setRowFilter(rf);
        } catch (java.util.regex.PatternSyntaxException ex) {}
   }
    
   public static int seleccionarFila(MouseEvent evt) {
        JTable tablaReferencia = (JTable) evt.getComponent();
        Point puntoReferencia = evt.getPoint();
        int filaSeleccionada = tablaReferencia.rowAtPoint(puntoReferencia);
        ListSelectionModel modeloTabla = tablaReferencia.getSelectionModel();
        modeloTabla.setSelectionInterval(filaSeleccionada, filaSeleccionada);
        return filaSeleccionada;
    }
    //</editor-fold>   
    //<editor-fold defaultstate="collapsed" desc="GUI Frame Util">
      public static void insertaInternalFrame(JInternalFrame jf,JDesktopPane jd){
        try {
            if(!jf.isShowing()){
                if (jf.isIcon()) {
                   jf.setIcon(false); 
                   jf.toFront();
                }else{
                 jf.pack();   
                    try {
                      jd.add(jf);  
                    } catch (IllegalArgumentException e) {                
                      jd.remove(jf);                 
                      jd.add(jf); 
                      e.printStackTrace();
                    }            
                 jf.setLocation(((jd.getWidth()/2)-(jf.getWidth()/2)),((jd.getHeight()/2)-(jf.getHeight()/2)));
                 jf.show();
                 jf.toFront();                 
                }        
            }else{              
              jf.toFront();
              jf.setLocation(((jd.getWidth()/2)-(jf.getWidth()/2)),((jd.getHeight()/2)-(jf.getHeight()/2)));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
       //jd.updateUI();
    }
    public static void centreaInternalFrame(JInternalFrame jf,JDesktopPane jd){
        jf.setLocation(((jd.getWidth()/2)-(jf.getWidth()/2)),((jd.getHeight()/2)-(jf.getHeight()/2)));
    }
    public static void salir(Component parent){     
       int op =  JOptionPane.showConfirmDialog(parent,"Esta seguro que desea salir del sistema.","Atencion",JOptionPane.YES_NO_OPTION);        
       if (op==JOptionPane.YES_OPTION) {
            System.exit(0);
       } 
    }
    public static void cerrar(JDialog parent){     
       int op =  JOptionPane.showConfirmDialog(parent,"Esta seguro que desea cerrar.","Atencion",JOptionPane.YES_NO_OPTION);        
       if (op==JOptionPane.YES_OPTION) {
            parent.dispose();
       } 
    }
     public static void closeInternalFrame(JInternalFrame jf,JDesktopPane jd) throws PropertyVetoException{
       jf.doDefaultCloseAction();
       jd.remove(jf);
    }
      public static void centreaVentana(Window vent){
          vent.setLocationRelativeTo(null);
      }
      public static void setIconoVentana(Window vent,String resourcePath){
          //Image icon = Toolkit.getDefaultToolkit().createImage(Class.class.getClass().getResource(resourcePath));
          //ImageIcon icon =  new ImageIcon(Class.class.getClass().getResource(resourcePath)); 
          vent.setIconImage(getIconFromResource(resourcePath).getImage());
      }
      public static void setIconoVentana(JInternalFrame vent,String resourcePath){           
          vent.setFrameIcon(getIconFromResource(resourcePath));
      }
      
//      public static void setIconoVentana(JRibbonFrame vent,String resourcePath){          
//          vent.setIconImage(getIconFromResource(resourcePath).getImage());
//          vent.setApplicationIcon(getResizableIconFromResource(resourcePath));
//      }
      public static void maximizarAbsoluta(Frame ref){
          ref.setExtendedState(Frame.MAXIMIZED_BOTH);
      }
      public static void maximizar(Frame ref){
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
          screenSize.height=screenSize.height-40;
          screenSize.width=screenSize.width-10;
          ref.setSize(screenSize);
      }
      public static void maximizar(Dialog ref){
          Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
          screenSize.height=screenSize.height-40;
          screenSize.width=screenSize.width-10;
          ref.setSize(screenSize);
      }
      public static void restaurar(Frame ref){
          ref.setExtendedState(Frame.NORMAL);
      }
      public static void maximizarHorizontalmente(Frame ref){
          ref.setExtendedState(Frame.MAXIMIZED_HORIZ);
      }    
      public static void maximizarVerticalmente(Frame ref){
          ref.setExtendedState(Frame.MAXIMIZED_VERT);
      } 
      public static void minimizar(Frame ref){
          ref.setExtendedState(Frame.ICONIFIED);
      } 
      public static boolean isMaximizado(Frame ref){
          return ref.getExtendedState()==Frame.MAXIMIZED_BOTH;
      } 
      public static void adaptarMovimiento(JDialog win){
         new UndecoratedMove().MoveAdapter(win);
      }
      public static void adaptarMovimiento(JFrame win){
         new UndecoratedMove().MoveAdapter(win);
      }
      public static void adaptarMovimiento(JInternalFrame win){
         new UndecoratedMove().MoveAdapter(win);
      }
      public static void adaptarForma(JDialog win,float aw,float ah){
          new ShapeDecorated().applyShape(win, aw, ah);
      }
      public static void adaptarForma(JFrame win,float aw,float ah){
          new ShapeDecorated().applyShape(win, aw, ah);
      }
      public static ImageIcon getIconFromResource(String resource) { 
        return new ImageIcon(Class.class.getClass().getResource(resource));
      }
      
      public static void aplicaTransparencia(Window window){
          AWTUtilitiesWrapper.setWindowOpaque(window,false);
      }
      //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Imprecion Util">
      public static void imprimirSilencioso(Printable prntbl) throws PrinterException{
         PrinterJob pj = PrinterJob.getPrinterJob();    
         /*PageFormat defaultFormat = new PageFormat();
         defaultFormat = pj.defaultPage(defaultFormat); */       
         pj.setPrintable(prntbl);
         pj.print();             
      }
      public static void imprimirDialogo(Printable prntbl) throws PrinterException{
         PrinterJob job = PrinterJob.getPrinterJob();
              job.setPrintable(prntbl);
              boolean aceptar_impresion =job.printDialog();            
               if(aceptar_impresion){
                   job.print();
               }                
      }
      public static int imprimir(Graphics graphics, PageFormat pageFormat, int pageIndex,JComponent component){
          if (pageIndex > 0) { 
              return Printable.NO_SUCH_PAGE;
          }else{
           Graphics2D g2d = (Graphics2D)graphics;  
           g2d.setClip(0,0,component.getWidth(),component.getHeight());
            g2d.translate(0,0);
            //g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            //g2d.scale( ((Number)(scale/100)).doubleValue(),((Number)(scale/100)).doubleValue());
            g2d.scale(0.408,0.421);
           component.printAll(graphics);        
           return Printable.PAGE_EXISTS;
          } 
      }
      //</editor-fold>    
    //<editor-fold defaultstate="collapsed" desc="Fecha y Numeros Util">
    public static java.util.Date castDate_SQL_UTIL(java.sql.Date df){
      return new java.util.Date(df.getTime());
    }
    public static java.sql.Date castDate_UTIL_SQL(java.util.Date df){
      return new java.sql.Date(df.getTime());
    }
    public static java.sql.Timestamp castTimestamp_UTIL_SQL(java.util.Date df){
      Date dat = new Date();
      df.setHours(dat.getHours());
      df.setMinutes(dat.getMinutes());
      df.setSeconds(dat.getSeconds());
      return new java.sql.Timestamp(df.getTime());
    }
      public static String getFechaUltimaModificacionCorto(File fl){
         Date dt = new Date(fl.lastModified());
         Calendar gc = new GregorianCalendar();
         gc.setTime(dt);       
         
       return (new DecimalFormat("00").format(gc.get(Calendar.DATE))
               +"/"+new DecimalFormat("00").format((gc.get(Calendar.MONTH)+1))
               +"/"+gc.get(Calendar.YEAR)
               +" "+new DecimalFormat("00").format(Hora[gc.get(Calendar.HOUR)])
               +":"+new DecimalFormat("00").format(gc.get(Calendar.MINUTE))
               +":"+new DecimalFormat("00").format(gc.get(Calendar.SECOND))
               +" "+Horario[gc.get(Calendar.AM_PM)]);
      }

      public static String getFechaUltimaModificacionLargo(File fl){
         Date dt = null;
         Calendar gc = null;
         dt = new Date(fl.lastModified());
         gc = new GregorianCalendar();
         gc.setTime(dt);       
       return (Dias_Semana[dt.getDay()]
               +", "+new DecimalFormat("00").format(gc.get(Calendar.DATE))
               +" de "+Meses_Anio[gc.get(Calendar.MONTH)]
               +" de "+gc.get(Calendar.YEAR)
               +", "+new DecimalFormat("00").format(Hora[gc.get(Calendar.HOUR)])
               +":"+new DecimalFormat("00").format(gc.get(Calendar.MINUTE))
               +":"+new DecimalFormat("00").format(gc.get(Calendar.SECOND))
               +" "+Horario[gc.get(Calendar.AM_PM)]);
      } 
      public static java.sql.Date convertStringToDate(String referencia){
        int anio,mes,dia,post;
        post = referencia.indexOf("/")!=-1?referencia.indexOf("/"):referencia.indexOf("-");
        dia = Integer.parseInt(referencia.substring(0,post).trim());
        referencia = referencia.substring(post+1,referencia.length());
        post = referencia.indexOf("/")!=-1?referencia.indexOf("/"):referencia.indexOf("-");
        mes = Integer.parseInt(referencia.substring(0,post).trim());
        referencia = referencia.substring(post+1,referencia.length());
        anio = Integer.parseInt(referencia.trim());         
        return new java.sql.Date(anio-1900,mes-1,dia);
      }
      public static String convertirFecha_Letra(Date fecha){
          return convertirFecha_Letra(fecha.getDate(),fecha.getMonth(),fecha.getYear()+1900);
      }
      private static String convertirFecha_Letra(int dia, int mes, int anio){
          String fecha = "";
          fecha += convertirNumero_Letras((String.valueOf(dia))) + convertirMes(mes,anio) + convertirNumero_Letras((String.valueOf(anio)));
          return fecha;
      }
      public static String convertDateString(int date){
          return Meses_Anio[date];
      }
      private static String centimizaNumero(long num){
          String nc=""+num;
          if (nc.length()>=2) {
              nc=""+num;
          }else{
              nc=""+num+"0";
          }
          return nc;
      }
      public static String convertirPrecio_Letras(double precio){
          String sprecio = ""+precio,
                 pe=sprecio.substring(0,sprecio.indexOf(".")),
                 pf=sprecio.substring(sprecio.indexOf(".")+1,sprecio.length());
          
          return (convertirNumero_Letras(pe)+" con "+centimizaNumero(Long.parseLong(pf))+"/100 nuevos soles").toUpperCase();
      }
      public static String convertirNumero_Letras(int num){
          return convertirNumero_Letras(""+num);
      }
      public static String convertirNumero_Letras(String numero) {
          String literal = "";
          String Num[] = numero.split(",");

              if (Integer.parseInt(Num[0]) > 999) {//si es miles
                  literal = getMiles(Num[0]);
              } else if (Integer.parseInt(Num[0]) > 99) {//si es centena
                  literal = getCentenas(Num[0]);
              } else if (Integer.parseInt(Num[0]) > 9) {//si es decena
                  literal = getDecenas(Num[0]);
              } else {//sino unidades -> 9
                  literal = getUnidades(Num[0]);
              }
              return literal;      
      }

      private static String getUnidades(String numero) {// 1 - 9
          //si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
          String num = numero.substring(numero.length() - 1);
          return UNIDADES[Integer.parseInt(num)];
      }

      private static String getDecenas(String num) {// 99                        
          int n = Integer.parseInt(num);
          if (n < 10) {//para casos como -> 01 - 09
              return getUnidades(num);
          }
          ////////////////////////////
          else if (n >= 20 && n < 30) {//para 20...99
              String u = getUnidades(num);
              if (u.equals("")) { //para 20,30,40,50,60,70,80,90
                  return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
              } else {
                  return  "veinti" + u;
              }
          }
          ///////////////
          else if (n >= 30) {//para 20...99
              String u = getUnidades(num);
              if (u.equals("")) { //para 20,30,40,50,60,70,80,90
                  return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
              } else {
                  return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
              }
          } else {//numeros entre 11 y 19
              return DECENAS[n - 10];
          }
      }

      private static String getCentenas(String num) {// 999 o 099
          if( Integer.parseInt(num)>99 ){//es centena
              if (Integer.parseInt(num) == 100) {//caso especial
                  return " cien ";
              } else {
                   return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
              } 
          }else{//por Ej. 099 
              //se quita el 0 antes de convertirNumero_Letras a decenas
              return getDecenas(Integer.parseInt(num)+"");            
          }        
      }

      private static String getMiles(String numero) {// 999 999
          //obtiene las centenas
          String c = numero.substring(numero.length() - 3);
          //obtiene los miles
          String m = numero.substring(0, numero.length() - 3);
          String n;
          //se comprueba que miles tenga valor entero
          if (Integer.parseInt(m) > 0) {
              if(Integer.parseInt(m)== 1){
                  return "mil " + getCentenas(c);
              }else{
                  n = getCentenas(m);
                  return n + "mil " + getCentenas(c);
              }            
          } else {
              return "" + getCentenas(c);
          }
      }

     private static String convertirMes(int mes, int anio){         
         if (anio>1999){
           return ("de " + Meses_Anio[mes].toUpperCase() + " del ");
         }else{
           return ("de " + Meses_Anio[mes].toUpperCase() + " de ");   
         }             
      }

     public static String mesLetras(int mes) {
          return (Meses_Anio[mes].toUpperCase());       
      }

    public static int obtenerEdad(java.sql.Date fechaNacimiento){
        return obtenerEdad(new Date(fechaNacimiento.getTime()));
    }
    public static int obtenerEdad(java.util.Date fechaNacimiento){
        return obtenerEdad(fechaNacimiento.getYear(),fechaNacimiento.getMonth(), fechaNacimiento.getDate());
    }
    private static int obtenerEdad(int anioNacimiento,int mesNacimiento,int diaNacimiento){
          Date fechaActual = new Date();
          if( (fechaActual.getMonth()) >= mesNacimiento){
              if((fechaActual.getMonth()) > mesNacimiento ){
                  return Math.abs(fechaActual.getYear() - anioNacimiento);
              }else{
                  if(fechaActual.getDate()>= diaNacimiento){
                      return Math.abs(fechaActual.getYear() - anioNacimiento); 
                  }else{
                      return Math.abs((fechaActual.getYear() - 1) - anioNacimiento);
                  }                    
              }
          }else{
              return Math.abs((fechaActual.getYear() - 1) - anioNacimiento);
          }
      }
      public static int totalDiasMora(java.util.Date fp){  
           /*
            - Si se vencio la fecha de pago - Devuelve los dias de mora que se paso (+)
            - Si todavia no se vencio la fecha de pago - Devuelve los dias que faltan (-)
           */
           int cont=0;        
           int tdxm[] = {31,(fp.getYear()+1900)%4==0?29:28,31,30,31,30,31,31,30,31,30,31};  
           java.util.Date fa = new java.util.Date();        
           for (int i = fp.getMonth()+1; i <= fa.getMonth(); i++) {
              cont+=tdxm[i]; 
           }
           cont-=((tdxm[fa.getMonth()]-fa.getDate())-(tdxm[fp.getMonth()]-fp.getDate()));        
           return cont;
       }
       public static int totalDiasMora(java.sql.Date date){
            return totalDiasMora(Utilitarios.castDate_SQL_UTIL(date));
       }
      //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="String Util">
    public static String toUpperCaseInit(String src){
          String nmsg="";
          int pos,sz=src.length();        
          for (int i = 0; i < sz;i++) {            
              src=src.trim();
              pos=src.indexOf(" ");
              if (pos!=-1) { 
                nmsg+=toUpperCaseInitLetter(src.substring(0,pos)) +" ";              
                src=src.substring(pos,src.length()).trim();                
              }else{             
               nmsg+=toUpperCaseInitLetter(src);             
               i=sz;
              }         
          }
      return nmsg;
   }
   private static String toUpperCaseInitLetter(String src){
     String tmp1,tmp2;
         tmp1=(""+src.charAt(0)).toUpperCase();
         tmp2=src.substring(1,src.length()).toLowerCase();
     return (tmp1+tmp2);
   }
    public static int cantidadPalabras(String src){       
          int cant = 0,pos,sz=src.length();        
          for (int i = 0; i < sz;i++) {            
              src=src.trim();
              pos=src.indexOf(" ");
              if (pos!=-1) {
                cant++;              
                src=src.substring(pos,src.length()).trim();                
              }else{  
               cant++;
               i=sz;
              }         
          }
      return cant;
   }

    public static int cantidadOcurrenciasPatron(String cadena, String patron){
      int count = 0, start = 0,len = patron.length();
       while((start = cadena.indexOf(patron, start) + 1) > 0) {
          count++;
          start += len;
       }
      return count;
   }
    public static String remplazarPatron(String src,String r1,String r2){
     return src.trim().replaceAll(r1,r2);
    }  
    public static String quitaEspaciosBlancos(String src){
      return remplazarPatron(src," ","");
    }  
    public static String[] analyzeStringReference(String ref){
        String rsp[] = new String[4],
               tmp[],rf[] = new String[3];

           tmp=splitStringReference(prepareStringRefence(ref));
           rsp[0]=tmp[0].toLowerCase();       
           tmp=splitStringReference(tmp[1]);
           rsp[1]=tmp[0].toLowerCase();
           if (tmp[1]!=null) {
               tmp=splitStringReference(tmp[1]);
               rsp[2]=tmp[0].toLowerCase();
               if (tmp[1]!=null) {
                  rsp[3]=tmp[1].toLowerCase(); 
               }
           }else{//Tiene Un solo apellido y sus nombres
             rf[0]=rsp[0];
             rf[1]="";
             rf[2]=rsp[1];
             rsp=null;
             return rf;
           }
           if (rsp[3]!=null) {
               if (rsp[1].toLowerCase().trim().startsWith("de la")) {// de la en el primer apellido
                   rf[0]=rsp[0]+(char)KeyEvent.VK_SPACE+rsp[1];
                   rf[1]=rsp[2];
                   rf[2]=rsp[3];
                   rsp=null;
                   return rf; 
               }else if(rsp[2].toLowerCase().trim().startsWith("de la")){// de la en el segundo apellido
                   rf[0]=rsp[0];
                   rf[1]=rsp[1]+(char)KeyEvent.VK_SPACE+rsp[2];
                   rf[2]=rsp[3];
                   rsp=null;
                   return rf;
               }
           }else{
             rf[0]=rsp[0];
             rf[1]=rsp[1];
             rf[2]=rsp[2];
             rsp=null;
             return rf;
           }
        return rsp;     
     }

     public static String prepareStringRefence(String ref){
        String rf1,rf2;
        int psc = ref.indexOf(",");
           if (psc!=-1) {
             rf1 = ref.substring(0,psc).trim();
             rf2 = ref.substring(psc+1,ref.length()).trim(); 

             return rf1+","+(char)KeyEvent.VK_SPACE+rf2;
           }else{
             return ref.trim();
           }
       }

     public static String[] splitStringReference(String ref){
         if (ref!=null && !ref.trim().equals("")) {
           String nref[] = new String[2];
           int pos;
           ref=ref.toLowerCase().trim();        
           pos=ref.indexOf(""+(char)KeyEvent.VK_SPACE);        
                if (pos!=-1) {                  
                   if (ref.startsWith("del"+(char)KeyEvent.VK_SPACE)) {                     
                        pos=ref.indexOf("del")+"del".length();      
                        splitStringReferenceRecurente(nref, ref, pos);                                 
                   }else if(ref.startsWith("la"+(char)KeyEvent.VK_SPACE)){
                      pos=ref.indexOf("la")+"la".length();      
                      splitStringReferenceRecurente(nref, ref, pos);                   
                   }else if(ref.startsWith("de"+(char)KeyEvent.VK_SPACE)){                    
                       if (ref.startsWith("de"+(char)KeyEvent.VK_SPACE+"la"+(char)KeyEvent.VK_SPACE)) {                
                           pos=ref.indexOf("de"+(char)KeyEvent.VK_SPACE+"la")+("de"+(char)KeyEvent.VK_SPACE+"la").length(); 
                           splitStringReferenceRecurente(nref, ref, pos);                        
                       } else if(ref.startsWith("de"+(char)KeyEvent.VK_SPACE)){
                          pos=ref.indexOf("de")+"de".length(); 
                          splitStringReferenceRecurente(nref, ref, pos);                      
                       }
                   }else if(ref.startsWith("santa"+(char)KeyEvent.VK_SPACE)){
                           pos=ref.indexOf("santa")+"santa".length();  
                          splitStringReferenceRecurente(nref, ref, pos);                      
                   }else if(ref.startsWith("san"+(char)KeyEvent.VK_SPACE)){
                           pos=ref.indexOf("san")+"san".length();  
                           splitStringReferenceRecurente(nref, ref, pos);                       
                   }else{                     
                     nref[0] = ref.substring(0,pos).trim();  
                     nref[1] = ref.substring(pos,ref.length()).trim();
                     splitStringReferenceSubRecurente(nref, ref);                                
                   }                             
               }else{              
                 nref[0] = ref.trim();
                 nref[1] = null;                 
                }     
           return nref;  
         }else{
          return null;
         }
     }

     public static  void splitStringReferenceRecurente(String nref[],String ref, int pos){
         nref[0] = ref.substring(0,pos).trim();
         nref[1] = ref.substring(pos,ref.length()).trim();                       
         pos = nref[1].trim().indexOf(""+(char)KeyEvent.VK_SPACE);
         nref[0]+=""+(char)KeyEvent.VK_SPACE+nref[1].substring(0,pos).trim();                     
         nref[1] = nref[1].substring(pos,nref[1].length()).trim();
         splitStringReferenceSubRecurente(nref, ref);      
     }
     public static  void splitStringReferenceSubRecurente(String nref[],String ref){
        int pos_coma = nref[0].indexOf(",");
        if (pos_coma!=-1) {
           if (pos_coma==nref[0].length()-1) {
             nref[0]=nref[0].substring(0,pos_coma);                           
           }
        }else{
           pos_coma=nref[1].indexOf(",");
           if (pos_coma!=-1) {
              if (pos_coma==0) {
                nref[1] = nref[1].substring(pos_coma+1,nref[1].length()).trim();  
              }           
           }else{
              nref[0] = ref.trim();
              nref[1] = null;
           }
         }    
     }
    public static void printException(Exception exRef){     
      exRef.printStackTrace();
      JOptionPane.showMessageDialog(null, "Error: \n"+exRef.toString(),"ERROR", JOptionPane.ERROR_MESSAGE);
    }
    public static String getComand(String inf){       
          return inf.substring((inf.indexOf("="))+1,inf.length());
    }
    public static String subString(String ref,int lng){
        return ref.length()>lng?ref.toUpperCase().substring(0,lng):ref;
    }
    public static String formateaPrecio(String r,int c){
        int cnt = r.length()-3;
        cnt=c-cnt;
        for (int i = cnt; i >0; i--) {
            r=" "+r;
        }
        return r;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="GUI Control Validator Util">   
    public static void enableComponent(Object[] lObj){
        for (Object object : lObj) {
            if (object instanceof JTextField) {
                JTextField tmp = (JTextField)object; 
                tmp.setEnabled(true);
                tmp.setEditable(true);
            }else if(object instanceof JPasswordField){
                JPasswordField tmp = (JPasswordField)object;                
                tmp.setEnabled(true);
                tmp.setEditable(true);
            }else if(object instanceof JTextArea){
                JTextArea tmp = (JTextArea)object;                
               tmp.setEnabled(true);
               tmp.setEditable(true);
            }else if(object instanceof JTextPane){
                JTextPane tmp = (JTextPane)object;                
                tmp.setEnabled(true);
                tmp.setEditable(true);
            }else if(object instanceof JEditorPane){
                JEditorPane tmp = (JEditorPane)object;                
                tmp.setEnabled(true);
                tmp.setEditable(true);
            }else if(object instanceof JComboBox){
                JComboBox tmp = (JComboBox)object;                
                tmp.setEnabled(true);
            }else if(object instanceof JDateChooser){
                JDateChooser tmp = (JDateChooser)object;                
                tmp.setEnabled(true);
            }else if(object instanceof JSpinner){
                JSpinner tmp = (JSpinner)object;                
                tmp.setEnabled(true);
            }else if(object instanceof JButton){
                JButton tmp = (JButton)object;                
                tmp.setEnabled(true);
            }else if(object instanceof JTable){
                JTable tmp = (JTable)object;                
                tmp.setEnabled(true);
            }else if(object instanceof JCheckBox){
                JCheckBox tmp = (JCheckBox)object;                
                tmp.setEnabled(true);
            }else if(object instanceof JRadioButton){
                JRadioButton tmp = (JRadioButton)object;                
                tmp.setEnabled(true);
            }else if(object instanceof JYearChooser){
                JYearChooser tmp = (JYearChooser)object;                
                tmp.setEnabled(true);
            }else if(object instanceof JHourChooser){
                JHourChooser tmp = (JHourChooser)object;                
                tmp.setEnabled(true);
            }
        }
    }
    public static void disableComponent(Object[] lObj){
        for (Object object : lObj) {
            if (object instanceof JTextField) {
                JTextField tmp = (JTextField)object; 
                tmp.setEnabled(false);
                tmp.setEditable(false);
            }else if(object instanceof JPasswordField){
                JPasswordField tmp = (JPasswordField)object;                
                tmp.setEnabled(false);
                tmp.setEditable(false);
            }else if(object instanceof JTextArea){
                JTextArea tmp = (JTextArea)object;                
               tmp.setEnabled(false);
               tmp.setEditable(false);
            }else if(object instanceof JTextPane){
                JTextPane tmp = (JTextPane)object;                
                tmp.setEnabled(false);
                tmp.setEditable(false);
            }else if(object instanceof JEditorPane){
                JEditorPane tmp = (JEditorPane)object;                
                tmp.setEnabled(false);
                tmp.setEditable(false);
            }else if(object instanceof JComboBox){
                JComboBox tmp = (JComboBox)object;                
                tmp.setEnabled(false);
            }else if(object instanceof JDateChooser){
                JDateChooser tmp = (JDateChooser)object;                
                tmp.setEnabled(false);
            }else if(object instanceof JSpinner){
                JSpinner tmp = (JSpinner)object;                
                tmp.setEnabled(false);
            }else if(object instanceof JButton){
                JButton tmp = (JButton)object;                
                tmp.setEnabled(false);
            }else if(object instanceof JTable){
                JTable tmp = (JTable)object;                
                tmp.setEnabled(false);
            }else if(object instanceof JCheckBox){
                JCheckBox tmp = (JCheckBox)object;                
                tmp.setEnabled(false);
            }else if(object instanceof JRadioButton){
                JRadioButton tmp = (JRadioButton)object;                
                tmp.setEnabled(false);
            }else if(object instanceof JYearChooser){
                JYearChooser tmp = (JYearChooser)object;                
                tmp.setEnabled(false);
            }else if(object instanceof JHourChooser){
                JHourChooser tmp = (JHourChooser)object;                
                tmp.setEnabled(false);
            }
        }
    }
    public static void resetComponents(Object[] lObj){
        for (Object object : lObj) {
            if (object instanceof JTextField) {
                JTextField tmp = (JTextField)object; 
                tmp.setText("");
            }else if(object instanceof JPasswordField){
                JPasswordField tmp = (JPasswordField)object; 
                tmp.setText("");
            }else if(object instanceof JLabel){
                JLabel tmp = (JLabel)object; 
                tmp.setText("");
            }else if(object instanceof JTextArea){
                JTextArea tmp = (JTextArea)object;  
                tmp.setText("");
            }else if(object instanceof JTextPane){
                JTextPane tmp = (JTextPane)object;  
                tmp.setText("");
            }else if(object instanceof JEditorPane){
                JEditorPane tmp = (JEditorPane)object;
                tmp.setText("");
            }else if(object instanceof JComboBox){
                JComboBox tmp = (JComboBox)object;   
                tmp.setSelectedIndex(0);
            }else if(object instanceof JDateChooser){
                JDateChooser tmp = (JDateChooser)object; 
                tmp.setDate(null);
            }else if(object instanceof JCheckBox){
                JCheckBox tmp = (JCheckBox)object; 
                tmp.setSelected(false);
            }else if(object instanceof JTable){
                JTable tmp = (JTable)object; 
                ((org.rx.cr.gui.table.AbstractTableModel)tmp.getModel()).clear();                
            }
        }
    }
    //<editor-fold defaultstate="collapsed" desc="removeValidatorEvent">
    public static void removeValidatorEvent(Object[] lObj){
        for (Object object : lObj) {
            if (object instanceof JTextField) {
                JTextField tmp = (JTextField)object;                
                //removeValidatorEvent(tmp);  
                tmp.setText("");
            }else if(object instanceof JPasswordField){
                JPasswordField tmp = (JPasswordField)object;                
                //removeValidatorEvent(tmp); 
                tmp.setText("");
            }else if(object instanceof JTextArea){
                JTextArea tmp = (JTextArea)object;                
                //removeValidatorEvent(tmp); 
                tmp.setText("");
            }else if(object instanceof JTextPane){
                JTextPane tmp = (JTextPane)object;                
                //removeValidatorEvent(tmp); 
                tmp.setText("");
            }else if(object instanceof JEditorPane){
                JEditorPane tmp = (JEditorPane)object;                
                //removeValidatorEvent(tmp); 
                tmp.setText("");
            }else if(object instanceof JComboBox){
                JComboBox tmp = (JComboBox)object;                
                //removeValidatorEvent(tmp); 
                tmp.setSelectedIndex(0);
            }else if(object instanceof JDateChooser){
                JDateChooser tmp = (JDateChooser)object;                
                //removeValidatorEvent(tmp); 
                tmp.setDate(null);
            }
        }
    }
    private static void removeValidatorEvent(JTextField txt){
        ActionListener action_event[] = txt.getActionListeners();
        for (ActionListener actionListener : action_event) {
            txt.removeActionListener(actionListener);
        }
        KeyListener key_event[] = txt.getKeyListeners();
        for (KeyListener keyListener : key_event) {
            txt.removeKeyListener(keyListener);
        }         
        PropertyChangeListener prop_event[] = txt.getPropertyChangeListeners();
        for (PropertyChangeListener propertyChangeListener : prop_event) {
            txt.removePropertyChangeListener(propertyChangeListener);
        }
    }
    private static void removeValidatorEvent(JPasswordField txt){
        ActionListener action_event[] = txt.getActionListeners();
        for (ActionListener actionListener : action_event) {
            txt.removeActionListener(actionListener);
        }
        KeyListener key_event[] = txt.getKeyListeners();
        for (KeyListener keyListener : key_event) {
            txt.removeKeyListener(keyListener);
        }   
        PropertyChangeListener prop_event[] = txt.getPropertyChangeListeners();
        for (PropertyChangeListener propertyChangeListener : prop_event) {
            txt.removePropertyChangeListener(propertyChangeListener);
        }
    }
    private static void removeValidatorEvent(JTextArea txt){        
        KeyListener key_event[] = txt.getKeyListeners();
        for (KeyListener keyListener : key_event) {
            txt.removeKeyListener(keyListener);
        }    
        PropertyChangeListener prop_event[] = txt.getPropertyChangeListeners();
        for (PropertyChangeListener propertyChangeListener : prop_event) {
            txt.removePropertyChangeListener(propertyChangeListener);
        }
    }
    private static void removeValidatorEvent(JTextPane txt){        
        KeyListener key_event[] = txt.getKeyListeners();
        for (KeyListener keyListener : key_event) {
            txt.removeKeyListener(keyListener);
        }   
        PropertyChangeListener prop_event[] = txt.getPropertyChangeListeners();
        for (PropertyChangeListener propertyChangeListener : prop_event) {
            txt.removePropertyChangeListener(propertyChangeListener);
        }        
    }
    private static void removeValidatorEvent(JEditorPane txt){        
        KeyListener key_event[] = txt.getKeyListeners();
        for (KeyListener keyListener : key_event) {
            txt.removeKeyListener(keyListener);
        }   
        PropertyChangeListener prop_event[] = txt.getPropertyChangeListeners();
        for (PropertyChangeListener propertyChangeListener : prop_event) {
            txt.removePropertyChangeListener(propertyChangeListener);
        }
    }    
    private static void removeValidatorEvent(JComboBox txt){        
        KeyListener key_event[] = txt.getKeyListeners();
        for (KeyListener keyListener : key_event) {
            txt.removeKeyListener(keyListener);
        }   
        PropertyChangeListener prop_event[] = txt.getPropertyChangeListeners();
        for (PropertyChangeListener propertyChangeListener : prop_event) {
            txt.removePropertyChangeListener(propertyChangeListener);
        }
        ItemListener ietn_event[] = txt.getItemListeners();
        for (ItemListener itemListener : ietn_event) {
            txt.removeItemListener(itemListener);
        }
    } 
    private static void removeValidatorEvent(JDateChooser txt){        
        KeyListener key_event[] = txt.getKeyListeners();
        for (KeyListener keyListener : key_event) {
            txt.removeKeyListener(keyListener);
        }   
        PropertyChangeListener prop_event[] = txt.getPropertyChangeListeners();
        for (PropertyChangeListener propertyChangeListener : prop_event) {
            txt.removePropertyChangeListener(propertyChangeListener);
        }
    } 
    //</editor-fold>
    public static void addCharacterValidatorEvent(Object[][] lObj){
        //<editor-fold defaultstate="collapsed" desc="addEnterFocus">    
        for (int i = 0; i < lObj.length; i++) {
            if (lObj[i][0] instanceof JTextField) {
                JTextField tmp = (JTextField)lObj[i][0];
                addCharacterValidator(tmp,Integer.parseInt(lObj[i][1].toString()),Integer.parseInt(lObj[i][2].toString()));                
            }else if(lObj[i][0] instanceof JPasswordField){
                JPasswordField tmp = (JPasswordField)lObj[i][0];
                addCharacterValidator(tmp,Integer.parseInt(lObj[i][1].toString()),Integer.parseInt(lObj[i][2].toString()));  
            }else if(lObj[i][0] instanceof JTextArea){
                JTextArea tmp = (JTextArea)lObj[i][0];
                addCharacterValidator(tmp,Integer.parseInt(lObj[i][1].toString()),Integer.parseInt(lObj[i][2].toString()));  
            }else if(lObj[i][0] instanceof JTextPane){
                JTextPane tmp = (JTextPane)lObj[i][0];
                addCharacterValidator(tmp,Integer.parseInt(lObj[i][1].toString()),Integer.parseInt(lObj[i][2].toString()));  
            }else if(lObj[i][0] instanceof JEditorPane){
                JEditorPane tmp = (JEditorPane)lObj[i][0];
                addCharacterValidator(tmp,Integer.parseInt(lObj[i][1].toString()),Integer.parseInt(lObj[i][2].toString()));  
            }
        }        
        //</editor-fold>
    }
    public static void addEnterDoclickEvent(Object[][] lObj){
        for (Object[] lObj1 : lObj) {
            if (lObj1[0] instanceof JTextField) {
                JTextField tmp = (JTextField) lObj1[0];
                final JButton tmp2 = (JButton) lObj1[1];     
                tmp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tmp2.doClick();
                    }
                });
            } else if (lObj1[0] instanceof JPasswordField) {
                JPasswordField tmp = (JPasswordField) lObj1[0];
                final JButton tmp2 = (JButton) lObj1[1];     
                tmp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tmp2.doClick();
                    }
                });  
            }
        }
        //</editor-fold>
    }
    public static void addEnterFocusEvent(Object[][] lObj){
        //<editor-fold defaultstate="collapsed" desc="addEnterFocus">        
        for (int i = 0; i < lObj.length; i++) {            
            if (lObj[i][0] instanceof JTextField) {
                JTextField tmp = (JTextField)lObj[i][0]; 
                addEnterFocusEvent(tmp,lObj[i][1]);                  
            }else if(lObj[i][0] instanceof JPasswordField){
                JPasswordField tmp = (JPasswordField)lObj[i][0];
                addEnterFocusEvent(tmp,lObj[i][1]);
            }
        }
        //</editor-fold>
    }
    public static void  addValidadorResetAlert(Object[] lObj){
        //<editor-fold defaultstate="collapsed" desc="addValidadorResetAlert">
        for (Object object : lObj) {
            if (object instanceof JTextField) {
                JTextField tmp = (JTextField)object;
                addValidadorResetAlert(tmp);
            }else if(object instanceof JPasswordField){
                JPasswordField tmp = (JPasswordField)object;
                addValidadorResetAlert(tmp);
            }else if(object instanceof JTextArea){
                JTextArea tmp = (JTextArea)object;
                addValidadorResetAlert(tmp);
            }else if(object instanceof JTextPane){
                JTextPane tmp = (JTextPane)object;
                addValidadorResetAlert(tmp);
            }else if(object instanceof JEditorPane){
                JEditorPane tmp = (JEditorPane)object;
                addValidadorResetAlert(tmp);
            }else if(object instanceof JComboBox){
                JComboBox tmp = (JComboBox)object;
                addValidadorResetAlert(tmp);
            }else if(object instanceof JDateChooser){
                JDateChooser tmp = (JDateChooser)object;
                addValidadorResetAlert(tmp);
            }
        }
        //</editor-fold>
    }
    public static boolean isDatosLlenos(Object[][] lObj){
        //<editor-fold defaultstate="collapsed" desc="isDatosLlenos">
        boolean resp = true,rsp_tmp;
        for (int i = 0; i < lObj.length; i++) {            
            if (lObj[i][0] instanceof JTextField) {
                JTextField tmp = (JTextField)lObj[i][0];
                rsp_tmp = isValidoDatosControl(tmp,lObj[i][1].toString());
                if (rsp_tmp) {
                    resp&=rsp_tmp;
                } else {
                    return false;
                }                
            }else if(lObj[i][0] instanceof JPasswordField){
                JPasswordField tmp = (JPasswordField)lObj[i][0];
                rsp_tmp = isValidoDatosControl(tmp,lObj[i][1].toString());
                if (rsp_tmp) {
                    resp&=rsp_tmp;
                } else {
                    return false;
                } 
            }else if(lObj[i][0] instanceof JTextArea){
                JTextArea tmp = (JTextArea)lObj[i][0];
                rsp_tmp = isValidoDatosControl(tmp,lObj[i][1].toString());
                if (rsp_tmp) {
                    resp&=rsp_tmp;
                } else {
                    return false;
                } 
            }else if(lObj[i][0] instanceof JTextPane){
                JTextPane tmp = (JTextPane)lObj[i][0];
                rsp_tmp = isValidoDatosControl(tmp,lObj[i][1].toString());
                if (rsp_tmp) {
                    resp&=rsp_tmp;
                } else {
                    return false;
                } 
            }else if(lObj[i][0] instanceof JEditorPane){
                JEditorPane tmp = (JEditorPane)lObj[i][0];
                rsp_tmp = isValidoDatosControl(tmp,lObj[i][1].toString());
                if (rsp_tmp) {
                    resp&=rsp_tmp;
                } else {
                    return false;
                } 
            }else if(lObj[i][0] instanceof JComboBox){
                JComboBox tmp = (JComboBox)lObj[i][0];
                rsp_tmp = isValidoDatosControl(tmp,lObj[i][1].toString());
                if (rsp_tmp) {
                    resp&=rsp_tmp;
                } else {
                    return false;
                } 
            }else if(lObj[i][0] instanceof JDateChooser){
                JDateChooser tmp = (JDateChooser)lObj[i][0];
                rsp_tmp = isValidoDatosControl(tmp,lObj[i][1].toString());
                if (rsp_tmp) {
                    resp&=rsp_tmp;
                } else {
                    return false;
                } 
            }else if(lObj[i][0] instanceof JSpinner){
                JSpinner tmp = (JSpinner)lObj[i][0];
                rsp_tmp = isValidoDatosControl(tmp,lObj[i][1].toString());
                if (rsp_tmp) {
                    resp&=rsp_tmp;
                } else {
                    return false;
                } 
            }else if(lObj[i][0] instanceof JTable){
                JTable tmp = (JTable)lObj[i][0];
                rsp_tmp = isValidoDatosControl(tmp,lObj[i][1].toString());
                if (rsp_tmp) {
                    resp&=rsp_tmp;
                } else {
                    return false;
                } 
            }
        }
        return resp;
        //</editor-fold>
    }    
    public static boolean isAlgunaOpcionElegida(JCheckBox[] lst,String msg){
        //<editor-fold defaultstate="collapsed" desc="isDatosLlenos">
        boolean rsp = true;
        int sz = lst.length;
        for (int i = 0; i < sz ; i++) {           
            rsp|=lst[i].isSelected();
        }        
        return isValidoDatosControl(rsp,msg);
        //</editor-fold>
    }    
    private static void addEnterFocusEvent(JTextField tmp, Object lObj) {
         //<editor-fold defaultstate="collapsed" desc="addEnterFocusEvent Sub">
        if (lObj instanceof JTextField) {
                    final JTextField tmp2 = (JTextField)lObj;                    
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }else if(lObj instanceof JPasswordField){
                    final JPasswordField tmp2 = (JPasswordField)lObj;
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }else if(lObj instanceof JTextArea){
                    final JTextArea tmp2 = (JTextArea)lObj;
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }else if(lObj instanceof JTextPane){
                    final JTextPane tmp2 = (JTextPane)lObj;
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }else if(lObj instanceof JEditorPane){
                    final JEditorPane tmp2 = (JEditorPane)lObj;
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }else if(lObj instanceof JComboBox){
                    final JComboBox tmp2 = (JComboBox)lObj;
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }else if(lObj instanceof JDateChooser){
                    final JDateChooser tmp2 = (JDateChooser)lObj;
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }else if(lObj instanceof JSpinner){
                    final JSpinner tmp2 = (JSpinner)lObj;
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }  
        //</editor-fold>
    }
    private static void addEnterFocusEvent(JPasswordField tmp, Object lObj) {
         //<editor-fold defaultstate="collapsed" desc="addEnterFocusEvent Sub">
        if (lObj instanceof JTextField) {
                    final JTextField tmp2 = (JTextField)lObj;                    
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }else if(lObj instanceof JPasswordField){
                    final JPasswordField tmp2 = (JPasswordField)lObj;
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }else if(lObj instanceof JTextArea){
                    final JTextArea tmp2 = (JTextArea)lObj;
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }else if(lObj instanceof JTextPane){
                    final JTextPane tmp2 = (JTextPane)lObj;
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }else if(lObj instanceof JEditorPane){
                    final JEditorPane tmp2 = (JEditorPane)lObj;
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }else if(lObj instanceof JComboBox){
                    final JComboBox tmp2 = (JComboBox)lObj;
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }else if(lObj instanceof JDateChooser){
                    final JDateChooser tmp2 = (JDateChooser)lObj;
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }else if(lObj instanceof JSpinner){
                    final JSpinner tmp2 = (JSpinner)lObj;
                    tmp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            tmp2.requestFocus();
                        }
                     });
                }  
        //</editor-fold>
    }
    //<editor-fold defaultstate="collapsed" desc="addValidadorResetAlert"> 
    private static void addValidadorResetAlert(final JTextField txt){       
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                resetControl(txt);
            }            
        });
    }
    private static void addValidadorResetAlert(final JPasswordField txt){       
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                resetControl(txt);
            }            
        });
    }
    private static void addValidadorResetAlert(final JTextArea txt){       
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                resetControl(txt);
            }            
        });
    }
    private static void addValidadorResetAlert(final JTextPane txt){       
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                resetControl(txt);
            }            
        });
    }
    private static void addValidadorResetAlert(final JEditorPane txt){       
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                resetControl(txt);
            }            
        });
    }
    private static void addValidadorResetAlert(final JComboBox jcb){   
        jcb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                resetControl(jcb);
            }
        });
    }
    private static void addValidadorResetAlert(final JDateChooser jdc){     
        jdc.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {                
                resetControl(jdc);
            }
        });
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="isValidoDatosControl">   
    private static boolean isValidoDatosControl(JTextField jtx,String msg){
        return !(alertControl(jtx)?setMsj(msg):false);
    }
    private static boolean isValidoDatosControl(JTextArea jta,String msg){
        return !(alertControl(jta)?setMsj(msg):false);
    }
    private static boolean isValidoDatosControl(boolean rsp,String msg){
        return !(!rsp?setMsj(msg):false);
    }
    private static boolean isValidoDatosControl(JTextPane jta,String msg){
        return !(alertControl(jta)?setMsj(msg):false);
    }
    private static boolean isValidoDatosControl(JPasswordField jpf,String msg){
        return !(alertControl(jpf)?setMsj(msg):false);
    }
    private static boolean isValidoDatosControl(JEditorPane jpf,String msg){
        return !(alertControl(jpf)?setMsj(msg):false);
    }
    private static boolean isValidoDatosControl(JComboBox jcbx,String msg){
        return !(alertControl(jcbx)?setMsj(msg):false);
    }
    private static boolean isValidoDatosControl(JTable tab,String msg){
        return !(alertControl(tab)?setMsj(msg):false);
    }
    private static boolean isValidoDatosControl(JDateChooser jdc,String msg){
        return !(alertControl(jdc)?setMsj(msg):false);
    }
    private static boolean isValidoDatosControl(JSpinner jsp,String msg){
        return !(alertControl(jsp)?setMsj(msg):false);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="addCharacterValidator">
    public static void addCharacterValidator(final JTextField txt,final int tp_chr,final int nro_chr){       
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (tp_chr==Utilitarios.NUMERICO) {
                    validaCaracterNumerico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.NUMERICO_REAL){
                    validaCaracterNumericoMoneda(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO){
                    validaCaracterAlfabetico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_CM){
                    validaCaracterAlfabeticoCM(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_NUMERICO){
                    validaCaracterAlfabeticoNumerico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_NUMERICO_SPB){
                    validaCaracterAlfabeticoNumericoSPB(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.CARACTERES_COMPLETOS){
                    //validaCaracterAlfabeticoNumericoSPB(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }
            }            
        });
    }
    public static void addCharacterValidator(final JTextArea txt,final int tp_chr,final int nro_chr){       
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (tp_chr==Utilitarios.NUMERICO) {
                    validaCaracterNumerico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.NUMERICO_REAL){
                    validaCaracterNumericoMoneda(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO){
                    validaCaracterAlfabetico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_CM){
                    validaCaracterAlfabeticoCM(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_NUMERICO){
                    validaCaracterAlfabeticoNumerico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_NUMERICO_SPB){
                    validaCaracterAlfabeticoNumericoSPB(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.CARACTERES_COMPLETOS){
                    validaNumeroCaracteres(txt,nro_chr);
                }
            }            
        });
    }
    public static void addCharacterValidator(final JTextPane txt,final int tp_chr,final int nro_chr){       
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (tp_chr==Utilitarios.NUMERICO) {
                    validaCaracterNumerico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.NUMERICO_REAL){
                    validaCaracterNumericoMoneda(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO){
                    validaCaracterAlfabetico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_CM){
                    validaCaracterAlfabeticoCM(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_NUMERICO){
                    validaCaracterAlfabeticoNumerico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_NUMERICO_SPB){
                    validaCaracterAlfabeticoNumericoSPB(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.CARACTERES_COMPLETOS){
                    validaNumeroCaracteres(txt,nro_chr);
                }
            }            
        });
    }
    public static void addCharacterValidator(final JEditorPane txt,final int tp_chr,final int nro_chr){       
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (tp_chr==Utilitarios.NUMERICO) {
                    validaCaracterNumerico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.NUMERICO_REAL){
                    validaCaracterNumericoMoneda(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO){
                    validaCaracterAlfabetico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_CM){
                    validaCaracterAlfabeticoCM(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_NUMERICO){
                    validaCaracterAlfabeticoNumerico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_NUMERICO_SPB){
                    validaCaracterAlfabeticoNumericoSPB(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.CARACTERES_COMPLETOS){
                    validaNumeroCaracteres(txt,nro_chr);
                }
            }            
        });
    }
    public static void addCharacterValidator(final JPasswordField txt,final int tp_chr,final int nro_chr){       
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (tp_chr==Utilitarios.NUMERICO) {
                    validaCaracterNumerico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.NUMERICO_REAL){
                    validaCaracterNumericoMoneda(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO){
                    validaCaracterAlfabetico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_CM){
                    validaCaracterAlfabeticoCM(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_NUMERICO){
                    validaCaracterAlfabeticoNumerico(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.ALFABETICO_NUMERICO_SPB){
                    validaCaracterAlfabeticoNumericoSPB(e,txt);
                    validaNumeroCaracteres(txt,nro_chr);
                }else if(tp_chr==Utilitarios.CARACTERES_COMPLETOS){
                    validaNumeroCaracteres(txt,nro_chr);
                }
            }            
        });
    }
    //</editor-fold>
    private static boolean setMsj(String msj) {
        JOptionPane.showMessageDialog(null,msj,"Atencion",JOptionPane.ERROR_MESSAGE); 
        return true;
    }
    //<editor-fold defaultstate="collapsed" desc="alertControl">  
     public static boolean alertControl(JDateChooser jdc){
        if(jdc.getDate()==null){          
            jdc.getDateEditor().getUiComponent().setBackground(Color.red);
            jdc.requestFocus();
            return true;
        }else{
            jdc.getDateEditor().getUiComponent().setBackground(Color.WHITE);
            return false;
        }
    }
     public static boolean alertControl(JSpinner jsp){
        if(Double.parseDouble(jsp.getValue().toString())<=0){          
            jsp.setBackground(Color.RED);
            jsp.requestFocus();
            return true;
        }else{
            jsp.setBackground(Color.WHITE);
            return false;
        }
    }
    public static boolean alertControl(JTextField txf){
        if(txf.getText().trim().length()<=0){
            txf.setBackground(Color.RED);
            txf.requestFocus();
           return true;
        }else{
            txf.setBackground(Color.WHITE);
            return false;
        }
    }
    public static boolean alertControl(JPasswordField txf){
        if(txf.getText().trim().length()<=0){
            txf.setBackground(Color.RED);
            txf.requestFocus();
           return true;
        }else{
            txf.setBackground(Color.WHITE);
            return false;
        }
    }
    public static boolean alertControl(JTextArea txf){
        if(txf.getText().trim().length()<=0){
            txf.setBackground(Color.RED);
            txf.requestFocus();
           return true;
        }else{
            txf.setBackground(Color.WHITE);
            return false;
        }
    }
    public static boolean alertControl(JEditorPane txf){
        if(txf.getText().trim().length()<=0){
            txf.setBackground(Color.RED);
            txf.requestFocus();
           return true;
        }else{
            txf.setBackground(Color.WHITE);
            return false;
        }
    }
    public static boolean alertControl(JTextPane txf){
        if(txf.getText().trim().length()<=0){
            txf.setBackground(Color.RED);
            txf.requestFocus();
           return true;
        }else{
            txf.setBackground(Color.WHITE);
            return false;
        }
    }
    public  static boolean alertControl(JComboBox cbx){
        if(cbx.getSelectedIndex()<=0){
            cbx.setBorder(new javax.swing.border.LineBorder(Color.RED, 2, true));
            cbx.requestFocus();
            return true;
        }else{
            cbx.setBorder(null);
            return false;
        }
    }
    public  static boolean alertControl(JTable tab){            
        if(((org.rx.cr.gui.table.AbstractTableModel)tab.getModel()).size()>0){
            tab.setBackground(Color.WHITE);
            return true;
        }else{
            tab.setBackground(Color.RED);
            return false;
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="resetControl">   
    public static  void resetControl(JTextField txf){
        if(txf.getText().trim().length()>0){
            txf.setBackground(Color.WHITE);
        }else{
            txf.setBackground(Color.RED);
        }        
    }
    public static  void resetControl(JTextArea txf){
        if(txf.getText().trim().length()>0){
            txf.setBackground(Color.WHITE);
        }else{
            txf.setBackground(Color.RED);
        }  
    }
    public static  void resetControl(JEditorPane txf){
        if(txf.getText().trim().length()>0){
            txf.setBackground(Color.WHITE);
        }else{
            txf.setBackground(Color.RED);
        }  
    }
    public static  void resetControl(JTextPane txf){
        if(txf.getText().trim().length()>0){
            txf.setBackground(Color.WHITE);
        }else{
            txf.setBackground(Color.RED);
        }  
    }
    public static  void resetControl(JComboBox cbx){
        if(cbx.getSelectedIndex()>0){
            //cbx.setBorder(null);
            cbx.setBorder(new javax.swing.border.LineBorder(Color.WHITE, 0, true));
        }else{
            cbx.setBorder(new javax.swing.border.LineBorder(Color.WHITE, 0, true));
            cbx.requestFocus();
        }          
    }    
    public static  void resetControl(JDateChooser jdc){
        if(jdc.getDate()!=null){
            jdc.getDateEditor().getUiComponent().setBackground(Color.WHITE);
        }else{
            //jdc.getDateEditor().getUiComponent().setBackground(Color.RED);
            jdc.requestFocus();
        }          
    }
    //</editor-fold>
    public static void saltoLineaTextArea(JTextArea txa){
        txa.setLineWrap(true);
        txa.setWrapStyleWord(true);
    }
    public static void escapeExit(KeyEvent evt){
      if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) {
            System.exit(0);
      }
    }
    //<editor-fold defaultstate="collapsed" desc="Sub Validadores">
    public static void validaNumeroCaracteres(JTextField txt,int cant){  
         String textAux="";
         for (int i = 0; i < txt.getText().length(); i++) {
               if (textAux.length()<cant){
                 textAux += txt.getText().charAt(i);
               }							
         }
         txt.setText(textAux);	   
    }
    public static void validaNumeroCaracteres(JTextArea txt,int cant){  
         String textAux="";
         for (int i = 0; i < txt.getText().length(); i++) {
               if (textAux.length()<cant){
                 textAux += txt.getText().charAt(i);
               }							
         }
         txt.setText(textAux);	   
    }
    public static void validaNumeroCaracteres(JTextPane txt,int cant){  
         String textAux="";
         for (int i = 0; i < txt.getText().length(); i++) {
               if (textAux.length()<cant){
                 textAux += txt.getText().charAt(i);
               }							
         }
         txt.setText(textAux);	   
    }
    public static void validaNumeroCaracteres(JEditorPane txt,int cant){  
         String textAux="";
         for (int i = 0; i < txt.getText().length(); i++) {
               if (textAux.length()<cant){
                 textAux += txt.getText().charAt(i);
               }							
         }
         txt.setText(textAux);	   
    }
    public static void validaNumeroCaracteres(JPasswordField txt,int cant){  
         String textAux="";
         for (int i = 0; i < txt.getText().length(); i++) {
               if (textAux.length()<cant){
                 textAux += txt.getText().charAt(i);
               }							
         }
         txt.setText(textAux);	   
    }
    public static int getNumeroCaracteres(JTextField txt){  
       return txt.getText().length();	   
    }
    public static int getNumeroCaracteres(JTextArea txt){  
       return txt.getText().length();	   
    }
    public static int getNumeroCaracteres(JTextPane txt){  
       return txt.getText().length();	   
    }
    public static void validaCaracterNumerico(KeyEvent e,JTextField txt){
     Character caract = new Character(e.getKeyChar());
        if (!esNumerico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esNumerico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterNumerico(KeyEvent e,JTextArea txt){
     Character caract = new Character(e.getKeyChar());
        if (!esNumerico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esNumerico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterNumerico(KeyEvent e,JTextPane txt){
     Character caract = new Character(e.getKeyChar());
        if (!esNumerico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esNumerico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterNumerico(KeyEvent e,JEditorPane txt){
     Character caract = new Character(e.getKeyChar());
        if (!esNumerico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esNumerico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterNumerico(KeyEvent e,JPasswordField txt){
     Character caract = new Character(e.getKeyChar());
        if (!esNumerico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esNumerico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static boolean esNumerico(Character caracter){
      char caract = caracter.charValue();
      if ( !(Character.isDigit(caract) 
          || caract == KeyEvent.VK_SPACE 
          || caract == KeyEvent.VK_BACK_SPACE
          || caract == KeyEvent.VK_ENTER
          || caract == KeyEvent.VK_LEFT
          || caract == KeyEvent.VK_RIGHT)){
          return false;
      }else{
          return true;
      }					
    }  
    public static void validaCaracterAlfabetico(KeyEvent e,JTextField txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabetico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabetico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }  
    }
    public static void validaCaracterAlfabetico(KeyEvent e,JTextArea txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabetico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabetico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }  
    }
    public static void validaCaracterAlfabetico(KeyEvent e,JTextPane txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabetico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabetico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }  
    }
    public static void validaCaracterAlfabetico(KeyEvent e,JEditorPane txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabetico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabetico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }  
    }
    public static void validaCaracterAlfabetico(KeyEvent e,JPasswordField txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabetico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabetico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }  
    }
    public static boolean esAlfabetico(Character caracter){
      char caract = caracter.charValue();
      if ( !(Character.isLetter(caract) 
           || caract == KeyEvent.VK_SPACE 
           || caract == KeyEvent.VK_BACK_SPACE
           || caract == KeyEvent.VK_ENTER
           || caract == KeyEvent.VK_LEFT
           || caract == KeyEvent.VK_RIGHT)){
          return false;
      }else{
          return true;
      }					
    }  
    public static void validaCaracterAlfabeticoCM(KeyEvent e,JTextField txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoCM(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoCM(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }  
    }
    public static void validaCaracterAlfabeticoCM(KeyEvent e,JTextArea txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoCM(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoCM(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }  
    }
    public static void validaCaracterAlfabeticoCM(KeyEvent e,JTextPane txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoCM(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoCM(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }  
    }
    public static void validaCaracterAlfabeticoCM(KeyEvent e,JEditorPane txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoCM(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoCM(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }  
    }
    public static void validaCaracterAlfabeticoCM(KeyEvent e,JPasswordField txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoCM(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoCM(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }  
    }
    public static boolean esAlfabeticoCM(Character caracter){
      char caract = caracter.charValue();
      if ( !(Character.isLetter(caract) 
           || caract == KeyEvent.VK_SPACE 
           || caract == KeyEvent.VK_BACK_SPACE
           || caract == KeyEvent.VK_ENTER
           || caract == KeyEvent.VK_COMMA
           || caract == KeyEvent.VK_LEFT
           || caract == KeyEvent.VK_RIGHT)){
          return false;
      }else{
          return true;
      }					
    }  
    public static void validaCaracterAlfabeticoNumerico(KeyEvent e,JTextField txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoNumerico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoNumerico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterAlfabeticoNumerico(KeyEvent e,JTextArea txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoNumerico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoNumerico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterAlfabeticoNumerico(KeyEvent e,JTextPane txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoNumerico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoNumerico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterAlfabeticoNumerico(KeyEvent e,JEditorPane txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoNumerico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoNumerico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterAlfabeticoNumerico(KeyEvent e,JPasswordField txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoNumerico(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoNumerico(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static boolean esAlfabeticoNumerico(Character caracter){
      char caract = caracter.charValue();
      if ( !(Character.isDigit(caract) 
              || Character.isLetter(caract)
              || caract == KeyEvent.VK_SPACE 
              || caract == KeyEvent.VK_BACK_SPACE
              || caract == KeyEvent.VK_ENTER
              || caract == KeyEvent.VK_LEFT
              || caract == KeyEvent.VK_RIGHT)){
          return false;
      }else{
          return true;
      }					
    }
    public static void validaCaracterAlfabeticoNumericoSPB(KeyEvent e,JTextField txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoNumericoSPB(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoNumericoSPB(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterAlfabeticoNumericoSPB(KeyEvent e,JTextArea txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoNumericoSPB(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoNumericoSPB(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterAlfabeticoNumericoSPB(KeyEvent e,JTextPane txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoNumericoSPB(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoNumericoSPB(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterAlfabeticoNumericoSPB(KeyEvent e,JEditorPane txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoNumericoSPB(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoNumericoSPB(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterAlfabeticoNumericoSPB(KeyEvent e,JPasswordField txt){
     Character caract = new Character(e.getKeyChar());
        if (!esAlfabeticoNumericoSPB(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esAlfabeticoNumericoSPB(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static boolean esAlfabeticoNumericoSPB(Character caracter){
      char caract = caracter.charValue();
      if ( !(Character.isDigit(caract) 
              || Character.isLetter(caract)
              || caract == KeyEvent.VK_SPACE //espacio
              || caract == KeyEvent.VK_BACK_SPACE //retroceso
              || caract == KeyEvent.VK_COMMA //coma
              || caract == KeyEvent.VK_PERIOD //punto
              || caract == KeyEvent.VK_COLON //dos puntos
              || caract == KeyEvent.VK_SEMICOLON // punto y coma
              || caract == KeyEvent.VK_ENTER
              || caract == KeyEvent.VK_SLASH
              || caract == KeyEvent.VK_MINUS
              || caract == KeyEvent.VK_LEFT
              || caract == KeyEvent.VK_RIGHT)){
          return false;
      }else{
          return true;
      }					
    }
    public static void validaCaracterNumericoMoneda(KeyEvent e,JTextField txt){
     Character caract = new Character(e.getKeyChar());
        if (!esCaracterNumericoMoneda(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esCaracterNumericoMoneda(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterNumericoMoneda(KeyEvent e,JTextArea txt){
     Character caract = new Character(e.getKeyChar());
        if (!esCaracterNumericoMoneda(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esCaracterNumericoMoneda(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterNumericoMoneda(KeyEvent e,JEditorPane txt){
     Character caract = new Character(e.getKeyChar());
        if (!esCaracterNumericoMoneda(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esCaracterNumericoMoneda(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterNumericoMoneda(KeyEvent e,JTextPane txt){
     Character caract = new Character(e.getKeyChar());
        if (!esCaracterNumericoMoneda(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esCaracterNumericoMoneda(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static void validaCaracterNumericoMoneda(KeyEvent e,JPasswordField txt){
     Character caract = new Character(e.getKeyChar());
        if (!esCaracterNumericoMoneda(caract)) {
            String textAux="";
            for (int i = 0; i < txt.getText().length(); i++) {
               if (esCaracterNumericoMoneda(new Character(txt.getText().charAt(i)))){
                 textAux += txt.getText().charAt(i);
               }							
            }
            txt.setText(textAux);
            //getToolkit().beep();
        }   
    }
    public static boolean esCaracterNumericoMoneda(Character caracter){
      char caract = caracter.charValue();
      if ( !(Character.isDigit(caract)             
              || caract == KeyEvent.VK_SPACE //espacio
              || caract == KeyEvent.VK_BACK_SPACE //retroceso              
              || caract == KeyEvent.VK_PERIOD //punto                        
              || caract == KeyEvent.VK_ENTER
              || caract == KeyEvent.VK_LEFT
              || caract == KeyEvent.VK_RIGHT)){ 
          return false;
      }else{
          return true;
      }					
    }
    //</editor-fold>    
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="GUI Font Util">
    public static Font getErikaTypeBold(float sz){
      //return getCustomFont("/org/edessco/sisregcivil/resource/font/Erika_Type_Bold.ttf",sz);
        return getCustomFont("font/Erika_Type_Bold.ttf",sz);
    }
     public static Font getArialBold(float sz){
      //return getCustomFont("/org/edessco/sisregcivil/resource/font/ariblk.ttf",sz);
      return getCustomFont("font/ariblk.ttf",sz);
    }
    public static Font getCustomFont(String ref,float sz){
      Font font=null;
      try {
              font = Font.createFont(Font.TRUETYPE_FONT,new File(Utilitarios.getCurentPath()+File.separator+File.separator+ref));
              font = font.deriveFont(sz);
          }catch (FontFormatException ex) {
              Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
          }
      return font;
    }
    //</editor-fold>  
    //<editor-fold defaultstate="collapsed" desc="SO, Stream Util">
    public static long memoriaLibreMV(){
        return Runtime.getRuntime().freeMemory();
    }
    public static long memoriaMaximaMV(){        
        return Runtime.getRuntime().maxMemory();
    }
    public static long memoriaTotalMV(){        
        return Runtime.getRuntime().totalMemory();
    }
    
    public static String getCurentPath(){
         String os = System.getProperty("os.name");
         String path = System.getProperty("user.dir");
         if (os.equals("linux")) {
           path+=File.separator;
         } else { /*if(os.equals("windows"))*/
             if (path.length()>3) {
                 path+=File.separator;
             }
         }
       return path;
     }  
    public static void finalizarProceso(String processName) throws IOException{
          ejecutaComando("taskkill /F /T /IM "+processName.trim());
    }
    public static Process ejecutaComando(String comand) throws IOException{
        return Runtime.getRuntime().exec(comand.trim());
    }
    public static void refrescarMemoria() {
        Runtime.getRuntime().gc();
    }

    public static void deleteFile(String path_src) throws IOException{
           ejecutaComando("cmd.exe /C del /F /Q \""+path_src+"\"");
    }
    public static void renameFile(String path_src) throws IOException{
          ejecutaComando("cmd.exe /C ren \""+path_src+"\" *.xxx");
    }
    public static void apagarSistemaOperativo() throws IOException{
          ejecutaComando("shutdown /s /f /t 00");
    }
    public static void reiniciarSistemaOperativo() throws IOException{
          ejecutaComando("shutdown /r /f /t 00");
    }
    public static void ejecutarMicrosoftOffice(String program) throws IOException{
            File fl = new File(SystemInfo.getDirectorioArchivosPrograma()+File.separator+"Microsoft Office");
            if (!fl.exists()) {
               fl = new File(SystemInfo.getDirectorioArchivosProgramaX86()+File.separator+"Microsoft Office");
            }
            File[] f = fl.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.isDirectory() && pathname.getName().startsWith("Office")) {
                       return true;
                    }else{
                      return false;
                    }
                }
            });
            fl = f[0];
            if (fl!=null) {
               Utilitarios.ejecutaComando(fl.getAbsolutePath()+File.separator+program);
            }
            fl=null;
            f=null;
    }
    public static void ejecutarMSWord(){
        try {
               Utilitarios.ejecutarMicrosoftOffice("winword.exe");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Microsoft Word no esta Instalado","Atencion",JOptionPane.INFORMATION_MESSAGE);
            }
    }
    public static void ejecutarMSExcel(){
        try {
                Utilitarios.ejecutarMicrosoftOffice("excel.exe");        
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Microsoft Excel no esta Instalado","Atencion",JOptionPane.INFORMATION_MESSAGE);
            }
    }
    public static void ejecutarMSPowerPoint(){
        try {
                Utilitarios.ejecutarMicrosoftOffice("powerpnt.exe");           
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Microsoft PowerPoint no esta Instalado","Atencion",JOptionPane.INFORMATION_MESSAGE);
            }
    }
    public static void ejecutarNotepad_Mas_Mas() throws IOException{
            File fl = new File(SystemInfo.getDirectorioArchivosPrograma()+File.separator+"Notepad++");            
            if (!fl.exists()) {
               fl = new File(SystemInfo.getDirectorioArchivosProgramaX86()+File.separator+"Notepad++");
            }         
            Utilitarios.ejecutaComando(fl.getAbsolutePath()+File.separator+"notepad++.exe");
    }    
    public static void ejecutarNotepad(){
        try {
                Utilitarios.ejecutarNotepad_Mas_Mas();            
            } catch (IOException ex) {
                try {
                    Utilitarios.ejecutaComando("notepad.exe");
                } catch (IOException ex1) {
                    JOptionPane.showMessageDialog(null,"Bloc de Notas no esta Instalado","Atencion",JOptionPane.INFORMATION_MESSAGE);
                }            
            }
    }    
    public static void ejecutarWordPad(){
        try {
                 Utilitarios.ejecutaComando("write.exe");
             } catch (IOException ex) {
                 JOptionPane.showMessageDialog(null,"WordPad no esta Instalado","Atencion",JOptionPane.INFORMATION_MESSAGE);
             }
    } 
    public static void ejecutarCalc(){
        try {
                 Utilitarios.ejecutaComando("calc.exe");
             } catch (IOException ex) {
                 JOptionPane.showMessageDialog(null,"Calculadora no esta Instalado","Atencion",JOptionPane.INFORMATION_MESSAGE);
             }
    } 
    public static String getFileName(String fna) { 
      return fna.lastIndexOf(".") != -1?fna.substring(0,fna.lastIndexOf(".")):fna;      
    }
    public static String getFileName(File src){
        return src.exists()?getFileName(src.getName().trim()):"";
    }    
    public static String getFileExtencion(String str){
        return str.lastIndexOf(".")!=-1?str.substring(str.lastIndexOf(".")+1,str.length()):"";        
    }
    public static String getFileExtencion(File fl) throws FileNotFoundException{
        return fl.exists() && fl.isFile()?getFileExtencion(fl.getName().trim()):"";        
    }
    public static String fileExtencion(File src){
        return src.exists() && src.isFile()?getFileExtencion(src.getName().trim()):"";
    }
    private static String readLineChars(DataInputStream dis) throws IOException{
        String tmp_ln="";
        boolean nl = false;
        int chr;
        while (dis.available()>0 && !nl) {
            chr = dis.read();
            if (chr!='\n'/* && chr!='\r'*/) {
              tmp_ln+=(char)chr;
            } else {
               nl=true;
            }
        }
      return tmp_ln;
    }   
    private static byte[] readLineBytes(DataInputStream dis) throws IOException{        
      return readLineChars(dis).getBytes();
    }  
    public static InputStream encodeFileBinaryBASE64(File src){
      byte[] bytes = new byte[(int)src.length()];
      try {          
          new FileInputStream(src).read(bytes);
      } catch (Exception ex) {
          Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
      }
      return new ByteArrayInputStream(encodeBinaryBASE64(bytes));
    }
    public static Object[] encodeFileBinaryBASE64_C(File src){  
      byte[] bytes = new byte[(int)src.length()];
      FileInputStream fis = null;
      try {          
          fis=new FileInputStream(src);
          fis.read(bytes);
          fis.close();
      } catch (Exception ex) {
          Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
      }
      byte[] data_encode = encodeBinaryBASE64(bytes);
      return new Object[]{new ByteArrayInputStream(data_encode),data_encode.length};
    }
    public static Object[] encodeFileToByte(File src){  
      byte[] bytes = new byte[(int)src.length()];
      FileInputStream fis = null;
      try {          
          fis=new FileInputStream(src);
          fis.read(bytes);
          fis.close();
      } catch (Exception ex) {
          Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
      }
      return new Object[]{new ByteArrayInputStream(bytes),bytes.length};
    }
    public static byte[] encodeBinaryHexa(byte[] data){
        String encoded = DatatypeConverter.printHexBinary(data);
        return encoded.getBytes();
    }
    public static String encodeBinaryHexa(String data){
        String encoded = DatatypeConverter.printHexBinary(data.getBytes());
        return new String(encoded.getBytes());
    }
    public static File encodeBinaryHexa(File src,String nRef) throws FileNotFoundException, IOException{          
        FileInputStream fis = new FileInputStream(src);
        byte[] bytes = new byte[(int)src.length()];
        fis.read(bytes);        
        bytes = encodeBinaryHexa(bytes);
        fis.close();

        File feHex = new File(nRef);
        FileOutputStream osfeHex = new FileOutputStream(feHex);
        
        osfeHex.write(bytes);
        osfeHex.close();
        
        return feHex;
    }
    public static byte[] decodeHexBinary(byte[] data){
        byte[] decoded = DatatypeConverter.parseHexBinary(new String(data));
        return decoded;
    }
    public static String decodeHexBinary(String data){
        byte[] decoded = DatatypeConverter.parseHexBinary(data);
        return new String(decoded);
    }
    public static File decodeFileHexBinary(byte[] data,String nomRef) throws IOException{
        byte[] decoded = decodeHexBinary(data);
        File bin = new File(nomRef);
        FileOutputStream fos = new FileOutputStream(bin);
        fos.write(decoded);
        fos.close();        
        return bin;
    }
    public static File encodeFileBinaryBASE64(File src,String nRef) throws FileNotFoundException, IOException{          
        FileInputStream fis = new FileInputStream(src);
        byte[] bytes = new byte[(int)src.length()];
        fis.read(bytes);        
        bytes = encodeBinaryBASE64(bytes);         
        fis.close();

        File feb64 = new File(nRef);
        FileOutputStream osfeb64 = new FileOutputStream(feb64);
        
        osfeb64.write(bytes);
        osfeb64.close();
        
        return feb64;
    }
    public static String encodeBinaryBASE64(String data){
        String encoded = DatatypeConverter.printBase64Binary(data.getBytes());    
        return encoded;
    }
    public static byte[] encodeBinaryBASE64(byte[] data){
        String encoded = DatatypeConverter.printBase64Binary(data);    
        return encoded.getBytes();
    }
    public static File decodeFileBASE64Binary(byte[] data,String nomRef) throws IOException{
        byte[] decoded = decodeBASE64Binary(data);       
        File bin = new File(nomRef);
        FileOutputStream fos = new FileOutputStream(bin);
        fos.write(decoded);
        fos.flush();
        fos.close();        
        refrescarMemoria();
        return bin;
    }
    public static File byteToFile(byte[] data,String nomRef) throws IOException{
        File bin = new File(nomRef);
        FileOutputStream fos = new FileOutputStream(bin);
        fos.write(data);
        fos.flush();
        fos.close();        
        refrescarMemoria();
        return bin;
    }
    public static String decodeBASE64Binary(String data){
        byte[] decoded = DatatypeConverter.parseBase64Binary(data);
        return new String(decoded);
    }
    public static byte[] decodeBASE64Binary(byte[] data){
        byte[] decoded = DatatypeConverter.parseBase64Binary(new String(data));
        return decoded;
    }
    public static long fileSize(File fl){     
      if (fl.exists()) {
        if (fl.isDirectory()) {
         return fileSize(fl.listFiles());
        } else {
         return fl.length();
        }
      } else {
         return 0;
      }
    }
    public static long fileSize(File[] fl){
        if (fl!=null) {
            long lnt =0;
            for (int i = 0; i < fl.length; i++) {
                if (fl[i].isDirectory()) {
                    lnt+=fileSize(fl[i].listFiles());
                } else {
                    lnt+=fl[i].length();
                }
            }
            return lnt;
        } else {
            return 0;
        }
    }   
      
    public static void renameFile(File src,String nname) throws FileNotFoundException{      
      nname=nname+"."+getFileExtencion(src);
      src.renameTo(new File(src.getParentFile().getPath(),nname));
    }
    public static String encodeRx(String data){return encodeBinaryBASE64(encodeBinaryHexa(encodeBinaryBASE64(data)));}
    public static String decodeRx(String data){return decodeBASE64Binary(decodeHexBinary(decodeBASE64Binary(data)));}    
    public static String _int_$(String _$$_int){return decodeRx(_$$_int);}
    public static byte[] getFileByte(File src){
      try {
           byte[] data = new byte[(int)src.length()];            
           FileInputStream fis = new FileInputStream(src);
           fis.read(data,0,(int) src.length());
           fis.close();
           return data;
        } catch (IOException ex) {
            return new byte[]{};
        }
    }
    public InputStream getResourceStream(String rsc){
     return getClass().getResourceAsStream(rsc);
    }
    public static byte[] getResourceByte(String rsc){
      return getInputStreamByte(new Utilitarios().getResourceStream(rsc));
    }
    public static byte[] getInputStreamByte(InputStream is){
      try {
           int  size = is.available();
           byte[] data = new byte[size];  
           is.read(data,0,size);
           is.close();
           return data;
        } catch (IOException ex) {
            return new byte[]{};
        }
    }
    public static File getByteFile(byte[] data){
      try {
           File src = new File(getCurentPath()+File.separator+"tmp_stream_file.bin");
           FileOutputStream fos = new FileOutputStream(src);           
           fos.write(data);
           fos.flush();
           fos.close();
           return src;
        } catch (IOException ex) {
            return null;
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Resumen HASH Util">
    public static String resumenHash(byte[] data, String algoritmo){
        String output="";  
        try {
           MessageDigest md = MessageDigest.getInstance(algoritmo);
           md.update(data);
           byte[] codigo = md.digest();           
           for (int i = 0; i < codigo.length; i++){
             output += Integer.toHexString((codigo[i] >> 4) & 0xf);
             output += Integer.toHexString(codigo[i] & 0xf);
           }            
        } catch (NoSuchAlgorithmException ex) {
           JOptionPane.showMessageDialog(null,"Algoritmo "+algoritmo.toUpperCase()+" especificado incorrecto","Error",JOptionPane.ERROR_MESSAGE);           
        }
      return output.toUpperCase();
    }
    public static String resumenHash(File file,String algoritmo) throws FileNotFoundException, IOException{        
        FileInputStream fis = new FileInputStream(file);
        byte[] data_buff = new byte[(int)file.length()];
        fis.read(data_buff);        
        fis.close();        
       return resumenHash(data_buff,algoritmo);
    }
    public static String resumenHash(String str, String algoritmo){        
        return resumenHash(str.getBytes(), algoritmo);
    }
    public static String md5(File file) throws FileNotFoundException, IOException{
      return resumenHash(file,"MD5");
    }
    public static String md5(String msg){
      return resumenHash(msg,"MD5");
    }
    public static String md5(byte[] data){
      return resumenHash(data,"MD5");
    }
    public static String sha1(File file) throws FileNotFoundException, IOException{
      return resumenHash(file,"SHA1");
    }
    public static String sha1(String msg){
      return resumenHash(msg,"SHA1");
    }
    public static String sha1(byte[] data){
      return resumenHash(data,"SHA1");
    }    
    public static boolean isEqualResumen(String da,String db){
      return da.equals(db);
    }
    public static void isEqualResumen(File fl,String db,String algoritmo) throws FileNotFoundException, IOException{
        String da = resumenHash(fl,algoritmo);        
        if (isEqualResumen(da,db)) {
           JOptionPane.showMessageDialog(null,"Fichero Integro","Atencion",JOptionPane.INFORMATION_MESSAGE);
        } else {
           JOptionPane.showMessageDialog(null,"Fichero no Integro","Error",JOptionPane.ERROR_MESSAGE); 
        }
    }    
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Networking">
    public static String getMACLocal(){
        NetworkInterface ni;
        try {
         ni = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
         byte[] mac = ni.getHardwareAddress();
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < mac.length; i++) {
          sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));  
         } 
          return sb.toString();
        } catch (Exception e) {
         return "00-00-00-00-00-00";
        }
   }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="GUI Icon">
    public static ImageIcon resizeIcon(byte[]  data,int w,int h){        
        ImageIcon icon = new ImageIcon(data);
        Image img = icon.getImage() ;  
        Image newimg = img.getScaledInstance(w,h, java.awt.Image.SCALE_SMOOTH ) ;  
        icon = new ImageIcon(newimg);
       return icon;
    }
    public static ImageIcon resizeIcon(String path,int w,int h){        
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage() ;  
        Image newimg = img.getScaledInstance(w,h, java.awt.Image.SCALE_SMOOTH ) ;  
        icon = new ImageIcon(newimg);
       return icon;
    }
    public static ImageIcon resizeIcon(File file,int w,int h){        
        try {
            ImageIcon icon = new ImageIcon(file.toURL());
            Image img = icon.getImage() ;  
            Image newimg = img.getScaledInstance(w,h, java.awt.Image.SCALE_SMOOTH ) ;  
            icon = new ImageIcon(newimg);
           return icon;
        } catch (MalformedURLException ex) {
            return null;
        }
    }    
    public static ImageIcon resizeIcon(URL url,int w,int h){        
        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage() ;  
        Image newimg = img.getScaledInstance(w,h, java.awt.Image.SCALE_SMOOTH ) ;  
        icon = new ImageIcon(newimg);
       return icon;
    }    
    public static ImageIcon resizeIcon(Image imag,int w,int h){  
        ImageIcon icon = new ImageIcon(imag);
        Image img = icon.getImage() ;  
        Image newimg = img.getScaledInstance(w,h,java.awt.Image.SCALE_SMOOTH ) ;  
        icon = new ImageIcon(newimg);
       return icon;
    }
    public static ImageIcon resizeIcon(ImageIcon icon,int w,int h){        
        Image img = icon.getImage() ;  
        Image newimg = img.getScaledInstance(w,h, java.awt.Image.SCALE_SMOOTH ) ;  
        icon = new ImageIcon(newimg);
       return icon;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="GUI Control Miselanius">
    public static void addPlaceholder(JTextField txf,final String marca_agua){
        JTextField n_txf = new JTextField(){
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                if(isEnabled() && getText().isEmpty() && !(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)){
                    Graphics2D g2 = (Graphics2D)g.create();
                    g2.setColor(Color.gray);
                    g2.setFont(getFont().deriveFont(Font.ITALIC));
                    g2.drawString(marca_agua,5,18);
                    g2.dispose();
                }
            }
        };
        n_txf.setText(txf.getText());
        n_txf.setToolTipText(txf.getToolTipText());
        n_txf.setEditable(txf.isEditable());
        n_txf.setEnabled(txf.isEnabled());
        n_txf.setRequestFocusEnabled(txf.isRequestFocusEnabled());   
        //<editor-fold defaultstate="collapsed" desc="Event Listener's">
        ActionListener[] al = txf.getActionListeners();
        for (ActionListener l : al) {
            n_txf.addActionListener(l);
        }        
        MouseListener[] ml = txf.getMouseListeners();
        for (MouseListener l : ml) {
            n_txf.addMouseListener(l);
        }
        KeyListener[] kl = txf.getKeyListeners();
        for (KeyListener l : kl) {
            n_txf.addKeyListener(l);
        }
        AncestorListener[] acl = txf.getAncestorListeners();
        for (AncestorListener l : acl) {
            n_txf.addAncestorListener(l);
        }        
        CaretListener[] cl = txf.getCaretListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        ComponentListener[] cnl = txf.getComponentListeners();
        for (ComponentListener l : cnl) {
            n_txf.addComponentListener(l);
        }   
        ContainerListener[] cntl = txf.getContainerListeners();
        for (ContainerListener l : cntl) {
            n_txf.addContainerListener(l);
        }   
        
        txf.getFocusListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getHierarchyBoundsListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getHierarchyListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getInputMethodListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getMouseMotionListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getMouseWheelListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getPropertyChangeListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getVetoableChangeListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        //</editor-fold>
        //txf=n_txf;
    }
    public static void addPlaceholder(JPasswordField txf,final String marca_agua){
        JPasswordField n_txf = new JPasswordField(){
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                if(isEnabled() && getText().isEmpty() && !(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)){
                    Graphics2D g2 = (Graphics2D)g.create();
                    g2.setColor(Color.gray);
                    g2.setFont(getFont().deriveFont(Font.ITALIC));
                    g2.drawString(marca_agua,5,18);
                    g2.dispose();
                }
            }
        };
        n_txf.setText(txf.getText());
        n_txf.setToolTipText(txf.getToolTipText());
        n_txf.setEditable(txf.isEditable());
        n_txf.setEnabled(txf.isEnabled());
        n_txf.setRequestFocusEnabled(txf.isRequestFocusEnabled());   
        //<editor-fold defaultstate="collapsed" desc="Event Listener's">
        ActionListener[] al = txf.getActionListeners();
        for (ActionListener l : al) {
            n_txf.addActionListener(l);
        }        
        MouseListener[] ml = txf.getMouseListeners();
        for (MouseListener l : ml) {
            n_txf.addMouseListener(l);
        }
        KeyListener[] kl = txf.getKeyListeners();
        for (KeyListener l : kl) {
            n_txf.addKeyListener(l);
        }
        AncestorListener[] acl = txf.getAncestorListeners();
        for (AncestorListener l : acl) {
            n_txf.addAncestorListener(l);
        }        
        CaretListener[] cl = txf.getCaretListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        ComponentListener[] cnl = txf.getComponentListeners();
        for (ComponentListener l : cnl) {
            n_txf.addComponentListener(l);
        }   
        ContainerListener[] cntl = txf.getContainerListeners();
        for (ContainerListener l : cntl) {
            n_txf.addContainerListener(l);
        }   
        
        txf.getFocusListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getHierarchyBoundsListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getHierarchyListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getInputMethodListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getMouseMotionListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getMouseWheelListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getPropertyChangeListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getVetoableChangeListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        //</editor-fold>
        //txf=n_txf;
    }
    public static void addPlaceholder(JTextArea txf,final String marca_agua){
        JTextArea n_txf = new JTextArea(){
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                if(isEnabled() && getText().isEmpty() && !(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)){
                    Graphics2D g2 = (Graphics2D)g.create();
                    g2.setColor(Color.gray);
                    g2.setFont(getFont().deriveFont(Font.ITALIC));
                    g2.drawString(marca_agua,5,18);
                    g2.dispose();
                }
            }
        };
        n_txf.setText(txf.getText());
        n_txf.setToolTipText(txf.getToolTipText());
        n_txf.setEditable(txf.isEditable());
        n_txf.setEnabled(txf.isEnabled());
        n_txf.setRequestFocusEnabled(txf.isRequestFocusEnabled());   
        //<editor-fold defaultstate="collapsed" desc="Event Listener's">          
        MouseListener[] ml = txf.getMouseListeners();
        for (MouseListener l : ml) {
            n_txf.addMouseListener(l);
        }
        KeyListener[] kl = txf.getKeyListeners();
        for (KeyListener l : kl) {
            n_txf.addKeyListener(l);
        }
        AncestorListener[] acl = txf.getAncestorListeners();
        for (AncestorListener l : acl) {
            n_txf.addAncestorListener(l);
        }        
        CaretListener[] cl = txf.getCaretListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        ComponentListener[] cnl = txf.getComponentListeners();
        for (ComponentListener l : cnl) {
            n_txf.addComponentListener(l);
        }   
        ContainerListener[] cntl = txf.getContainerListeners();
        for (ContainerListener l : cntl) {
            n_txf.addContainerListener(l);
        }   
        
        txf.getFocusListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getHierarchyBoundsListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getHierarchyListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getInputMethodListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getMouseMotionListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getMouseWheelListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getPropertyChangeListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        txf.getVetoableChangeListeners();
        for (CaretListener l : cl) {
            n_txf.addCaretListener(l);
        }   
        //</editor-fold>
        //txf=n_txf;
    }
    public static void setFondoEscritorio(JDesktopPane dp,String ref){
        BufferedImage imagen = null;       
        URL path = Class.class.getResource(ref);        
        try {
            imagen = ImageIO.read(path);            
            dp.setBorder(new DesktopPaneBackground(imagen));
            
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
  }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="NRO LOTE GENERATOR">
    public static String genNroLote() {
        Date current_date = new Date();
        return numberFormat(current_date.getHours(),"####")
              +"-"+numberFormat(current_date.getDate(),"##")
              +numberFormat(current_date.getMonth()+1,"##")
              +numberFormat(current_date.getYear()+1900,"####");
    }
    //</editor-fold>  
    //<editor-fold defaultstate="collapsed" desc="DATE">
    /*(12/04/2014) => Date()*/
    public Date createDate(String dt) {  
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try {
            if (dt.length()==10) {
                int d=Integer.parseInt(dt.substring(0,2));
                int m=Integer.parseInt(dt.substring(3,5));
                int a=Integer.parseInt(dt.substring(6,dt.length()));
                int DIAS_MES[] = {31,a%4==0?29:28,31,30,31,30,31,31,30,31,30,31};
                return (m>=1 && m<=12)?(d>=1 && d<=DIAS_MES[m-1])?new Date(a-1900,m-1,d):null:null;
            }else{
                return null;
            }                        
        } catch (NumberFormatException e) {
            return null;
        }
        //</editor-fold>
    }
    /*(Thu Feb 27 17:33:42 COT 2014)GMT => Date()*/
    public Date createGMTDate(String ref) {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        String dia,mes = null,anio;
        dia=ref.substring(7,10);
        if (ref.indexOf("Jan")>=0) { 
            mes="01";
        }else if (ref.indexOf("Feb")>=0){
            mes="02";
        }else if (ref.indexOf("Mar")>=0){
            mes="03";
        }else if (ref.indexOf("Apr")>=0){
            mes="04";
        }else if (ref.indexOf("May")>=0){
            mes="05";
        }else if (ref.indexOf("Jun")>=0){
            mes="06";
        }else if (ref.indexOf("Jul")>=0){
            mes="07";
        }else if (ref.indexOf("Aug")>=0){
            mes="08";
        }else if (ref.indexOf("Sep")>=0){
            mes="09";
        }else if (ref.indexOf("Oct")>=0){
            mes="10";
        }else if (ref.indexOf("Nov")>=0){
            mes="11";
        }else if (ref.indexOf("Dec")>=0){
            mes="12";
        }        
        anio=ref.substring(24,28);      
        return new Date((Integer.parseInt(anio.trim())-1900),(Integer.parseInt(mes.trim())-1),Integer.parseInt(dia.trim()));
        //</editor-fold>
    }
    //</editor-fold>
//</editor-fold>
}
