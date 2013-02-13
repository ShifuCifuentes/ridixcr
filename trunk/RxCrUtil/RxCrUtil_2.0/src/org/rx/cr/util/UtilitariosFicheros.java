package org.rx.cr.util;

import java.awt.Color;
import java.io.*;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class UtilitariosFicheros implements Runnable{

    private Thread hilo=null;
    private JProgressBar root_progress=null;
    private JLabel root_msg_progress=null;
    private long file_size=0;
    private long file_current_size=0;
    private String Unid="";
    private boolean cancel=false,mover=false;
    private FileInputStream fsrc;
    private FileOutputStream fdst;
    private File src=null; 
    private int buffer=-1;
    private byte[] arrayOfByte ;

    public UtilitariosFicheros(JProgressBar proc,JLabel msg) {
     this.root_progress=proc;
     this.root_msg_progress=msg;         
     hilo = new Thread(this);
     hilo.start(); 
    } 
    
    public UtilitariosFicheros() {     
    }
            
    @Override
    public void run() {
        while(true){
            if (mover) {
                if (file_current_size<=file_size) {                          
                            try {  
                                   if ((buffer = fsrc.read(arrayOfByte)) > 0  && !cancel) {
                                     fdst.write(arrayOfByte,0,buffer);
                                     file_current_size+=buffer;                                      
                                     setFile_current_size(file_current_size);
                                      root_progress.setValue(getLengthPreformat(file_current_size));      
                                      root_msg_progress.setText("Progresso... "+getLengthPreformat(file_current_size) +" de "+getInfoLength());
                                      pintaProgressBar();  
                                   }else{
                                     fdst.close();
                                     fsrc.close();  
                                     src.delete();
                                     root_progress.setString("Carga Completa ... 100%");
                                     mover=false;
                                   }
                             } catch (IOException ex) {
                                    Logger.getLogger(UtilitariosFicheros.class.getName()).log(Level.SEVERE, null, ex);
                             }                       
                 } 
        }
            try {Thread.sleep(2);} 
            catch (InterruptedException ex) {}
      }    
    }
    
    public void pintaProgressBar(){
     int val = (int)(100*((double)root_progress.getValue()/(double)getLengthPreformat(file_size)));
     
     if (val >=0 && val < 34){
      root_progress.setForeground(Color.red);		
     }else if (val >= 34 && val <= 68){
      root_progress.setForeground(Color.yellow);
     }else if (val >68 && val < 100){
      root_progress.setForeground(Color.green);
     }else if(val == 100){
      root_progress.setForeground(Color.blue);
     }    
    }
    
    public void mover(File src,File dst) throws FileNotFoundException{
            this.src=src;
            fsrc = new FileInputStream(src);
            fdst = new FileOutputStream(dst);
            arrayOfByte = new byte[5*1024];
            setFile_size(src.length());                 
            root_progress.setMaximum(getLengthPreformat(src.length()));
            root_msg_progress.setText("Progresso... "+0+" de "+getInfoLength());
            mover=true; 
    }

    public double getLengthKB() {
        double lng = file_size;
        double tm = lng/1024.0;
         setUnid("KB");
        return tm;
    }
    public double getLengthMB() {
        double lng = getLengthKB();
        double tm = lng/1024.0;
        setUnid("MB");
        return tm;
    }
    public double getLengthGB() {
        double lng = getLengthMB();
        double tm = lng/1024.0;
        setUnid("GB");
        return tm;
    }  
    public double getLengthTB() {
        double lng = getLengthGB();
        double tm = lng/1024.0;
        setUnid("TB");
        return tm;
    }  
    
    public double getCLengthKB(long sz) {
        double lng = sz;
        double tm = lng/1024.0;
         setUnid("KB");
        return tm;
    }
    public double getCLengthMB(long sz) {
        double lng = getCLengthKB(sz);
        double tm = lng/1024.0;
        setUnid("MB");
        return tm;
    }
    public double getCLengthGB(long sz) {
        double lng = getCLengthMB(sz);
        double tm = lng/1024.0;
        setUnid("GB");
        return tm;
    }  
    public double getCLengthTB(long sz) {
        double lng = getCLengthGB(sz);
        double tm = lng/1024.0;
        setUnid("TB");
        return tm;
    }  
    
    public String getUnid() {
        return Unid;
    }
    public void setUnid(String Unid) {
        this.Unid = Unid;
    }
   
  public int getLengthPreformat(long sz){    ///****** PONER ATENCION  
      if (file_size>=1024L && file_size<Math.pow(1024,2)) {          
       return ((int)getCLengthKB(sz));
      } else if(file_size>=Math.pow(1024,2) && file_size<Math.pow(1024,3)){
       return ((int)getCLengthMB(sz));
      }else if(file_size>=Math.pow(1024,3) && file_size<Math.pow(1024,4)){
        return ((int)getCLengthGB(sz));
      }else if(file_size>=Math.pow(1024,4) && file_size<Math.pow(1024,5)){
        return ((int)getCLengthTB(sz));
      }else if(file_size>0 && file_size<1024L){
        return ((int)sz);
      }else{
        return 0;
      }
  }
  public String getInfoLength(){
      DecimalFormat fmt = new DecimalFormat("0.00");
      if (file_size>=1024L && file_size<Math.pow(1024,2)) {
       return fmt.format((int)getLengthKB())+" Kb";
      } else if(file_size>=Math.pow(1024,2) && file_size<Math.pow(1024,3)){
       return fmt.format((int)getLengthMB())+" Mb";
      }else if(file_size>=Math.pow(1024,3) && file_size<Math.pow(1024,4)){
        return fmt.format((int)getLengthGB())+" Gb";
      }else if(file_size>=Math.pow(1024,4) && file_size<Math.pow(1024,5)){
        return fmt.format((int)getLengthGB())+" Tb";
      }else if(file_size>0 && file_size<1024L){
        return fmt.format((int)file_size)+" b";
      }else{
        return "0 b";
      }
  }
    
    public long getFile_size() {
        return file_size;
    }

    public void setFile_size(long file_size) {
        this.file_size = file_size;
    }

    public long getFile_current_size() {
        return file_current_size;
    }

    public void setFile_current_size(long file_current_size) {
        this.file_current_size = file_current_size;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }    
}
