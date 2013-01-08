package org.rx.systienda.gui;




import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;
import org.rx.cr.ds.DSConeccion;
import org.rx.cr.report.ReportGeneric;

public final class EmitirReporte extends javax.swing.JInternalFrame {
    private ReportGeneric reportGeneric=null;
    private PrincipalTienda root=null;
    private JInternalFrame reportFrame=null;
    private JPanel reportPanel=null;
    String titulo = null;
    private DSConeccion ds=null;
    private String reports[][]={{"reporte_venta_fecha","reporte_venta_anio","reporte_ventas_todo"},
                                {"reporte_producto_por_vencer"}};
    
    public EmitirReporte(PrincipalTienda root) {       
        initComponents();        
        this.root=root;
        defaultConfPanel();
        
    }
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jpnlRangoFecha = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        jDateChooser2 = new com.toedter.calendar.JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jpnlDato = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jpnlControles = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxReport = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cbxReportOp = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Emitir Reporte");

        jPanel1.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        jpnlRangoFecha.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha"));
        jpnlRangoFecha.setOpaque(false);

        jLabel4.setText("hasta");

        jLabel3.setText("Desde ");

        javax.swing.GroupLayout jpnlRangoFechaLayout = new javax.swing.GroupLayout(jpnlRangoFecha);
        jpnlRangoFecha.setLayout(jpnlRangoFechaLayout);
        jpnlRangoFechaLayout.setHorizontalGroup(
            jpnlRangoFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlRangoFechaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnlRangoFechaLayout.setVerticalGroup(
            jpnlRangoFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlRangoFechaLayout.createSequentialGroup()
                .addGroup(jpnlRangoFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        /*

        jPanel3.add(jpnlRangoFecha);
        jpnlRangoFecha.setBounds(10, 130, 330, 56);
        */

        jpnlDato.setBorder(javax.swing.BorderFactory.createTitledBorder("Dato"));
        jpnlDato.setOpaque(false);

        jLabel5.setText("Año ");

        javax.swing.GroupLayout jpnlDatoLayout = new javax.swing.GroupLayout(jpnlDato);
        jpnlDato.setLayout(jpnlDatoLayout);
        jpnlDatoLayout.setHorizontalGroup(
            jpnlDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDatoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jYearChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnlDatoLayout.setVerticalGroup(
            jpnlDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlDatoLayout.createSequentialGroup()
                .addGroup(jpnlDatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        /*

        jPanel3.add(jpnlDato);
        jpnlDato.setBounds(10, 70, 330, 58);
        */

        jpnlControles.setOpaque(false);

        jLabel1.setText("Reporte");

        cbxReport.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>", "Venta", "Fecha Vencimiento" }));
        cbxReport.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxReportItemStateChanged(evt);
            }
        });
        cbxReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxReportActionPerformed(evt);
            }
        });

        jLabel2.setText(" Por");

