
package org.rx.systienda.gui;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.rx.systienda.bean.BEProducto;
import org.rx.systienda.bl.BLAlmacenPrimario;
import org.rx.systienda.bl.BLAlmacenVenta;
import org.rx.systienda.gui.model.ModeloEntrega;
import org.rx.systienda.gui.model.ModeloRalizarEntrega;


public final class AdministarEntrega extends javax.swing.JInternalFrame {

    private ModeloEntrega modelEntrega = null;
    private ModeloRalizarEntrega modelRealizarEntrega = null;
    private PrincipalTienda root=null;    
    private BLAlmacenPrimario bl1 = null;  
    private BLAlmacenVenta bl2 = null;
    public BEProducto bean=null;
 
   
    
    public AdministarEntrega(PrincipalTienda root) {
        initComponents();
        this.root=root;
        modelEntrega = new ModeloEntrega();
        modelRealizarEntrega = new ModeloRalizarEntrega();
        jTable1.setModel(modelEntrega);
        jTable2.setModel(modelRealizarEntrega);
        personalizaTabla(jTable2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        jSpinner1 = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Administrar Entrega Producto");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Administrar Entrega Producto");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTA DE PRODUCTOS ALMACEN PRIMARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel1.setOpaque(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Denominacion", "Stock fraccionario", "Cantidad_Almac"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setOpaque(false);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(3).setResizable(false);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTA DE PRODUCTOS ALMACEN VENTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel3.setOpaque(false);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Denominacion", "Presentacion", "Cantidad_Tienda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setOpaque(false);
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/search.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTextField2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel());
        jSpinner1.setEnabled(false);
        jSpinner1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSpinner1KeyReleased(evt);
            }
        });

        jButton2.setText(">");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("<");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Stock Entregado");

        jButton5.setText("Cancelar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 13, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jButton2)
                        .addGap(6, 6, 6)
                        .addComponent(jButton3))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(Guardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinner1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner1KeyReleased
        //Utilitarios.validaCaracterNumerico(evt, jSpinner1);
    }//GEN-LAST:event_jSpinner1KeyReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
      jButton1.doClick();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       listarProducto();
       Guardar.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         simulaEntregaProducto();    
         jButton2.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        simulaEntregaCancelada();   
        jButton3.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        registraEntregaProducto();  
        Guardar.setEnabled(false);
    }//GEN-LAST:event_GuardarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       cancelarEntregaProducto();       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        listarProductoVenta();
        jButton3.setEnabled(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        jButton4.doClick();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
       jButton3.setEnabled(true);
        bean=modelRealizarEntrega.get(jTable2.getSelectedRow());
    }//GEN-LAST:event_jTable2MouseReleased

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        jSpinner1.setEnabled(true);
        jSpinner1.setValue(0);
        jButton2.setEnabled(true);
        Guardar.setEnabled(true);
        bean=modelEntrega.get(jTable1.getSelectedRow());
    }//GEN-LAST:event_jTable1MouseReleased

    public void listarProducto(){
       try {
            bl1 = new BLAlmacenPrimario(root.getConf());
            ArrayList<BEProducto> list  = bl1.buscarReferencia(jTextField1.getText().trim());
            modelEntrega.addAll(list); 
            jSpinner1.setValue(0);
            jSpinner1.setEnabled(false);
            jButton2.setEnabled(false);
        } catch (Exception ex) {            
            Logger.getLogger(AdministarEntrega.class.getName()).log(Level.SEVERE, null, ex);            
        }         
    }
    public void listarProductoVenta(){
       try {
            bl2 = new BLAlmacenVenta(root.getConf());
            ArrayList<BEProducto> list  = bl2.buscarReferencia(jTextField2.getText().trim());
            modelRealizarEntrega.addAll(list);            
            jSpinner1.setValue(0);
            jSpinner1.setEnabled(false);
            jButton2.setEnabled(false);
            personalizaTabla(jTable2);
        } catch (Exception ex) {            
            Logger.getLogger(AdministarEntrega.class.getName()).log(Level.SEVERE, null, ex);            
        }         
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private void simulaEntregaProducto() {
       try {                       
            if (bean.getStock()>=Integer.parseInt(jSpinner1.getValue().toString()) && Integer.parseInt(jSpinner1.getValue().toString())>0) {
                bl1 = new BLAlmacenPrimario(root.getConf());
                if (!bl1.consultaStockAlmacenVenta(bean.getId_producto())) {
                    bean.setStock(Integer.parseInt(jSpinner1.getValue().toString()));                    
                    bean.setBand_entrega(true);                                         
                    jSpinner1.setValue(0);
                    jSpinner1.setEnabled(false); 
                    bl1.actualizarStockAlmacenEntregaRealizada(bean);                     
                    modelRealizarEntrega.add(bean);  
                    listarProducto();     
                }else{
                    JOptionPane.showMessageDialog(this,"Todavia Existen Productos Por Vender\nen el Almacen de Venta.\nPrimero termine de venderlo para poder\nrealizar una nueva entrega.","Atencion",JOptionPane.INFORMATION_MESSAGE);
                    jSpinner1.setValue(0);
                    jSpinner1.setEnabled(false);
                    jButton2.setEnabled(false);
                    jButton4.doClick();
                }                     
            } else if(Integer.parseInt(jSpinner1.getValue().toString())==0){
                JOptionPane.showMessageDialog(this,"Especifique una cantidad ","Atencion",JOptionPane.INFORMATION_MESSAGE);                                
            }else{
            JOptionPane.showMessageDialog(this,"Stock Actual Insuficiente","Atencion",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {  
            Logger.getLogger(AdministrarVenta.class.getName()).log(Level.SEVERE, null, ex);            
        } 
    }

    private void simulaEntregaCancelada() {
        try { 
          bl1 = new BLAlmacenPrimario(root.getConf());
            if (bean.isBand_entrega()) {
                bean = modelRealizarEntrega.get(jTable2.getSelectedRow());
                modelRealizarEntrega.remove(jTable2.getSelectedRow());
                modelRealizarEntrega.getListaAux().remove(bean);
                bl1.actualizarStockAlmacenEntregaCancelada(bean);                          
                listarProducto();
            }          
        }catch (Exception ex) {            
            Logger.getLogger(AdministrarVenta.class.getName()).log(Level.SEVERE, null, ex);            
        } 
    }

    private void registraEntregaProducto() {
       bl1 = new BLAlmacenPrimario(root.getConf()); 
       try { 
        int id_venta= bl1.registrarEntrega(root.getBeanUser().getId_cuenta());
        int szaux = modelRealizarEntrega.getListaAux().size();
        for (int i = 0; i < szaux; i++) {
            bean=(BEProducto)modelRealizarEntrega.getListaAux().get(i);            
            bl1.registrar_detalle_Entrega(bean,id_venta);
        }
         modelRealizarEntrega.clear();         
         modelRealizarEntrega.getListaAux().clear();
         jButton4.doClick();
        } catch (Exception ex) {             
                Logger.getLogger(AdministrarVenta.class.getName()).log(Level.SEVERE, null, ex);               
        } 
    }
    private void cancelarEntregaProducto() {
       bl1 = new BLAlmacenPrimario(root.getConf());         
       try {         
        int szaux = modelRealizarEntrega.getListaAux().size();
        for (int i = 0; i < szaux; i++) {
            bean=modelRealizarEntrega.getListaAux().get(i);            
            bl1.actualizarStockAlmacenEntregaCancelada(bean);
        }
         modelRealizarEntrega.clear();
         modelRealizarEntrega.getListaAux().clear();         
         listarProducto();
         jButton3.setEnabled(false);
         jButton2.setEnabled(false);
         jSpinner1.setEnabled(false);
         jSpinner1.setValue(0);
        } catch (Exception ex) {
                Logger.getLogger(AdministrarVenta.class.getName()).log(Level.SEVERE, null, ex);                
        } 
    }
    public void personalizaTabla(JTable tb){        
    // Utilitarios.inmovilizaColumnas(tb);
        /*
     Utilitarios.alinearDatosColumnaTablaCentro(2,tb);
     Utilitarios.alinearDatosColumnaTablaCentro(3,tb);
     Utilitarios.alinearDatosColumnaTablaCentro(4,tb);*/
    }
}
