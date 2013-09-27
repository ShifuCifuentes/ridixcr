package org.rx.cr.test;

import org.rx.cr.conf.Config;
import org.rx.cr.db.DBA;
import org.rx.cr.ds.DSConeccion;
import static org.rx.cr.util.ResourceMetadataDB.*;
import org.rx.cr.util.gui.AdminIntall;
import org.rx.cr.util.gui.ConfigClient;
import org.rx.cr.util.gui.ConfigServer;

public class TestGeneric {
    public static void main(String[] args) {
//        setMetaDataDB(new String[]{
//            "NjM2RDU2Nzc2MjMzNEEzMDVBNTc0RTdBNjE2NzNEM0Q=",
//            "NjM2RDM5NzY2NDQxM0QzRA==",
//            "NEQ1NDQ5N0E0RTQ0NTUzMjRFN0E2NzNE",
//            "NjM2RDM5NzY2NDQxM0QzRA==",
//            "NEQ1NDQ5N0E0RTQ0NTUzMjRFN0E2NzNE",
//            "NUE0NzQ5NzY1QTQ3NEE2NjVBNTc3MDZDNjI1ODQyNzM2Mjc5MzU3QTYzNTc3NzNE"
//        });
//        SubClassTest sbt = new SubClassTest();
//        sbt.testStatic();//        
//        Config conf = new Config(Config.SERVER); 
//        conf.setApp_name("CSJA_server");
//        conf.loadConf();
//        System.out.println(conf.toString());
//        DBA.selectMYSQL();
        ConfigServer confS = new ConfigServer(null,"CSJA");
        System.out.println(confS.getConfig());
        System.out.println("\n");
        ConfigClient conf = new ConfigClient(null,"CSJA");
        System.out.println(conf.getConfig());
//        AdminIntall intall = new AdminIntall(null,"CSJA");
//        System.out.println(intall.getConf());
//        DSConeccion ds = new DSConeccion(conf);
//        System.out.println(ds.getConeccion());
    }
}
