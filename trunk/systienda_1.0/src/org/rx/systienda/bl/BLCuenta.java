
package org.rx.systienda.bl;

import java.util.ArrayList;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.rx.systienda.bean.BECuenta;
import org.rx.systienda.dao.DAOCuenta;

public class BLCuenta {
    private DAOCuenta dao;
    private DSConeccion ds;
    private Config conf;

    public BLCuenta(Config conf) {
        this.conf=conf;
    }
    
    public int registrar(BECuenta bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOCuenta(ds.getConeccion());
        resp = dao.registrar(bean);
        dao.close();
        return resp;
    }
    public int actualizarRegistro(BECuenta bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOCuenta(ds.getConeccion());
        resp = dao.actualizarRegistro(bean);
        dao.close();
        return resp;
    }
    public int eliminarRegistro(BECuenta bean){
       int resp;
        ds = new DSConeccion(conf);
        dao =new DAOCuenta(ds.getConeccion());
        resp = dao.eliminarRegistro(bean);
        dao.close();
        return resp;
    }
    public ArrayList<BECuenta> buscarReferencia(String ref){
        ArrayList<BECuenta> list;
        ds = new DSConeccion(conf);
        dao =new DAOCuenta(ds.getConeccion());
        list = dao.buscarReferencia(ref);
        dao.close();
        return list;
    }
    public ArrayList<BECuenta> listar(){
        ArrayList<BECuenta> list;
        ds = new DSConeccion(conf);
        dao =new DAOCuenta(ds.getConeccion());
        list = dao.listar();
        dao.close();
        return list;
    }
    public BECuenta buscar(int id){
        BECuenta bean;
        ds = new DSConeccion(conf);
        dao =new DAOCuenta(ds.getConeccion());
        bean = dao.buscar(id);
        dao.close();
        return bean;
    }
    public boolean consultaExistenciaAdministradores(){
        boolean resp;
        ds = new DSConeccion(conf);
        dao =new DAOCuenta(ds.getConeccion());
        resp = dao.consultaExistenciaAdministradores();
        dao.close();
        return resp;
    }
    public boolean buscarExistenciaUsuario(String ref){
        boolean resp;
        ds = new DSConeccion(conf);
        dao =new DAOCuenta(ds.getConeccion());
        resp = dao.buscarExistenciaUsuario(ref);
        dao.close();
        return resp;
    }
    public BECuenta validarLoguinPersonal(String ref,String ref2){
        BECuenta bean;
        ds = new DSConeccion(conf);
        dao =new DAOCuenta(ds.getConeccion());
        bean = dao.validarLoguinPersonal(ref, ref2);
        dao.close();
        return bean;
    }
}
