package org.sysconpat.rx.gui.locales;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static org.rx.cr.util.Utilitarios.*;
import org.sysconpat.rx.be.BEContenedor;
import org.sysconpat.rx.be.BECuentaContable;
import org.sysconpat.rx.be.BELocal;
import org.sysconpat.rx.be.BETipoCuenta;
import org.sysconpat.rx.be.BEUbigeo;
import org.sysconpat.rx.bl.BLLocal;
import org.sysconpat.rx.gui.models.ModeloLocal;
import org.sysconpat.rx.gui.principal.Principal;
import org.sysconpat.rx.util.UtilContenedor;
import org.sysconpat.rx.util.UtilUbigeo;

public final class JIF_AdministrarLocalesEntidad extends javax.swing.JInternalFrame {
    private Principal root;
    private ModeloLocal model;
    private UtilContenedor utilContenedor=null;
     private UtilUbigeo utilUbigeo=null;
     
     private BELocal be = null;
     private BLLocal bl = null;
     
     private static final int NUEVO=1,MODIFICAR=2,DESCONOCIDO=-1;
     private int operacion=DESCONOCIDO;
     
    public JIF_AdministrarLocalesEntidad(Principal root) {
        try {
            initComponents();
            this.root = root;
            model = new ModeloLocal();
            jTable1.setModel(model);
            utilContenedor = new UtilContenedor(root.getConfig());
            utilUbigeo = new UtilUbigeo(root.getConfig());
            utilUbigeo.defeaultSelectedUbigeo("ayacucho","huamanga","ayacucho", cbx_departamento, cbx_provincia, cbx_distrito);
            cargarCombos();
            agregaValidadoresControl();
        } catch (Exception ex) {
            Logger.getLogger(JIF_AdministrarLocalesEntidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbx_departamento = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cbx_provincia = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cbx_distrito = new javax.swing.JComboBox();
        txt_cod_departamento = new javax.swing.JTextField();
        txt_cod_provincia = new javax.swing.JTextField();
        txt_cod_distrito = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Administrar Locales de Entidad");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Locales Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/Buscar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Local", "Direccion"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Local", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("NOMBRE DEL LOCAL :");

        jTextField2.setEnabled(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("TIPO DE PROPIEDAD :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>", "Publica", "Privada" }));
        jComboBox1.setEnabled(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("AREA :");

        jTextField3.setEnabled(false);

        jLabel4.setText("UNIDAD METRICA :");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>", "M²", "HA" }));
        jComboBox2.setEnabled(false);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>", "ALAMEDA", "AVENIDA", "BLOQUE", "CALLE", "CARRETERA", "JIRON", "MALECON", "OVALO", "PARQUE", "PASAJE", "PLAZA", "PROLONGACION", "OTRO" }));
        jComboBox3.setEnabled(false);

        jTextField4.setEnabled(false);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("DIRECCION :");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("NUMERO :");

        jTextField5.setEnabled(false);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("MANZANA :");

        jTextField6.setEnabled(false);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("LOTE :");

        jTextField7.setEnabled(false);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("REGION :");

        cbx_departamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        cbx_departamento.setEnabled(false);
        cbx_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_departamentoActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("PROVINCIA :");

        cbx_provincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        cbx_provincia.setEnabled(false);
        cbx_provincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_provinciaActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("DISTRITO :");

        cbx_distrito.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        cbx_distrito.setEnabled(false);
        cbx_distrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_distritoActionPerformed(evt);
            }
        });

