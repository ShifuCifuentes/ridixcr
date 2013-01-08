package org.rx.systienda.gui;

import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.rx.cr.util.Utilitarios;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.cr.util.gui.BackupCreator;
import org.rx.cr.util.gui.BackupRestore;
import org.rx.cr.util.gui.ConfigAdmin;
import org.rx.cr.util.gui.PanelGadget;
import org.rx.cr.util.gui.PanelRelojAnalogico;
import org.rx.cr.util.gui.VisorPDF;
import org.rx.systienda.bean.BECuenta;
import org.rx.systienda.dao.DAOCuenta;


public final class PrincipalTienda extends javax.swing.JFrame {

    public AdministrarVenta venta1=null;
    public AdministarEntrega adminEntrega=null;
    public AdministrarPersonal adminEmpleado=null;   
    public AdministrarProducto adminProducto=null;
    public AdministrarProveedor adminProveedor=null;    
    public IniciarSession jdIniciarSesion = null; 
    public AdministrarCompra adminCompra=null;
    public EmitirReporte emitirReporte = null;
    public AdministrarCategoria adminGenero=null;
    public AdministrarMarca adminMarca=null;
    public ConfigAdmin jdConf = null;
    public About about = null;
    private DAOCuenta dao = null;
    private DSConeccion ds = null;
    private boolean isFirst=true,isSesionCloce=false;
    private int user_id;   
    private Config conf = null;
    private BECuenta beanUser;
    public JD_TicketVenta ticketVenta = null;
    private ImageIcon icon;
    
    private BackupCreator bcpc = null;
    private BackupRestore bcpr = null;
    private final VisorPDF manualVisor;
    private File resource_file;
    
    private JIF_AdministrarProducto adm_prod = null;
    
    public PrincipalTienda(){
        
        initComponents(); 
        icon = new ImageIcon(getClass().getResource("/org/rx/systienda/resource/Drug_basket_Icon_128.png"));
        setIconImage(icon.getImage());
        maximizar(this); 
        centreaVentana(this);
        personalizaFondoEscritorio(jDesktopPane1);
        jdConf = new ConfigAdmin(this,"sysbotica");
        jdConf.setUserTable("dbo.cuenta");
        setConf(jdConf.getConfig());
        if (!jdConf.isValidDBStructure()) {  
          bcpr = new BackupRestore(this,getConf());
          bcpr.setIconImage(icon.getImage());
          bcpr.validaRestauracionBackUp();
        }          
        venta1=new AdministrarVenta(this); 
        venta1.setFrameIcon(icon);
        adminEntrega=new AdministarEntrega(this);  
        adminEntrega.setFrameIcon(icon);
        adminEmpleado=new AdministrarPersonal(this);
        adminEmpleado.setFrameIcon(icon);
        //producto=new RegistrarProducto(this);
        adminProducto=new AdministrarProducto(this);
        adminProducto.setFrameIcon(icon);
        adm_prod = new JIF_AdministrarProducto(this);
        adm_prod.setFrameIcon(icon);
        adminProveedor= new AdministrarProveedor(this);
        adminProveedor.setFrameIcon(icon);
        adminCompra= new AdministrarCompra(this);
        adminCompra.setFrameIcon(icon);
        emitirReporte=new EmitirReporte(this);
        emitirReporte.setFrameIcon(icon);
        adminGenero=new AdministrarCategoria(this);
        adminGenero.setFrameIcon(icon);
        adminMarca=new AdministrarMarca(this);
        adminMarca.setFrameIcon(icon);       
        jdIniciarSesion = new IniciarSession(this);
        about = new About(this);
        ticketVenta = new JD_TicketVenta(this);   
        manualVisor = new VisorPDF();
        manualVisor.setIconImage(icon.getImage());
        resource_file = new File("help");
         if (!resource_file.exists()) {
           resource_file.mkdir();
         }
        resource_file = new File("font");
         if (!resource_file.exists()) {
           resource_file.mkdir();
         }
        resource_file=null;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new PanelGadget(PanelGadget.THEME_LIGHT);
        jPanel2 = new PanelRelojAnalogico();
        jPanel8 = new PanelGadget(PanelGadget.THEME_LIGHT);
        jLabel2 = new  Utilitarios(Utilitarios.HORA_SISTEMA);
        jLabel3 = new  Utilitarios(Utilitarios.FECHA_SISTEMA);
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();

        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/RefreshJava.png"))); // NOI18N
        jMenuItem17.setText("Refrescar");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem17);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SYSTIENDA - ESTANDAR");
        setBackground(new java.awt.Color(244, 241, 189));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setComponentPopupMenu(jPopupMenu1);

