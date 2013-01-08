
package org.rx.systienda.test;

import java.security.NoSuchAlgorithmException;
import org.rx.cr.conf.Config;

public class TestConf {

    public static void main(String[] args) throws NoSuchAlgorithmException{
       Config conf = new Config();
       /*conf.setHost("192.168.1.3");
       conf.setPort("pavel");
       conf.setDb("botica");
       conf.setUser("sysbotica");
       conf.setPassword("sysbotica123");       
       conf.saveConf();*/
       conf.loadConf();
      //System.out.println(conf.encodeStringASSCIIBase64(conf.resumenHashSHA1("Pavel")));
      System.out.println(conf.toString());       
       System.exit(0);               
    }
}
