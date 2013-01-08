package org.rx.systienda.bl;

import java.util.ArrayList;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.rx.systienda.bean.BEProducto;
import org.rx.systienda.dao.DAOAlmacenPrimario;

public class BLAlmacenPrimario {
    private DAOAlmacenPrimario dao;
    private DSConeccion ds;
    private Config conf;

    public BLAlmacenPrimario(Config conf) {
        this.conf=conf;
    }       
    public int registrar(BEProducto bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenPrimario(ds.getConeccion());
        resp = dao.registrar(bean);
        dao.close();
        return resp;
    }
    public int actualizarRegistro(BEProducto bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenPrimario(ds.getConeccion());
        resp = dao.actualizarRegistro(bean);
        dao.close();
        return resp;
    }
    public int eliminarRegistro(BEProducto bean){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenPrimario(ds.getConeccion());
        resp = dao.eliminarRegistro(bean);
        dao.close();
        return resp;
    }
    public ArrayList<BEProducto> buscarReferencia(String ref){
        ArrayList<BEProducto> list;
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenPrimario(ds.getConeccion());
        list = dao.buscarReferencia(ref);
        dao.close();
        return list;
    }   
    public ArrayList<BEProducto> listar(){
        ArrayList<BEProducto> list;
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenPrimario(ds.getConeccion());
        list = dao.listar();
        dao.close();
        return list;
    }
    public BEProducto buscar(int id){
        BEProducto bean;
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenPrimario(ds.getConeccion());
        bean = dao.buscar(id);
        dao.close();
        return bean;
    }
    public void actualizarStockAlmacenEntregaRealizada(BEProducto bean){
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenPrimario(ds.getConeccion());
        dao.actualizarStockAlmacenEntregaRealizada(bean);
        dao.close();
    }
    public void actualizarStockAlmacenEntregaCancelada(BEProducto bean){
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenPrimario(ds.getConeccion());
        dao.actualizarStockAlmacenEntregaCancelada(bean);
        dao.close();
    }
    public int registrarEntrega(int user_id){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenPrimario(ds.getConeccion());
        resp = dao.registrarEntrega(user_id);
        dao.close();
        return resp;
    }
    public void registrar_detalle_Entrega(BEProducto bean,int cod_venta){
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenPrimario(ds.getConeccion());
        dao.registrar_detalle_Entrega(bean,cod_venta);
        dao.close();
    }
    public boolean consultaStockAlmacenVenta(int id_producto){
        boolean resp;
        ds = new DSConeccion(conf);
        dao =new DAOAlmacenPrimario(ds.getConeccion());
        resp = dao.consultaStockAlmacenVenta(id_producto);
        dao.close();
        return resp;
    }
}
