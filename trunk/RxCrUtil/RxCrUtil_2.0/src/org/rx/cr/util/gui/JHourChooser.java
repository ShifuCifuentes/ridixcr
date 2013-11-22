package org.rx.cr.util.gui;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.rx.cr.util.Utilitarios.*;

public final class JHourChooser extends javax.swing.JPanel implements Runnable{
    private Date current_time = null;
    private Thread hilo;
    public JHourChooser() {
        initComponents();   
        setCurrentTime(); 
       hilo = new Thread(this);
       hilo.start();
    }
    @Override
    public void setEnabled(boolean enable){
        js_hour.setEnabled(enable);
        js_minute.setEnabled(enable);
        js_horario.setEnabled(enable);
    }
    public void setCurrentTime(){
     current_time= new Date();
     if (current_time.getHours()>=00 && current_time.getHours()<12) {
            if (current_time.getHours()==00) {
                js_hour.setValue(12);
                js_horario.setValue("AM");                
            } else {
                js_hour.setValue(current_time.getHours());
                js_horario.setValue("AM");                
            }
        }else if(current_time.getHours()>=12 && current_time.getHours()<=23){
           if (current_time.getHours()==12) {
                js_hour.setValue(12);
                js_horario.setValue("PM");                  
            } else {
               js_hour.setValue(current_time.getHours()-12);
               js_horario.setValue("PM");                 
            }
           
        }
        js_minute.setValue(current_time.getMinutes());        
    }
    
    public String getHour(){
        return numberFormat(Integer.parseInt(js_hour.getValue().toString().trim()),"##");
    }
    public String getMinute(){
        return numberFormat(Integer.parseInt(js_minute.getValue().toString().trim()),"##");
    }
    public String getHorario(){
        return js_horario.getValue().toString();
    }
    public String getTime(){
        return numberFormat(Integer.parseInt(js_hour.getValue().toString().trim()),"##")+":"+numberFormat(Integer.parseInt(js_minute.getValue().toString().trim()),"##")+" "+js_horario.getValue().toString();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        js_hour = new javax.swing.JSpinner();
        js_minute = new javax.swing.JSpinner();
        js_horario = new javax.swing.JSpinner();

        js_hour.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        js_hour.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        js_minute.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        js_minute.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        js_horario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        js_horario.setModel(new javax.swing.SpinnerListModel(new String[] {"AM", "PM"}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(js_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(js_minute, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(js_horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(js_hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(js_minute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(js_horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner js_horario;
    private javax.swing.JSpinner js_hour;
    private javax.swing.JSpinner js_minute;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (true) {     
            setCurrentTime();
            try {Thread.sleep(1000);} catch (InterruptedException ex) {}
        }
    }
}
