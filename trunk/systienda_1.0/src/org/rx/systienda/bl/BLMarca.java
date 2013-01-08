package org.rx.systienda.bl;

import java.util.ArrayList;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.rx.systienda.bean.BEMarca;
import org.rx.systienda.dao.DAOMarca;

public class BLMarca {
    private DAOMarca dao;
    private DSConeccion ds;
    private Config conf;

    public BLMarca(Config conf) {
        this.conf=conf;
    }
    public int registrar(BEMarca bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOMarca(ds.getConeccion());
        resp = dao.registrar(bean);
        dao.close();
        return resp;
    }    
    public int registrarMarca(BEMarca bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOMarca(ds.getConeccion());
        resp = dao.registrarMarca(bean);
        dao.close();
        return resp;
    }
    public int actualizarRegistro(BEMarca bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOMarca(ds.getConeccion());
        resp = dao.actualizarRegistro(bean);
        dao.close();
        return resp;
    }
    public int eliminarRegistro(BEMarca bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOMarca(ds.getConeccion());
        resp = dao.eliminarRegistro(bean);
        dao.close();
        return resp;
    }
    public ArrayList<BEMarca> buscarReferencia(String ref){
        ArrayList<BEMarca> list;
        ds = new DSConeccion(conf);
        dao =new DAOMarca(ds.getConeccion());
        list = dao.buscarReferencia(ref);
        dao.close();
        return list;
    }
    public ArrayList<BEMarca> listar(){
        ArrayList<BEMarca> list;
        ds = new DSConeccion(conf);
        dao =new DAOMarca(ds.getConeccion());
        list = dao.listar();
        dao.close();
        return list;
    }
    public BEMarca buscar(int id){
        BEMarca bean;
        ds = new DSConeccion(conf);
        dao =new DAOMarca(ds.getConeccion());
        bean = dao.buscar(id);
        dao.close();
        return bean;
    }
}
