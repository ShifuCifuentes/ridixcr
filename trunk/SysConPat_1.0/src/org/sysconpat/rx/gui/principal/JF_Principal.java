package org.sysconpat.rx.gui.principal;

import javax.swing.Box;
import java.util.*;
import javax.swing.*;
import org.rx.cr.conf.Config;
import org.rx.cr.gui.DesktopPanel;
import org.rx.cr.report.ReportGeneric;
import org.rx.cr.util.Utilitarios;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.cr.util.gui.*;
import org.sysconpat.rx.be.*;
import org.sysconpat.rx.gui.ayuda.*;
import org.sysconpat.rx.gui.baja_bienes.*;
import org.sysconpat.rx.gui.bienes_activos.*;
import org.sysconpat.rx.gui.catalogo.*;
import org.sysconpat.rx.gui.contabilidad.*;
import org.sysconpat.rx.gui.locales.*;
import org.sysconpat.rx.gui.reportes.*;
import org.sysconpat.rx.gui.seguridad.*;
import org.sysconpat.rx.util.ResourceIDVendor;


public class JF_Principal extends javax.swing.JFrame {
    private static final java.awt.Color //PRIMER_MENU=java.awt.Color.yellow,
                                        PRIMER_MENU=new java.awt.Color(245,250,187),
                                        //SEGUNDO_MENU=new java.awt.Color(1, 132, 205),
                                        SEGUNDO_MENU=new java.awt.Color(0,63,101),
                                        //TERCER_MENU=new java.awt.Color(160,120,46),
                                        TERCER_MENU=new java.awt.Color(60,45,17),
                                        //CUARTO_MENU=new java.awt.Color(240,117,2),
                                        CUARTO_MENU=new java.awt.Color(255,153,51),
                                        //QUINTO_MENU=new java.awt.Color(124,188,25),
                                        QUINTO_MENU=new java.awt.Color(153,255,153),
                                        //SEXTO_MENU=new java.awt.Color(67,59,143),
                                        SEXTO_MENU=new java.awt.Color(153,153,204),
                                        SEPTIMO_MENU=new java.awt.Color(101,91,143),
                                        //OCTAVO_MENU=new java.awt.Color(255,255,255);
                                        OCTAVO_MENU=new java.awt.Color(239,239,239);
    private Config config;
                     
    private DesktopPanel escritorio=null;
    
    private ArrayList<BEContenedor> modulos_cargados= null;
    
    public JIF_AdministrarLocalesEntidad adminLocal = null;
    public JIF_AdministrarAreasEntidad adminAreas = null;
    public JIF_AdministrarOficinasEntidad adminOficina = null;
    public JIF_AdministrarPersonalEntidad adminPersonal = null;
    public JIF_AdministrarBienes adminBienes = null;
    public JIF_TrasladarBienes traslBienes = null;
    public JIF_RegistrarUsuario regUsuario= null;
    public JIF_MantenerUsuario adminUsuario= null;
    public JIF_AdministrarBajaBienes adminBajaBienes = null;
    public JIF_GenerarReporteAsignacionBienesPatrimoniales genRepAsBp = null;    
    public JIF_GenerarReporteFormatoDatosBienes genRepFormDatBp = null;
    public JIF_GenerarReporteOtrosBP genRepOtrosBp = null;
    public JIF_GenerarReporteBienesPatrimonialesLocal genRepBpLoc=null;
    public JIF_GenerarReportePersonalLocal genRepPersLoc=null;
    public JIF_ConsultarCatalogo consCat=null;
    public JIF_ConsultarCatalogoDetallado consCatDet=null;
    private JIF_ActualizarCatalogo actuCat=null;
    private JIF_Depreciacion dep=null;
    private JIF_DepreciacionAnual depAnu=null;
    private JIF_DepreciacionIndividual depIndiv=null;
    private JIF_ResumenContable jIF_ResumenContable=null;
    
    private VisorPDF manualVisor=null;
    private JD_About about = null;
    private JD_Contacto contact = null;
    
