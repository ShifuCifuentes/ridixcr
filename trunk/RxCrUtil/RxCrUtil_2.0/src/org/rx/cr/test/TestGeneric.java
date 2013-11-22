package org.rx.cr.test;

import javax.swing.ImageIcon;
import org.rx.cr.util.Utilitarios;

public class TestGeneric {
    public void test() {
        ImageIcon imageIcon = new ImageIcon(Utilitarios.getResourceByte(""));
    }
    public static void main(String[] args) {
        System.out.println(Utilitarios.genNroLote()); 
        
    }
}
