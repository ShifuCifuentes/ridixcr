package org.sysconpat.rx.test;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.rx.cr.conf.Config;
import org.rx.cr.conf.ConfigServerCMD;
import org.rx.cr.util.SystemInfo;
import static org.rx.cr.util.Utilitarios.*;
import org.sysconpat.rx.ds.DSUtil;
import static org.sysconpat.rx.ds.DSUtil.*;
import org.sysconpat.rx.util.ResourceIDVendor;

public class TestSEC {
    private static Config conf;
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(encodeRx("CERCUS"));
        System.out.println(encodeRx("Sistema de Control Patrimonial - CERCUS"));
        System.out.println(encodeRx("---------------------------------------"));
        //System.out.println(encodeRx("127.0.0.1"));
        System.out.println("Host "+encodeRx("127.0.0.1"));
        System.out.println("Port "+encodeRx("5432"));
        System.out.println("DB "+encodeRx("control_patrimonial"));
        System.out.println("User "+encodeRx("sysconpat"));
        System.out.println("Pass "+encodeRx("sysconpat123"));
        System.out.println("User root "+encodeRx("postgres"));
        //System.out.println(encodeRx("cercus2013"));
        System.out.println("Passroot "+encodeRx("12345678"));
        System.out.println(encodeRx("10"));
        System.out.println(_Conneccion());
//        System.out.println(new File(SystemInfo.getDirectorioArchivosPrograma()+File.separator+"PostgreSQL").exists());
//        System.out.println(new File(SystemInfo.getDirectorioArchivosProgramaX86()+File.separator+"PostgreSQL").exists());
//        System.out.println(SystemInfo.getDirectorioArchivosPrograma());
//        System.out.println(SystemInfo.getDirectorioArchivosProgramaX86());
        
    }
}
