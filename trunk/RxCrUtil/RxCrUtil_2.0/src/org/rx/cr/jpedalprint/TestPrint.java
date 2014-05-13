package org.rx.cr.jpedalprint;

import java.io.File;
import static org.rx.cr.util.Utilitarios.*;

public class TestPrint {
    public static void main(String[] args) {
       JPedalPrint jPedalPrint = new JPedalPrint(new String[]{"-d",getCurentPath()+File.separator+"imagen_resolucion.pdf"});
        jPedalPrint.printer(null);
    }
}
