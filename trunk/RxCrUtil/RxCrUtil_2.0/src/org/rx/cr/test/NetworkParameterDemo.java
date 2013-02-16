package org.rx.cr.test;

import java.io.FileWriter;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class NetworkParameterDemo {
  public static void main(String[] args) throws Exception {
    Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
    while (en.hasMoreElements()) {
      NetworkInterface ni = en.nextElement();
//      if(ni.isVirtual()){          
//        printParameter(ni);
//      }
      printParameter(ni);
    }
  }
  public static String getMAC(NetworkInterface a){  
    try {   
      byte[] mac = a.getHardwareAddress();   
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < mac.length; i++) {
       sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));  
      }  
      return sb.toString();
    } catch (Exception e) {
      return "00-00-00-00-00-00";
    }
 }
  public static void printParameter(NetworkInterface ni) throws SocketException {
    System.out.println(" Nombre = " + ni.getName());
    System.out.println(" Nombre a mostrar= " + ni.getDisplayName());
    System.out.println(" Está activa = " + ni.isUp());
    System.out.println(" Soporte para multicast = " + ni.supportsMulticast());
    System.out.println(" Es loopback = " + ni.isLoopback());
    System.out.println(" Es virtual = " + ni.isVirtual());
    System.out.println(" Es punto a punto = " + ni.isPointToPoint());
    System.out.println(" Dirección MAC = " + getMAC(ni));    
    System.out.println(" MTU = " + ni.getMTU());

    System.out.println("\nLista de direcciones de interfaz:");
    List<InterfaceAddress> list = ni.getInterfaceAddresses();
    Iterator<InterfaceAddress> it = list.iterator();

    while (it.hasNext()) {
      InterfaceAddress ia = it.next();
      System.out.println(" Dirección = " + ia.getAddress());
      System.out.println(" Broadcast = " + ia.getBroadcast());
      System.out.println(" Longitud de prefijo de red = " + ia.getNetworkPrefixLength());
      System.out.println("");
    }
  }
}