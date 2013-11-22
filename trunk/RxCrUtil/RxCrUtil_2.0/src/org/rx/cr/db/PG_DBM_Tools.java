package org.rx.cr.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.rx.cr.conf.Config;
import org.rx.cr.util.SystemInfo;
import static org.rx.cr.util.Utilitarios.*;

public class PG_DBM_Tools {

    private Config conf=null;
    private File pg_dump_file=null;
    private File pg_restore_file=null;
    private File postgres_dir_appdata=null;  
    private File pg_hba_conf=null;
    private File root_postgres=null;
    public PG_DBM_Tools(Config conf) {       
        
        this.conf = conf;       
        root_postgres = new File(SystemInfo.getDirectorioArchivosPrograma()+File.separator+"PostgreSQL");
        if (!root_postgres.exists()) {
            root_postgres = new File(SystemInfo.getDirectorioArchivosProgramaX86()+File.separator+"PostgreSQL");
        }
        pg_dump_file = new File(new File(root_postgres.listFiles()[0].getAbsolutePath()+File.separator+"bin").getAbsolutePath()+File.separator+"pg_dump.exe");        
        pg_restore_file = new File(new File(root_postgres.listFiles()[0].getAbsolutePath()+File.separator+"bin").getAbsolutePath()+File.separator+"pg_restore.exe");
        pg_hba_conf = new File(conf.getDir_db()+File.separator+"pg_hba.conf");
               
    }
       
