package org.rx.cr.bl;

import java.sql.Connection;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.rx.cr.generic.MVCGeneric;

public abstract class BLAbstract<Tipo> implements MVCGeneric<Tipo>{
    private Config conf=null;
    private DSConeccion ds = null;
    
    public void setDSConeccion(DSConeccion ds){
        this.ds = ds;
    }
    public void setConfig(Config conf){
        this.conf=conf;    
    }
    public Connection getConeccion(){
        if (ds==null) {
         ds = new DSConeccion(conf);   
        }        
        return ds.getConeccion();
    }
}
