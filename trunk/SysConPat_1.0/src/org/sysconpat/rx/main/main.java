package org.sysconpat.rx.main;

import java.io.File;
import java.net.UnknownHostException;
import org.rx.cr.conf.Config;
import org.rx.cr.conf.ConfigServerCMD;
import org.rx.cr.db.DBA;
import static org.rx.cr.util.Utilitarios.*;
import org.sysconpat.rx.SysConPat;
import org.sysconpat.rx.ds.DSUtil;
import org.sysconpat.rx.gui.principal.JF_Splash;
import static org.sysconpat.rx.util.ResourceIDVendor.*;

public class main {
    static {
        DBA.selectPOSTGRESQL();
    }
    @SysConPat(author=RidixCr)
    public static void main(String args[]) throws UnknownHostException {
        if (args!=null && args.length>0 && args[0].equals("-install")) {
            installConfiguracion(args);
        }else{
            initGUI();
        }
        
    }

    private static void initGUI() {  
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        final Config conf =  new Config(Config.CLIENT);
        conf.setApp_name(APP_ID);
        try {            
            conf.loadConf();
            if (DSUtil._DSConneccion(conf).getConeccion()!=null) {
                //<editor-fold defaultstate="collapsed" desc="comment">
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Windows".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(JF_Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(JF_Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(JF_Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(JF_Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new JF_Splash(conf).setVisible(true);
                    }
                });
                 //</editor-fold>
            }else{            
                conf.setHost(HOST);
                conf.setPort(PORT);
                conf.setDb(DB);
                conf.setUser(USER);
                conf.setPassword(PASSWORD);
                conf.saveConf();
            }
        } catch (Exception e) {            
            conf.setHost(HOST);
            conf.setPort(PORT);
            conf.setDb(DB);
            conf.setUser(USER);
            conf.setPassword(PASSWORD);
            conf.saveConf();
        }
        //</editor-fold>
    }

    private static void installConfiguracion(String args[]) throws UnknownHostException {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        Config conf;
        if (args[1].equals("server")) {
            conf = new Config(Config.SERVER);
            conf.setApp_name(APP_ID);
            //conf.setHost(InetAddress.getLocalHost().getHostAddress().trim());
            conf.setPort(PORT);
            conf.setDb(DB);
            conf.setUser(USER);
            conf.setPassword(PASSWORD);
            conf.setUser_db_root(USER_ROOT);
            conf.setPassword_db_root(PASSWORD_ROOT);
            conf.setMax_clientes(MAX_CLIENTS);
            ConfigServerCMD cadmin = new ConfigServerCMD(conf,"lib"+File.separator+"structure_db_psql_1.5.jar","dbo.usuario");
            cadmin.saveConfServer();
            cadmin.validDBStructure();
        }else if(args[1].equals("client")){
            conf = new Config(Config.CLIENT);
            conf.setApp_name(APP_ID);            
            //conf.setHost(new IPServer().getIp_server());
            conf.setPort(PORT);
            conf.setDb(DB);
            conf.setUser(USER);
            conf.setPassword(PASSWORD);
            conf.saveConf();
        }        
        //</editor-fold>
    }
}
