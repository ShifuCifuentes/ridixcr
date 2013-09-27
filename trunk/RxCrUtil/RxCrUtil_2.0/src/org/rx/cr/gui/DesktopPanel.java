package org.rx.cr.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu.Separator;
import javax.swing.Timer;
import javax.swing.border.Border;
import org.rx.cr.util.SystemInfo;
import org.rx.cr.util.Utilitarios;
import org.rx.cr.util.gui.MonitorMemoria;
import org.rx.cr.util.gui.PanelGadget;
import org.rx.cr.util.gui.PanelRelojAnalogico;

public final class DesktopPanel extends javax.swing.JPanel{
    protected RenderingHints hints;
    protected int counter = 0;
    protected Color color_inicio = Color.BLACK;//new Color(0,153,255);
    protected Color color_fin = new Color(255, 255, 255, 0);
    private double memoria_total = 0.0;
    private double memoria_libre = 0.0;
    private MonitorMemoria monitor_memoria = null;
    public DesktopPanel() {
        initComponents();
        hints = createRenderingHints();
        monitor_memoria = new MonitorMemoria();
        jSplitPane1.setVisible(false);
        jPanel3.setVisible(false);
        jPanel8.setVisible(false);
        reubicaGadguets();
        iniciaAnimacionCurvas();
        preparaMonitorMemoria();
        iniciarSondeoMemoria();
        cargarInfoBasico();        
    }
    public void setColorInicioCurva(Color color){
        this.color_inicio = color;
    }
    public void setColorFinCurva(Color color){
        this.color_fin = color;
    }
    public void setDesktopBackground(String ref){
        this.personalizaFondoEscritorio(jDesktopPane1,ref);
    }
    public void setImageApp(String ref){
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(ref)));
    }
    public void setAppName(String ref){
        jLabel4.setText(ref);
    }
    public void addPopUpMenuItem(JMenuItem jmi_ref){
        jPopupMenu1.add(jmi_ref);
    }
    public void addPopUpMenuItemSeparator(){
        jPopupMenu1.add(new Separator());
    }
    private void iniciaAnimacionCurvas() {
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animate();
                repaint();
            }
        });
        timer.start();
    }
    private void iniciarSondeoMemoria() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sondearMemoria();
            }
        });
        timer.start();
    }

    private void sondearMemoria() {
              memoria_libre = (Utilitarios.memoriaLibreMV()/1024.0)/1024.0;
              monitorMemoria.setString((int)(memoria_libre)+" MB de "+(int)(memoria_total)+" MB");              
              monitorMemoria.setValue(((int)memoria_libre));
            
         
    }
    protected RenderingHints createRenderingHints() {
        RenderingHints renderHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                       renderHints.put(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                       renderHints.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        return renderHints;
    }

    public void animate() {
        counter++;
    }
    
    @Override
    public boolean isOpaque() {
        return false;
    }
    
    protected void dibujaCurvas(Graphics2D g2,
            float y1, float y1_offset,
            float y2, float y2_offset,
            float cx1, float cx1_offset,
            float cy1, float cy1_offset,
            float cx2, float cx2_offset,
            float cy2, float cy2_offset,
            float thickness,
            float speed,
            boolean invert) {
        //<editor-fold defaultstate="collapsed" desc="dibujaCurvas">  
        float width = getWidth();

        float offset = (float) Math.sin(counter / (speed * Math.PI));

        float start_x = 0.0f;
        float start_y = offset * y1_offset + y1;
        float end_x = width;
        float end_y = offset * y2_offset + y2;

        float ctrl1_x = offset * cx1_offset + cx1;
        float ctrl1_y = offset * cy1_offset + cy1;
        float ctrl2_x = offset * cx2_offset + cx2;
        float ctrl2_y = offset * cy2_offset + cy2;

        GeneralPath thickCurve = new GeneralPath();
        thickCurve.moveTo(start_x, start_y);
        thickCurve.curveTo(ctrl1_x, ctrl1_y,
                ctrl2_x, ctrl2_y,
                end_x, end_y);
        thickCurve.lineTo(end_x, end_y + thickness);
        thickCurve.curveTo(ctrl2_x, ctrl2_y + thickness,
                ctrl1_x, ctrl1_y + thickness,
                start_x, start_y + thickness);
        thickCurve.lineTo(start_x, start_y);

        Rectangle bounds = thickCurve.getBounds();
        if (!bounds.intersects(g2.getClipBounds())) {
            return;
        }

        GradientPaint painter = new GradientPaint(0, bounds.y,
                invert ? color_fin : color_inicio,
                0, bounds.y + bounds.height,
                invert ? color_inicio : color_fin);

        Paint oldPainter = g2.getPaint();
        g2.setPaint(painter);
        g2.fill(thickCurve);

        g2.setPaint(oldPainter);
        //</editor-fold>
    }
    
    public void insertarInternalFrame(JInternalFrame jif){
        Utilitarios.insertaInternalFrame(jif,jDesktopPane1);
    }
    
    public void closeInternalFrame(JInternalFrame jif){
        try {
            Utilitarios.closeInternalFrame(jif,jDesktopPane1);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(DesktopPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void preparaMonitorMemoria() {
        
        memoria_total = ((Utilitarios.memoriaTotalMV()>Utilitarios.memoriaMaximaMV()?Utilitarios.memoriaTotalMV():Utilitarios.memoriaMaximaMV())/1024.0)/1024.0;        
        monitorMemoria.setMaximum(((int)memoria_total));
    }

    private void reubicaGadguets() {
        ////////////////// GADGUET'S ///////////////////////
       jPanel8.setBounds(jDesktopPane1.getWidth()-(jPanel8.getWidth()+10),jPanel3.getHeight()+10,jPanel8.getWidth(),jPanel8.getHeight());       
       jPanel3.setBounds(jDesktopPane1.getWidth()-(jPanel3.getWidth()+10),5,jPanel3.getWidth(),jPanel3.getHeight());  
       ///////////////////APP ICON  + NAME ///////////////
       jLabel1.setBounds(jDesktopPane1.getWidth()-(jLabel1.getWidth()+10),jDesktopPane1.getHeight()-(jLabel1.getHeight()+30),jLabel1.getWidth(),jLabel1.getHeight()); 
       jLabel4.setBounds(jDesktopPane1.getWidth()-(jLabel1.getWidth()+10),jDesktopPane1.getHeight()-(jLabel4.getHeight()),jLabel4.getWidth(),jLabel4.getHeight()); 
    }

    private void cargarInfoBasico() {
        jlb_so.setText(SystemInfo.getNombreSO().toUpperCase());
        jlb_escritorio.setText(SystemInfo.getEscritorioOS().toUpperCase());
        jlb_arquitectura.setText(SystemInfo.getArquitecturaSO().toUpperCase()+" - "+SystemInfo.getArquitecturaModeloDatosSO().toUpperCase()+" Bits");
        jlb_version.setText(SystemInfo.getVersionSO().toUpperCase());
        jlb_pais.setText(SystemInfo.getPaisUsuario().toUpperCase());
        jlb_lenguaje.setText(SystemInfo.getLenguajeUsuario().toUpperCase());
        jlb_nombre_jre.setText(SystemInfo.getNombrePlataformaEjecuccion().toUpperCase());
        jlb_version_jre.setText(SystemInfo.getVersionEspecificaJava().toUpperCase());
        jlb_nombre_jvm.setText(SystemInfo.getNombreMaquinaVirtual().toUpperCase());
        jlb_version_jvm.setText(SystemInfo.getVersionEspecificaMaquinaVirtual().toUpperCase());
        jlb_propietario.setText(SystemInfo.getVendedorMaquinaVirtual().toUpperCase());
        jlb_web.setText(SystemInfo.getURLVendedor().toUpperCase());
        
        jPanel9.add(monitor_memoria, java.awt.BorderLayout.CENTER);
        monitor_memoria.surf.start();
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
    
  public void personalizaFondoEscritorio(JDesktopPane dp,String ref){
        BufferedImage imagen = null;       
        URL path = getClass().getResource(ref);        
        try {
            imagen = ImageIO.read(path);            
            dp.setBorder(new DesktopPaneBackground(imagen));
            
        } catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }
  }

    @Override
    protected void paintComponent(Graphics g) {
        //<editor-fold defaultstate="collapsed" desc="paintComponent">     
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;

        RenderingHints oldHints = g2.getRenderingHints();
        g2.setRenderingHints(hints);

        float width = getWidth();
        float height = getHeight();

        g2.translate(0, -30);

        dibujaCurvas(g2,
                20.0f, -10.0f, 20.0f, -10.0f,
                width / 2.0f - 40.0f, 10.0f,
                0.0f, -5.0f,
                width / 2.0f + 40, 1.0f,
                0.0f, 5.0f,
                50.0f, 5.0f, false);

        g2.translate(0, 30);
        g2.translate(0, height - 60);

        dibujaCurvas(g2,
                30.0f, -15.0f, 50.0f, 15.0f,
                width / 2.0f - 40.0f, 1.0f,
                15.0f, -25.0f,
                width / 2.0f, 1.0f / 2.0f,
                0.0f, 25.0f,
                15.0f, 9.0f, false);

        g2.translate(0, -height + 60);

        dibujaCurvas(g2,
                height - 35.0f, -5.0f, height - 50.0f, 10.0f,
                width / 2.0f - 40.0f, 1.0f,
                height - 35.0f, -25.0f,
                width / 2.0f, 1.0f / 2.0f,
                height - 20.0f, 25.0f,
                25.0f, 7.0f, true);

        g2.setRenderingHints(oldHints);      
        //</editor-fold>
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new PanelGadget(PanelGadget.THEME_DARK);
        jPanel2 = new PanelRelojAnalogico(PanelGadget.THEME_DARK);
        jPanel8 = new PanelGadget(PanelGadget.THEME_DARK);
        jLabel2 = new  Utilitarios(Utilitarios.HORA_SISTEMA);
        jLabel3 = new  Utilitarios(Utilitarios.FECHA_SISTEMA);
        monitorMemoria = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jlb_so = new javax.swing.JLabel();
        jlb_escritorio = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlb_arquitectura = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jlb_version = new javax.swing.JLabel();
        jlb_pais = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jlb_lenguaje = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jlb_nombre_jre = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlb_version_jre = new javax.swing.JLabel();
        jlb_nombre_jvm = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jlb_version_jvm = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jlb_propietario = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jlb_web = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/cr/resource/Refresh.png"))); // NOI18N
        jMenuItem1.setText("Actualizar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jDesktopPane1.setComponentPopupMenu(jPopupMenu1);
        jDesktopPane1.setOpaque(false);

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

        jPanel3.setBounds(710, 10, 145, 145);
        jDesktopPane1.add(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));

        monitorMemoria.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        monitorMemoria.setToolTipText("Memoria disponible");
        monitorMemoria.setString("Sondeo de Memoria");
        monitorMemoria.setStringPainted(true);
        monitorMemoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                monitorMemoriaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(monitorMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(monitorMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBounds(710, 170, 145, 80);
        jDesktopPane1.add(jPanel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/cr/resource/app.png"))); // NOI18N
        jLabel1.setBounds(750, 310, 100, 100);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("APP Name");
        jLabel4.setBounds(750, 420, 100, 40);
        jDesktopPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSplitPane1.setDividerLocation(180);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setEnabled(false);
        jSplitPane1.setOpaque(false);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("S.O. :");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(10, 11, 80, 13);

        jlb_so.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel5.add(jlb_so);
        jlb_so.setBounds(93, 11, 100, 14);

        jlb_escritorio.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel5.add(jlb_escritorio);
        jlb_escritorio.setBounds(93, 31, 100, 14);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Escritorio :");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(10, 31, 80, 13);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Arquitec. :");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(10, 51, 80, 13);

        jlb_arquitectura.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel5.add(jlb_arquitectura);
        jlb_arquitectura.setBounds(93, 51, 100, 14);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Version :");
        jPanel5.add(jLabel10);
        jLabel10.setBounds(10, 71, 80, 13);

        jlb_version.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel5.add(jlb_version);
        jlb_version.setBounds(93, 71, 100, 14);

        jlb_pais.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel5.add(jlb_pais);
        jlb_pais.setBounds(93, 91, 100, 14);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Pais :");
        jPanel5.add(jLabel11);
        jLabel11.setBounds(10, 91, 80, 13);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Lenguaje :");
        jPanel5.add(jLabel12);
        jLabel12.setBounds(10, 111, 80, 13);

        jlb_lenguaje.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel5.add(jlb_lenguaje);
        jlb_lenguaje.setBounds(93, 111, 100, 14);

        jTabbedPane1.addTab("Info. S.O.", new javax.swing.ImageIcon(getClass().getResource("/org/rx/cr/resource/help-browser.png")), jPanel5); // NOI18N

        jPanel6.setOpaque(false);
        jPanel6.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nom. JRE:");
        jPanel6.add(jLabel6);
        jLabel6.setBounds(10, 11, 53, 13);

        jlb_nombre_jre.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel6.add(jlb_nombre_jre);
        jlb_nombre_jre.setBounds(70, 10, 120, 14);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Ver. JRE:");
        jPanel6.add(jLabel7);
        jLabel7.setBounds(10, 31, 53, 13);

        jlb_version_jre.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel6.add(jlb_version_jre);
        jlb_version_jre.setBounds(70, 30, 120, 14);

        jlb_nombre_jvm.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel6.add(jlb_nombre_jvm);
        jlb_nombre_jvm.setBounds(70, 50, 120, 14);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Nom. JVM:");
        jPanel6.add(jLabel13);
        jLabel13.setBounds(10, 51, 53, 13);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Ver. JVM:");
        jPanel6.add(jLabel14);
        jLabel14.setBounds(10, 71, 53, 13);

        jlb_version_jvm.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel6.add(jlb_version_jvm);
        jlb_version_jvm.setBounds(70, 70, 120, 14);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Vendedor :");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(10, 91, 53, 13);

        jlb_propietario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel6.add(jlb_propietario);
        jlb_propietario.setBounds(70, 90, 120, 14);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Web :");
        jPanel6.add(jLabel16);
        jLabel16.setBounds(10, 111, 53, 13);

        jlb_web.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel6.add(jlb_web);
        jlb_web.setBounds(70, 110, 120, 14);

        jTabbedPane1.addTab("Info. Java", new javax.swing.ImageIcon(getClass().getResource("/org/rx/cr/resource/help-browser.png")), jPanel6); // NOI18N

        jSplitPane1.setTopComponent(jTabbedPane1);

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.BorderLayout());
        jTabbedPane2.addTab("Info. Memoria", new javax.swing.ImageIcon(getClass().getResource("/org/rx/cr/resource/help-browser.png")), jPanel9); // NOI18N

        jSplitPane1.setRightComponent(jTabbedPane2);

        jSplitPane1.setBounds(0, 0, 210, 360);
        jDesktopPane1.add(jSplitPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
       reubicaGadguets();
    }//GEN-LAST:event_formComponentResized

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       refrescarMemoria();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void monitorMemoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_monitorMemoriaMouseClicked
        refrescarMemoria();
    }//GEN-LAST:event_monitorMemoriaMouseClicked

    
    private void refrescarMemoria(){
        Utilitarios.refrescarMemoria();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel jlb_arquitectura;
    private javax.swing.JLabel jlb_escritorio;
    private javax.swing.JLabel jlb_lenguaje;
    private javax.swing.JLabel jlb_nombre_jre;
    private javax.swing.JLabel jlb_nombre_jvm;
    private javax.swing.JLabel jlb_pais;
    private javax.swing.JLabel jlb_propietario;
    private javax.swing.JLabel jlb_so;
    private javax.swing.JLabel jlb_version;
    private javax.swing.JLabel jlb_version_jre;
    private javax.swing.JLabel jlb_version_jvm;
    private javax.swing.JLabel jlb_web;
    private javax.swing.JProgressBar monitorMemoria;
    // End of variables declaration//GEN-END:variables
}
