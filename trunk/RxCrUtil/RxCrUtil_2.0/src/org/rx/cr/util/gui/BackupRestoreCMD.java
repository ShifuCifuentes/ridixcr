package org.rx.cr.util.gui;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import org.rx.cr.conf.Config;
import org.rx.cr.db.PG_DBM_Tools;
import static org.rx.cr.util.Utilitarios.*;

public class BackupRestoreCMD {
    private PG_DBM_Tools bpc=null;
    private Process process=null;
    private File backupFile = null;

    public BackupRestoreCMD(String back_file_name,Config conf) {
        //InetAddress.getLocalHost().getHostAddress().trim()
        backupFile=new File(getCurentPath()+File.separator+back_file_name);
        bpc = new PG_DBM_Tools(conf);
    }
    public BackupRestoreCMD(String back_file_name,PG_DBM_Tools tools) {
        backupFile=new File(getCurentPath()+File.separator+back_file_name);
        bpc = tools;
    }
    
    public void cancelarProceso() throws Exception  {
       finalizarProceso("pg_dump.exe");
       finalizarProceso("cmd.exe");
       deleteFile("mk_back_up_db.bat");
       deleteFile("restore_back_up_db.bat");
       bpc.deletePostgresAppDataInfo();
    }

    public void ejecutaProceso() {
       try {
            bpc.postgresSqlProgramData();
            bpc.setPg_db_file(backupFile);
            process = bpc.restore_BackUp_DB_PostgreSQL();
            InputStream is = process.getInputStream();
            int buff = -1;
            String log_back_up="";
            while ((buff=is.read())>0) {                
               log_back_up+=(char)buff; 
            }
            is.close();
            ejecutaComando("cmd.exe /C echo restauracion de Copia de Seguridad DB finalizada correctamente el (%date:~3,2%-%date:~0,2%-%date:~6,4%) a las (%time:~0,2%-%time:~3,2%-%time:~6,2%) por favor guarde su copia de respaldo en un lugar seguro para evitar cualquier catastrofe y perdida de informacion. "+log_back_up+">"+"backup_db.log");           
            try {Thread.sleep(2*1000);} 
            catch (InterruptedException ex) {}            
            deleteFile("mk_back_up_db.bat");
            deleteFile("restore_back_up_db.bat");
            bpc.deletePostgresAppDataInfo();  
            //JOptionPane.showMessageDialog(null,"La base de datos fue correctamente restaurada, vuelva a iniciar el sistema.","Atencion",JOptionPane.INFORMATION_MESSAGE);                         
        } catch (IOException ex) {
           // Logger.getLogger(BackupRestore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