    public String pg_dump_file(){
        if (pg_dump_file.exists()) {
          return pg_dump_file.getAbsolutePath();   
        }else{
           JOptionPane.showMessageDialog(null,"Instale correctamente el gestor\nde Base de datos PostgreSQL","Atencion",JOptionPane.INFORMATION_MESSAGE);
         return null;
        }      
    }
    public String pg_restore_file(){
        if (pg_restore_file.exists()) {
          return pg_restore_file.getAbsolutePath();   
        }else{
           JOptionPane.showMessageDialog(null,"Instale correctamente el gestor\nde Base de datos PostgreSQL","Atencion",JOptionPane.INFORMATION_MESSAGE);
         return null;
        }      
    }
    public Process mk_BackUp_DB_PostgreSQL() throws IOException{ 
            FileOutputStream fos = new FileOutputStream(new File("mk_back_up_db.bat"));
            renameFile(getConf().getDir_backup_db()+File.separator+"*.backup");
            String comand="\""+pg_dump_file()+"\""+" -h "+getConf().getHost()+" -p "+getConf().getPort()+" -i -U "+getConf().getUser_db_root()+" -Fc -b -v -f"+" \""+getConf().getDir_backup_db()+File.separator+"db_"+getConf().getDb()+"_(%date:~3,2%-%date:~0,2%-%date:~6,4%)_(%time:~0,2%-%time:~3,2%-%time:~6,2%).backup\" "+getConf().getDb()+"";            
            fos.write(comand.getBytes());
            fos.close();
            //File bat_path = new File(si.getDirectorioActual()+File.separator+"mk_back_up_db.bat");
            //Utilitarios.ejecutaComando("cmd.exe /C echo "+comannd+">"+bat_path.getAbsolutePath());
            File bat_path = new File(SystemInfo.getDirectorioActual()+File.separator+"mk_back_up_db.bat");           
            if (bat_path.exists()) {
              //System.out.println(bat_path.getAbsolutePath());
              return ejecutaComando("cmd.exe /C start cmd.exe /C call \""+bat_path.getAbsolutePath()+"\""); 
            } else {
              //System.out.println("Archivo de lotes no existe");
              return null;  
            }         
    }
    public Process restore_BackUp_DB_PostgreSQL() throws IOException{    
            FileOutputStream fos = new FileOutputStream(new File("restore_back_up_db.bat"));
            String comand="\""+pg_restore_file()+"\""+" --host "+getConf().getHost()+" --port "+getConf().getPort()+" --username "+getConf().getUser_db_root()+" --dbname "+getConf().getDb()+" --verbose \""+getPg_db_file().getAbsolutePath()+"\"";
            fos.write(comand.getBytes());
            fos.close();
            //File bat_path = new File(si.getDirectorioActual()+File.separator+"restore_back_up_db.bat");
            //Utilitarios.ejecutaComando("cmd.exe /C echo "+comannd+">"+bat_path.getAbsolutePath());            
            File bat_path = new File(SystemInfo.getDirectorioActual()+File.separator+"restore_back_up_db.bat");
            if (bat_path.exists()) {
              //System.out.println(bat_path.getAbsolutePath());
              return ejecutaComando("cmd.exe /C start cmd.exe /C call \""+bat_path.getAbsolutePath()+"\"");   
            } else {
              //System.out.println("Archivo de lotes no existe");
              return null;     
            }
                     
    }
    public void postgresSqlProgramData(){
        try {
              postgres_dir_appdata = new File(SystemInfo.getDirectorioDatosPrograma()+File.separator+"postgresql");
              if (!postgres_dir_appdata.exists()) {
                 postgres_dir_appdata.mkdir(); 
              } 
              String comand = getConf().getHost()+":"+getConf().getPort()+":"+getConf().getDb()+":"+getConf().getUser_db_root()+":"+getConf().getPassword_db_root();
              FileOutputStream fos = new FileOutputStream(new File(postgres_dir_appdata.getAbsolutePath()+File.separator+"pgpass.conf"));
              fos.write(comand.getBytes());
              fos.close();
              //Utilitarios.ejecutaComando("cmd.exe /C echo "+conf.getHost()+":"+conf.getPort()+":"+conf.getDb()+":"+conf.getUser_db_root()+":"+conf.getPassword_db_root()+">"+postgres_dir_appdata.getAbsolutePath()+File.separator+"pgpass.conf");              
        } catch (IOException ex) {
            Logger.getLogger(PG_DBM_Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    public void deletePostgresAppDataInfo() throws IOException{
      File pgpass = new File(postgres_dir_appdata.getAbsolutePath()+File.separator+"pgpass.conf");
      if(!pgpass.exists()){
          deleteFile(pgpass.getAbsolutePath());
      }      
    }

    public File getPg_db_file() {
        return pg_hba_conf;
    }

    public void setPg_db_file(File pg_db_file) {
        this.pg_hba_conf = pg_db_file;
    }
    public boolean configurar_ip_s_cliente(){
        try {
            FileOutputStream pg_hba;
            if (pg_hba_conf!=null && pg_hba_conf.exists()) {
                pg_hba = new FileOutputStream(pg_hba_conf);
                mk_config_file(pg_hba);
                return true;
            }else{
                pg_hba_conf= new File(root_postgres.listFiles()[0].getAbsolutePath()+File.separator+"data"+File.separator+"pg_hba.conf");
                if (pg_hba_conf!=null && pg_hba_conf.exists()) {
                    pg_hba = new FileOutputStream(pg_hba_conf);
                    mk_config_file(pg_hba);
                    return true;
                }else{
                    return false;
                }
            }    
        } catch (IOException ex) {
            //Logger.getLogger(PG_DBM_Tools.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private void mk_config_file(FileOutputStream pg_hba) throws IOException {
        String pg_hba_conf_content="# TYPE  DATABASE        USER            CIDR-ADDRESS            METHOD\n";
        if (!conf.getHost().trim().equals("127.0.0.1")) {
            pg_hba_conf_content+="\n";
            pg_hba_conf_content+="# IPv4 local connections:\n";
            pg_hba_conf_content+="host    all             all             127.0.0.1/32            md5\n";
            int max_nro_clientes = Integer.parseInt(getConf().getMax_clientes());
            for (int i = 1; i <= max_nro_clientes; i++) {
                pg_hba_conf_content+="host    all             all             "+getConf().getHost().substring(0,getConf().getHost().lastIndexOf("."))+"."+i+"/32            md5\n";
            }
            pg_hba_conf_content+="host    all             all             "+getConf().getHost()+"/32            md5\n";
            pg_hba_conf_content+="# IPv6 local connections:\n";
            pg_hba_conf_content+="host    all             all             ::1/128                 md5\n";       
            pg_hba_conf_content+="# Allow replication connections from localhost, by a user with the\n";
            pg_hba_conf_content+="# replication privilege.\n";
            pg_hba_conf_content+="#host    replication     postgres        127.0.0.1/32            md5\n";
            pg_hba_conf_content+="#host    replication     postgres        ::1/128                 md5\n";
        }else{
            pg_hba_conf_content+="\n";
            pg_hba_conf_content+="# IPv4 local connections:\n";
            pg_hba_conf_content+="host    all             all             127.0.0.1/32            md5\n";          
            pg_hba_conf_content+="# IPv6 local connections:\n";
            pg_hba_conf_content+="host    all             all             ::1/128                 md5\n";
            pg_hba_conf_content+="# Allow replication connections from localhost, by a user with the\n";
            pg_hba_conf_content+="# replication privilege.\n";
            pg_hba_conf_content+="#host    replication     postgres        127.0.0.1/32            md5\n";
            pg_hba_conf_content+="#host    replication     postgres        ::1/128                 md5\n";
        }                
        pg_hba.write(pg_hba_conf_content.getBytes());
        pg_hba.close();
    }

    public Config getConf() {
        return conf;
    }

    public void setConf(Config conf) {
        this.conf = conf;
    }
}
