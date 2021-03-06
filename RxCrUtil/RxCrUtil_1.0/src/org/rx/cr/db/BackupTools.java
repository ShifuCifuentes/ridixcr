package org.rx.cr.db;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.rx.cr.conf.Config;
import org.rx.cr.util.SystemInfo;
import static org.rx.cr.util.Utilitarios.*;

public class BackupTools {

    private SystemInfo si = new SystemInfo();
    private Config conf=null;
    private File pg_dump_file=null;
    private File pg_restore_file=null;
    private File postgres_dir_appdata=null;  
    private File pg_db_file=null;
    public BackupTools(Config conf) {        
        si = new SystemInfo();
        this.conf = conf;        
        pg_dump_file = new File(new File(new File(SystemInfo.getDirectorioArchivosPrograma()+File.separator+"PostgreSQL").listFiles()[0].getAbsolutePath()+File.separator+"bin").getAbsolutePath()+File.separator+"pg_dump.exe");
        pg_restore_file = new File(new File(new File(SystemInfo.getDirectorioArchivosPrograma()+File.separator+"PostgreSQL").listFiles()[0].getAbsolutePath()+File.separator+"bin").getAbsolutePath()+File.separator+"pg_restore.exe");
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
            renameFile(conf.getDir_backup_db()+File.separator+"*.backup");
            String comand="\""+pg_dump_file()+"\""+" -h "+conf.getHost()+" -p "+conf.getPort()+" -i -U "+conf.getUser_db_root()+" -Fc -b -v -f"+" \""+conf.getDir_backup_db()+File.separator+"db_"+conf.getDb()+"_(%date:~3,2%-%date:~0,2%-%date:~6,4%)_(%time:~0,2%-%time:~3,2%-%time:~6,2%).backup\" "+conf.getDb()+"";            
            fos.write(comand.getBytes());
            fos.close();
            //File bat_path = new File(si.getDirectorioActual()+File.separator+"mk_back_up_db.bat");
            //Utilitarios.ejecutaComando("cmd.exe /C echo "+comannd+">"+bat_path.getAbsolutePath());
            File bat_path = new File(si.getDirectorioActual()+File.separator+"mk_back_up_db.bat");           
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
            String comand="\""+pg_restore_file()+"\""+" --host "+conf.getHost()+" --port "+conf.getPort()+" --username "+conf.getUser_db_root()+" --dbname "+conf.getDb()+" --verbose \""+getPg_db_file().getAbsolutePath()+"\"";
            fos.write(comand.getBytes());
            fos.close();
            //File bat_path = new File(si.getDirectorioActual()+File.separator+"restore_back_up_db.bat");
            //Utilitarios.ejecutaComando("cmd.exe /C echo "+comannd+">"+bat_path.getAbsolutePath());            
            File bat_path = new File(si.getDirectorioActual()+File.separator+"restore_back_up_db.bat");
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
              postgres_dir_appdata = new File(si.getDirectorioDatosPrograma()+File.separator+"postgresql");
              if (!postgres_dir_appdata.exists()) {
                 postgres_dir_appdata.mkdir(); 
              } 
              String comand = conf.getHost()+":"+conf.getPort()+":"+conf.getDb()+":"+conf.getUser_db_root()+":"+conf.getPassword_db_root();
              FileOutputStream fos = new FileOutputStream(new File(postgres_dir_appdata.getAbsolutePath()+File.separator+"pgpass.conf"));
              fos.write(comand.getBytes());
              fos.close();
              //Utilitarios.ejecutaComando("cmd.exe /C echo "+conf.getHost()+":"+conf.getPort()+":"+conf.getDb()+":"+conf.getUser_db_root()+":"+conf.getPassword_db_root()+">"+postgres_dir_appdata.getAbsolutePath()+File.separator+"pgpass.conf");              
        } catch (IOException ex) {
            Logger.getLogger(BackupTools.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    public void deletePostgresAppDataInfo(){
      deleteFile(new File(postgres_dir_appdata.getAbsolutePath()+File.separator+"pgpass.conf").getAbsolutePath());
    }

    public File getPg_db_file() {
        return pg_db_file;
    }

    public void setPg_db_file(File pg_db_file) {
        this.pg_db_file = pg_db_file;
    }
}
