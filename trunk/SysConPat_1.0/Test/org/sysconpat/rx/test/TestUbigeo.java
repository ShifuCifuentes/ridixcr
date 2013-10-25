package org.sysconpat.rx.test;

import java.util.ArrayList;
import org.rx.cr.conf.Config;
import org.sysconpat.rx.be.BEUbigeo;
import org.sysconpat.rx.bl.BLUbigeo;

public class TestUbigeo {
    public static void main(String[] args) throws Exception {
        Config conf = new Config(Config.CLIENT);
        conf.setApp_name("SysConPat");
        conf.loadConf();
        //System.out.println(conf.toString());
        BLUbigeo bl = new BLUbigeo(conf);
        System.out.println("======REGIONES=======");
        ArrayList<BEUbigeo> lista = bl.listar_regiones();
        for (BEUbigeo bEUbigeo : lista) {
            System.out.println(bEUbigeo.getNombre_region()+" : "+bEUbigeo.getCodigo_region());
        }
        System.out.println("=======PROVINCIAS=======");
        ArrayList<BEUbigeo> lista2 = bl.listar_provincias_region(2);
        for (BEUbigeo bEUbigeo : lista2) {
            System.out.println(bEUbigeo.getNombre_provincia()+" : "+bEUbigeo.getCodigo_provincia());
        }
        System.out.println("========DISTRITOS========");
        ArrayList<BEUbigeo> lista3 = bl.listar_distritos_provincia_region(3,2);
        for (BEUbigeo bEUbigeo : lista3) {
            System.out.println(bEUbigeo.getNombre_distrito()+" : "+bEUbigeo.getCodigo_distrito());
        }
    }
}
