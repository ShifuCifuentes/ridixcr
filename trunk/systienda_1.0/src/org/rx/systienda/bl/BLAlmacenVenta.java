package org.rx.systienda.bl;

import java.util.ArrayList;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.rx.systienda.bean.BEProducto;
import org.rx.systienda.dao.DAOAlmacenVenta;

public class BLAlmacenVenta {
    private DAOAlmacenVenta dao;
    private DSConeccion ds;
    private Config conf;

    public BLAlmacenVenta(Config conf) {
        this.conf=conf;
    }
    
    public int registrar(BEProducto bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenVenta(ds.getConeccion());
        resp = dao.registrar(bean);
        dao.close();
        return resp;
    }
    
    public int actualizarRegistro(BEProducto bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenVenta(ds.getConeccion());
        resp = dao.actualizarRegistro(bean);
        dao.close();
        return resp;
    }
    
    public int eliminarRegistro(BEProducto bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenVenta(ds.getConeccion());
        resp = dao.eliminarRegistro(bean);
        dao.close();
        return resp;
    }
    
    public ArrayList<BEProducto> buscarReferencia(String ref){
        ArrayList<BEProducto> list;
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenVenta(ds.getConeccion());
        list = dao.buscarReferencia(ref);
        dao.close();
        return list;
    }
    
    public ArrayList<BEProducto> listar(){
        ArrayList<BEProducto> list;
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenVenta(ds.getConeccion());
        list = dao.listar();
        dao.close();
        return list;
    }
    
    public BEProducto buscar(int id){
        BEProducto bean;
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenVenta(ds.getConeccion());
        bean = dao.buscar(id);
        dao.close();
        return bean;
    }
}
