package org.rx.cr.bl;

import java.sql.Connection;
import org.RidixCr;
import org.rx.cr.conf.Config;
import org.rx.cr.db.DBA;
import org.rx.cr.ds.DSConeccion;
import org.rx.cr.generic.MVCGeneric;
import static org.rx.cr.util.Utilitarios.*;

public abstract class BLAbstract<Tipo> implements MVCGeneric<Tipo>{
    private Config conf=null;
    private DSConeccion ds = null;
    private String appContextPath=null;
    private int dba;
    
    public void setDSConeccion(DSConeccion ds){
        this.ds = ds;
    }
    public void setConfig(Config conf){
        this.dba= DBA.selectedDBA();
        this.conf=conf;    
    }
    public Connection getConeccion(){
        if (ds==null) {
         ds = new DSConeccion(dba,conf);   
        }        
        return ds.getConeccion();
    }
    @RidixCr(author=RidixCr)
    @Deprecated
    public Tipo autenticarUsuario(String user,String password) throws Exception{
        throw new UnsupportedOperationException("Implementar si se requiere!");
    }

    public String getAppContextPath() {
        return appContextPath;
    }

    public void setAppContextPath(String appContextPath) {
        this.appContextPath = appContextPath;
    }
}
