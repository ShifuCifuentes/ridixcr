package org.rx.systienda.bl;

import java.util.ArrayList;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.rx.systienda.bean.BEPersonal;
import org.rx.systienda.dao.DAOPersonal;

public class BLPersonal {
    private DAOPersonal dao;
    private DSConeccion ds;
    private Config conf;

    public BLPersonal(Config conf) {
        this.conf=conf;
    }
    public int registrar(BEPersonal bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOPersonal(ds.getConeccion());
        resp = dao.registrar(bean);
        dao.close();
        return resp;
    }
    public int actualizarRegistro(BEPersonal bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOPersonal(ds.getConeccion());
        resp = dao.actualizarRegistro(bean);
        dao.close();
        return resp;
    }
    public int eliminarRegistro(BEPersonal bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOPersonal(ds.getConeccion());
        resp = dao.eliminarRegistro(bean);
        dao.close();
        return resp;
    }
    public ArrayList<BEPersonal> buscarReferencia(String ref){
        ArrayList<BEPersonal> list;
        ds = new DSConeccion(conf);
        dao =new DAOPersonal(ds.getConeccion());
        list = dao.buscarReferencia(ref);
        dao.close();
        return list;
    }
    public ArrayList<BEPersonal> listar(){
        ArrayList<BEPersonal> list;
        ds = new DSConeccion(conf);
        dao =new DAOPersonal(ds.getConeccion());
        list = dao.listar();
        dao.close();
        return list;
    }
    public BEPersonal buscar(int id){
        BEPersonal bean;
        ds = new DSConeccion(conf);
        dao =new DAOPersonal(ds.getConeccion());
        bean = dao.buscar(id);
        dao.close();
        return bean;
    }
}
