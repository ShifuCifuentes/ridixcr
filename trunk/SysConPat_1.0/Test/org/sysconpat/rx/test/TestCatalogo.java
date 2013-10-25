package org.sysconpat.rx.test;

import org.sysconpat.rx.bl.BLCatalogo;

public class TestCatalogo {
    public static void main(String[] args) throws Exception {
        BLCatalogo bl = new BLCatalogo();
        System.out.println(bl.ultimo_correlativo_bien_patrimonial("",0,0));
    }
}
