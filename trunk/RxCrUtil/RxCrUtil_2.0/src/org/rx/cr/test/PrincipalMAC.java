package org.rx.cr.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PrincipalMAC extends JFrame {
 
 JLabel lmac=new JLabel();
 
 public PrincipalMAC() {
  JPanel p = new JPanel();
  p.add(lmac);
  conseguirMAC();
  add(p);
 }
 
 public void conseguirMAC(){
  NetworkInterface a;
  try {
   a = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
   byte[] mac = a.getHardwareAddress();
   
   StringBuilder sb = new StringBuilder();
   for (int i = 0; i < mac.length; i++) {
    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));  
   } 
   FileWriter fwriter = new FileWriter("mac.dat");
   fwriter.write("MAC: " + sb.toString());
   fwriter.close();
   lmac.setText("MAC : "+sb.toString());
   
  } catch (Exception e) {
   e.printStackTrace(); 
  }
 }
 
 public static void main(String arg[]){
  PrincipalMAC p=new PrincipalMAC();
  p.setVisible(true);
  p.setBounds(0, 0, 400, 200);
  p.setLocationRelativeTo(null);
  p.setDefaultCloseOperation(EXIT_ON_CLOSE);
 } 
}
