package org.sysconpat.rx.gui.principal;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import javax.swing.SwingWorker;
import org.rx.cr.util.Utilitarios;
import org.sysconpat.rx.SysConPat;
import org.sysconpat.rx.gui.seguridad.JF_Loguin;
import org.sysconpat.rx.util.ResourceIDVendor;
import static org.rx.cr.util.Utilitarios.*;


public class JF_Splash extends javax.swing.JFrame implements PropertyChangeListener{
//    static {
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        JDialog.setDefaultLookAndFeelDecorated(true);     
//        SubstanceLookAndFeel.setSkin(new OfficeBlack2007Skin());        
//    }
    private Task progress_gestor;   
    
    public JF_Splash() {
        initComponents();
        Utilitarios.adaptarForma(this,30,30);
        Utilitarios.centreaVentana(this);
        Utilitarios.adaptarMovimiento(this);
        Utilitarios.aplicaTransparencia(this);
        Utilitarios.setIconoVentana(this,"/org/sysconpat/rx/resource/SysRent_Min.png");
        progress_gestor = new Task();
        progress_gestor.addPropertyChangeListener(this);
        progress_gestor.execute();    
    }
    @SysConPat(author=RidixCr)
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);

        setTitle(ResourceIDVendor.CLIENT_APP_ID);
        jPanel1.setOpaque(false);

        setTitle(ResourceIDVendor.CLIENT_APP_ID);
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/Splash_Cergus.png"))); // NOI18N
        setTitle(ResourceIDVendor.CLIENT_APP_ID);
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 372, 210);

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(135, 194, 254));
        jProgressBar1.setBorderPainted(false);
        jProgressBar1.setFocusable(false);
        jProgressBar1.setIndeterminate(true);
        jProgressBar1.setString("Progreso de carga...");
        jProgressBar1.setStringPainted(true);
        setTitle(ResourceIDVendor.CLIENT_APP_ID);
        jPanel2.add(jProgressBar1);
        jProgressBar1.setBounds(165, 91, 190, 18);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

    public class Task extends SwingWorker<Void,Void> {
        @Override
        public Void doInBackground() {
            Random random = new Random();
            int progress = 0;
            setProgress(0);
            try {
                Thread.sleep(500+random.nextInt(500));
                }
            catch (InterruptedException ignore) {}
            while (progress<100) {
                try {
                    Thread.sleep(random.nextInt(500));
                    }
                catch (InterruptedException ex) {}
                progress += random.nextInt(10);
                setProgress(Math.min(progress,100));                
            }
            return null;
        }        
        @Override
        public void done() { 
            loguin();           
            setCursor(null);
          }
    }
    private void loguin() {           
           java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new JF_Loguin();
                    dispose();
                }
            }); 
        }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress".equals(evt.getPropertyName())) {
          int progress = (Integer)evt.getNewValue();
          jProgressBar1.setIndeterminate(false);
          jProgressBar1.setValue(progress);
          jProgressBar1.setString(String.format("  Progreso de carga al %d%%",progress_gestor.getProgress())+" ...");
        }
    }
}
