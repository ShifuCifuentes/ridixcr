package org.sysconpat.rx.gui.seguridad;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static org.rx.cr.util.Utilitarios.*;
import org.sysconpat.rx.be.BEContenedor;
import org.sysconpat.rx.be.BERolUsuario;
import org.sysconpat.rx.be.BEUsuario;
import org.sysconpat.rx.bl.BLContenedor;
import org.sysconpat.rx.bl.BLRolUsuario;
import org.sysconpat.rx.bl.BLUsuario;
import org.sysconpat.rx.gui.models.TModeloRol;
import org.sysconpat.rx.gui.models.TModeloUsuario;
import org.sysconpat.rx.gui.principal.*;

public class JIF_MantenerUsuario extends javax.swing.JInternalFrame {
    private JF_Principal root=null;
    private TModeloRol tabMD = null;
    private TModeloRol tabMA = null;
    
    private BLContenedor bl1 = null;
    
    private BLUsuario bl2 = null;
    private BEUsuario be1 = null;
    
    private BLRolUsuario bl3 = null;
    private BERolUsuario be2 = null;
    
    private TModeloUsuario tabMU=null;
    
    private static final int NUEVO=1,MODIFICAR=2,DESCONOCIDO=0;
    private int operacion=0;
    public JIF_MantenerUsuario(JF_Principal root) {
        initComponents();
        this.root=root;
        adaptarMovimiento(this);
        tabMD = new TModeloRol();
        tabMA = new TModeloRol();
        jTabMD.setModel(tabMD);
        jTabMA.setModel(tabMA);
        tabMU = new TModeloUsuario();
        jTabMU.setModel(tabMU);    
        agregarEventosValidadores();
        filtradorBusqueda(jTabMU,jTextField6,1);
    }
    //<editor-fold defaultstate="collapsed" desc="Varibles de Autogeneradas">   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txf_nombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txf_apell_pat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txf_apell_mat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txf_dni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbx_genero = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txf_nombre_usuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txf_clave_usuario = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        cbx_estado = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabMD = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabMA = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabMU = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Mantener Usuario");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nombres :");

