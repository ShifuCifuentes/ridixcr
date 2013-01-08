package org.rx.systienda.bl;

import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.rx.systienda.bean.BEProducto;
import org.rx.systienda.dao.DAOCompra;

public class BLCompra {
    private DAOCompra dao;
    private DSConeccion ds;
    private Config conf;

    public BLCompra(Config conf) {
        this.conf=conf;
    }
    
    public int registrar(int id_cu){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOCompra(ds.getConeccion());
        resp = dao.registrar(id_cu);
        dao.close();
        return resp;
    }
    public void registrar_detalle(int id_com,BEProducto bean){
        ds = new DSConeccion(conf);
        dao =new DAOCompra(ds.getConeccion());
        dao.registrar_detalle(id_com,bean);
        dao.close();
    }
    public boolean consultaStockAlmacen(int id_producto){
        boolean resp;
        ds = new DSConeccion(conf);
        dao =new DAOCompra(ds.getConeccion());
        resp = dao.consultaStockAlmacen(id_producto);
        dao.close();
        return resp;
    }
}
