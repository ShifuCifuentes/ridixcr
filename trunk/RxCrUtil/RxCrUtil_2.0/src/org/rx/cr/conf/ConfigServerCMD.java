package org.rx.cr.conf;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.rx.cr.db.PG_DBM_Tools;
import org.rx.cr.ds.DSConeccion;
import org.rx.cr.util.gui.BackupRestoreCMD;

public final class ConfigServerCMD {
    private String tableTest;
    private PG_DBM_Tools tools = null;
    private BackupRestoreCMD br_cmd;
    private DSConeccion ds;
    public ConfigServerCMD(Config conf,String back_file_name,String test_table_name) {
        ds = new DSConeccion(conf);
        setTableTest(test_table_name);
        tools = new PG_DBM_Tools(conf);
        br_cmd = new BackupRestoreCMD(back_file_name, tools);
    }
       
    public void validDBStructure(){     
        Connection conn = ds.getConeccion();
        Statement pst=null;
        if (conn!=null) {
          try {
                pst = conn.createStatement();            
                pst.execute("select * from "+getTableTest());            
                conn.close();
                pst.close();
            } catch (Exception ex) {
                try {
                    conn.close();
                    pst.close();                                   
                } catch (Exception ex1) {}
               br_cmd.ejecutaProceso();
            }   
        }else{
            br_cmd.ejecutaProceso();
        }
    }
    
    private void create_role_create_database(Config conf){
     ds.setDb(conf.getUser_db_root());
     ds.setUser(conf.getUser_db_root());
     ds.setPass(conf.getPassword_db_root());     
     ds.defaultPostgreSql();
     Connection conn = ds.getConeccion();
     Statement pst;
        try {
            pst = conn.createStatement();            
            pst.execute("drop database  IF EXISTS "+conf.getDb());            
            pst = conn.createStatement();            
            pst.execute("drop role  IF EXISTS "+conf.getUser());            
            pst = conn.createStatement();            
            pst.execute("CREATE ROLE "+conf.getUser()+" LOGIN ENCRYPTED PASSWORD '"+conf.getPassword()+"' VALID UNTIL 'infinity'");            
            pst = conn.createStatement();
            pst.execute("CREATE DATABASE "+conf.getDb()+" WITH ENCODING='UTF8' OWNER="+conf.getUser()+" CONNECTION LIMIT=-1");           
            conn.close();
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public String getTableTest() {
        return tableTest;
    }

    public void setTableTest(String tableTest) {
        this.tableTest = tableTest;
    }

    public PG_DBM_Tools getTools() {
        return tools;
    }

    public void setTools(PG_DBM_Tools tools) {
        this.tools = tools;
    }
    
    public void saveConfServer() {    
       tools.getConf().saveConf();
       create_role_create_database(tools.getConf());
       //tools.configurar_ip_s_cliente();
    }    
}
