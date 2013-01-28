package org.rx.cr.util.gui;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class UndecoratedMove {
    private static Point pnt;
public UndecoratedMove() {
        pnt = new Point();
    }
public void MoveAdapter(final JFrame jp){
      jp.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        pnt.x = e.getX();
        pnt.y = e.getY();
      }
      });
     jp.addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
        Point p = jp.getLocation();
        jp.setLocation(p.x + e.getX() - pnt.x, p.y + e.getY() - pnt.y);
      }
      });
 }
public void MoveAdapter(final JDialog jp){
   jp.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        pnt.x = e.getX();
        pnt.y = e.getY();
      }
      });
     jp.addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
        Point p = jp.getLocation();
        jp.setLocation(p.x + e.getX() - pnt.x, p.y + e.getY() - pnt.y);
      }
      });
 }
public void MoveAdapter(final JInternalFrame jp){
   jp.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        pnt.x = e.getX();
        pnt.y = e.getY();
      }
      });
     jp.addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
        Point p = jp.getLocation();
        jp.setLocation(p.x + e.getX() - pnt.x, p.y + e.getY() - pnt.y);
      }
      });
 }
}
