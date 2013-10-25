package org.sysconpat.rx.test;

import java.util.ArrayList;
import org.rx.cr.conf.Config;
import org.sysconpat.rx.be.BEContenedor;
import org.sysconpat.rx.be.BETipoCuenta;
import org.sysconpat.rx.bl.BLContenedor;

public class TestContenedor {

    public static void main(String[] args) throws Exception {
        Config conf = new Config(Config.CLIENT);
        conf.setApp_name("SysConPat");
        conf.loadConf();
        System.out.println(conf.toString());
        BLContenedor bl = new BLContenedor(conf);
        ArrayList<BETipoCuenta> lista = bl.listar_tipos_cuenta_locales();
        for (BETipoCuenta bEContenedor : lista) {
            System.out.println(bEContenedor.getNombre_tipo());
        }
    }
}
