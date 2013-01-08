package org.rx.systienda.bl;

import java.util.ArrayList;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.rx.systienda.bean.BECategoria;
import org.rx.systienda.dao.DAOCategoria;

public class BLCategoria {
    private DAOCategoria dao;
    private DSConeccion ds;
    private Config conf;

    public BLCategoria(Config conf) {
        this.conf=conf;
    }
    
    public int registrar(BECategoria bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOCategoria(ds.getConeccion());
        resp = dao.registrar(bean);
        dao.close();
        return resp;
    }
    
    public int actualizarRegistro(BECategoria bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOCategoria(ds.getConeccion());
        resp = dao.actualizarRegistro(bean);
        dao.close();
        return resp;
    }
    
    public ArrayList<BECategoria> buscarReferencia(String ref){
        ArrayList<BECategoria> list;
        ds = new DSConeccion(conf);
        dao =new DAOCategoria(ds.getConeccion());
        list = dao.buscarReferencia(ref);
        dao.close();
        return list;
    }
}
