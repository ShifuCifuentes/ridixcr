package org.rx.cr.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.RidixCr;
import static org.rx.cr.util.Utilitarios.*;

public class TestUtilitarios {
    @RidixCr(author=RidixCr)
    public static void main(String[] args) throws FileNotFoundException, IOException {   
        System.out.println(encodeRx(AUTOR));  
        System.out.println(encodeRx(RidixCr));  
        System.out.println(AUTOR); 
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getClassName());
//                if ("Windows".equals(info.getName())) {
//                    try {
//                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                        break;
//                    } catch (ClassNotFoundException ex) {
//                        Logger.getLogger(TestUtilitarios.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (InstantiationException ex) {
//                        Logger.getLogger(TestUtilitarios.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (IllegalAccessException ex) {
//                        Logger.getLogger(TestUtilitarios.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (UnsupportedLookAndFeelException ex) {
//                        Logger.getLogger(TestUtilitarios.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
            }
        File file = new File(getCurentPath()+File.separator+"dist"+File.separator+"RxCrUtil_2.0.jar");
        if (!file.exists()) {
            file = new File(getCurentPath()+File.separator+"RxCrUtil_2.0.jar");
        }
        String md5 = md5(file);
        String sha1 = sha1(file);
        System.out.println("MD5 : "+md5);
        System.out.println("SHA1: "+sha1);
        
        System.out.println(sha1("RidixCr.{import java.*}"));
        
        System.exit(0); 
        /***/
    }
}
