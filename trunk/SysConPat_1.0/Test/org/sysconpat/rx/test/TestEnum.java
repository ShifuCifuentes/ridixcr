/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sysconpat.rx.test;

import org.sysconpat.rx.gui.servicios.ServiciosExistentes;

/**
 *
 * @author ridix
 */
public class TestEnum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiciosExistentes[] enum_list = ServiciosExistentes.values();
        for (int i = 0; i < enum_list.length; i++) {
            ServiciosExistentes se = enum_list[i];
            //System.out.println(ServiciosExistentes.valueOf("rol_admin"));
            System.out.println(se);
        }
    }
}