        cbxReportOp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>", "Fecha", "Año", "Todos" }));
        cbxReportOp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxReportOpItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jpnlControlesLayout = new javax.swing.GroupLayout(jpnlControles);
        jpnlControles.setLayout(jpnlControlesLayout);
        jpnlControlesLayout.setHorizontalGroup(
            jpnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlControlesLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxReportOp, 0, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnlControlesLayout.setVerticalGroup(
            jpnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(cbxReportOp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jpnlControles);
        jpnlControles.setBounds(10, 10, 330, 42);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 11, 348, 197);

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(263, 214, 80, 23);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxReportOpItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxReportOpItemStateChanged
        configuraPanel();
    }//GEN-LAST:event_cbxReportOpItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            generaReporte();
        } catch (JRException ex) {
            Logger.getLogger(EmitirReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(EmitirReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxReportItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxReportItemStateChanged
        if (cbxReport.getSelectedIndex()==0) {            
            cbxReportOp.removeAllItems();
            cbxReportOp.addItem("<Seleccionar>");
            cbxReportOp.setSelectedIndex(0);  
            cbxReportOp.setEnabled(true);
        }else if(cbxReport.getSelectedIndex()==1){
            cbxReportOp.removeAllItems();
            cbxReportOp.addItem("<Seleccionar>");
            cbxReportOp.addItem("Fecha");
            cbxReportOp.addItem("Año");
            cbxReportOp.addItem("Todos");
            cbxReportOp.setSelectedIndex(0);  
            cbxReportOp.setEnabled(true);
        }else{           
           cbxReportOp.removeAllItems();
           cbxReportOp.addItem("<Seleccionar>");
           cbxReportOp.setSelectedIndex(0);   
           cbxReportOp.setEnabled(false);
        }      
    }//GEN-LAST:event_cbxReportItemStateChanged

    private void cbxReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxReportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxReportActionPerformed

    public void defaultConfPanel(){
        jDateChooser1.setEnabled(false);
        jDateChooser2.setEnabled(false);
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jYearChooser1.setEnabled(false);
        setSize(382,150);
        jPanel3.remove(jpnlRangoFecha);
        jPanel3.remove(jpnlDato);
        jPanel3.setSize(348,180);
        jButton1.setBounds(285,80, 71, 23);
        jPanel3.setSize(348,60);        
        jPanel3.updateUI();
        jPanel1.setSize(370,115);
        jPanel1.updateUI();
        updateUI();
    }
    public void configuraPanelDatos(){
        jDateChooser1.setEnabled(false);
        jDateChooser2.setEnabled(false);
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jYearChooser1.setEnabled(true);        
        jPanel3.add(jpnlDato);
        jpnlDato.setBounds(10,50, 330, 57);
        jPanel3.setSize(348,120);                    
        jPanel3.remove(jpnlRangoFecha);
        jPanel1.add(jButton1);
        jButton1.setBounds(285,140, 71, 23);
        setSize(382,210);
        jPanel3.updateUI();
        updateUI();
    }
    public void configuraPanelFecha(){
        jDateChooser1.setEnabled(true);
        jDateChooser2.setEnabled(true);
        jDateChooser1.setDate(new Date());
        jDateChooser2.setDate(new Date());
        jYearChooser1.setEnabled(false);
        
        jPanel3.add(jpnlRangoFecha);
        jpnlRangoFecha.setBounds(10,50, 330, 57);   
        jPanel3.setSize(348,120);
        jPanel3.remove(jpnlDato);
        jButton1.setBounds(285,140, 71, 23);
        setSize(382,210);
        jPanel3.updateUI();
        updateUI();
    }
    
    public void configuraPanel(){
     if (cbxReportOp.getSelectedIndex() > 0) {
            switch (cbxReportOp.getSelectedIndex()) {                
                case 1:
                    configuraPanelFecha();
                    break;
                case 2:
                    configuraPanelDatos();
                    break;
                case 3:
                    defaultConfPanel();
                    break;
            }
        }else{
          defaultConfPanel();
        }
    }
    public void generaReporte() throws JRException, Exception{
     if (cbxReport.getSelectedIndex()>0) {
         if (cbxReportOp.getSelectedIndex() > 0 || !cbxReportOp.isEnabled()) {
            switch (cbxReport.getSelectedIndex()) {                
                case 1:
                    ds=new DSConeccion(root.getConf());
                    reportGeneric = new ReportGeneric(ds.getConeccion());                   
                    reportGeneric.setReportParent("/org/rx/systienda/report/");
                    switch(cbxReportOp.getSelectedIndex()){
                        case 1: 
                            reportPanel = reportGeneric.mkReport(reports[0][0],new String[]{"fecha_inicio","fecha_fin"},new Object[]{jDateChooser1.getDate(),jDateChooser2.getDate()});
                            titulo = reports[0][0].replaceAll("_"," ").toUpperCase();
                            break;
                        case 2: 
                            reportPanel = reportGeneric.mkReport(reports[0][1],new String[]{"anio"},new Object[]{new Integer(jYearChooser1.getYear())});
                            titulo = reports[0][1].replaceAll("_"," ").toUpperCase();
                            break;
                        case 3: 
                             reportPanel = reportGeneric.mkReport(reports[0][2]);
                             titulo = reports[0][2].replaceAll("_"," ").toUpperCase();
                            break;
                    }      
                    
                    reportFrame= new JInternalFrame();
                    //reportFrame.setFrameIcon(im);
                    reportFrame.setClosable(true);
                    reportFrame.setIconifiable(true);                    
                    reportFrame.getContentPane().add(reportPanel);
                    reportFrame.setTitle(titulo);
                    root.insertarInternalFrame(reportFrame);
                    reportFrame.setMaximum(true);
                    break;
                case 2:
                    ds=new DSConeccion(root.getConf());
                    reportGeneric = new ReportGeneric(ds.getConeccion());                    
                    reportGeneric.setReportParent("/org/rx/systienda/report/");
                    reportPanel = reportGeneric.mkReport(reports[1][0]);
                    titulo = reports[0][2].replaceAll("_"," ").toUpperCase();
                    reportFrame= new JInternalFrame();
                    //reportFrame.setFrameIcon(im);
                    reportFrame.setClosable(true);
                    reportFrame.setIconifiable(true);
                    reportFrame.getContentPane().add(reportPanel);
                    reportFrame.setTitle(titulo);
                    root.insertarInternalFrame(reportFrame);
                    reportFrame.setMaximum(true);
                    break;                
            } 
         } else {
            JOptionPane.showMessageDialog(null,"Selecciones la opcion correcta \npara generar el reporte...","Atencion",JOptionPane.INFORMATION_MESSAGE); 
         }            
        }else{
         JOptionPane.showMessageDialog(null,"Selecciones la opcion correcta \npara generar el reporte...","Atencion",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxReport;
    private javax.swing.JComboBox cbxReportOp;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JPanel jpnlControles;
    private javax.swing.JPanel jpnlDato;
    private javax.swing.JPanel jpnlRangoFecha;
    // End of variables declaration//GEN-END:variables



}
