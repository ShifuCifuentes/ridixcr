package org.sysconpat.rx.ds;

import java.sql.Connection;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import static org.sysconpat.rx.util.ResourceIDVendor.*;

public class DSUtil {   
   
    
    public static DSConeccion _DSConneccion(Config conf){
        return new DSConeccion(conf);
    }
    public static DSConeccion _DSConneccion(){
        return new DSConeccion(HOST,PORT,DB,USER,PASSWORD);
    }
    public static Connection _Conneccion(){
        return _DSConneccion().getConeccion();
    }
    public static void main(String[] args) {
        System.out.println(HOST);
        System.out.println(USER);
        System.out.println(PASSWORD);
        System.out.println(USER_ROOT);
        System.out.println(PASSWORD_ROOT);
    }
}