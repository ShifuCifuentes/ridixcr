package org.sysconpat.rx.gui.baja_bienes;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import org.rx.cr.util.Utilitarios;
import static org.rx.cr.util.Utilitarios.*;
import org.sysconpat.rx.be.BEArea;
import org.sysconpat.rx.be.BEBajaBienPatrimonial;
import org.sysconpat.rx.be.BEBienPatrimonial;
import org.sysconpat.rx.be.BEContenedor;
import org.sysconpat.rx.be.BECuentaContable;
import org.sysconpat.rx.be.BELocal;
import org.sysconpat.rx.be.BEOficina;
import org.sysconpat.rx.be.BEPersonal;
import org.sysconpat.rx.be.BETipoCuenta;
import org.sysconpat.rx.bl.BLBajaBienPatrimonial;
import org.sysconpat.rx.bl.BLBienPatrimonial;
import org.sysconpat.rx.gui.bienes_activos.JP_AdministrarBienes;
import org.sysconpat.rx.gui.locales.JIF_AdministrarAreasEntidad;
import org.sysconpat.rx.gui.models.ModeloBienPatrimonial;
import org.sysconpat.rx.gui.principal.*;
import org.sysconpat.rx.util.UtilContenedor;

public final class JIF_AdministrarBajaBienes extends javax.swing.JInternalFrame {
    private JF_Principal root=null;
    private BEBajaBienPatrimonial be=null;
    private BEBienPatrimonial be2=null;
    private ModeloBienPatrimonial model = null;
    private ModeloBienPatrimonial model2 = null;
    private UtilContenedor utilContenedor = null;
    private static final int NUEVO=1,MODIFICAR=2,DESCONOCIDO=-1;
    private int operacion=DESCONOCIDO;
    private BLBajaBienPatrimonial bl = null;
    private BLBienPatrimonial blbp = null;
    public JIF_AdministrarBajaBienes(JF_Principal root) {
        initComponents();
        this.root = root;
        utilContenedor = new UtilContenedor(root.getConfig());
        model = new ModeloBienPatrimonial();
        jTable2.setModel(model);
        model2 = new ModeloBienPatrimonial();
        jTable3.setModel(model2);
        cargarCombos();
        agregaValidadoresControl();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jTextField16 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        jLabel13 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jComboBox9 = new javax.swing.JComboBox();
        jComboBox10 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        jLabel21 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jTextField17 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setBackground(new java.awt.Color(160, 120, 46));
        setClosable(true);
        setIconifiable(true);
        setTitle("Administrar Baja de Bienes Patrimoniales");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bienes patrimoniales registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), java.awt.Color.white)); // NOI18N
        jPanel5.setOpaque(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/Buscar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "COD. PATRIMONIAL", "BIEN"
            }
        ));
        jTable2.setOpaque(false);
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable2MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField16, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Bien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), java.awt.Color.white)); // NOI18N
        jPanel2.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("DENOMINACION :");

        jTextField2.setEditable(false);
        jTextField2.setBackground(java.awt.Color.white);
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.white, java.awt.Color.white));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("GRUPO GENERICO :");

        jTextField3.setEditable(false);
        jTextField3.setBackground(java.awt.Color.white);
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.white, java.awt.Color.white));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("CLASE :");

        jTextField4.setEditable(false);
        jTextField4.setBackground(java.awt.Color.white);
        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.white, java.awt.Color.white));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("COD. PATRIMONIAL :");

        jTextField5.setEditable(false);
        jTextField5.setBackground(java.awt.Color.white);
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.white, java.awt.Color.white));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("ULT. CORR. :");

        jTextField6.setEditable(false);
        jTextField6.setBackground(java.awt.Color.white);
        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.white, java.awt.Color.white));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("TIPO DE CUENTA :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("VAL. ADQ.:");

        jTextField8.setEditable(false);
        jTextField8.setBackground(java.awt.Color.white);
        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.white, java.awt.Color.white));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("CANTIDAD :");

        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.white, java.awt.Color.white));
        jTextField9.setEnabled(false);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("ACT. FIJO ESTATAL");
        jRadioButton1.setOpaque(false);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("CUENTA ORDEN");
        jRadioButton2.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("CUENTA CONTABLE :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        jComboBox1.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CLASIF :");

        jTextField11.setEditable(false);
        jTextField11.setBackground(java.awt.Color.white);
        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.white, java.awt.Color.white));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("FORMA DE ADQ. :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("FECHA :");

        jDateChooser1.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("DOC. ADQ. :");

        jTextField13.setEditable(false);
        jTextField13.setBackground(java.awt.Color.white);
        jTextField13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.white, java.awt.Color.white));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("ESTADO :");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Escoja un estado de movimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), java.awt.Color.white)); // NOI18N
        jPanel3.setOpaque(false);

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("EN TRANSITO");
        jCheckBox4.setOpaque(false);

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("INVENTARIADO");
        jCheckBox3.setOpaque(false);

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("FICHADO");
        jCheckBox2.setOpaque(false);

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("ASEDURADO");
        jCheckBox1.setOpaque(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addGap(75, 75, 75)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jCheckBox3)
                .addGap(43, 43, 43)
                .addComponent(jCheckBox4)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        jComboBox2.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("LOCAL :");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        jComboBox3.setEnabled(false);
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("AREA :");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        jComboBox4.setEnabled(false);
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("OFICINA :");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        jComboBox5.setEnabled(false);
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("PERSONAL :");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        jComboBox6.setEnabled(false);

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        jComboBox9.setEnabled(false);

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        jComboBox10.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jComboBox9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField6)
                                    .addComponent(jTextField4)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField11))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField13))
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.LEADING, 0, 167, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acta de Baja del Bien Patrimonial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), java.awt.Color.white)); // NOI18N
        jPanel1.setOpaque(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("RESOLUCION DE BAJA :");

        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.white, java.awt.Color.white));
        jTextField1.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("FECHA DE BAJA :");

        jDateChooser2.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("CAUSA DE BAJA :");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccionar>" }));
        jComboBox7.setEnabled(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("DOC. SBN NRO :");

        jTextField7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.white, java.awt.Color.white));
        jTextField7.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jComboBox7, 0, 163, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(jTextField7))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/Guardar_Min.png"))); // NOI18N
        jButton6.setEnabled(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/Cancelar_Min.png"))); // NOI18N
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/Modificar_Min.png"))); // NOI18N
        jButton7.setEnabled(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/Nuevo.png"))); // NOI18N
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bienes patrimoniales dados de baja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), java.awt.Color.white)); // NOI18N
        jPanel6.setOpaque(false);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/Buscar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "COD. PATRIMONIAL", "BIEN"
            }
        ));
        jTable3.setOpaque(false);
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable3MouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextField17, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        listarBienesPatrimoniales();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseReleased
        recuperar_datos_bien_patrimonial();
    }//GEN-LAST:event_jTable2MouseReleased

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        if (jComboBox3.getSelectedIndex()>0) {
            try {
                utilContenedor.cargarAreas(jComboBox4,((BELocal)jComboBox3.getSelectedItem()).getId_local());
            } catch (Exception ex) {
                Logger.getLogger(JP_AdministrarBienes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        if(jComboBox4.getSelectedIndex()>0){
            try {
                utilContenedor.cargarOficinas(jComboBox5,((BEArea)jComboBox4.getSelectedItem()).getId_area());
            } catch (Exception ex) {
                Logger.getLogger(JP_AdministrarBienes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        if(jComboBox5.getSelectedIndex()>0){
            try {
                utilContenedor.cargarPersonal(jComboBox6,((BEOficina)jComboBox5.getSelectedItem()).getId_oficina());
            } catch (Exception ex) {
                Logger.getLogger(JP_AdministrarBienes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            if(isDatosValidos()){
                guardar_cambios();
                jButton6.setEnabled(false);
                jButton7.setEnabled(false);
                jButton8.setEnabled(true);
            }            
        } catch (Exception ex) {
            Logger.getLogger(JIF_AdministrarBajaBienes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton7.setEnabled(false);
        jButton8.setEnabled(true);
        jButton6.setEnabled(false);
        resetControl();
        deshabilitar_controles_datos();
        operacion=DESCONOCIDO;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        operacion=MODIFICAR;        
        jButton7.setEnabled(false);
        jButton6.setEnabled(true);
        habilitar_controles_datos();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (jTable2.getSelectedRow()>=0) {
            operacion=NUEVO;
            jButton8.setEnabled(false);
            jButton6.setEnabled(true);
            habilitar_controles_datos();
            prepara_nueva_baja_bien_patrimonial();
        }else{
            JOptionPane.showMessageDialog(root,"Primero seleccione un bien patrimonial registrado.", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            resetControl();
            jButton7.setEnabled(false);
        }     
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       listarBienesPatrimonialesBaja();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseReleased
        recuperarDatosBajaBienPatrimonial();
    }//GEN-LAST:event_jTable3MouseReleased
   
    //<editor-fold defaultstate="collapsed" desc="Variables Autogeneradas">    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    
    public void cargarCombos() {
        try {
            utilContenedor.cargarTipoCuentaLocales(jComboBox9);
            utilContenedor.cargarCuentasContablesBienPatrimonial(jComboBox1);
            utilContenedor.cargarFormaAdquisicion(jComboBox10);
            utilContenedor.cargarEstadosBien(jComboBox2);
            utilContenedor.cargarLocales(jComboBox3);            
            utilContenedor.cargarCausalBaja(jComboBox7);                           
        } catch (Exception ex) {
            Logger.getLogger(JIF_AdministrarAreasEntidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void agregaValidadoresControl() {
        addEnterDoclickEvent(new Object[][]{            
            {jTextField16,jButton2},
            {jTextField17,jButton3}
        });
        addCharacterValidatorEvent(new Object[][]{
            {jTextField9,NUMERICO,6},
            {jTextField1,CARACTERES_COMPLETOS,150},            
            {jTextField7,CARACTERES_COMPLETOS,50} 
        });
    }
    private void resetControl(){
        resetComponents(new Object[]{  
            jTextField2,jTextField3,jTextField4,jTextField5,jTextField6,jComboBox9,
            jTextField8,jTextField11,jTextField9,jComboBox1,jComboBox10,jDateChooser1,
            jTextField13,jCheckBox1,jCheckBox2,jCheckBox3,jCheckBox4,jComboBox2,jComboBox3,
            jComboBox4,jComboBox5,jComboBox6,jTextField1,jDateChooser2,jComboBox7,jTextField7
        });        
    }
    private void habilitar_controles_datos(){  
       enableComponent(new Object[]{
            jComboBox9,jTextField9,jComboBox1,jComboBox6,jTextField1,jDateChooser2,jComboBox7,jTextField7
       });    
       jTextField2.requestFocus();
    }
    private void deshabilitar_controles_datos(){
        disableComponent(new Object[]{
            jComboBox9,jTextField9,jComboBox1,jComboBox6,jTextField1,jDateChooser2,jComboBox7,jTextField7
        });
         jTextField1.requestFocus();
    }
     private boolean isDatosValidos(){
        return isDatosLlenos(new Object[][]{            
            {jComboBox9,"Seleccione el tipo de cuenta."},  
            {jTextField9,"Ingrese la cantidad."},                   
            {jComboBox1,"Seleccione la cuenta contable."},                   
            {jComboBox6,"Seleccione personal encargado."},                   
            {jTextField1,"Ingrese la resolucion de baja."},                   
            {jDateChooser2,"Ingrese fecha de la resolucion."},                   
            {jComboBox7,"Seleccione un causal de baja."},                   
            {jTextField7,"Ingrese NRO DOC. SBN."}                   
        });
    }  
     private void guardar_cambios() throws Exception {
        switch(operacion){
            case NUEVO: 
                registrar_bien_patrimonial();
                break;
            case MODIFICAR: 
                guardar_cambios_bien_patrimonial();
                break;
        }
    }
    
     private void registrar_bien_patrimonial() throws Exception {
        bl = new BLBajaBienPatrimonial(root.getConfig());
        be = new BEBajaBienPatrimonial();
        be.setId_bien(be2.getId_bien_patrimonial());
        be.setId_cta_contable(((BECuentaContable)jComboBox1.getSelectedItem()).getId_cuenta_contable());
        be.setId_personal(((BEPersonal)jComboBox6.getSelectedItem()).getId_personal());
        be.setFecha_baja(castDate_UTIL_SQL(jDateChooser2.getDate()));
        be.setCantidad(Integer.parseInt(jTextField9.getText().trim()));
        be.setResolucion_baja(jTextField1.getText());
        be.setDoc_sbn(jTextField7.getText());
        be.setTipo_cuenta(((BETipoCuenta)jComboBox9.getSelectedItem()).getId_tipo());
        be.setCausal_baja(((BEContenedor)jComboBox7.getSelectedItem()).getId_contenedor());
        int rs = bl.registrar(be);               
        if(rs>=0){            
            resetControl();
            deshabilitar_controles_datos();
            operacion=DESCONOCIDO;
            listarBienesPatrimoniales();
            listarBienesPatrimonialesBaja();
            JOptionPane.showMessageDialog(root,"Correctamente registrado.", "Atencion", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(root,"Error de registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardar_cambios_bien_patrimonial() throws Exception {
        bl = new BLBajaBienPatrimonial(root.getConfig());        
        be.setId_bien(be2.getId_bien_patrimonial());
        be.setId_cta_contable(((BECuentaContable)jComboBox1.getSelectedItem()).getId_cuenta_contable());
        be.setId_personal(((BEPersonal)jComboBox6.getSelectedItem()).getId_personal());
        be.setFecha_baja(castDate_UTIL_SQL(jDateChooser2.getDate()));
        be.setCantidad(Integer.parseInt(jTextField9.getText().trim()));
        be.setResolucion_baja(jTextField1.getText());
        be.setDoc_sbn(jTextField7.getText());
        be.setTipo_cuenta(((BETipoCuenta)jComboBox9.getSelectedItem()).getId_tipo());
        be.setCausal_baja(((BEContenedor)jComboBox7.getSelectedItem()).getId_contenedor());
        int rs = bl.actualizarRegistro(be);      
        if(rs>=0){            
            resetControl();
            deshabilitar_controles_datos();
            operacion=DESCONOCIDO;
            listarBienesPatrimoniales();
            listarBienesPatrimonialesBaja();
            JOptionPane.showMessageDialog(root,"Correctamente actualizado.", "Atencion", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(root,"Error de actualizacion.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }     
    private void listarBienesPatrimoniales() {
        try {
            blbp = new BLBienPatrimonial(root.getConfig());
            ArrayList<BEBienPatrimonial> lista = blbp.buscarReferencia(jTextField16.getText().trim());
            model.addAll(lista);
        } catch (Exception ex) {
            Logger.getLogger(JP_AdministrarBienes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void listarBienesPatrimonialesBaja() {
        try {
            bl = new BLBajaBienPatrimonial(root.getConfig());
            ArrayList<BEBienPatrimonial> lista = bl.buscarReferenciaBajaBienPatrimonial(jTextField16.getText().trim());
            model2.addAll(lista);
        } catch (Exception ex) {
            Logger.getLogger(JP_AdministrarBienes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void recuperar_datos_bien_patrimonial() {
        if (jTable2.getSelectedRow()>=0) {
            try {
                be2 = model.get(jTable2.getSelectedRow());
                jTextField2.setText(be2.getDenominacion());
                jTextField3.setText(be2.getGrupo_generico());
                jTextField4.setText(be2.getClase_bien());
                jTextField5.setText(be2.getCodigo_patrimonial());
                jTextField6.setText(""+be2.getUl_correlativo());
                utilContenedor.seleccionarItemComboTipoCuenta(jComboBox9,be2.getTipo_cuenta());
                jTextField8.setText(""+be2.getValor_adquisicion());
                jTextField11.setText(be2.getClasificador());
                jTextField9.setText(""+be2.getCantidad());
                if (be2.isEleccion_af_co()) {
                    jRadioButton1.setSelected(true);
                } else {
                    jRadioButton2.setSelected(true);
                }
                utilContenedor.seleccionarItemComboCuenta(jComboBox1,be2.getId_cta_contable());
                utilContenedor.seleccionarItemComboContenedor(jComboBox10,be2.getForma_adquisicion());
                jDateChooser1.setDate(Utilitarios.castDate_SQL_UTIL(be2.getFecha_adquisicion()));
                jTextField13.setText(be2.getDoc_adquisicion());
                jCheckBox1.setSelected(be2.isAsegurado());
                jCheckBox2.setSelected(be2.isFichado());
                jCheckBox3.setSelected(be2.isInventariado());
                jCheckBox4.setSelected(be2.isEntransito());
                utilContenedor.seleccionarItemComboContenedor(jComboBox2,be2.getEstado());
                utilContenedor.seleccionarItemComboLocal(jComboBox3,be2.getId_local());
                utilContenedor.seleccionarItemComboArea(jComboBox4,be2.getId_area());
                utilContenedor.seleccionarItemComboOficina(jComboBox5,be2.getId_oficina());
                utilContenedor.seleccionarItemComboPersonal(jComboBox6,be2.getId_personal());                
            } catch (Exception ex) {
                Logger.getLogger(JP_AdministrarBienes.class.getName()).log(Level.SEVERE, null, ex);
            }          
        }
    }

    private void recuperarDatosBajaBienPatrimonial() {
        if(jTable3.getSelectedRow()>=0){
            try {
                blbp = new BLBienPatrimonial(root.getConfig());
                bl = new BLBajaBienPatrimonial(root.getConfig());                
                be = bl.buscar(model2.get(jTable3.getSelectedRow()).getId_bien_patrimonial());
                be2 = blbp.buscar(be.getId_bien());                
                jTextField2.setText(be2.getDenominacion());
                jTextField3.setText(be2.getGrupo_generico());
                jTextField4.setText(be2.getClase_bien());
                jTextField5.setText(be2.getCodigo_patrimonial());
                jTextField6.setText(""+be2.getUl_correlativo());                
                jTextField8.setText(""+be2.getValor_adquisicion());
                jTextField11.setText(be2.getClasificador());                
                jRadioButton1.setSelected(be2.isEleccion_af_co());                
                utilContenedor.seleccionarItemComboContenedor(jComboBox10,be2.getForma_adquisicion());
                jDateChooser1.setDate(Utilitarios.castDate_SQL_UTIL(be2.getFecha_adquisicion()));
                jTextField13.setText(be2.getDoc_adquisicion());
                jCheckBox1.setSelected(be2.isAsegurado());
                jCheckBox2.setSelected(be2.isFichado());
                jCheckBox3.setSelected(be2.isInventariado());
                jCheckBox4.setSelected(be2.isEntransito());
                utilContenedor.seleccionarItemComboContenedor(jComboBox2,be2.getEstado());
                utilContenedor.seleccionarItemComboLocal(jComboBox3,be2.getId_local());
                utilContenedor.seleccionarItemComboArea(jComboBox4,be2.getId_area());
                utilContenedor.seleccionarItemComboOficina(jComboBox5,be2.getId_oficina()); 
                /////////////////////////////////////////////////////////////////////////////
                utilContenedor.seleccionarItemComboTipoCuenta(jComboBox9,be.getTipo_cuenta());
                jTextField9.setText(""+be.getCantidad());
                utilContenedor.seleccionarItemComboCuenta(jComboBox1,be.getId_cta_contable());
                utilContenedor.seleccionarItemComboPersonal(jComboBox6,be.getId_personal());
                jTextField1.setText(be.getResolucion_baja());
                jDateChooser2.setDate(castDate_SQL_UTIL(be.getFecha_baja()));
                utilContenedor.seleccionarItemComboContenedor(jComboBox7,be.getCausal_baja());
                jTextField7.setText(be.getDoc_sbn());  
                
                jButton7.setEnabled(true);
            } catch (Exception ex) {
                Logger.getLogger(JIF_AdministrarBajaBienes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }            
    }

    private void prepara_nueva_baja_bien_patrimonial() {
         resetComponents(new Object[]{  
            jTextField1,jDateChooser2,jComboBox7,jTextField7
        }); 
    }

    
}
