package org.rx.cr.conf;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
import org.rx.cr.util.ResourceMetadataDB;
import org.rx.cr.util.Utilitarios;

public final class Config {
    public static final int NUEVALINEA=10,SERVER=1,CLIENT=2,META_DATOS_SOFT=3;
    private InputStreamReader isr;
    private OutputStreamWriter osw;
    private String app_name;
    private final String NAME_CONF_FILE="APP.conf";
    private String install_mode;
    
    private String user;
    private String password;
    private String port;
    private String db;       
    private String ip;    
    private File ftmp;
    
    private String user_db_root;
    private String passworddb_root;
    private String dir_backup_db="";
    private String dir_db="";
    private String max_clientes;
    private int invocador;
        
    public Config(int invocador){      
        try {
            setInvocador(invocador);
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean loadConf(){
        try {            
            ftmp = new File(Utilitarios.getCurentPath()+File.separator+"conf"+File.separator+getAppConfigFileName());               
            isr = new InputStreamReader(new FileInputStream(ftmp));  
            load();           
            isr.close();
            return true;
        }catch(Exception ex){
            //Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    private void load() throws IOException, Exception{               
        String line;  
        while (isr.ready()) {
            line = decodeStringBase64ASSCII(readLine().trim());            
            line=line.trim();
            switch(getInvocador()){
                case SERVER:
                        //<editor-fold defaultstate="collapsed" desc="Server">    
                        if(line.startsWith("host=")){
                            setHost(getInfoConf(line));                
                        }else if(line.startsWith("port=")){
                            setPort(getInfoConf(line));                 
                        }else if(line.startsWith("db=")){
                            setDb(getInfoConf(line));                 
                        }else if(line.startsWith("user=")){
                            setUser(getInfoConf(line));                 
                        }else if(line.startsWith("password=")){
                            setPassword(getInfoConf(line)); 
                        }else if(line.startsWith("user_db_root=")){
                            setUser_db_root(getInfoConf(line)); 
                        }else if(line.startsWith("passworddb_root=")){
                            setPassword_db_root(getInfoConf(line));
                        }else if(line.startsWith("dir_backup_db=")){
                            setDir_backup_db(getInfoConf(line)); 
                        }else if(line.startsWith("dir_db=")){
                            setDir_db(getInfoConf(line));  
                        }else if(line.startsWith("max_clients=")){
                            setMax_clientes(getInfoConf(line));   
                        }else{
                          throw new Exception("Error de Sintaxis Archivo Erroneo");
                        }          
                    break;
                    //</editor-fold>
                case CLIENT: 
                        //<editor-fold defaultstate="collapsed" desc="Client">
                        if(line.startsWith("host=")){
                            setHost(getInfoConf(line));                
                        }else if(line.startsWith("port=")){
                            setPort(getInfoConf(line));                 
                        }else if(line.startsWith("db=")){
                            setDb(getInfoConf(line));                 
                        }else if(line.startsWith("user=")){
                            setUser(getInfoConf(line));                 
                        }else if(line.startsWith("password=")){
                            setPassword(getInfoConf(line)); 
                        }else{                           
                         throw new Exception("Error de Sintaxis Archivo Erroneo");
                        }         
                    break;  
                    //</editor-fold>
               case META_DATOS_SOFT: 
                        if(line.startsWith("db=")){
                            setDb(getInfoConf(line));                 
                        }else if(line.startsWith("user=")){
                            setUser(getInfoConf(line));                 
                        }else if(line.startsWith("password=")){
                            setPassword(getInfoConf(line)); 
                        }else if(line.startsWith("user_db_root=")){
                            setUser_db_root(getInfoConf(line)); 
                        }else if(line.startsWith("passworddb_root=")){
                            setPassword_db_root(getInfoConf(line));
                        }else{
                          throw new Exception("Error de Sintaxis Archivo Erroneo");
                        }         
                    break;  
            }                
        }
    }
    private String readLine() throws IOException{
        String aux="";
        boolean fl = false;
        while (isr.ready() && !fl) {
           int cr = isr.read();
            if (cr!=NUEVALINEA) {
              aux+=(char)cr;
            } else {
               fl=true;
            }
        }
      return aux;
    }    
    private String getInfoConf(String inf){
       String tmpinf;
       int ps;
       ps = inf.indexOf("=");
       tmpinf=inf.substring(ps+1,inf.length());
        return tmpinf;
    }
   
    public void saveConf(){
        try {        
            ftmp = new File("conf");
            if (!ftmp.exists()) {
               ftmp.mkdir(); 
            }
            ftmp = new File(Utilitarios.getCurentPath()+File.separator+"conf"+File.separator+getAppConfigFileName());
            osw = new OutputStreamWriter(new FileOutputStream(ftmp));
            save();
            osw.close();
            ftmp=null;
        } 
        catch (FileNotFoundException ex) {}
        catch (IOException ex) {}
    }
    private void save() throws IOException{
      switch(getInvocador()){
          case SERVER:      
                osw.write(encodeStringASSCIIBase64("host="+getHost()) +"\n");      
                osw.write(encodeStringASSCIIBase64("port="+getPort()) +"\n");
                osw.write(encodeStringASSCIIBase64("db="+getDb()) +"\n");
                osw.write(encodeStringASSCIIBase64("user="+getUser()) +"\n");
                osw.write(encodeStringASSCIIBase64("password="+getPassword())+"\n");
                osw.write(encodeStringASSCIIBase64("user_db_root="+getUser_db_root())+"\n");
                osw.write(encodeStringASSCIIBase64("passworddb_root="+getPassword_db_root())+"\n");
                osw.write(encodeStringASSCIIBase64("dir_backup_db="+getDir_backup_db())+"\n");       
                osw.write(encodeStringASSCIIBase64("dir_db="+getDir_db())+"\n");       
                osw.write(encodeStringASSCIIBase64("max_clients="+getMax_clientes())+"\n");       
              break;
          case CLIENT:   
                osw.write(encodeStringASSCIIBase64("host="+getHost()) +"\n");      
                osw.write(encodeStringASSCIIBase64("port="+getPort()) +"\n");
                osw.write(encodeStringASSCIIBase64("db="+getDb()) +"\n");
                osw.write(encodeStringASSCIIBase64("user="+getUser()) +"\n");
                osw.write(encodeStringASSCIIBase64("password="+getPassword())+"\n");                
              break;  
          case META_DATOS_SOFT: 
                osw.write(encodeStringASSCIIBase64("db="+getDb()) +"\n");
                osw.write(encodeStringASSCIIBase64("user="+getUser()) +"\n");
                osw.write(encodeStringASSCIIBase64("password="+getPassword())+"\n");   
                osw.write(encodeStringASSCIIBase64("user_db_root="+getUser_db_root())+"\n");
                osw.write(encodeStringASSCIIBase64("passworddb_root="+getPassword_db_root())+"\n");
              break;  
      }    
    }

    
    public String encodeStringASSCIIBase64(String ref){    
       return DatatypeConverter.printBase64Binary(ref.getBytes());
    }
    public String decodeStringBase64ASSCII(String ref){
       return new String(DatatypeConverter.parseBase64Binary(ref));
    }
    public String getUser() {
        return user.trim();
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password.trim();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port.trim();
    }

    public void setPort(String port) {
        this.port = port;
    }
    
    public String getHost() {
        return ip.trim();
    }

    public void setHost(String ip) {
        this.ip = ip;
    }

    public String getDb() {
        return db.trim();
    }

    public void setDb(String db) {
        this.db = db;
    }
    
    @Override
    public String toString(){
      switch(getInvocador()){
          case SERVER: 
              return "\nHost : "+getHost()
                    +"\nPort : "+getPort()
                    +"\nDb : "+getDb()
                    +"\nUser : "+getUser()
                    +"\nPass : "+getPassword()
                    +"\nUser Root : "+getUser_db_root()
                    +"\nPass Root : "+getPassword_db_root()
                    +"\nDB BackUp Dir : "+getDir_backup_db()
                    +"\nDB Dir : "+getDir_db();
          case CLIENT: 
              return "\nHost : "+getHost()
                    +"\nPort : "+getPort()
                    +"\nDb : "+getDb()
                    +"\nUser : "+getUser()
                    +"\nPass : "+getPassword();
          default: return "";
      }      
    }

    public String getUser_db_root() {
        return user_db_root;
    }

    public void setUser_db_root(String user_db_root) {
        this.user_db_root = user_db_root;
    }

    public String getPassword_db_root() {
        return passworddb_root;
    }

    public void setPassword_db_root(String passworddb_root) {
        this.passworddb_root = passworddb_root;
    }

    public String getDir_backup_db() {
        return dir_backup_db;
    }

    public void setDir_backup_db(String dir_backup_db) {
        this.dir_backup_db = dir_backup_db;
    }    

    public String getApp_name() {
        return app_name;
    }
    private String getAppConfigFileName(){        
        return getApp_name()!=null&!getApp_name().equals("")?getApp_name()+".conf":NAME_CONF_FILE;
    }
    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getDir_db() {
        return dir_db;
    }
    public void setDir_db(String dir_db) {
        this.dir_db = dir_db;
    }
    public String getMax_clientes() {
        return max_clientes;
    }
    public void setMax_clientes(String max_clientes) {
        this.max_clientes = max_clientes;
    }
    public int getInvocador() {
        return invocador;
    }
    public void setInvocador(int invocador) {
        this.invocador = invocador;
    }

    public String getInstall_mode() {
        return install_mode;
    }

    public void setInstall_mode(String install_mode) {
        this.install_mode = install_mode;
    }
}