        jPanel3.setLayout(null);

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel2);
        jPanel2.setBounds(5, 5, 135, 135);

        jPanel3.setBounds(750, 10, 145, 145);
        jDesktopPane1.add(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBounds(750, 170, 145, 55);
        jDesktopPane1.add(jPanel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/Community_Help_min.png"))); // NOI18N
        jButton1.setToolTipText("Administrar Personal");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/compra.png"))); // NOI18N
        jButton2.setToolTipText("Administrar Compra");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/prod_min.png"))); // NOI18N
        jButton6.setToolTipText("Administrar Producto");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/fabricante_min.png"))); // NOI18N
        jButton7.setToolTipText("Administrar Proveedor");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/box_open_min.png"))); // NOI18N
        jButton4.setToolTipText("Administrar Entrega");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/botiquin_min.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/report_min.png"))); // NOI18N
        jButton5.setToolTipText("Generar Reporte");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/ayuda_min.png"))); // NOI18N
        jButton8.setToolTipText("Ayuda");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/ktip_min.png"))); // NOI18N
        jButton9.setToolTipText("Acerca de");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

        jMenu1.setText("Sistema");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/login_min.png"))); // NOI18N
        jMenuItem7.setText("Inciar Sesion");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/login_out_min.png"))); // NOI18N
        jMenuItem9.setText("Cerrar Sesion");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);
        jMenu1.add(jSeparator4);

        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/backup_restore_min.png"))); // NOI18N
        jMenuItem18.setText("Restaura Copia de Seguridad");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem18);

        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/backup_min.png"))); // NOI18N
        jMenuItem19.setText("Crear Copia de Seguridad");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem19);
        jMenu1.add(jSeparator3);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/exit_min.png"))); // NOI18N
        jMenuItem8.setText("Salir");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Personal");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/Community_Help_min.png"))); // NOI18N
        jMenuItem1.setText("Administrar Personal");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Almacen");

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/compra.png"))); // NOI18N
        jMenuItem10.setText("Administrar Compra");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);
        jMenu6.add(jSeparator1);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/marca.png"))); // NOI18N
        jMenuItem15.setText("Administrar Marca");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem15);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/fabricante_min.png"))); // NOI18N
        jMenuItem4.setText("Administrar Proveedor");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/prod_min.png"))); // NOI18N
        jMenuItem13.setText("Administrar Categoria");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem13);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/prod_min.png"))); // NOI18N
        jMenuItem3.setText("Administrar Producto");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);
        jMenu6.add(jSeparator2);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/box_open_min.png"))); // NOI18N
        jMenuItem11.setText("Administracion Entrega");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem11);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Ventas");

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/botiquin_min.png"))); // NOI18N
        jMenuItem5.setText("Registro Venta");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem5);

        jMenuBar1.add(jMenu7);

        jMenu2.setText("Reportes");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/report_min.png"))); // NOI18N
        jMenuItem2.setText("Emitir Reporte");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ayuda");

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/ayuda_min.png"))); // NOI18N
        jMenuItem6.setText("Manual de Usuario");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/systienda/resource/ktip_min.png"))); // NOI18N
        jMenuItem12.setText("Acerca de");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        insertarInternalFrame(venta1);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        insertarInternalFrame(adminEmpleado);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        insertarInternalFrame(adminProducto);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        insertarInternalFrame(adminProveedor);        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        jPanel8.setBounds(jDesktopPane1.getWidth()-(jPanel8.getWidth()+10),jPanel3.getHeight()+10,jPanel8.getWidth(),jPanel8.getHeight());       
        jPanel3.setBounds(jDesktopPane1.getWidth()-(jPanel3.getWidth()+10),5,jPanel3.getWidth(),jPanel3.getHeight());            
                
         try {
          defaultAdminConf();  
        } catch (Exception e) {} 
    }//GEN-LAST:event_formComponentResized

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        insertarInternalFrame(adminEntrega);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        insertarInternalFrame(adminCompra);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        insertarInternalFrame(emitirReporte);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
       jdIniciarSesion.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
      cerrarSesion();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
          salir();            
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertarInternalFrame(adminEmpleado);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        insertarInternalFrame(adminCompra);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        insertarInternalFrame(adminEntrega);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        insertarInternalFrame(venta1);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        insertarInternalFrame(emitirReporte);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       insertarInternalFrame(adminProducto);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       insertarInternalFrame(adminProveedor);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        about.setVisible(true);
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        about.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
       insertarInternalFrame(adminGenero);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
       insertarInternalFrame(adminMarca);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        refrescarMemoria();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       salir();
    }//GEN-LAST:event_formWindowClosing

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
      
    }//GEN-LAST:event_formComponentShown

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
      visorManual();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       visorManual();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
       bcpc = new BackupCreator(this,getConf());
       bcpc.setIconImage(icon.getImage());
       bcpc.validaCreacionBackUp();
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
       bcpc = new BackupCreator(this,getConf());
       bcpr.setIconImage(icon.getImage());
       bcpr.validaRestauracionBackUp();
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    public void salir(){
     int op =  JOptionPane.showConfirmDialog(this,"Esta seguro que desea Salir del Sitema.","Atencion",JOptionPane.YES_NO_OPTION);
        
       if (op==JOptionPane.YES_OPTION) {            
            cerrarSesion();
            System.exit(0);
        } 
    }
    
    public void defaultAdminConf(){
        loguinStart();
        try {
            ds = new DSConeccion(getConf());
            dao = new DAOCuenta(ds.getConeccion());
            if (dao.consultaExistenciaAdministradores()) {
                if (isFirst) {            
                    jdIniciarSesion. setVisible(true);
                    isFirst=false;
                }
            } else {
               configuraInterfazDefault();
               setVisible(true); 
               jMenuItem19.setVisible(false);
            }
            dao.close();
        } catch (Exception ex) {
            Logger.getLogger(PrincipalTienda.class.getName()).log(Level.SEVERE, null, ex);
            dao.close();
        }
    
    }
    
    public void loguinStart(){ 
        jdIniciarSesion.validaConfFile();
    }
    
    
    
    public void cerrarSesion(){
      isSesionCloce=true;
      jMenuBar1.removeAll();
      habilitarLoguin();
      jMenuBar1.add(jMenu1);
      jMenuBar1.add(Box.createHorizontalGlue());
      jMenuBar1.add(jMenu3);
      jMenuBar1.updateUI();       
      jToolBar1.removeAll();
      jToolBar1.add(Box.createHorizontalGlue());
      jToolBar1.add(jButton8);
      jToolBar1.add(jButton9);
      jToolBar1.updateUI(); 
      jDesktopPane1.removeAll();
      jDesktopPane1.updateUI();       
    }
    
    public void SesionDisableDefault(){
      isSesionCloce=true;
      jMenuBar1.removeAll();
      SessionLoguinDefault();
      jMenuBar1.add(jMenu1);
      jMenuBar1.add(Box.createHorizontalGlue());
      jMenuBar1.add(jMenu3);
      jMenuBar1.updateUI();       
      jToolBar1.removeAll();
      jToolBar1.add(Box.createHorizontalGlue());
      jToolBar1.add(jButton8);
      jToolBar1.add(jButton9);
      jToolBar1.updateUI();            
    }
    public void configuraInterfazDefault(){     
      jMenuBar1.removeAll();
      jMenuBar1.add(jMenu1);
      jMenuBar1.add(jMenu5);
      jMenuBar1.add(Box.createHorizontalGlue());
      jMenuBar1.add(jMenu3); 
      SesionDisableDefault();
      jMenuBar1.updateUI(); 
      jToolBar1.removeAll();
      jToolBar1.add(jButton1);
      jToolBar1.add(Box.createHorizontalGlue());
      jToolBar1.add(jButton8);
      jToolBar1.add(jButton9);
      jToolBar1.updateUI(); 
//      maximizar(this);      
//      centreaVentana(this);
    }
    public void configuraInterfazAdministrador(){
      jMenuBar1.removeAll();
      jMenuBar1.add(jMenu1);
      jMenuBar1.add(jMenu5);       
      jMenuBar1.add(jMenu6); 
      jMenuBar1.add(jMenu7);
      jMenuBar1.add(jMenu2);
      jMenuBar1.add(Box.createHorizontalGlue());
      jMenuBar1.add(jMenu3);
      jMenuBar1.updateUI();
      jToolBar1.updateUI();
        if (isSesionCloce) {
            jToolBar1.removeAll();
            jToolBar1.add(jButton1);
            jToolBar1.add(jButton2);
            jToolBar1.add(jButton6);
            jToolBar1.add(jButton7);
            jToolBar1.add(jButton4);
            jToolBar1.add(jButton3);
            jToolBar1.add(jButton5); 
            jToolBar1.add(Box.createHorizontalGlue());
            jToolBar1.add(jButton8);
            jToolBar1.add(jButton9);
            jToolBar1.updateUI();  
            isSesionCloce=false;
        }       
    }
    public void configuraInterfazVendedor(){
      jMenuBar1.removeAll();
      jMenuBar1.add(jMenu1);      
      jMenuBar1.add(jMenu7);   
      jMenuBar1.add(Box.createHorizontalGlue());
      jMenuBar1.add(jMenu3);
      jMenuBar1.updateUI();
      jToolBar1.remove(jButton1);
      jToolBar1.remove(jButton2);
      jToolBar1.remove(jButton6);
      jToolBar1.remove(jButton7);
      jToolBar1.remove(jButton4);
      jToolBar1.remove(jButton5);
      jToolBar1.updateUI(); 
      if (isSesionCloce) {
            jToolBar1.removeAll();            
            jToolBar1.add(jButton3); 
            jToolBar1.add(Box.createHorizontalGlue());
            jToolBar1.add(jButton8);
            jToolBar1.add(jButton9);
            jToolBar1.updateUI();  
            isSesionCloce=false;
        }       
    }
    
    
    public void desavilitarLoguin(){     
     jMenu1.removeAll();     
     jMenu1.add(jMenuItem9);
     jMenu1.add(jSeparator3);
     jMenu1.add(jMenuItem19);
     jMenu1.add(jSeparator4);
     jMenu1.add(jMenuItem8);
     jMenu1.updateUI();      
    }
    public void habilitarLoguin(){
     jMenu1.removeAll();
     jMenu1.add(jMenuItem7);
     jMenu1.add(jSeparator3);
     jMenu1.add(jMenuItem19);
     jMenu1.add(jSeparator4);
     jMenu1.add(jMenuItem8);
     jMenu1.updateUI();      
    }
    
    public void SessionLoguinDefault(){
     jMenu1.removeAll();     
     jMenu1.add(jMenuItem19);
     jMenu1.add(jSeparator4);
     jMenu1.add(jMenuItem8);
     jMenu1.updateUI();      
    }
    
     
    public void insertarInternalFrame(JInternalFrame jif){
        try {
            insertaInternalFrame(jif,jDesktopPane1);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(PrincipalTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public static void main(String args[]) throws ParseException, UnsupportedLookAndFeelException{
       
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
            
        UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalTienda(); 
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Config getConf() {
        return conf;
    }

    public BECuenta getBeanUser() {
        return beanUser;
    }

    public void setBeanUser(BECuenta beanUser) {
        this.beanUser = beanUser;
    }

    public void setConf(Config conf) {
        this.conf = conf;
    }

    private void visorManual() {            
        try {            
            //manual = new File(getClass().getResource("/org/edessco/sisregcivil/help/doc/Manual.pdf").getPath());
            resource_file = new File(getCurentPath()+File.separator+File.separator+"help/Manual.pdf");
            if (resource_file.exists()) {
              manualVisor.openFile(resource_file);
              manualVisor.setVisible(true);
            } else {
              JOptionPane.showMessageDialog(this,"No existe ningun archivo de ayuda asociado al sistema.","Atencion",JOptionPane.INFORMATION_MESSAGE);  
            }
            
        }catch (IOException ex) {
            Logger.getLogger(PrincipalTienda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public class DesktopPaneBackground implements Border{
    private final BufferedImage image;

    public DesktopPaneBackground(BufferedImage image) {
        this.image = image;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {     
        g.drawImage(image,0,0,c.getWidth(),c.getHeight(), null);
    } 
}  
    
  public void personalizaFondoEscritorio(JDesktopPane dp){
        BufferedImage imagen = null;       
        URL path = getClass().getResource("/org/rx/systienda/resource/SysTienda.png");        
        try {
            imagen = ImageIO.read(path);
            dp.setBorder(new DesktopPaneBackground(imagen));
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
  }
}
