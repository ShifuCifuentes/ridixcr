
package org.rx.systienda.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.systienda.bean.BEProducto;
import org.rx.systienda.bl.BLAlmacenVenta;
import org.rx.systienda.bl.BLVenta;
import org.rx.systienda.gui.model.ModeloRealizaVenta;
import org.rx.systienda.gui.model.ModeloVenta;


public class AdministrarVenta extends javax.swing.JInternalFrame {
    private BLVenta bl1;
    private BLAlmacenVenta bl2;
    public ModeloVenta modelo=null;
    public BEProducto bean=null;
    public ModeloRealizaVenta modeloventa=null;
    private PrincipalTienda root=null;    
    private static final int UNITARIO=1,FRACCIONARIO=2,SUB_FRACCIONARIO=3;

    public AdministrarVenta(PrincipalTienda root) {
        initComponents();
        modelo=new ModeloVenta();
        modeloventa=new ModeloRealizaVenta();
        jTable1.setModel(modelo);
        jTable2.setModel(modeloventa);
        this.root=root;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Realizar Venta");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTA DE PRODUCTOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel1.setOpaque(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Denominacion", "Presentacion", "Stock actual", "Precio de Venta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowHorizontalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "LISTA DE PRODUCTOS SELECCIONADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel2.setOpaque(false);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Denominacion", "Presentacion", "Cantidad", "Precio Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.setShowHorizontalLines(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText(">");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("<");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setText("Total : S/.");

        jTextField2.setEditable(false);

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSpinner1.setEnabled(false);
        jSpinner1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jSpinner1KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cantidad");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tipo Compra");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>", "Unitario", "Fraccionario", "S.Mayoritario" }));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Administrar Venta");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 845, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(280, 280, 280)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))))
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton5)
                            .addGap(269, 269, 269))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3)
                                .addComponent(jButton2)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinner1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner1KeyReleased
        //Utilitarios.validaCaracterNumerico(evt, jSpinner1);
    }//GEN-LAST:event_jSpinner1KeyReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        jButton1.doClick();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listarProductoVenta();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
       
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       /*jSpinner1.setEnabled(true);
       jButton4.setEnabled(true);
       bean=(BEProducto)modelo.get(jTable1.getSelectedRow());*/
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        simularEntregaProductoVenta();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
              
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     simularCancelacionVenta();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
       jSpinner1.setEnabled(true);
       jButton4.setEnabled(true);       
       jButton5.setEnabled(false);        
       jTable2.clearSelection();        
       bean=modelo.get(jTable1.getSelectedRow());
    }//GEN-LAST:event_jTable1MouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       cancelarVenta();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       registrarVenta();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        jButton5.setEnabled(true);
        jButton4.setEnabled(false);
        jTable1.clearSelection();
        bean=modeloventa.get(jTable2.getSelectedRow()); 
    }//GEN-LAST:event_jTable2MouseReleased

    public void listarProductoVenta(){
       try {
            bl2 = new BLAlmacenVenta(root.getConf());
            ArrayList<BEProducto> list  = bl2.buscarReferencia(jTextField1.getText().trim());
            modelo.addAll(list);            
            jSpinner1.setValue(0);
            jSpinner1.setEnabled(false);
            jButton2.setEnabled(false);
        } catch (Exception ex) {            
            Logger.getLogger(AdministarEntrega.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }    
    private void cancelarVenta() {
       bl1 = new BLVenta(root.getConf());
       try { 
        for (int i = 0; i < modeloventa.size(); i++) {
            bean=modeloventa.get(i);            
            bl1.actualizarStockAlmacenVentaCancelada(bean);
        }
         modeloventa.clear();
         jTextField2.setText("");
         listarProductoVenta();
         jButton5.setEnabled(false);
         jButton4.setEnabled(false);
         jSpinner1.setEnabled(false);
         jSpinner1.setValue(0);
         simulaActivacionRegistro();
        } catch (Exception ex) {                
           Logger.getLogger(AdministrarVenta.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    private void simularEntrega() throws SQLException{ 
         bl1 = new BLVenta(root.getConf());
         double prvt = (bean.getPrecio_compra()+(bean.getPrecio_compra()*(bean.getPorcentaje_utilidad()/100)));
             if (jComboBox1.getSelectedIndex()==3) {//mayoritario
               bean.setTip_compra(UNITARIO);//   
               bean.setPrecio_venta(Integer.parseInt(jSpinner1.getValue().toString())*prvt);                      
               bean.setStock(Integer.parseInt(jSpinner1.getValue().toString()));                      
             }else if(jComboBox1.getSelectedIndex()==2){
               bean.setTip_compra(FRACCIONARIO);   //fraccionario
               bean.setPrecio_venta(Integer.parseInt(jSpinner1.getValue().toString())*(prvt/bean.getStock_fraccionario_referencia()));
               bean.setStock(Integer.parseInt(jSpinner1.getValue().toString()));                        
             }else if(jComboBox1.getSelectedIndex()==1){
               bean.setTip_compra(SUB_FRACCIONARIO); //unitario
               bean.setPrecio_venta(Integer.parseInt(jSpinner1.getValue().toString())*((prvt/bean.getStock_fraccionario_referencia())/bean.getStock_fraccionario_unitario_referencia()));
               bean.setStock(Integer.parseInt(jSpinner1.getValue().toString()));                        
             }
         bl1.actualizarStockAlmacenVentaRealizada(bean);
         modeloventa.add(bean);
         jSpinner1.setValue(0);
         jSpinner1.setEnabled(false);  
         jButton4.setEnabled(false);
         jButton5.setEnabled(false);
         listarProductoVenta(); 
         jTextField2.setText(numberFormat(modeloventa.importeTotal(),"#.##"));
    }
    private void simularEntregaProductoVenta() {
        try { 
            if (jComboBox1.getSelectedIndex()>0) {
                bl1 = new BLVenta(root.getConf());
                if (jComboBox1.getSelectedIndex()==3) {
                    if (bean.getStock()>=Integer.parseInt(jSpinner1.getValue().toString()) && Integer.parseInt(jSpinner1.getValue().toString())>0) {
                      simularEntrega();  
                    }else if(Integer.parseInt(jSpinner1.getValue().toString())==0){
                        JOptionPane.showMessageDialog(this,"Especifique una cantidad ","Atencion",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this,"Stock Actual Insuficiente.","Atencion",JOptionPane.INFORMATION_MESSAGE);                                                  
                        bl1.reEstructurarStockAlmacenVenta(bean.getId_producto(),FRACCIONARIO,Integer.parseInt(jSpinner1.getValue().toString()));
                        listarProductoVenta();
                    }
                    jSpinner1.setValue(0);
                    jSpinner1.setEnabled(false);  
                    jButton4.setEnabled(false);
                    jButton5.setEnabled(false);                    
                }else if (jComboBox1.getSelectedIndex()==2){
                    if (bean.getStock_fraccionario()>=Integer.parseInt(jSpinner1.getValue().toString()) && Integer.parseInt(jSpinner1.getValue().toString())>0) {
                        simularEntrega();  
                    }else if(Integer.parseInt(jSpinner1.getValue().toString())==0){
                        JOptionPane.showMessageDialog(this,"Especifique una cantidad ","Atencion",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this,"Stock Actual Insuficiente.","Atencion",JOptionPane.INFORMATION_MESSAGE);
                        bl1.reEstructurarStockAlmacenVenta(bean.getId_producto(),FRACCIONARIO,Integer.parseInt(jSpinner1.getValue().toString()));
                        listarProductoVenta();
                    }
                    jSpinner1.setValue(0);
                    jSpinner1.setEnabled(false);  
                    jButton4.setEnabled(false);
                    jButton5.setEnabled(false);
                }else if (jComboBox1.getSelectedIndex()==1){
                    if (bean.getStock_fraccionario_unitario()>=Integer.parseInt(jSpinner1.getValue().toString()) && Integer.parseInt(jSpinner1.getValue().toString())>0) {
                        simularEntrega();  
                    }else if(Integer.parseInt(jSpinner1.getValue().toString())==0){
                       JOptionPane.showMessageDialog(this,"Especifique una cantidad ","Atencion",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                       JOptionPane.showMessageDialog(this,"Stock Actual Insuficiente.","Atencion",JOptionPane.INFORMATION_MESSAGE);
                       bl1.reEstructurarStockAlmacenVenta(bean.getId_producto(),SUB_FRACCIONARIO,Integer.parseInt(jSpinner1.getValue().toString()));
                       listarProductoVenta();
                    }
                    jSpinner1.setValue(0);
                    jSpinner1.setEnabled(false);  
                    jButton4.setEnabled(false);
                    jButton5.setEnabled(false);
                } 
                simulaActivacionRegistro();
            }else{
                JOptionPane.showMessageDialog(this,"Especifique tipo de Compra.","Atencion",JOptionPane.INFORMATION_MESSAGE);  
                jSpinner1.setValue(0);
                jSpinner1.setEnabled(false);  
                jButton4.setEnabled(false);
                jButton5.setEnabled(false);
            }            
        } catch (SQLException ex) {  
            Logger.getLogger(AdministrarVenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this,"Seleccione un producto de la lista","Atencion",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void simularCancelacionVenta() {
       try { 
          bl1 = new BLVenta(root.getConf());
          modeloventa.remove(jTable2.getSelectedRow());          
          bl1.actualizarStockAlmacenVentaCancelada(bean);
          jTextField2.setText(numberFormat(modeloventa.importeTotal(),"#.#"));
          listarProductoVenta();
          simulaActivacionRegistro();
        } catch (Exception ex) {            
            Logger.getLogger(AdministrarVenta.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    private void registrarVenta() {
       bl1 = new BLVenta(root.getConf());   
       try { 
        int id_venta= bl1.registrar(this.root.getBeanUser().getId_cuenta());
        for (int i = 0; i < modeloventa.size(); i++) {
            bean=modeloventa.get(i);      
            root.ticketVenta.add(bean);
            bl1.registrar_detalle_venta(bean,id_venta);
        }
         modeloventa.clear();         
         jTextField2.setText("");         
         jButton5.setEnabled(false);
         jButton4.setEnabled(false);
         jSpinner1.setEnabled(false);
         jSpinner1.setValue(0);
         jButton2.setEnabled(false);
         JOptionPane.showMessageDialog(this,"Registro de Venta Exitoso.","Atencion",JOptionPane.INFORMATION_MESSAGE);         
         //root.insertarInternalFrame(root.ticketVenta);
         //root.ticketVenta.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(AdministrarVenta.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    private void simulaActivacionRegistro() {
        if (modeloventa.size()>0) {
           jButton2.setEnabled(true);
        }else{
          jButton2.setEnabled(false);
        }
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    
}
