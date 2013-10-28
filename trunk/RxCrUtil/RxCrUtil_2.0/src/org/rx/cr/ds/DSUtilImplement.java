package org.rx.cr.ds;

import java.lang.reflect.Method;
import java.sql.Connection;
import org.rx.cr.conf.Config;

public class DSUtilImplement implements IDSUtil{
    public void setDefault(Method m){
    
    }

    @Override
    public DSConeccion _DSConneccion(Config conf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DSConeccion _DSConneccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Connection _Conneccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
