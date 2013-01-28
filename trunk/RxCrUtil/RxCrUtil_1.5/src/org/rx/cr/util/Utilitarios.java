package org.rx.cr.util;

//<editor-fold defaultstate="collapsed" desc="Importaciones">
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.print.*;
import java.beans.PropertyVetoException;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.xml.bind.DatatypeConverter;
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
    private static TableRowSorter<AbstractTableModel> clasificador;    
    private static JTextField tftxt;
    private int op=-1;    
    private Thread hilo;
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
    //<editor-fold defaultstate="collapsed" desc="GUI Util">
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
    //<editor-fold defaultstate="collapsed" desc="GUI Control Validadores">
    public static void validaNumeroCaracteres(JTextField txt,int cant){  
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
    //<editor-fold defaultstate="collapsed" desc="GUI Table Util">
    public static void inmovilizaColumnas(JTable table){
          /*table.getTableHeader().disable();
          table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);*/
         table.setRowSelectionAllowed(false);
         table.getTableHeader().setReorderingAllowed(false);
      }
      public static void formateaColumna(int index,JTable table,int size){
          table.getColumnModel().getColumn(index).setResizable(false);
          table.getColumnModel().getColumn(index).setMinWidth(size);
          table.getColumnModel().getColumn(index).setWidth(size); 
          table.getColumnModel().getColumn(index).setMaxWidth(size);
      }
      public static void formateaColumnaResidimensionable(int index,JTable table,int size){
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
         public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
          JLabel componet = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                 componet.setHorizontalAlignment(SwingConstants.RIGHT);       
          return componet;
         }
        };
        table.getColumnModel().getColumn(index).setCellRenderer(render);
      }
      public static void alinearDatosColumnaTablaIzquierda(int index,JTable table){
       TableCellRenderer render = new DefaultTableCellRenderer() {
         @Override
         public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
          JLabel componet = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                 componet.setHorizontalAlignment(SwingConstants.LEFT);       
          return componet;
         }
        };
        table.getColumnModel().getColumn(index).setCellRenderer(render);
      }
      public static void alinearDatosColumnaTablaCentro(int index,JTable table){
       TableCellRenderer render = new DefaultTableCellRenderer() {
         @Override
         public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
          JLabel componet = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                 componet.setHorizontalAlignment(SwingConstants.CENTER);       
          return componet;
         }
        };
        table.getColumnModel().getColumn(index).setCellRenderer(render);
      }
      public static void filtradorBusqueda(AbstractTableModel mdl,JTable tb,JTextField txt){     
      clasificador = new TableRowSorter<AbstractTableModel>(mdl);
      tb.setModel(mdl);
      tb.setRowSorter(clasificador);  
      actualizadorFiltrado(txt);
    }
    
    public static void actualizadorFiltrado(JTextField txt){
     tftxt=txt;
     txt.getDocument().addDocumentListener(
                new DocumentListener() {
                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        nuevoFiltradoProductos();                        
                    }
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        nuevoFiltradoProductos();
                    }
                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        nuevoFiltradoProductos();
                    }
                });            
   }
    private static void nuevoFiltradoProductos() {
         RowFilter<AbstractTableModel,Object> Filtrador_Filas = null;
        try {
            Filtrador_Filas = RowFilter.regexFilter(tftxt.getText(),0);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
       clasificador.setRowFilter(Filtrador_Filas);
    }
    //</editor-fold>   
    //<editor-fold defaultstate="collapsed" desc="GUI Frame Util">
      public static void insertaInternalFrame(JInternalFrame jf,JDesktopPane jd) throws PropertyVetoException{
       if(!jf.isShowing()){
           if (jf.isIcon()) {
              jf.setIcon(false); 
           }else{
            jf.pack();   
               try {
                 jd.add(jf);  
               } catch (IllegalArgumentException e) {                
                 jd.remove(jf);                 
                 jd.add(jf); 
               }            
            jf.setLocation(((jd.getWidth()/2)-(jf.getWidth()/2)),((jd.getHeight()/2)-(jf.getHeight()/2)));
            jf.show();
            jf.toFront();
           }        
       }
       else{
         jf.toFront();
       }
       //jd.updateUI();
    }
     public static void closeInternalFrame(JInternalFrame jf,JDesktopPane jd) throws PropertyVetoException{
       jf.doDefaultCloseAction();
       jd.remove(jf);
    }
      public static void centreaVentana(Window vent){
          vent.setLocationRelativeTo(null);
      }
      public void setIconoVentana(Window vent,String resourcePath){
          Image icon = Toolkit.getDefaultToolkit().createImage(getClass().getResource(resourcePath));
          vent.setIconImage(icon);
      }
      public void setIconoVentana(JInternalFrame vent,String resourcePath){
          ImageIcon icon =  new ImageIcon(getClass().getResource(resourcePath)); 
          vent.setFrameIcon(icon);
      }
      public static void maximizarAbsoluta(Frame ref){
          ref.setExtendedState(Frame.MAXIMIZED_BOTH);
      }
      public static void maximizar(Frame ref){
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

      private static String convertirNumero_Letras(String numero) {
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
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="GUI Control Util">
    public static boolean paintTxfVacio(JTextField txf){
        if(txf.getText().trim().equals("")){
           //txf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
            txf.setBackground(new java.awt.Color(204, 0, 0));
            txf.requestFocus();
           return true;
        }else{
            //txf.setBorder(null);
            txf.setBackground(new java.awt.Color(255, 255, 255));
            return false;
        }
    }
    public  static boolean paintCbxVacio(JComboBox cbx){
        if(cbx.getSelectedIndex()==0){
            cbx.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
            cbx.requestFocus();
            return true;
        }else{
            cbx.setBorder(null);
            return false;
        }
    }
    
    public static  void resetPaintTxf(JTextField txf){
        if(txf.getText().trim().equals("")){
            txf.setBackground(new java.awt.Color(255, 255, 255));
        }
        txf.setBackground(new java.awt.Color(255, 255, 255));
    }
    public static  void resetPaintCbx(JComboBox cbx){
        cbx.setBorder(null);
    }    
    public static void saltoLineaTextArea(JTextArea txa){
        txa.setLineWrap(true);
        txa.setWrapStyleWord(true);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="GUI Font Util">
    public Font getErikaTypeBold(float sz){
      //return getCustomFont("/org/edessco/sisregcivil/resource/font/Erika_Type_Bold.ttf",sz);
        return getCustomFont("font/Erika_Type_Bold.ttf",sz);
    }
     public Font getArialBold(float sz){
      //return getCustomFont("/org/edessco/sisregcivil/resource/font/ariblk.ttf",sz);
      return getCustomFont("font/ariblk.ttf",sz);
    }
    public Font getCustomFont(String ref,float sz){
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
    public static void finalizarProceso(String processName){
          try {
              ejecutaComando("taskkill /F /T /IM "+processName.trim());
          } catch (IOException ex) {
              Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    public static Process ejecutaComando(String comand) throws IOException{
        return Runtime.getRuntime().exec(comand.trim());
    }
    public static void refrescarMemoria() {
        Runtime.getRuntime().gc();
    }

    public static void deleteFile(String path_src){
          try {
              ejecutaComando("cmd.exe /C del /F /Q \""+path_src+"\"");
          } catch (IOException ex) {
              Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    public static void renameFile(String path_src){
          try {
              ejecutaComando("cmd.exe /C ren \""+path_src+"\" *.xxx");
          } catch (IOException ex) {
              Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    public static void apagarSistemaOperativo(){
          try {
              ejecutaComando("shutdown /s /f /t 00");
          } catch (IOException ex) {
              Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    public static void reiniciarSistemaOperativo(){
          try {
              ejecutaComando("shutdown /r /f /t 00");
          } catch (IOException ex) {
              Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    public static void ejecutarMicrosoftOffice(String program) throws IOException{
            File fl = new File(SystemInfo.getDirectorioArchivosPrograma()+File.separator+"Microsoft Office");
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
    public static void ejecutarNotepad_Mas_Mas() throws IOException{
            File fl = new File(SystemInfo.getDirectorioArchivosPrograma()+File.separator+"Notepad++");            
            if (fl!=null && fl.exists()) {
               Utilitarios.ejecutaComando(fl.getAbsolutePath()+File.separator+"notepad++.exe");
            }
            fl=null;            
    }    
    public static String getFileName(String fna) { 
      return fna.lastIndexOf(".") != -1?fna.substring(0,fna.lastIndexOf(".")):fna;      
    }
    public static String getFileName(File src){
        return src.exists()?getFileName(src.getName().trim()):"";
    }    
    public static String getExtencion(String str){
        return str.lastIndexOf(".")!=-1?str.substring(str.lastIndexOf("."),str.length()):"";        
    }
    public static String getExtencion(File fl) throws FileNotFoundException{
        return fl.exists() && fl.isFile()?getExtencion(fl.getName().trim()):"";        
    }
    public static String fileExtencion(File src){
        return src.exists() && src.isFile()?getExtencion(src.getName().trim()):"";
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
      return new ByteArrayInputStream(bytes);
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
        fos.close();        
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
      nname=nname+"."+getExtencion(src);
      src.renameTo(new File(src.getParentFile().getPath(),nname));
    }
    public static String encodeRx(String data){return encodeBinaryBASE64(encodeBinaryHexa(encodeBinaryBASE64(data)));}
    public static String decodeRx(String data){return decodeBASE64Binary(decodeHexBinary(decodeBASE64Binary(data)));}
    public static String _$xRx$_int(String _$$_int){return encodeRx(_$$_int);}
    public static String _$xRx$_int_(String _$$_int){return decodeRx(_$$_int);}
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
    //</editor-fold>
}
