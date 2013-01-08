package org.rx.systienda.gui;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.rx.cr.ds.DSConeccion;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.cr.util.gui.ShapeDecorated;
import org.rx.cr.util.gui.UndecoratedMove;
import org.rx.systienda.bean.BECuenta;
import org.rx.systienda.bl.BLCuenta;
import org.rx.systienda.dao.DAOCuenta;


public final class IniciarSession extends javax.swing.JDialog {

    private UndecoratedMove moveAdapter=null;   
    private ShapeDecorated guiDecorated = null;    
    private BECuenta bean=null;
    private BLCuenta bl;
    private PrincipalTienda root=null;    
    public IniciarSession(PrincipalTienda root) {
        super(root,true);
        initComponents();
        this.root=root;
        personalizaLoguin();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txfUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txpClave = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Usuario :");

        txfUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txfUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfUsuarioActionPerformed(evt);
            }
        });
        txfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfUsuarioKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Clave :");

        txpClave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txpClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txpClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txpClaveActionPerformed(evt);
            }
        });
        txpClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txpClaveKeyPressed(evt);
            }
        });

        jButton1.setText("Aceptar");
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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/logoBotica1.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/logoBotica.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/logoBotica2.png"))); // NOI18N

        jButton2.setText("Cancelar");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txfUsuario)
                                    .addComponent(txpClave, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))
                        .addGap(29, 29, 29)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txpClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(294, 294, 294))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUsuarioKeyPressed
      escapeExit(evt);
    }//GEN-LAST:event_txfUsuarioKeyPressed

    private void txpClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txpClaveKeyPressed
         escapeExit(evt);
    }//GEN-LAST:event_txpClaveKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        escapeExit(evt);
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
       escapeExit(evt);
    }//GEN-LAST:event_jButton2KeyPressed

    private void txfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfUsuarioActionPerformed
       txpClave.requestFocus();
    }//GEN-LAST:event_txfUsuarioActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       txfUsuario.requestFocus();
    }//GEN-LAST:event_formComponentShown

    private void txpClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txpClaveActionPerformed
       jButton1.doClick();
    }//GEN-LAST:event_txpClaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       logueaConfigura();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void personalizaLoguin(){
        moveAdapter = new UndecoratedMove();
        moveAdapter.MoveAdapter(this);
        guiDecorated = new ShapeDecorated();
        guiDecorated.applyShape(this,30f,30f);        
        centreaVentana(this);
    }
    public void escapeExit(KeyEvent evt){
      if (evt.getKeyCode()==KeyEvent.VK_ESCAPE) {
            System.exit(0);
      }
    }
    
    public void validaConfFile(){
     if (root.getConf()==null){      
       JOptionPane.showMessageDialog(this,"No Posee con Ningun Dato de Coneccion con el servidor de base de datos\n primero configurelo y resien inicie el sistema.","Atencion",JOptionPane.ERROR_MESSAGE);
       root.jdConf.setVisible(true);
     }
    }
    public void logueaConfigura(){       
       try {            
            bl = new BLCuenta(root.getConf());      
            if (txfUsuario.getText().trim().length()>0 || txpClave.getText().trim().length()>0) {
                bean = bl.validarLoguinPersonal(txfUsuario.getText().trim(),txpClave.getText().trim());
                if (bean!=null) {
                    //bean = dao.validarLoguinPersonal(txfUsuario.getText().trim(),txpClave.getText().trim());
                    //if (bean!=null) {
                        if (bean.getEstado()==true) {//Usuario Activo                        
                            if (bean.getRol().toLowerCase().startsWith("administrador")) {
                                root.configuraInterfazAdministrador();
                                root.desavilitarLoguin();    
                                txfUsuario.requestFocus();
                            } else if(bean.getRol().toLowerCase().startsWith("vendedor")){
                               root.configuraInterfazVendedor();
                               root.desavilitarLoguin();  
                               txfUsuario.requestFocus();
                            }
                            //root.setUser_id(bean.getId_cuenta());
                            root.setBeanUser(bean);
                            txfUsuario.setText("");
                            txpClave.setText("");
                            txfUsuario.requestFocus();
                            dispose();
                            root.setVisible(true);                        
                        }else{//Usuario Inactivo
                          txfUsuario.requestFocus();
                         JOptionPane.showMessageDialog(this,"Estimado Usuario su Cuenta se Encuentra\ninactiva por favor contactese con el \nadministrador de cuentas para que lo habilite.","Atencion",JOptionPane.INFORMATION_MESSAGE);
                        }   
                    /*} else {
                       txfUsuario.requestFocus();
                       JOptionPane.showMessageDialog(this,"Usuario o Clave Invalidos","Error",JOptionPane.ERROR_MESSAGE); 
                    }*/
                } else {
                    txfUsuario.requestFocus();
                    JOptionPane.showMessageDialog(this,"Usuario o Clave Invalidos","Error",JOptionPane.ERROR_MESSAGE);
                }
            } else {
                txfUsuario.requestFocus();
                JOptionPane.showMessageDialog(this,"Por Favor Ingrese sus Datos","Atencion",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(IniciarSession.class.getName()).log(Level.SEVERE, null, ex);            
        }      
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txfUsuario;
    private javax.swing.JPasswordField txpClave;
    // End of variables declaration//GEN-END:variables
}
