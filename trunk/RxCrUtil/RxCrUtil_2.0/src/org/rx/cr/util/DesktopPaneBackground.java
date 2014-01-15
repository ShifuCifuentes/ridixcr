package org.rx.cr.util;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;

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
