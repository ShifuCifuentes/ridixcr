package org.sysconpat.rx.test;

import java.sql.Date;
import org.rx.cr.conf.Config;
import org.rx.cr.util.Utilitarios;
import org.sysconpat.rx.bl.BLBienPatrimonial;

public class TestDepreciacion {
    public static void main(String[] args) throws Exception {
        Config conf = new Config();
        conf.setApp_name("CERCUS");
        conf.loadConf();
        BLBienPatrimonial bl = new BLBienPatrimonial(conf);
        //bl.generar_deprecion_general(Utilitarios.castDate_UTIL_SQL(new java.util.Date(2013-1900,07,05)));
        //bl.generar_deprecion_general_individual(Utilitarios.castDate_UTIL_SQL(new java.util.Date(2013-1900,07,05)),2);
        bl.generar_depreciacion_general_individual_anual(Utilitarios.castDate_UTIL_SQL(new java.util.Date(2013-1900,07,05)),2);
    }
}
