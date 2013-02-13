package org.rx.cr.ds;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.rx.cr.conf.Config;

public final class DSConeccion {
    private String user=null;
    private String pass=null;
    private String driver=null;
    private String url=null;
    private String host=null;
    private String port=null;
    private String db=null;
    private String sid=null;
   
     public DSConeccion(String host, String puerto, String db,String usuario,String clave) {
        setHost(host);
        setPort(puerto);
        setDb(db);
        setUser(usuario);
        setPass(clave); 
        defaultPostgreSql();            
     }
     public DSConeccion(Config conf) {
        setHost(conf.getHost());
        setPort(conf.getPort());
        setDb(conf.getDb());
        setUser(conf.getUser());
        setPass(conf.getPassword()); 
        defaultPostgreSql();            
     }
     
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void defaultPostgreSql(){
     setDriver("org.postgresql.Driver");
     setUrl("jdbc:postgresql://"+getHost()+":"+getPort()+"/"+getDb());
    }
    public void defaultMSSql(){
     setDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     setUrl("jdbc:sqlserver://"+getHost()+":"+getPort()+";databaseName="+getDb());
    }
    public void defaultOracle(){
     setDriver("oracle.jdbc.OracleDriver");
     setUrl("jdbc:oracle:thin:@"+getHost()+":"+getPort()+":"+getSid());
    }
    public void defaultMySql(){
     setDriver("com.mysql.jdbc.Driver");
     setUrl("jdbc:mysql://"+getHost()+":"+getPort()+"/"+getDb());
    }
    public Connection getConeccion(){
        try {
            Class.forName(getDriver()).newInstance();
        } catch (InstantiationException ex) {
            System.err.println(ex);
            return null;
        } catch (IllegalAccessException ex) {
            System.err.println(ex);
            return null;
        }catch (ClassNotFoundException ex) {
            System.err.println(ex);
            return null;
        }
        try {            
            return DriverManager.getConnection(getUrl(),getUser(),getPass());
        }
        catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }
    
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