        txt_cod_departamento.setEditable(false);
        txt_cod_departamento.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_cod_provincia.setEditable(false);
        txt_cod_provincia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_cod_distrito.setEditable(false);
        txt_cod_distrito.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, 0, 121, Short.MAX_VALUE))
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbx_distrito, javax.swing.GroupLayout.Alignment.LEADING, 0, 391, Short.MAX_VALUE)
                            .addComponent(cbx_provincia, javax.swing.GroupLayout.Alignment.LEADING, 0, 391, Short.MAX_VALUE)
                            .addComponent(cbx_departamento, 0, 391, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_cod_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_cod_provincia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_cod_distrito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbx_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cod_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbx_provincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cod_provincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbx_distrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cod_distrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Complementarios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("TIPO DE CUENTA :");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>", "ESTATAL", "PRIVADA" }));
        jComboBox7.setEnabled(false);
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("CUENTA :");

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        jComboBox9.setEnabled(false);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("VALOR CONTABLE :");

        jTextField10.setEnabled(false);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("OFIC. REGISTRAL :");

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>", "REGISTROS PUBLICOS", "REGISTRO PREDIAL" }));
        jComboBox10.setEnabled(false);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("TOMO :");

        jTextField11.setEnabled(false);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("FOJAS :");

        jTextField12.setEnabled(false);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("ASIENTO :");

        jTextField13.setEnabled(false);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("CODIGO PREDIO :");

        jTextField14.setEnabled(false);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("PRT. ELECT:");

        jTextField15.setEnabled(false);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("REG. SINABIP:");

        jTextField16.setEnabled(false);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("PROP. REGISTRAL :");

        jTextField17.setEnabled(false);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("BENEFICIA.:");

        jTextField18.setEnabled(false);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("TIPO DE MONEDA :");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>", "SOLES", "DOLARES", "EUROS" }));
        jComboBox8.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField10)
                    .addComponent(jComboBox10, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField11)
                    .addComponent(jTextField14)
                    .addComponent(jTextField17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addComponent(jTextField15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField13, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField16, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))))
                            .addComponent(jTextField18, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox9, 0, 253, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox8, 0, 207, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/Nuevo.png"))); // NOI18N
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/Modificar_Min.png"))); // NOI18N
        jButton7.setEnabled(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/Guardar_Min.png"))); // NOI18N
        jButton6.setEnabled(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/Cancelar_Min.png"))); // NOI18N
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        operacion=NUEVO;
        jButton8.setEnabled(false);
        jButton6.setEnabled(true);
        habilitar_controles_datos();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        operacion=MODIFICAR;        
        jButton7.setEnabled(false);
        jButton6.setEnabled(true);
        habilitar_controles_datos();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            if(isDatosValidos()){
                guardar_cambios();
                jButton6.setEnabled(false);
                jButton7.setEnabled(false);
                jButton8.setEnabled(true);
            }            
        } catch (Exception ex) {
            Logger.getLogger(JIF_AdministrarLocalesEntidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton7.setEnabled(false);
        jButton8.setEnabled(true);
        jButton6.setEnabled(false);
        resetControl();
        deshabilitar_controles_datos();
        deshabilitar_controles_detalle();
        operacion=DESCONOCIDO;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listarLocales();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        if (jComboBox7.getSelectedIndex()>0) {
            try {
                utilContenedor.cargarCuentasContables(jComboBox9,((BETipoCuenta)jComboBox7.getSelectedItem()).getId_tipo());
            } catch (Exception ex) {
                Logger.getLogger(JIF_AdministrarLocalesEntidad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void cbx_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_departamentoActionPerformed
      eventoComboRegion();
    }//GEN-LAST:event_cbx_departamentoActionPerformed

    private void cbx_provinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_provinciaActionPerformed
      eventoComboProvincia();
    }//GEN-LAST:event_cbx_provinciaActionPerformed

    private void cbx_distritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_distritoActionPerformed
      eventoComboDistrito();
    }//GEN-LAST:event_cbx_distritoActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        controlaActivacionDetalles();       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
       recuperar_datos_local();
    }//GEN-LAST:event_jTable1MouseReleased

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        jTextField1.requestFocus();
    }//GEN-LAST:event_formComponentShown
    
    
    //<editor-fold defaultstate="collapsed" desc="Variables Declaradas">    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbx_departamento;
    private javax.swing.JComboBox cbx_distrito;
    private javax.swing.JComboBox cbx_provincia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JComboBox jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField txt_cod_departamento;
    private javax.swing.JTextField txt_cod_distrito;
    private javax.swing.JTextField txt_cod_provincia;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    private void listarLocales(){
        try {
            BLLocal bl = new BLLocal(root.getConfig());
            ArrayList<BELocal> list = bl.buscarReferencia(jTextField1.getText());
            model.addAll(list);
            root.adminAreas.cargarCombos();
        } catch (Exception ex) {
            Logger.getLogger(JIF_AdministrarLocalesEntidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarCombos() throws Exception{
        utilContenedor.cargarTiposPropiedad(jComboBox1);
        utilContenedor.cargarUnidadesMetricas(jComboBox2);
        utilContenedor.cargarTiposDireccion(jComboBox3);
        utilContenedor.cargarTipoCuentaLocales(jComboBox7);
        utilContenedor.cargarTiposMoneda(jComboBox8);
        utilContenedor.cargarOficinaRegistral(jComboBox10);
    }
    
    public void eventoComboRegion(){
       if (utilUbigeo!=null && cbx_departamento.getSelectedIndex()>0) {         
            utilUbigeo.eventoComboRegion(cbx_departamento, cbx_provincia, cbx_distrito,txt_cod_departamento,txt_cod_provincia,txt_cod_distrito);                    
       }
    }
    public void eventoComboProvincia(){
       if (utilUbigeo!=null && cbx_provincia.getSelectedIndex()>0) {           
            utilUbigeo.eventoComboProvincia(cbx_departamento, cbx_provincia, cbx_distrito,txt_cod_departamento,txt_cod_provincia,txt_cod_distrito);                  
       }
    }
    public void eventoComboDistrito(){
       if (utilUbigeo!=null) {
            utilUbigeo.eventoComboDistrito(cbx_departamento, cbx_provincia, cbx_distrito,txt_cod_departamento,txt_cod_provincia,txt_cod_distrito);        
       }
    }

    private void guardar_cambios() throws Exception {
        switch(operacion){
            case NUEVO: 
                registrar_local();
                break;
            case MODIFICAR: 
                guardar_cambios_local();
                break;
        }
    }
    private void registrar_local() throws Exception{
        be = new BELocal();
        bl = new BLLocal(root.getConfig());
        be.setNombre(jTextField2.getText());        
        be.setTipo_propiedad(jComboBox1.getSelectedIndex()>0?((BEContenedor)jComboBox1.getSelectedItem()).getId_contenedor():0);
        be.setArea(Double.parseDouble(jTextField3.getText().trim()));
        be.setUnidad_metrica(jComboBox2.getSelectedIndex()>0?((BEContenedor)jComboBox2.getSelectedItem()).getId_contenedor():0);
        be.setTipo_direccion(jComboBox3.getSelectedIndex()>0?((BEContenedor)jComboBox3.getSelectedItem()).getId_contenedor():0);
        be.setDireccion(jTextField4.getText().trim());
        be.setNro(jTextField5.getText().trim());
        be.setManzana(jTextField6.getText().trim());
        be.setLote(jTextField7.getText().trim());
        be.setId_ubigeo(cbx_distrito.getSelectedIndex()>0?((BEUbigeo)cbx_distrito.getSelectedItem()).getId_ubigeo():0);
        be.setTipo_cuenta(jComboBox7.getSelectedIndex()>0?((BETipoCuenta)jComboBox7.getSelectedItem()).getId_tipo():0);
        be.setTipo_moneda(jComboBox8.getSelectedIndex()>0?((BEContenedor)jComboBox8.getSelectedItem()).getId_contenedor():0);
        be.setValor_contable(jTextField10.getText());
        be.setId_cuenta(jComboBox9.getSelectedIndex()>0?((BECuentaContable)jComboBox9.getSelectedItem()).getId_cuenta_contable():0);
        be.setOficina_registral(jComboBox10.getSelectedIndex()>0?((BEContenedor)jComboBox10.getSelectedItem()).getId_contenedor():0);
        be.setTomo(jTextField11.getText());
        be.setFojas(jTextField12.getText());
        be.setAsiento(jTextField13.getText());
        be.setCodigo_predio(jTextField14.getText());
        be.setPartida_electoral(jTextField15.getText());
        be.setRegistro_sinabip(jTextField16.getText());
        be.setPropiedad_registral(jTextField17.getText());
        be.setBeneficiario(jTextField18.getText());
        int rs = bl.registrar(be);
        if(rs>=0){            
            resetControl();
            deshabilitar_controles_datos();
            operacion=DESCONOCIDO;
            listarLocales();
            JOptionPane.showMessageDialog(this,"Correctamente registrado.", "Atencion", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this,"Error de registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void guardar_cambios_local() throws Exception {        
        bl = new BLLocal(root.getConfig());
        be.setNombre(jTextField2.getText());        
        be.setTipo_propiedad(jComboBox1.getSelectedIndex()>0?((BEContenedor)jComboBox1.getSelectedItem()).getId_contenedor():0);
        be.setArea(Double.parseDouble(jTextField3.getText().trim()));
        be.setUnidad_metrica(jComboBox2.getSelectedIndex()>0?((BEContenedor)jComboBox2.getSelectedItem()).getId_contenedor():0);
        be.setTipo_direccion(jComboBox3.getSelectedIndex()>0?((BEContenedor)jComboBox3.getSelectedItem()).getId_contenedor():0);
        be.setDireccion(jTextField4.getText().trim());
        be.setNro(jTextField5.getText().trim());
        be.setManzana(jTextField6.getText().trim());
        be.setLote(jTextField7.getText().trim());
        be.setId_ubigeo(cbx_distrito.getSelectedIndex()>0?((BEUbigeo)cbx_distrito.getSelectedItem()).getId_ubigeo():0);
        be.setTipo_cuenta(jComboBox7.getSelectedIndex()>0?((BETipoCuenta)jComboBox7.getSelectedItem()).getId_tipo():0);
        be.setTipo_moneda(jComboBox8.getSelectedIndex()>0?((BEContenedor)jComboBox8.getSelectedItem()).getId_contenedor():0);
        be.setValor_contable(jTextField10.getText());
        be.setId_cuenta(jComboBox9.getSelectedIndex()>0?((BECuentaContable)jComboBox9.getSelectedItem()).getId_cuenta_contable():0);
        be.setOficina_registral(jComboBox10.getSelectedIndex()>0?((BEContenedor)jComboBox10.getSelectedItem()).getId_contenedor():0);
        be.setTomo(jTextField11.getText());
        be.setFojas(jTextField12.getText());
        be.setAsiento(jTextField13.getText());
        be.setCodigo_predio(jTextField14.getText());
        be.setPartida_electoral(jTextField15.getText());
        be.setRegistro_sinabip(jTextField16.getText());
        be.setPropiedad_registral(jTextField17.getText());
        be.setBeneficiario(jTextField18.getText());
        int rs = bl.actualizarRegistro(be);
        if(rs>=0){            
            resetControl();
            deshabilitar_controles_datos();
            operacion=DESCONOCIDO;
            listarLocales();
            JOptionPane.showMessageDialog(this,"Correctamente actualizado.", "Atencion", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this,"Error de actualizacion.", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }
    private void resetControl(){
        resetComponents(new Object[]{
            jTextField2,jComboBox1,jTextField3,jComboBox2,jComboBox3,jTextField4,jTextField5,jTextField6,jTextField7,cbx_departamento,cbx_provincia,cbx_distrito,
            jComboBox7,jComboBox8,jTextField10,jComboBox9,jComboBox10,jTextField11,jTextField12,jTextField13,jTextField14,jTextField15,jTextField16,jTextField17,jTextField18
        });
        utilUbigeo.defeaultSelectedUbigeo("ayacucho","huamanga","ayacucho",cbx_departamento,cbx_provincia,cbx_distrito);
    }
    private void habilitar_controles_datos(){  
       enableComponent(new Object[]{
            jTextField2,jComboBox1,jTextField3,jComboBox2,jComboBox3,jTextField4,jTextField5,jTextField6,jTextField7,cbx_departamento,cbx_provincia,cbx_distrito
       });
       controlaActivacionDetalles();
       jTextField2.requestFocus();
    }
    private void deshabilitar_controles_datos(){
        disableComponent(new Object[]{
             jTextField2,jComboBox1,jTextField3,jComboBox2,jComboBox3,jTextField4,jTextField5,jTextField6,jTextField7,cbx_departamento,cbx_provincia,cbx_distrito
        });
        jTextField1.requestFocus();
    }
    private void habilitar_controles_detalle(){
        enableComponent(new Object[]{
            jComboBox7,jComboBox8,jTextField10,jComboBox9,jComboBox10,jTextField11,jTextField12,jTextField13,jTextField14,jTextField15,jTextField16,jTextField17,jTextField18           
        });
    }
    private void deshabilitar_controles_detalle(){
        disableComponent(new Object[]{
             jComboBox7,jComboBox8,jTextField10,jComboBox9,jComboBox10,jTextField11,jTextField12,jTextField13,jTextField14,jTextField15,jTextField16,jTextField17,jTextField18           
        });
    }

    private void recuperar_datos_local() {
       jButton7.setEnabled(true);
       be = model.get(jTable1.getSelectedRow());
       jTextField2.setText(be.getNombre());
       utilContenedor.seleccionarItemComboContenedor(jComboBox1,be.getTipo_propiedad());       
       jTextField3.setText(""+be.getArea());       
       utilContenedor.seleccionarItemComboContenedor(jComboBox2,be.getUnidad_metrica());
       utilContenedor.seleccionarItemComboContenedor(jComboBox1,be.getTipo_propiedad());
       utilContenedor.seleccionarItemComboContenedor(jComboBox3,be.getTipo_direccion());
       jTextField4.setText(be.getDireccion());
       jTextField5.setText(be.getNro());
       jTextField6.setText(be.getManzana());
       jTextField7.setText(be.getLote());
       utilUbigeo.recuperDatosUbigeo(be.getId_ubigeo(),cbx_departamento,cbx_provincia,cbx_distrito);
       utilContenedor.seleccionarItemComboTipoCuenta(jComboBox7,be.getTipo_cuenta());
       utilContenedor.seleccionarItemComboCuenta(jComboBox9,be.getId_cuenta());
       jTextField10.setText(be.getValor_contable());
       utilContenedor.seleccionarItemComboContenedor(jComboBox8,be.getTipo_moneda());
       utilContenedor.seleccionarItemComboContenedor(jComboBox10,be.getOficina_registral());
       jTextField11.setText(be.getTomo());
       jTextField12.setText(be.getFojas());
       jTextField13.setText(be.getAsiento());
       jTextField14.setText(be.getCodigo_predio());
       jTextField15.setText(be.getPartida_electoral());
       jTextField16.setText(be.getRegistro_sinabip());
       jTextField17.setText(be.getPropiedad_registral());
       jTextField18.setText(be.getBeneficiario());
    }

    private void controlaActivacionDetalles() {
        if (jComboBox1.getSelectedIndex()>0 && jComboBox1.getSelectedIndex()==1 && jComboBox1.isEnabled()) {
           habilitar_controles_detalle();
        }else{
           deshabilitar_controles_detalle();
        } 
    }

    private void agregaValidadoresControl() {
        addEnterDoclickEvent(new Object[][]{
            {jTextField1,jButton1}
        });
        addCharacterValidatorEvent(new Object[][]{
            {jTextField2,CARACTERES_COMPLETOS,100},
            {jTextField3,NUMERICO_REAL,10},
            {jTextField4,CARACTERES_COMPLETOS,100},
            {jTextField5,NUMERICO,6},            
            {jTextField6,ALFABETICO,6},            
            {jTextField7,ALFABETICO_NUMERICO_SPB,6},   
            {jTextField10,ALFABETICO_NUMERICO_SPB,10},     
            {jTextField11,ALFABETICO_NUMERICO_SPB,10},     
            {jTextField12,ALFABETICO_NUMERICO_SPB,10},     
            {jTextField13,ALFABETICO_NUMERICO_SPB,10},     
            {jTextField14,ALFABETICO_NUMERICO_SPB,10},     
            {jTextField15,ALFABETICO_NUMERICO_SPB,10},     
            {jTextField16,ALFABETICO_NUMERICO_SPB,10},     
            {jTextField17,ALFABETICO_NUMERICO_SPB,10},     
            {jTextField18,ALFABETICO_CM,150}     
        });        
    }
    private boolean isDatosValidos(){
        return isDatosLlenos(new Object[][]{
            {jTextField2,"Ingrese nombre del local."},
            {jComboBox1,"Seleccione el tipo de propiedad."},
            {jTextField3,"Ingrese el area."},
            {jComboBox2,"Seleccione la unidad metrica."},
            {jTextField4,"Ingrese la direccion."},
            {jTextField5,"Ingrese el nro de la Direccion."},            
            {jTextField6,"Ingrese la manzana."},            
            {jTextField7,"Ingrese el lote."},   
            {jComboBox7,"Seleccione el tipo de cuenta."},   
            {jComboBox8,"Seleccione el tipo de moneda."},   
            {jTextField10,"Ingrese el valor contable."},     
            {jComboBox9,"Seleccione la cuenta contable."},     
            {jComboBox10,"Seleccione la oficina registral."},     
            {jTextField11,"Ingrese el nro de tomo."},     
            {jTextField12,"Ingrese el nro fojas."},     
            {jTextField13,"Ingrese el asiento."},     
            {jTextField14,"Ingrese el codigo de predio."},     
            {jTextField15,"Ingrese la partida electoral."},     
            {jTextField16,"Ingrese el codigo de registro de sinabip."},     
            {jTextField17,"Ingrese la propiedad registral."},     
            {jTextField18,"Ingrese los datos del beneficiario."}     
        });
    }    
}
