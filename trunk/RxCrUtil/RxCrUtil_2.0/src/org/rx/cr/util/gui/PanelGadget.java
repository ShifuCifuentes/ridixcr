package org.rx.cr.util.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelGadget extends JPanel{

    private ImageIcon ImageBackground = null;
    public static final int THEME_LIGHT=1,THEME_DARK=2;
    
    public PanelGadget(int op) {
        setOpaque(false);
        if (op==THEME_LIGHT) {
            ImageBackground = new ImageIcon(getClass().getResource("/org/rx/cr/resource/GadyedBackgroundBlack.png"));
        } else if(op==THEME_DARK){
            ImageBackground = new ImageIcon(getClass().getResource("/org/rx/cr/resource/GadyedBackgroundWhite.png"));
        }
    }
    
    @Override
    public void paintComponent( Graphics g ){      
      super.paintComponent(g);     
      Graphics2D g2d = (Graphics2D)g;
      Shape shape = new RoundRectangle2D.Float(0,0,getWidth(),getHeight(),40f,40f);        
      Rectangle r = shape.getBounds();
      g2d.clip(shape);       
      g2d.drawImage(ImageBackground.getImage(), r.x, r.y, r.width, r.height, null);      
   }
}