    private BackupCreator bc = null;
    private BackupRestore br = null;
    
    public JF_Principal() {
        initComponents();
        Utilitarios.setIconoVentana(this,"/org/sysconpat/rx/resource/SysRent_Min.png");
        escritorio = new DesktopPanel();
        escritorio.setImageApp("/org/sysconpat/rx/resource/APP_Icon.png");
        escritorio.setDesktopBackground("/org/sysconpat/rx/resource/FondoKimbiri.png");
        escritorio.setAppName(ResourceIDVendor.APP_ID);
        escritorio.quitaPanelesInfo();
        escritorio.setDibujaCurbas(false);
        jPanel2.add(escritorio);        
        Utilitarios.maximizar(this);
        Utilitarios.centreaVentana(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        locales = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        bienes_activos = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        baja_bienes = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        reportes = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        contabilidad = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        catalogo = new javax.swing.JMenu();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem45 = new javax.swing.JMenuItem();
        jMenuItem46 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        servicios = new javax.swing.JMenu();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        ayuda = new javax.swing.JMenu();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SISTEMA DE CONTROL PATRIMONIAL - CERCUS");
        setBackground(new java.awt.Color(0, 63, 101));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 51, 204));
        jMenuBar1.setAlignmentY(0.5F);
        jMenuBar1.setBorderPainted(false);
        jMenuBar1.setOpaque(false);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(279, 35));

        locales.setBackground(java.awt.Color.yellow);
        locales.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        locales.setText("LOCALES");
        locales.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        locales.setMargin(new java.awt.Insets(10, 10, 10, 10));

        jMenuItem1.setBackground(java.awt.Color.yellow);
        jMenuItem1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem1.setText("ADMINISTRAR LOCALES");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        locales.add(jMenuItem1);

        jMenuItem4.setBackground(java.awt.Color.yellow);
        jMenuItem4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem4.setText("ADMINISTRAR AREAS");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        locales.add(jMenuItem4);

        jMenuItem5.setBackground(java.awt.Color.yellow);
        jMenuItem5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem5.setText("ADMINISTRAR OFICINAS");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        locales.add(jMenuItem5);

        jMenuItem6.setBackground(java.awt.Color.yellow);
        jMenuItem6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem6.setText("ADMINISTRAR PERSONAL");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        locales.add(jMenuItem6);

        jMenuBar1.add(Box.createHorizontalGlue());

        jMenuBar1.add(locales);

        bienes_activos.setBackground(new java.awt.Color(1, 132, 205));
        bienes_activos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        bienes_activos.setForeground(new java.awt.Color(255, 255, 255));
        bienes_activos.setText("BIENES ACTIVOS");
        bienes_activos.setContentAreaFilled(false);
        bienes_activos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bienes_activos.setMargin(new java.awt.Insets(10, 10, 10, 10));

        jMenuItem2.setBackground(new java.awt.Color(1, 132, 205));
        jMenuItem2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem2.setText("ADMINISTRACION DE BIENES");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        bienes_activos.add(jMenuItem2);

        jMenuItem7.setBackground(new java.awt.Color(1, 132, 205));
        jMenuItem7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem7.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem7.setText("TRASLADO DE BIENES");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        bienes_activos.add(jMenuItem7);

        jMenuBar1.add(bienes_activos);

        baja_bienes.setBackground(new java.awt.Color(160, 120, 46));
        baja_bienes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        baja_bienes.setForeground(new java.awt.Color(255, 255, 255));
        baja_bienes.setText("BAJA DE BIENES");
        baja_bienes.setContentAreaFilled(false);
        baja_bienes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        baja_bienes.setMargin(new java.awt.Insets(10, 10, 10, 10));

        jMenuItem3.setBackground(new java.awt.Color(160, 120, 46));
        jMenuItem3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setText("ADMINISTRAR BAJAS");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        baja_bienes.add(jMenuItem3);

        jMenuBar1.add(baja_bienes);

        reportes.setBackground(new java.awt.Color(240, 117, 2));
        reportes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        reportes.setForeground(new java.awt.Color(255, 255, 255));
        reportes.setText("REPORTES");
        reportes.setContentAreaFilled(false);
        reportes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reportes.setMargin(new java.awt.Insets(10, 10, 10, 10));

        jMenuItem10.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem10.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem10.setText("FORMATO DE ASIGNACION DE BIENES");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        reportes.add(jMenuItem10);

        jMenuItem11.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem11.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem11.setText("FORMATO DE DATOS DE BIENES");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        reportes.add(jMenuItem11);

        jMenu9.setBackground(new java.awt.Color(240, 117, 2));
        jMenu9.setForeground(new java.awt.Color(255, 255, 255));
        jMenu9.setText("BIENES ACTIVOS");
        jMenu9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem8.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem8.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem8.setText("GENERAL ");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem8);

        jMenuItem9.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem9.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem9.setText("DETALLADO");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem9);

        jMenuItem12.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem12.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem12.setText("OTROS");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem12);

        reportes.add(jMenu9);

        jMenu10.setBackground(new java.awt.Color(240, 117, 2));
        jMenu10.setForeground(new java.awt.Color(255, 255, 255));
        jMenu10.setText("FORMATO DE BIENES");
        jMenu10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem13.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem13.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem13.setText("ACTIVOS FIJOS");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem13);

        jMenuItem14.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem14.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem14.setText("CUENTAS DE ORDEN");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem14);

        jMenuItem15.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem15.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem15.setText("BIENES EN TRANSITO");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem15);

        jMenuItem16.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem16.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem16.setText("INVENTARIO GENERAL");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem16);

        reportes.add(jMenu10);

        jMenuItem17.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem17.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem17.setText("BIENES POR LOCAL");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        reportes.add(jMenuItem17);

        jMenu11.setBackground(new java.awt.Color(240, 117, 2));
        jMenu11.setForeground(new java.awt.Color(255, 255, 255));
        jMenu11.setText("BIENES DADOS DE BAJA");
        jMenu11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem18.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem18.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem18.setText("GENERAL");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem18);

        jMenuItem19.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem19.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem19.setText("DETALLADO");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem19);

        reportes.add(jMenu11);
        reportes.add(jSeparator1);

        jMenuItem20.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem20.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem20.setText("LOCALES DE ENTIDAD");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        reportes.add(jMenuItem20);

        jMenuItem21.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem21.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem21.setText("AREAS DE ENTIDAD");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        reportes.add(jMenuItem21);

        jMenuItem22.setBackground(new java.awt.Color(240, 117, 2));
        jMenuItem22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem22.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem22.setText("PERSONAL DE ENTIDAD");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        reportes.add(jMenuItem22);

        jMenuBar1.add(reportes);

        contabilidad.setBackground(new java.awt.Color(124, 188, 25));
        contabilidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        contabilidad.setForeground(new java.awt.Color(255, 255, 255));
        contabilidad.setText("CONTABILIDAD");
        contabilidad.setContentAreaFilled(false);
        contabilidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        contabilidad.setMargin(new java.awt.Insets(10, 10, 10, 10));

        jMenuItem23.setBackground(new java.awt.Color(124, 188, 25));
        jMenuItem23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem23.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem23.setText("DEPRECIACION");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        contabilidad.add(jMenuItem23);

        jMenuItem25.setBackground(new java.awt.Color(124, 188, 25));
        jMenuItem25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem25.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem25.setText("DEPRECIACION INDIVIDUAL");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        contabilidad.add(jMenuItem25);

        jMenuItem27.setBackground(new java.awt.Color(124, 188, 25));
        jMenuItem27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem27.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem27.setText("RESUMEN CONTABLE");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        contabilidad.add(jMenuItem27);

        jMenuItem28.setBackground(new java.awt.Color(124, 188, 25));
        jMenuItem28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem28.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem28.setText("VEHICULOS");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        contabilidad.add(jMenuItem28);

        jMenuItem29.setBackground(new java.awt.Color(124, 188, 25));
        jMenuItem29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem29.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem29.setText("ACTIVO FIJO");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        contabilidad.add(jMenuItem29);

        jMenuItem30.setBackground(new java.awt.Color(124, 188, 25));
        jMenuItem30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem30.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem30.setText("CUENTAS DE ORDEN");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        contabilidad.add(jMenuItem30);

        jMenuItem31.setBackground(new java.awt.Color(124, 188, 25));
        jMenuItem31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem31.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem31.setText("CONSOLIDACION");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        contabilidad.add(jMenuItem31);

        jMenuBar1.add(contabilidad);

        catalogo.setBackground(new java.awt.Color(67, 59, 143));
        catalogo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        catalogo.setForeground(new java.awt.Color(255, 255, 255));
        catalogo.setText("CATALOGO");
        catalogo.setContentAreaFilled(false);
        catalogo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        catalogo.setOpaque(false);

        jMenuItem32.setBackground(new java.awt.Color(67, 59, 143));
        jMenuItem32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem32.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem32.setText("CONSULTA DE CATALOGO");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        catalogo.add(jMenuItem32);

        jMenuItem33.setBackground(new java.awt.Color(67, 59, 143));
        jMenuItem33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem33.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem33.setText("CONSULTA DE CATALOGO DETALLADO");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        catalogo.add(jMenuItem33);

        jMenu12.setBackground(new java.awt.Color(67, 59, 143));
        jMenu12.setForeground(new java.awt.Color(51, 51, 255));
        jMenu12.setText("TIPO DE CUENTA");

        jMenuItem40.setBackground(new java.awt.Color(67, 59, 143));
        jMenuItem40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem40.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem40.setText("ACTIVO FIJO");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem40);

        jMenuItem41.setBackground(new java.awt.Color(67, 59, 143));
        jMenuItem41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem41.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem41.setText("CUENTA DE ORDEN");
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem41);

        catalogo.add(jMenu12);

        jMenu13.setBackground(new java.awt.Color(67, 59, 143));
        jMenu13.setForeground(new java.awt.Color(51, 51, 255));
        jMenu13.setText("CLASIFICADOR");

        jMenuItem45.setBackground(new java.awt.Color(67, 59, 143));
        jMenuItem45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem45.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem45.setText("GASTO");
        jMenuItem45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem45ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem45);

        jMenuItem46.setBackground(new java.awt.Color(67, 59, 143));
        jMenuItem46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem46.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem46.setText("INGRESOS");
        jMenuItem46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem46ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem46);
        jMenu13.add(jSeparator2);

        jMenuItem43.setBackground(new java.awt.Color(67, 59, 143));
        jMenuItem43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem43.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem43.setText("LISTA CLASIFICADORES INGRESOS");
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem43);

        jMenuItem44.setBackground(new java.awt.Color(67, 59, 143));
        jMenuItem44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem44.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem44.setText("LISTA CLASIFICADORES  GASTOS");
        jMenuItem44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem44ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem44);

        catalogo.add(jMenu13);

        jMenuBar1.add(catalogo);

        servicios.setBackground(new java.awt.Color(101, 91, 143));
        servicios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        servicios.setForeground(new java.awt.Color(255, 255, 255));
        servicios.setText("SERVICIOS");
        servicios.setContentAreaFilled(false);
        servicios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        servicios.setMargin(new java.awt.Insets(10, 10, 10, 10));

        jMenuItem35.setBackground(new java.awt.Color(101, 91, 143));
        jMenuItem35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem35.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem35.setText("CREAR BACKUP DE BD");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        servicios.add(jMenuItem35);

        jMenuItem36.setBackground(new java.awt.Color(101, 91, 143));
        jMenuItem36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem36.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem36.setText("RESTAURAR BACKUP DE BD");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        servicios.add(jMenuItem36);

        jMenuBar1.add(servicios);

        ayuda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        ayuda.setText("AYUDA");
        ayuda.setContentAreaFilled(false);
        ayuda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ayuda.setMargin(new java.awt.Insets(10, 10, 10, 10));

        jMenuItem37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem37.setText("ABOUT");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        ayuda.add(jMenuItem37);

        jMenuItem38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem38.setText("MANUAL");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        ayuda.add(jMenuItem38);

        jMenuItem39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem39.setText("INICIO");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        ayuda.add(jMenuItem39);

        jMenuBar1.add(ayuda);
        jMenuBar1.add(Box.createHorizontalGlue());

        setJMenuBar(jMenuBar1);

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        setFondo(PRIMER_MENU);
        insertarInternalFrames(adminLocal);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        setFondo(PRIMER_MENU);
        insertarInternalFrames(adminAreas);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        setFondo(PRIMER_MENU);
        insertarInternalFrames(adminOficina);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        setFondo(PRIMER_MENU);
        insertarInternalFrames(adminPersonal);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        setFondo(SEGUNDO_MENU);
         insertarInternalFrames(adminBienes);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        setFondo(SEGUNDO_MENU);
        insertarInternalFrames(traslBienes);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        setFondo(TERCER_MENU);
        insertarInternalFrames(adminBajaBienes);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        setFondo(CUARTO_MENU);
        insertarInternalFrames(genRepAsBp);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        setFondo(CUARTO_MENU);
        insertarInternalFrames(genRepFormDatBp);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        setFondo(CUARTO_MENU);
         generarReporteGeneralBA();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        setFondo(CUARTO_MENU);
        generarReporteDetalladoBA();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        setFondo(CUARTO_MENU);
        insertarInternalFrames(genRepOtrosBp);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        setFondo(CUARTO_MENU);
        generarReporteFormatoBsAF();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        setFondo(CUARTO_MENU);
        generarReporteFormatoBsCO();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        setFondo(CUARTO_MENU);
        generarReporteFormatoBsEnTransito();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        setFondo(CUARTO_MENU);
        generarReporteFormatoBsInvGeneral();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        setFondo(CUARTO_MENU);
        insertarInternalFrames(genRepBpLoc);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        setFondo(CUARTO_MENU);
        generarReporteBienesPatrimonialesBaja();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        setFondo(CUARTO_MENU);
        generarReporteBienesPatrimonialesBajaDetallado();
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        setFondo(CUARTO_MENU);
        generarReporteLocalesEntidad();
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        setFondo(CUARTO_MENU);
        generarReporteAreasEntidad();
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        setFondo(CUARTO_MENU);
        insertarInternalFrames(genRepPersLoc);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        setFondo(QUINTO_MENU);
        insertarInternalFrames(dep);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        setFondo(QUINTO_MENU);
        insertarInternalFrames(depIndiv);
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        setFondo(QUINTO_MENU);
        insertarInternalFrames(jIF_ResumenContable);
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        setFondo(QUINTO_MENU);
        generarInventarioVehicular();
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        setFondo(QUINTO_MENU);
        generarReporteFormatoBsAF();
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        setFondo(QUINTO_MENU);
        generarReporteFormatoBsCO();
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
        setFondo(QUINTO_MENU);
        generarReporteConciliacion();
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        setFondo(SEXTO_MENU);
         insertarInternalFrames(consCat);   
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        setFondo(SEXTO_MENU);
        insertarInternalFrames(consCatDet); 
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        setFondo(SEPTIMO_MENU);
        backUpCraetor();   
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        setFondo(SEPTIMO_MENU);
        backUpRestorer();     
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
        setFondo(OCTAVO_MENU);
        about.setVisible(true);
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        setFondo(OCTAVO_MENU);
        manualVisor.visualizarManual();
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        //centreaVentana(this);
    }//GEN-LAST:event_formComponentResized

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        setFondo(new java.awt.Color(0, 63, 101));
    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        generarCatalogoAF();
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
        generarCatalogoCO();
    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem43ActionPerformed
        generarCatalogoClasificadorIngresos();
    }//GEN-LAST:event_jMenuItem43ActionPerformed

    private void jMenuItem44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem44ActionPerformed
        generarCatalogoClasificadorGastos();
    }//GEN-LAST:event_jMenuItem44ActionPerformed

    private void jMenuItem45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem45ActionPerformed
       generarCatalogoGeneralCG();
    }//GEN-LAST:event_jMenuItem45ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       salir();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem46ActionPerformed
        generarCatalogoGeneralCI();
    }//GEN-LAST:event_jMenuItem46ActionPerformed

    public void setFondo(java.awt.Color c){
        super.setBackground(c); 
         jPanel1.setBackground(c);
    }

    public void salir(){     
       int op =  JOptionPane.showConfirmDialog(this,"Esta seguro que desea salir del sistema.","Atencion",JOptionPane.YES_NO_OPTION);        
       if (op==JOptionPane.YES_OPTION) {
            System.exit(0);
       } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ayuda;
    private javax.swing.JMenu baja_bienes;
    private javax.swing.JMenu bienes_activos;
    private javax.swing.JMenu catalogo;
    private javax.swing.JMenu contabilidad;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem45;
    private javax.swing.JMenuItem jMenuItem46;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu locales;
    private javax.swing.JMenu reportes;
    private javax.swing.JMenu servicios;
    // End of variables declaration//GEN-END:variables
    
     public Config getConfig() {
        return config;
    }
    public void setConfig(Config config) throws Exception {
        this.config = config;
        initContent();
    }
    public ArrayList<BEContenedor> getModulos_cargados() {
        return modulos_cargados;
    }
    public void setModulos_cargados(ArrayList<BEContenedor> modulos_cargados) {
        this.modulos_cargados = modulos_cargados;
        configuraInterfazSegunRoles();
    }
    public void setLoguin(JF_Loguin jFLoguin) {
        
    }
    public void configuraInterfazSegunRoles(){
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        if (modulos_cargados.size()>0) {
            jMenuBar1.removeAll();
            jMenuBar1.add(Box.createHorizontalGlue());
            for (BEContenedor modulo : modulos_cargados) {
                if (modulo.getNombre().equals("Locales")) {
                   jMenuBar1.add(locales);
                }else if(modulo.getNombre().equals("Bienes Activos")){
                    jMenuBar1.add(bienes_activos);
                }else if(modulo.getNombre().equals("Baja de Bienes")){
                    jMenuBar1.add(baja_bienes);
                }else if(modulo.getNombre().equals("Reportes")){
                    jMenuBar1.add(reportes);
                }else if(modulo.getNombre().equals("Contabilidad")){
                    jMenuBar1.add(contabilidad);
                }else if(modulo.getNombre().equals("Catalogo")){
                    jMenuBar1.add(catalogo);
                }else if(modulo.getNombre().equals("Servicios")){
                    jMenuBar1.add(servicios);
                }else if(modulo.getNombre().equals("Seguridad")){
                    //getRibbon().addTask(seguridad);
                }else if(modulo.getNombre().equals("Ayuda")){
                    jMenuBar1.add(ayuda);
                }                
            }
            jMenuBar1.add(Box.createHorizontalGlue());
        }else{
            jMenuBar1.removeAll(); 
        }   
       // menu_backup.setEnabled(false); 
        //menu_session.setEnabled(false);
      //</editor-fold>
    } 
    private void backUpCraetor(){
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
       if(bc!=null){
           bc.validaCreacionBackUp();
       }else{
           bc = new BackupCreator(this,getConfig());                   
            Utilitarios.centreaVentana(bc);
            Utilitarios.setIconoVentana(bc,"/org/sysconpat/rx/resource/SysRent_Min.png");  
            bc.validaCreacionBackUp();
       }
       //</editor-fold>
    }
    private void backUpRestorer() {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
       if(br!=null){
           br.validaRestauracionBackUp();
       }else{                  
            br = new BackupRestore(this,getConfig());
            Utilitarios.centreaVentana(br);
            Utilitarios.setIconoVentana(br,"/org/sysconpat/rx/resource/SysRent_Min.png");
            br.validaRestauracionBackUp();
       }   
        //</editor-fold>  
    }
    //<editor-fold defaultstate="collapsed" desc="Genracion de Reportes">
    public void generarReporteGeneralBA() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales","Bienes Patrimoniales Resumen");        
        insertarInternalFrames(reportFrame);         
    }
    public void generarReporteDetalladoBA() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales_detallado","Bienes Patrimoniales Detallado");  
        insertarInternalFrames(reportFrame);         
    }
    public void generarReporteFormatoBsAF() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales_activo_fijo","Bienes Patrimoniales Activo Fijo");  
        insertarInternalFrames(reportFrame);         
    }    
    public void generarReporteFormatoBsCO() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales_cuentas_orden","Bienes Patrimoniales Cuentas de Orden");  
        insertarInternalFrames(reportFrame);         
    }    
    public void generarReporteFormatoBsEnTransito() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales_entransito","Bienes Patrimoniales en Transito");  
        insertarInternalFrames(reportFrame);         
    }    
    public void generarReporteFormatoBsInvGeneral() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales_detallado","Bienes Patrimoniales Inventario General");  
        insertarInternalFrames(reportFrame);         
    }    
    public void generarReporteBienesPatrimonialesBaja() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales_dados_baja","Bienes Patrimoniales dados de Baja");  
        insertarInternalFrames(reportFrame);         
    }    
    public void generarReporteBienesPatrimonialesBajaDetallado() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales_dados_baja_detallado","Bienes Patrimoniales dados de Baja Detallado");  
        insertarInternalFrames(reportFrame);         
    }    
    public void generarReporteLocalesEntidad() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("locales_entidad","Locales de la Entidad XXXX");          
        insertarInternalFrames(reportFrame);         
    }    
    private void generarReporteAreasEntidad() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("areas_entidad","Areas de la Entidad");  
        insertarInternalFrames(reportFrame);   
    }    
    private void generarReporteResumenDepreciacion() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("resumen_depreciacion","Resumen de Depreciacion");  
        insertarInternalFrames(reportFrame);   
    }    
    private void generarReporteResumenContable() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("resumen_contableFinal","Resumen Contable");  
        insertarInternalFrames(reportFrame);   
    }    
    private void generarInventarioVehicular() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("reporte_vehiculos","Inventario Vehicular"); 
        insertarInternalFrames(reportFrame);   
    }    
    private void generarReporteConciliacion() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("reporte_consolidacion","Conciliacion");  
        insertarInternalFrames(reportFrame);   
    }    
    public void generarCatalogoGeneralCG() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;
        reportFrame = report.mkReportToInternalFrame("catalogo_clasificadores_gastos","Catalogo Clasificador Gastos");        
        insertarInternalFrames(reportFrame);         
    }
    public void generarCatalogoGeneralCI() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;
        reportFrame = report.mkReportToInternalFrame("catalogo_clasificadores_ingresos","Catalogo Clasificador Ingresos");        
        insertarInternalFrames(reportFrame);         
    }
    //</editor-fold>
        
    private void initContent() throws Exception {
        //<editor-fold defaultstate="collapsed" desc="initContent">        
        //<editor-fold defaultstate="collapsed" desc="Internal Frames"> 
            adminLocal = new JIF_AdministrarLocalesEntidad(this);
            //Utilitarios.setIconoVentana(adminLocal,"/org/sysconpat/rx/resource/SysRent_Min.png");
            adminAreas = new JIF_AdministrarAreasEntidad(this);
            //Utilitarios.setIconoVentana(adminAreas,"/org/sysconpat/rx/resource/SysRent_Min.png");
            adminOficina = new JIF_AdministrarOficinasEntidad(this);
            //Utilitarios.setIconoVentana(adminOficina,"/org/sysconpat/rx/resource/SysRent_Min.png");
            adminPersonal = new JIF_AdministrarPersonalEntidad(this);
            //Utilitarios.setIconoVentana(adminPersonal,"/org/sysconpat/rx/resource/SysRent_Min.png");
            adminBienes = new JIF_AdministrarBienes(this);
            //Utilitarios.setIconoVentana(adminBienes,"/org/sysconpat/rx/resource/SysRent_Min.png");
            traslBienes = new JIF_TrasladarBienes(this);
            //Utilitarios.setIconoVentana(traslBienes,"/org/sysconpat/rx/resource/SysRent_Min.png");
            regUsuario = new JIF_RegistrarUsuario(this);
            //Utilitarios.setIconoVentana(regUsuario,"/org/sysconpat/rx/resource/SysRent_Min.png");
            adminUsuario = new JIF_MantenerUsuario(this);
            //Utilitarios.setIconoVentana(adminUsuario,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            adminBajaBienes = new JIF_AdministrarBajaBienes(this);
            //Utilitarios.setIconoVentana(adminBajaBienes,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            about = new JD_About(this);
            //Utilitarios.setIconoVentana(about,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            contact = new JD_Contacto(this);
            //Utilitarios.setIconoVentana(contact,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            genRepAsBp = new JIF_GenerarReporteAsignacionBienesPatrimoniales(this);
            //Utilitarios.setIconoVentana(genRepAsBp,"/org/sysconpat/rx/resource/SysRent_Min.png");             
            genRepFormDatBp = new JIF_GenerarReporteFormatoDatosBienes(this);
            //Utilitarios.setIconoVentana(genRepFormDatBp,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            genRepOtrosBp = new JIF_GenerarReporteOtrosBP(this);
            //Utilitarios.setIconoVentana(genRepOtrosBp,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            genRepBpLoc = new JIF_GenerarReporteBienesPatrimonialesLocal(this);
            //Utilitarios.setIconoVentana(genRepBpLoc,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            genRepPersLoc = new JIF_GenerarReportePersonalLocal(this);
            //Utilitarios.setIconoVentana(genRepPersLoc,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            consCat = new JIF_ConsultarCatalogo(this);
            //Utilitarios.setIconoVentana(consCat,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            consCatDet = new JIF_ConsultarCatalogoDetallado(this);
            //Utilitarios.setIconoVentana(consCatDet,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            actuCat = new JIF_ActualizarCatalogo(this);
            //Utilitarios.setIconoVentana(actuCat,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            dep = new JIF_Depreciacion(this);
            //Utilitarios.setIconoVentana(dep,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            depAnu = new JIF_DepreciacionAnual(this);
            //Utilitarios.setIconoVentana(depAnu,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            depIndiv = new JIF_DepreciacionIndividual(this);
            //Utilitarios.setIconoVentana(depIndiv,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            jIF_ResumenContable = new JIF_ResumenContable(this);
            manualVisor = new VisorPDF();
            manualVisor.setManual_name("Manual.pdf");
            Utilitarios.setIconoVentana(manualVisor,"/org/sysconpat/rx/resource/SysRent_Min.png");        
        //</editor-fold>    
        setVisible(true); 
        //</editor-fold>
    }
    
    public void insertarInternalFrames(JInternalFrame jif){
       escritorio.insertarInternalFrame(jif);       
    }

    private void generarCatalogoAF() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;
        reportFrame = report.mkReportToInternalFrame("catalogo_bienes_detallado_activo_fijo","Catalogo - Activo Fijo");        
        insertarInternalFrames(reportFrame); 
    }
    private void generarCatalogoCO() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;
        reportFrame = report.mkReportToInternalFrame("catalogo_bienes_detallado_cuenta_orden","Catalogo - Activo Fijo");        
        insertarInternalFrames(reportFrame); 
    }

    private void generarCatalogoClasificadorIngresos() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;
        reportFrame = report.mkReportToInternalFrame("clasificador_ingresos","Catalogo - Clasificador Ingresos");        
        insertarInternalFrames(reportFrame); 
    }

    private void generarCatalogoClasificadorGastos() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;
        reportFrame = report.mkReportToInternalFrame("clasificador_gastos","Catalogo - Clasificador Gastos");        
        insertarInternalFrames(reportFrame); 
    }
    
}
