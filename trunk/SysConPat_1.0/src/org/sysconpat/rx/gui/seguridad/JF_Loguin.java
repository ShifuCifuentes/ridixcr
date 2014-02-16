package org.sysconpat.rx.gui.seguridad;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.rx.cr.conf.Config;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.cr.util.gui.PanelCurvas;
import org.sysconpat.rx.be.BEContenedor;
import org.sysconpat.rx.be.BEUsuario;
import org.sysconpat.rx.bl.BLRolUsuario;
import org.sysconpat.rx.bl.BLUsuario;
import org.sysconpat.rx.gui.principal.*;
import org.sysconpat.rx.util.ResourceIDVendor;

public final class JF_Loguin extends javax.swing.JFrame {
//    static {
//            JFrame.setDefaultLookAndFeelDecorated(true);
//            JDialog.setDefaultLookAndFeelDecorated(true);      
//        }
    private Config config;   
    
    private BEUsuario beUsuario = null;
    private BLUsuario blUsuario = null;   
    private BLRolUsuario blRol = null;
    private ArrayList<BEContenedor> rolesUsuario=null;
    
    public JF_Loguin(Config config) {
        setConfig(config);
        initComponents();
        centreaVentana(this);
        adaptarMovimiento(this);
        adaptarForma(this,15,15);
        setIconoVentana(this,"/org/sysconpat/rx/resource/SysRent_Min.png");
        addEnterFocusEvent(new Object[][]{{txfUsuario,txpClave}});
        addEnterDoclickEvent(new Object[][]{{txpClave,jButton2}});        
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txfUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txpClave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Iniciar Session");
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 63, 101));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/LoguinMangerIcon_100.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("USUARIO :");

        txfUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        txfUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txfUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfUsuarioFocusLost(evt);
            }
        });
        txfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfUsuarioKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("CLAVE :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("INICIAR SESSION");
        //jLabel4.setText(ResourceIDVendor.APP_ID);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        txpClave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txpClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txpClave.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        txpClave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txpClaveFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txpClaveFocusLost(evt);
            }
        });
        txpClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txpClaveKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfUsuario)
                                    .addComponent(txpClave))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txpClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUsuarioKeyPressed
       escapeExit(evt);
    }//GEN-LAST:event_txfUsuarioKeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
       escapeExit(evt);
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
      escapeExit(evt);
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void txpClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txpClaveKeyPressed
        escapeExit(evt);
    }//GEN-LAST:event_txpClaveKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            validarDatosUsuario();
        } catch (Exception ex) {
            Logger.getLogger(JF_Loguin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txfUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfUsuarioFocusLost
       txfUsuario.setBackground(Color.WHITE);
       txfUsuario.setForeground(new Color(0,102,51));
    }//GEN-LAST:event_txfUsuarioFocusLost

    private void txfUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfUsuarioFocusGained
        txfUsuario.setBackground(new Color(204,255,255));//0,63,101     
        txfUsuario.setForeground(new Color(0,63,101));
    }//GEN-LAST:event_txfUsuarioFocusGained

    private void txpClaveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txpClaveFocusGained
        txpClave.setBackground(new Color(204,255,255));
        txpClave.setForeground(new Color(0,63,101));
    }//GEN-LAST:event_txpClaveFocusGained

    private void txpClaveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txpClaveFocusLost
       txpClave.setBackground(Color.WHITE);
       txpClave.setForeground(new Color(0,102,51));
    }//GEN-LAST:event_txpClaveFocusLost
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txfUsuario;
    private javax.swing.JPasswordField txpClave;
    // End of variables declaration//GEN-END:variables

    public void validarDatosUsuario() throws Exception{   
        blUsuario = new BLUsuario(getConfig());        
            if (txfUsuario.getText().trim().length()>0 || txpClave.getText().trim().length()>0) {  
                    beUsuario = blUsuario.autenticarUsuario(txfUsuario.getText().trim(),txpClave.getText().trim());
                    if (beUsuario!=null) {                            
                            if (beUsuario.getEstado()==true) {  
                                blRol = new BLRolUsuario(getConfig());
                                rolesUsuario = blRol.listar_modulos_usuario(beUsuario.getId_usuario());                                  
                                inicialSistemaPrincipal();                                                                  
                            }else{
                                txfUsuario.requestFocus();
                                JOptionPane.showMessageDialog(this,"Su cuenta se encuentra inactiva \ncontactese con el administrador ","Atencion",JOptionPane.INFORMATION_MESSAGE);
                            }   
                    } else {
                       txfUsuario.requestFocus();
                       JOptionPane.showMessageDialog(this,"Usuario o Clave incorrectos","Error",JOptionPane.ERROR_MESSAGE); 
                    }
            } else {
                txfUsuario.requestFocus();
                JOptionPane.showMessageDialog(this,"Ingrese todos los datos de su cuenta.","Atencion",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    private void inicialSistemaPrincipal() {        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                try {
                 JF_Principal   root = new JF_Principal();
                 root.setConfig(getConfig());
                 root.setModulos_cargados(rolesUsuario);
                 root.setLoguin(JF_Loguin.this);
                 dispose();
                 txfUsuario.setText("");
                 txpClave.setText("");
                 txfUsuario.requestFocus();
                } catch (Exception ex) {
                    Logger.getLogger(JF_Loguin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });  
    }
}