        txf_nombres.setEditable(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Apellido Paterno :");

        txf_apell_pat.setEditable(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellido Materno :");

        txf_apell_mat.setEditable(false);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("DNI :");

        txf_dni.setEditable(false);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Genero :");

        cbx_genero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Masculino", "Femenino" }));
        cbx_genero.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txf_apell_pat)
                    .addComponent(txf_apell_mat)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txf_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_genero, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txf_nombres))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txf_nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txf_apell_pat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(txf_apell_mat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txf_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbx_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nombre Usuario :");

        txf_nombre_usuario.setEditable(false);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Clave Usuario :");

        txf_clave_usuario.setEditable(false);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Estado de Usuario :");

        cbx_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Activo", "Inactivo" }));
        cbx_estado.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Asignacion Roles");

        jTabMD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Modulo"
            }
        ));
        jTabMD.setEnabled(false);
        jTabMD.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTabMD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTabMDMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTabMD);

        jLabel10.setText("Pre Roles :");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Cajero", "Asistente Cajero", "Administrador", "Asistente Administrador" }));
        jComboBox3.setEnabled(false);

        jTabMA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Modulo"
            }
        ));
        jTabMA.setEnabled(false);
        jTabMA.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTabMA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTabMAMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTabMA);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel11.setText("Modulo  Disponibles");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel12.setText("Modulo  Disponibles");

        jButton1.setText(">>");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        jButton4.setText("<<");
        jButton4.setEnabled(false);
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txf_nombre_usuario))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txf_clave_usuario)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbx_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(176, 176, 176)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 1, Short.MAX_VALUE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txf_nombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txf_clave_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbx_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/Cancelar_Min.png"))); // NOI18N
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jTabMU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Personal", "Direccion"
            }
        ));
        jTabMU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTabMUMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTabMU);

        jLabel13.setText("Referencia");

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sysconpat/rx/resource/Buscar.png"))); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(jButton9)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try{
        if (isValidoDatos() && tabMA.size()>0) {
            if (operacion==NUEVO) {
                    registrarUsuario();                
            }else if(operacion==MODIFICAR){
                guardarModificacion();
            }            
            jButton6.setEnabled(false);
            jButton8.setEnabled(true);
            jButton7.setEnabled(false);
            operacion=DESCONOCIDO;
        }
        } catch (Exception ex) {
                    Logger.getLogger(JIF_MantenerUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        resetComponent();
        jButton8.setEnabled(true);
        jButton6.setEnabled(false);
        desabilitarComponentes();
        operacion=DESCONOCIDO;
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       tabMA.addAll(tabMD.getList());
       personalizarTablas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tabMA.add(tabMD.get(jTabMD.getSelectedRow()));
        personalizarTablas();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if (jTabMA.getSelectedRow()>=0) {
            tabMA.remove(jTabMA.getSelectedRow());        
            personalizarTablas();
        }  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tabMA.clear();   
        personalizarTablas();
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTabMDMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabMDMouseReleased
        if (jTabMD.isEnabled()) {
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
        }        
    }//GEN-LAST:event_jTabMDMouseReleased

    private void jTabMAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabMAMouseReleased
        if (jTabMA.isEnabled()) {
           jButton3.setEnabled(true);
            jButton4.setEnabled(true); 
        }        
    }//GEN-LAST:event_jTabMAMouseReleased

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            listarUsuarios();
        } catch (Exception ex) {
            Logger.getLogger(JIF_MantenerUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        jButton9.doClick();
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            resetComponent();  
            cargar_lista_modulos();
        } catch (Exception ex) {
            Logger.getLogger(JIF_MantenerUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       operacion=NUEVO;
       jButton8.setEnabled(false);
       jButton6.setEnabled(true);
       resetComponent();
       habilitarComponentes();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTabMUMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabMUMouseReleased
        try {
            jButton7.setEnabled(true);
            //jButton8.setEnabled(false);
            recuperarDatos(seleccionarFila(evt));
        } catch (Exception ex) {
            Logger.getLogger(JIF_MantenerUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTabMUMouseReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        operacion=MODIFICAR;
        jButton7.setEnabled(false);
        jButton6.setEnabled(true);
        habilitarComponentes();
    }//GEN-LAST:event_jButton7ActionPerformed
    //<editor-fold defaultstate="collapsed" desc="Variables Autogeneradas">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbx_estado;
    private javax.swing.JComboBox cbx_genero;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTabMA;
    private javax.swing.JTable jTabMD;
    private javax.swing.JTable jTabMU;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField txf_apell_mat;
    private javax.swing.JTextField txf_apell_pat;
    private javax.swing.JPasswordField txf_clave_usuario;
    private javax.swing.JTextField txf_dni;
    private javax.swing.JTextField txf_nombre_usuario;
    private javax.swing.JTextField txf_nombres;
    // End of variables declaration//GEN-END:variables
     //</editor-fold>
    //</editor-fold>
    private void desabilitarComponentes(){
        disableComponent(new Object[]{txf_nombres,
                                      txf_apell_pat,
                                      txf_apell_mat,
                                      txf_dni,
                                      cbx_genero,
                                      txf_nombre_usuario,
                                      txf_clave_usuario,
                                      cbx_estado,
                                      jTabMD,
                                      jTabMA});  
    }
    private void habilitarComponentes(){
        enableComponent(new Object[]{txf_nombres,
                                      txf_apell_pat,
                                      txf_apell_mat,
                                      txf_dni,
                                      cbx_genero,
                                      txf_nombre_usuario,
                                      txf_clave_usuario,
                                      cbx_estado,
                                      jTabMD,
                                      jTabMA});  
    }
     private void resetComponent(){  
        resetComponents(new Object[]{txf_nombres,txf_apell_pat,
                                      txf_apell_mat,
                                      txf_dni,
                                      cbx_genero,
                                      txf_nombre_usuario,
                                      txf_clave_usuario,
                                      cbx_estado});         
        
        jTabMD.clearSelection();
        jTabMA.clearSelection();
        tabMA.clear();
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);  
        personalizarTablas();
    }
    private void personalizarTablas() {
        formateaAnchoColumnaTabla(0,jTabMU,40);
        formateaAnchoColumnaTabla(1,jTabMU,200);
        formateaAnchoColumnaTabla(0,jTabMD,40);
        formateaAnchoColumnaTabla(0,jTabMA,40);
    }
    private void cargar_lista_modulos() throws Exception {
        bl1 = new BLContenedor(root.getConfig());
        tabMD.addAll(bl1.listar_modulos());
        personalizarTablas();
    }
    private boolean isValidoDatos(){
     return isDatosLlenos(new Object[][]{{txf_nombres,"Ingrese Nombres"},
                                         {txf_apell_pat,"Ingrese Apellido Paterno"},
                                         {txf_apell_mat,"Ingrese Apellido Materno"},
                                         {txf_dni,"Ingrese DNI"},
                                         {cbx_genero,"Seleccione Genero"},
                                         {txf_nombre_usuario,"Ingrese Nombre Usuario"},
                                         {txf_clave_usuario,"Ingrese Clave Usuario"},
                                         {cbx_estado,"Seleccione un Estado"}});
    }
    private void registrarUsuario() throws Exception {
        bl2 = new BLUsuario(root.getConfig());
        be1 = new BEUsuario();
        be1.setNombres(txf_nombres.getText().trim());
        be1.setApellido_paterno(txf_apell_pat.getText().trim());
        be1.setApellido_materno(txf_apell_mat.getText().trim());
        be1.setNro_documento(txf_dni.getText().trim());
        be1.setGenero(cbx_genero.getSelectedItem().toString());
        be1.setNombre_usuario(txf_nombre_usuario.getText().trim());
        be1.setClave_usuario(txf_clave_usuario.getText().trim());
        if(cbx_estado.getSelectedIndex()==1){
            be1.setEstado(true);
        }else if(cbx_estado.getSelectedIndex()==2){
            be1.setEstado(false);
        }      
        int id = bl2.registrar(be1);
        id = registrarRolesAsignadosUsuario(id);
        if(id>=0){ 
            resetComponent();
            JOptionPane.showMessageDialog(this,"Registro de Usuario Exitoso.","Atencion",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this,"Error de Registro de Usuario.","Error",JOptionPane.ERROR_MESSAGE);
        }
        jButton9.doClick();
    }
    private int registrarRolesAsignadosUsuario(int id) throws Exception{
        ArrayList<BEContenedor> listRolesAsignados = this.tabMA.getList();
        bl3 = new BLRolUsuario(root.getConfig());
        int resp = -1;
        for (BEContenedor bEContenedor : listRolesAsignados) {
            be2 = new BERolUsuario();
            be2.setId_usuario(id);
            be2.setId_modulo(bEContenedor.getId_contenedor());
            be2.setNombre_Modulo(bEContenedor.getNombre());
            resp = bl3.registrar(be2);            
        }
        resetComponent();
        return resp;
    }
    private int guardarModificacionRolesAsignadosUsuario(BEUsuario bean) throws Exception{
        ArrayList<BEContenedor> listRolesAsignados = this.tabMA.getList();
        bl3 = new BLRolUsuario(root.getConfig());
        int resp = -1;
        bl3.eliminarRolesUsuario(bean);
        for (BEContenedor bEContenedor : listRolesAsignados) {
            be2 = new BERolUsuario();
            be2.setId_usuario(bean.getId_usuario());
            be2.setId_modulo(bEContenedor.getId_contenedor());
            be2.setNombre_Modulo(bEContenedor.getNombre());
            resp = bl3.registrar(be2);            
        }
        resetComponent();
        return resp;
    }

    private void agregarEventosValidadores() {
        addValidadorResetAlert(new Object[]{txf_nombres,
                                            txf_apell_pat,
                                            txf_apell_mat,
                                            txf_dni,
                                            cbx_genero,
                                            txf_nombre_usuario,
                                            txf_clave_usuario,
                                            cbx_estado});
        addEnterFocusEvent(new Object[][]{{txf_nombres,txf_apell_pat},
                                          {txf_apell_pat,txf_apell_mat},
                                          {txf_apell_mat,txf_dni},
                                          {txf_dni,cbx_genero},
                                          {txf_nombre_usuario,txf_clave_usuario},
                                          {txf_clave_usuario,cbx_estado}});  
        addEnterDoclickEvent(new Object[][]{{jTextField6,jButton9}});
        addCharacterValidatorEvent(new Object[][]{{txf_nombres,ALFABETICO,60},
                                                  {txf_apell_pat,ALFABETICO,60},
                                                  {txf_apell_mat,ALFABETICO,60},
                                                  {txf_dni,NUMERICO,8},
                                                  {txf_nombre_usuario,ALFABETICO_NUMERICO_SPB,60},
                                                  {txf_clave_usuario,ALFABETICO_NUMERICO_SPB,60}});
    }

    private void listarUsuarios() throws Exception {
         bl2 = new BLUsuario(root.getConfig());
         tabMU.addAll(bl2.buscarReferencia(jTextField6.getText()));
         personalizarTablas();
         jButton7.setEnabled(false);
    }

    private void guardarModificacion() throws Exception {
        bl2 = new BLUsuario(root.getConfig());
        be1.setNombres(txf_nombres.getText().trim());
        be1.setApellido_paterno(txf_apell_pat.getText().trim());
        be1.setApellido_materno(txf_apell_mat.getText().trim());
        be1.setNro_documento(txf_dni.getText().trim());
        be1.setGenero(cbx_genero.getSelectedItem().toString());
        be1.setNombre_usuario(txf_nombre_usuario.getText().trim());
        be1.setClave_usuario(txf_clave_usuario.getText().trim());
        if(cbx_estado.getSelectedIndex()==1){
            be1.setEstado(true);
        }else if(cbx_estado.getSelectedIndex()==2){
            be1.setEstado(false);
        }      
        bl2.actualizarRegistro(be1);
        int resp = guardarModificacionRolesAsignadosUsuario(be1);
        if(resp>=0){ 
            resetComponent();
            JOptionPane.showMessageDialog(this,"Actualizacion de Usuario Exitoso.","Atencion",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this,"Error de Actualizacion de Usuario.","Error",JOptionPane.ERROR_MESSAGE);
        }
        jButton9.doClick();
    }

    private void recuperarDatos(int fila) throws Exception {
        be1 = tabMU.get(fila);
        txf_nombres.setText(be1.getNombres());    
        txf_apell_pat.setText(be1.getApellido_paterno());
        txf_apell_mat.setText(be1.getApellido_materno());
        txf_dni.setText(be1.getNro_documento());        
        cbx_genero.setSelectedItem(be1.getGenero());
        txf_nombre_usuario.setText(be1.getNombre_usuario());
        txf_clave_usuario.setText(be1.getClave_usuario());
        cbx_estado.setSelectedItem(be1.getEstado()?"Activo":"Inactivo");
        bl3 = new BLRolUsuario(root.getConfig());
        ArrayList<BEContenedor> list = bl3.listar_modulos_usuario(be1.getId_usuario());
        tabMA.addAll(list);
    }
    
}
