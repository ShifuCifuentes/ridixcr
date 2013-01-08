
package org.rx.systienda.test;

import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.rx.cr.util.gui.ConfigAdmin;
import org.rx.systienda.bean.BECuenta;
import org.rx.systienda.bl.BLCuenta;


public class textconeccion {
    public static void main(String[] args) {
        Config conf = new Config();
        conf.setApp_name("sysbotica");
        conf.loadConf();
        BLCuenta bl = new BLCuenta(conf);
        BECuenta loguin = bl.validarLoguinPersonal("admin","123");
        System.out.println(loguin);
//        ConfigAdmin admin = new ConfigAdmin(null,"sysbotica");
//        admin.setUserTable("dbo.cuenta");
//        System.out.println(admin.isValidDBStructure());
//        System.exit(0);
    }
}
