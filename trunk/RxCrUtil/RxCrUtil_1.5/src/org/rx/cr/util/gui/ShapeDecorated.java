package org.rx.cr.util.gui;

import java.awt.Shape;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class ShapeDecorated {
  private boolean isShapingSupported;
  private ComponentListener shapeListener = null;
  private Shape shp = null;
  private float arcw=30,arch=30;
    public ShapeDecorated() {
      isShapingSupported = AWTUtilitiesWrapper.isTranslucencySupported(AWTUtilitiesWrapper.PERPIXEL_TRANSPARENT);
    }
    public void applyShape(JFrame fm){
      isShapingSupported = AWTUtilitiesWrapper.isTranslucencySupported(AWTUtilitiesWrapper.PERPIXEL_TRANSPARENT);
      if (!isShapingSupported) {
            return;
        }
        if (shapeListener != null) {
            shapeListener.componentResized(null);
            return;
        }
        final JFrame fd = fm;

        fd.addComponentListener(shapeListener = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                Shape shape = null;
                      shape = new RoundRectangle2D.Float(0, 0, fd.getWidth(), fd.getHeight(),arcw,arch);
                AWTUtilitiesWrapper.setWindowShape(fd, shape);
            }
            });
    }
    public void applyShape(JFrame fm,float aw,float ah){
      isShapingSupported = AWTUtilitiesWrapper.isTranslucencySupported(AWTUtilitiesWrapper.PERPIXEL_TRANSPARENT);
      if (!isShapingSupported) {
            return;
        }
        if (shapeListener != null) {
            shapeListener.componentResized(null);
            return;
        }
//         fm.setUndecorated(true);
        final JFrame fd = fm;
              arcw=aw;
              arch=ah;
              
        fd.addComponentListener(shapeListener = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                Shape shape = null;
                      shape = new RoundRectangle2D.Float(0, 0, fd.getWidth(), fd.getHeight(),arcw,arch);
                AWTUtilitiesWrapper.setWindowShape(fd, shape);
            }
            });
    }
    public void applyShape(JFrame fm,Shape sp){
      if (!isShapingSupported) {
            return;
        }
        if (shapeListener != null) {
            shapeListener.componentResized(null);
            return;
        }

        final JFrame fd = fm;
              shp = sp;
        fd.addComponentListener(shapeListener = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                AWTUtilitiesWrapper.setWindowShape(fd,shp);
            }
            });
    }
    public void applyShape(JDialog dl){
      isShapingSupported = AWTUtilitiesWrapper.isTranslucencySupported(AWTUtilitiesWrapper.PERPIXEL_TRANSPARENT);
      if (!isShapingSupported) {
            return;
        }
        if (shapeListener != null) {
            shapeListener.componentResized(null);
            return;
        }

        final JDialog fd = dl;

        fd.addComponentListener(shapeListener = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                Shape shape = null;
                      shape = new RoundRectangle2D.Float(0, 0, fd.getWidth(), fd.getHeight(),arcw,arch);
                AWTUtilitiesWrapper.setWindowShape(fd, shape);
            }
          });
    }
    public void applyShape(JDialog dl,float aw,float ah){
      isShapingSupported = AWTUtilitiesWrapper.isTranslucencySupported(AWTUtilitiesWrapper.PERPIXEL_TRANSPARENT);
      if (!isShapingSupported) {
            return;
        }
        if (shapeListener != null) {
            shapeListener.componentResized(null);
            return;
        }

        final JDialog fd = dl;
              arcw=aw;
              arch=ah;
        fd.addComponentListener(shapeListener = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                Shape shape = null;
                      shape = new RoundRectangle2D.Float(0, 0, fd.getWidth(), fd.getHeight(),arcw,arch);
                AWTUtilitiesWrapper.setWindowShape(fd, shape);
            }
          });
    }
    public void applyShape(JDialog fm,Shape sp){
      if (!isShapingSupported) {
            return;
        }
        if (shapeListener != null) {
            shapeListener.componentResized(null);
            return;
        }

        final JDialog fd = fm;
              shp = sp;
        fd.addComponentListener(shapeListener = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                AWTUtilitiesWrapper.setWindowShape(fd,shp);
            }
            });
    }
    /*
    public void applyShape(JComponent dl){
      isShapingSupported = AWTUtilitiesWrapper.isTranslucencySupported(AWTUtilitiesWrapper.PERPIXEL_TRANSPARENT);
      if (!isShapingSupported) {
            return;
        }
        if (shapeListener != null) {
            shapeListener.componentResized(null);
            return;
        }

        final JComponent fd = dl;

        fd.addComponentListener(shapeListener = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                Shape shape = null;
                      shape = new RoundRectangle2D.Float(0, 0, fd.getWidth(), fd.getHeight(),arcw,arch);
                AWTUtilitiesWrapper.setComponentShape(fd, shape);
            }
          });
    }
    public void applyShape(JComponent dl,float aw,float ah){
      isShapingSupported = AWTUtilitiesWrapper.isTranslucencySupported(AWTUtilitiesWrapper.PERPIXEL_TRANSPARENT);
      if (!isShapingSupported) {
            return;
        }
        if (shapeListener != null) {
            shapeListener.componentResized(null);
            return;
        }

        final JComponent fd = dl;
              arcw=aw;
              arch=ah;
        fd.addComponentListener(shapeListener = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                Shape shape = null;
                      shape = new RoundRectangle2D.Float(0, 0, fd.getWidth(), fd.getHeight(),arcw,arch);
                AWTUtilitiesWrapper.setComponentShape(fd, shape);
            }
          });
    }
    public void applyShape(JComponent fm,Shape sp){
      if (!isShapingSupported) {
            return;
        }
        if (shapeListener != null) {
            shapeListener.componentResized(null);
            return;
        }

        final JComponent fd = fm;
              shp = sp;
        fd.addComponentListener(shapeListener = new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                AWTUtilitiesWrapper.setComponentShape(fd, shp);
            }
            });
    }*/
}
