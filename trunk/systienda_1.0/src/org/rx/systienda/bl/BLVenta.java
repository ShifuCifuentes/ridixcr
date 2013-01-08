package org.rx.systienda.bl;

import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.rx.systienda.bean.BEProducto;
import org.rx.systienda.dao.DAOVenta;

public class BLVenta {
    private DAOVenta dao;
    private DSConeccion ds;
    private Config conf;    
    public BLVenta(Config conf) {
        this.conf=conf;
    }
    public int registrar(int id_cu){
        int resp;
        ds = new DSConeccion(conf);
        dao =new DAOVenta(ds.getConeccion());
        resp = dao.registrar(id_cu);
        dao.close();
        return resp;
    }
    public void registrar_detalle_venta(BEProducto bean,int cod_venta){
        ds = new DSConeccion(conf);
        dao =new DAOVenta(ds.getConeccion());
        dao.registrar_detalle_venta(bean, cod_venta);
        dao.close();
    }
    public void actualizarStockAlmacenVentaRealizada(BEProducto bean){
        ds = new DSConeccion(conf);
        dao =new DAOVenta(ds.getConeccion());
        dao.actualizarStockAlmacenVentaRealizada(bean);
        dao.close();
    }
    public void actualizarStockAlmacenVentaCancelada(BEProducto bean){
        ds = new DSConeccion(conf);
        dao =new DAOVenta(ds.getConeccion());
        dao.actualizarStockAlmacenVentaCancelada(bean);
        dao.close();
    }
    public void reEstructurarStockAlmacenVenta(int id_producto,int tipo_compra,int stock){
        ds = new DSConeccion(conf);
        dao =new DAOVenta(ds.getConeccion());
        dao.reEstructurarStockAlmacenVenta(id_producto, tipo_compra, stock);
        dao.close();
    }
}
