package org.rx.cr.util.gui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelCurvas extends JPanel{
            protected int counter = 0;
            protected Color color_inicio = Color.BLACK;
            protected Color color_fin = new Color(255, 255, 255, 0);
            private boolean cs = true;
            public PanelCurvas() { 
                this(Color.BLACK,new Color(255, 255, 255, 0));
            }
            public PanelCurvas(boolean s) { 
                this(Color.BLACK,new Color(255, 255, 255, 0),s);
            }
            public PanelCurvas(Color c1, Color c2) {
                this(c1, c2, true);                
            }
            public PanelCurvas(Color c1, Color c2,boolean s) {
                this.color_inicio = c1;
                this.color_fin = c2;        
                this.cs = s;
                iniciaAnimacionCurvas();           
            }
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);                
                dibujaCurvas(g);
            }
            public void dibujaCurvas(Graphics g){
                //<editor-fold defaultstate="collapsed" desc="Curvas">
                Graphics2D g2 = (Graphics2D) g;

                RenderingHints oldHints = g2.getRenderingHints();
                g2.setRenderingHints(createRenderingHints());

                float width = getWidth();
                float height = getHeight();

                g2.translate(0, -30);
                if(cs){
                    dibujaCurvas(g2,
                    20.0f, -10.0f, 20.0f, -10.0f,
                    width / 2.0f - 40.0f, 10.0f,
                    0.0f, -5.0f,
                    width / 2.0f + 40, 1.0f,
                    0.0f, 5.0f,
                    50.0f, 5.0f, false);
                }
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
            protected RenderingHints createRenderingHints() {
                RenderingHints renderHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
                renderHints.put(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                renderHints.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
                return renderHints;
            }

            public void animate() {
                counter++;
            }

}
