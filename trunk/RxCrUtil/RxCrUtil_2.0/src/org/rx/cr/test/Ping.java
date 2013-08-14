package org.rx.cr.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ping {
    public static void main(String[] args) throws UnknownHostException, IOException {
        InetAddress in = InetAddress.getByName("192.168.1.33"); 
        if (in.isReachable(2000)) { 
           System.out.println("Dirección accesible! :) "); 
        }else{ 
           System.out.println("La dirección indicada es inaccesible :("); 
        }
    }
}
