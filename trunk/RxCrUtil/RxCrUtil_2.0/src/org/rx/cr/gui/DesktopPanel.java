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
import org.rx.cr.util.Utilitarios;
import org.rx.cr.util.gui.PanelGadget;
import org.rx.cr.util.gui.PanelRelojAnalogico;

public final class DesktopPanel extends javax.swing.JPanel {
    protected RenderingHints hints;
    protected int counter = 0;
    protected Color color_inicio = Color.BLACK;//new Color(0,153,255);
    protected Color color_fin = new Color(255, 255, 255, 0);
    
    public DesktopPanel() {
        initComponents();
        hints = createRenderingHints();
        iniciaAnimacionCurvas();
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
        try {
            Utilitarios.insertaInternalFrame(jif,jDesktopPane1);
        } catch (PropertyVetoException ex) {
            //Logger.getLogger(JF_Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeInternalFrame(JInternalFrame jif){
        try {
            Utilitarios.closeInternalFrame(jif,jDesktopPane1);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(DesktopPanel.class.getName()).log(Level.SEVERE, null, ex);
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
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new PanelGadget(PanelGadget.THEME_DARK);
        jPanel2 = new PanelRelojAnalogico(PanelGadget.THEME_DARK);
        jPanel8 = new PanelGadget(PanelGadget.THEME_DARK);
        jLabel2 = new  Utilitarios(Utilitarios.HORA_SISTEMA);
        jLabel3 = new  Utilitarios(Utilitarios.FECHA_SISTEMA);
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/cr/resource/Refresh.png"))); // NOI18N
        jMenuItem1.setText("Actualizar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);
        jPopupMenu1.add(jSeparator1);

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

        jPanel8.setBounds(710, 170, 145, 55);
        jDesktopPane1.add(jPanel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/rx/cr/resource/app.png"))); // NOI18N
        jLabel1.setBounds(10, 170, 260, 250);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("APP Name");
        jLabel4.setBounds(10, 420, 260, 40);
        jDesktopPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
       jPanel8.setBounds(jDesktopPane1.getWidth()-(jPanel8.getWidth()+10),jPanel3.getHeight()+10,jPanel8.getWidth(),jPanel8.getHeight());       
       jPanel3.setBounds(jDesktopPane1.getWidth()-(jPanel3.getWidth()+10),5,jPanel3.getWidth(),jPanel3.getHeight());  
       jLabel1.setBounds(10,jDesktopPane1.getHeight()-(jLabel1.getHeight()+50),jLabel1.getWidth(),jLabel1.getHeight()); 
       jLabel4.setBounds(10,jDesktopPane1.getHeight()-(jLabel4.getHeight()+10),jLabel4.getWidth(),jLabel4.getHeight()); 
    }//GEN-LAST:event_formComponentResized

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       Utilitarios.refrescarMemoria();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
