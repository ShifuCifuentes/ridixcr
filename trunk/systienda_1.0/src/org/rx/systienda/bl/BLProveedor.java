package org.rx.systienda.bl;

import java.util.ArrayList;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.rx.systienda.bean.BEProveedor;
import org.rx.systienda.dao.DAOProveedor;

public class BLProveedor {
    private DAOProveedor dao;
    private DSConeccion ds;
    private Config conf;    
    public BLProveedor(Config conf) {
        this.conf=conf;
    }
    public int registrar(BEProveedor bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOProveedor(ds.getConeccion());
        resp = dao.registrar(bean);
        dao.close();
        return resp;
    }
    public int actualizarRegistro(BEProveedor bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOProveedor(ds.getConeccion());
        resp = dao.actualizarRegistro(bean);
        dao.close();
        return resp;
    }
    public int eliminarRegistro(BEProveedor bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOProveedor(ds.getConeccion());
        resp = dao.eliminarRegistro(bean);
        dao.close();
        return resp;
    }
    public ArrayList<BEProveedor> buscarReferencia(String ref){
        ArrayList<BEProveedor> list;
        ds = new DSConeccion(conf);
        dao =new DAOProveedor(ds.getConeccion());
        list = dao.buscarReferencia(ref);
        dao.close();
        return list;
    }
    public ArrayList<BEProveedor> listar(){
        ArrayList<BEProveedor> list;
        ds = new DSConeccion(conf);
        dao =new DAOProveedor(ds.getConeccion());
        list = dao.listar();
        dao.close();
        return list;
    }
    public BEProveedor buscar(int id){
        BEProveedor bean;
        ds = new DSConeccion(conf);
        dao =new DAOProveedor(ds.getConeccion());
        bean = dao.buscar(id);
        dao.close();
        return bean;
    }    
}
