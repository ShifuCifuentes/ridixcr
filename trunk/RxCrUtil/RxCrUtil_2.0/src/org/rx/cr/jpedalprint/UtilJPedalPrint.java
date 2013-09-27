package org.rx.cr.jpedalprint;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import static org.rx.cr.util.SystemInfo.*;
import static org.rx.cr.util.Utilitarios.*;

public class UtilJPedalPrint {
    public static void silentPrintPDF(File ref) throws IOException{
        printPDFFile(ref,"-s");
    }
    public static void dialogPrintPDF(File ref) throws IOException{
        printPDFFile(ref,"-d");
    }
    public static void dialogPrintPDF(Component parent,File ref) throws IOException{
        printPDFFile(parent,ref,"-d");
    }
    private static void printPDFFile(File pdfFile,String op) throws IOException{
        File jarFile = new File(getCurentPath()+File.separator+"lib\\JPedalPrint.jar");
        if (!jarFile.exists()) {
            jarFile = new File(getCurentPath()+File.separator+"JPedalPrint.jar");
        }
        File javaExe = new File(getDirectorioJava()+File.separator+"bin\\java.exe");        
        Runtime.getRuntime().exec(javaExe.getAbsolutePath()+" -jar "+jarFile.getAbsolutePath()+" "+op+" "+pdfFile.getAbsolutePath());
    }
    private static void printPDFFile(Component parent,File pdfFile,String op) throws IOException{
        JPedalPrint jPedalPrint = new JPedalPrint(new String[]{op,pdfFile.getAbsolutePath()});
        jPedalPrint.printer(parent);
    }
}
