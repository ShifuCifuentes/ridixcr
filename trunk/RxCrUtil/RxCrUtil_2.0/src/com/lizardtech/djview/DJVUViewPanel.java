package com.lizardtech.djview;

import static com.lizardtech.djview.Applet.IMAGE_STRING;
import static com.lizardtech.djview.Applet.TEXT_STRING;
import com.lizardtech.djvubean.DjVuBean;
import com.lizardtech.djvubean.DjVuViewport;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DJVUViewPanel extends javax.swing.JPanel {
    private DjVuBean djvu;    
    public DJVUViewPanel() {
        initComponents();
    }
    public void setFile(File f){
        try {
            removeAll();
            djvu = new DjVuBean();
            djvu.setURL(f.toURL());
            add(djvu.getToolbar(),BorderLayout.NORTH);
            add(getSplitPane(djvu.getOutline(),getCenterPane()),BorderLayout.CENTER);
            djvu.setTargetWidth(getSize().width);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

  public Component getScrollPane()throws IOException {
    Container retval = null;
    if(retval == null){
      final DjVuBean page = djvu;

      if(page instanceof DjVuViewport){
        retval = new Panel();
        retval.setLayout(new BorderLayout());
        retval.add("East",((DjVuViewport)page).getScrollbar(Scrollbar.VERTICAL));
        retval.add("South",((DjVuViewport)page).getScrollbar(Scrollbar.HORIZONTAL));
        retval.add("Center", page);
      }else{
        retval = new ScrollPane();
        retval.setBackground(new Color(128, 128, 128));
        retval.add(page);
      }
    }
    return retval;
  }    
  public Container getCenterPane()throws IOException {
    Container retval = null;
    if(retval == null){
      retval = new Panel();
      retval.setBackground(new Color(128, 128, 128));
      final CardLayout cardLayout = new CardLayout();
      retval.setLayout(cardLayout);
      retval.add(IMAGE_STRING,getScrollPane());
      retval.add(TEXT_STRING,djvu.getTextArea());
    }
    return retval;
  }  
  public Component getSplitPane(final Component leftPane,final Component centerPane){
    if(leftPane == null){
      return centerPane;
    }
    if(centerPane == null){
      return leftPane;
    }
    Container retval = null;
    try{
      final Class jsplitClass = Class.forName("javax.swing.JSplitPane");
      final Class[] params = {Integer.TYPE, Component.class, Component.class};
      final Constructor jsplitConstructor = jsplitClass.getConstructor(params);
      final Field horizontalField = jsplitClass.getField("HORIZONTAL_SPLIT");
      final Object horizontal = horizontalField.get(jsplitClass);
      final Object[] args = {horizontal, leftPane, centerPane};
      retval = (Container)jsplitConstructor.newInstance(args);
    }catch(final Throwable ignored){
      retval = new Panel(new BorderLayout());
      retval.add(leftPane, BorderLayout.WEST);
      retval.add(centerPane, BorderLayout.CENTER);
    }
    return retval;
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
