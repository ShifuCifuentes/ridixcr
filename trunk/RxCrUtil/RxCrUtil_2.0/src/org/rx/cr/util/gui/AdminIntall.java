package org.rx.cr.util.gui;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.rx.cr.conf.Config;
import static org.rx.cr.db.DBA.*;
import org.rx.cr.ds.DSConeccion;
import static org.rx.cr.util.Utilitarios.*;

public class AdminIntall extends javax.swing.JDialog {
    private ConfigServer server;
    private ConfigClient client;
    private Frame parent;  
    private Config conf;
    public AdminIntall(java.awt.Frame parent,String app_name) {
        super(parent, true);
        initComponents();        
        this.parent=parent;
        server = new ConfigServer(this.parent,app_name);        
        precargaConfig(server.getConfig());
        client = new ConfigClient(this.parent,app_name);
        precargaConfig(client.getConfig());
        setIconoVentana(this,"/org/rx/cr/resource/advancedsettings_min.png");
        centreaVentana(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("INSTALACION");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modo de Instalacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/cr/resource/Server.png"))); // NOI18N
        jButton1.setText("Server");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/cr/resource/Client.png"))); // NOI18N
        jButton2.setText("Client");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/cr/resource/advancedsettings_min.png"))); // NOI18N

        jLabel3.setText("Elija el modo de instalacion");

        jLabel4.setText("que desea para el sistema.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        serverConfig();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clientConfig();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //cerrar(this);
        salir(this);
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(AdminIntall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                selectMYSQL();
                AdminIntall dialog = new AdminIntall(new javax.swing.JFrame(),"CSJA");
                dialog.setTableTest("reportecsj.personal");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void serverConfig() {
        setVisible(false);        
        jButton2.setEnabled(false); 
        setConf(server.getConfig());
        if (getConf()!=null){
            //<editor-fold defaultstate="collapsed" desc="Verificacion de integridad de BD">
            Connection connection = new DSConeccion(getConf()).getConeccion();
            if(connection!=null){
                try {connection.close();} catch (SQLException ex) {}
                if (!server.isValidDBStructure()) {
                    //<editor-fold defaultstate="collapsed" desc="Falta Implementar">
//                    bcpr = new BackupRestore(this,server.getConfig());
//                    bcpr.validaRestauracionBackUp();
//                    switch(selectedDBA()){
//                        case DERBY: break;
//                        case DB2: break;
//                        case MYSQL:  break;
//                        case ORACLE: break;
//                        case POSTGRESQL: break;
//                        case SQLSERVER: break;
//                    }         
                    //</editor-fold>
                    JOptionPane.showMessageDialog(this,"Asegurese de que el servidor esta funcionando correctamente.","Atencion",JOptionPane.ERROR_MESSAGE);
                }else{                    
                    parent.setVisible(true);
                } 
            }else{
                JOptionPane.showMessageDialog(this,"El archivo de configuracion posee datos\nerroneos por favor corrijalos!.","Atencion",JOptionPane.ERROR_MESSAGE);
                server.setVisible(true); 
                server.preCargaDatosConfiguracion();
            }
            //</editor-fold>
        }else{
            JOptionPane.showMessageDialog(this,"Configure datos del servidor","Atencion",JOptionPane.ERROR_MESSAGE);
            server.setVisible(true);
        }          
        
    }
    private void clientConfig() {        
        setVisible(false);        
        jButton1.setEnabled(false);
        setConf(client.getConfig());
        if (getConf()!=null){
            //<editor-fold defaultstate="collapsed" desc="Verificacion de integridad de BD">
            Connection connection = new DSConeccion(getConf()).getConeccion();
            if(connection!=null){
                try {connection.close();} catch (SQLException ex) {}
                if (!client.isValidDBStructure()) {
                    JOptionPane.showMessageDialog(this,"Asegurese de que el servidor esta funcionando correctamente.","Atencion",JOptionPane.ERROR_MESSAGE);
                }else{
                    parent.setVisible(true);
                } 
            }else{
                JOptionPane.showMessageDialog(this,"El archivo de configuracion posee datos\nerroneos por favor corrijalos!.","Atencion",JOptionPane.ERROR_MESSAGE);
                client.setVisible(true); 
                client.preCargaDatosConfiguracion();
            }
            //</editor-fold>
        }else{
            JOptionPane.showMessageDialog(this,"Configure datos del servidor","Atencion",JOptionPane.ERROR_MESSAGE);
            client.setVisible(true);
        }        
    }

    public void setTableTest(String tableTest) {
        server.setTableTest(tableTest);        
        client.setTableTest(tableTest);        
    }

    public Config getConf() {
        return conf;
    }

    public void setConf(Config conf) {
        this.conf = conf;
    }

    private void precargaConfig(Config config) {
        if (getConf()==null) {
            setConf(config);
        }        
    }
}
