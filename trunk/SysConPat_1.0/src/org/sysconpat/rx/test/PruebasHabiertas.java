package org.sysconpat.rx.test;

import java.sql.Date;
import org.rx.cr.conf.Config;

public class PruebasHabiertas {

    public static void main(String[] args) {
        System.out.println(new Date(-1900,0,1).toString());
        Config conf = new Config();
        conf.setApp_name("CERCUS");
        conf.loadConf();
        System.out.println(conf.toString());
    }
}
