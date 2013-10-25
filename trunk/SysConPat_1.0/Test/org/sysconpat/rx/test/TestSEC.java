package org.sysconpat.rx.test;

import static org.rx.cr.util.Utilitarios.*;
import static org.sysconpat.rx.ds.DSUtil.*;

public class TestSEC {
    public static void main(String[] args) {
        System.out.println(encodeRx("CERCUS"));
        System.out.println(encodeRx("Sistema de Control Patrimonial - CERCUS"));
        System.out.println(encodeRx("---------------------------------------"));
        System.out.println(encodeRx("127.0.0.1"));
        System.out.println(encodeRx("5432"));
        System.out.println(encodeRx("control_patrimonial"));
        System.out.println(encodeRx("sysconpat"));
        System.out.println(encodeRx("sysconpat123"));
        ///System.out.println(_Conneccion());
    }
}
