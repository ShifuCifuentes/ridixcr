package org.rx.systienda.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.systienda.bean.BEProducto;
import org.rx.systienda.bean.BEVenta;

public class DAOVenta extends DAOAbstract<BEVenta> {
    public DAOVenta(Connection cn) {
       setConnection(cn);
    }    
    public int registrar(int id_cu) {           
        try {           
            setStoreProcedure("dbo.registrar_venta(?)");  
            setParameterInt(1,id_cu);
            return Integer.parseInt(commit().toString());
        }catch (SQLException ex) {
            return rollback(ex);
        }finally{
        }
    } 
    public void registrar_detalle_venta(BEProducto bean,int cod_venta) {        
        try {           
            setStoreProcedure("dbo.registrar_detalle_venta(?,?,?,?,?)");          
            setParameterInt(1,cod_venta);
            setParameterInt(2, bean.getId_producto());
            setParameterInt(3, bean.getStock());
            setParameterInt(4, bean.getTip_compra());
            setParameterDouble(5,Double.parseDouble(numberFormat( bean.getPrecio_venta(),"#.#").replace(",",".")));
            commit();        
        }catch (SQLException ex) {
            rollback(ex);         
        }finally{
        }
    }               
    public void actualizarStockAlmacenVentaRealizada(BEProducto bean){             
        try {           
            setStoreProcedure("dbo.actualizar_stock_almacen_venta_realizada(?,?,?)");          
            setParameterInt(1, bean.getId_producto());
            setParameterInt(2, bean.getTip_compra());
            setParameterInt(3, bean.getStock());
            commit();        
        }catch (SQLException ex) {
            rollback(ex);       
        }finally{
        }    
    }
    public void actualizarStockAlmacenVentaCancelada(BEProducto bean){               
        try {           
            setStoreProcedure("dbo.actualizar_stock_almacen_venta_cancelada(?,?,?)");          
            setParameterInt(1, bean.getId_producto());
            setParameterInt(2, bean.getTip_compra());
            setParameterInt(3, bean.getStock()); 
            commit();      
        }catch (SQLException ex) {
            rollback(ex);       
        }finally{
        }    
    }   
    public void reEstructurarStockAlmacenVenta(int id_producto,int tipo_compra,int stock) {               
        try {           
            setStoreProcedure("dbo.reestructura_stock_almacen_venta(?,?,?)");
            setParameterInt(1,id_producto);
            setParameterInt(2,tipo_compra);
            setParameterInt(3,stock);
            commit();
        }catch (SQLException ex) {
           rollback(ex);            
        }finally{            
        }
    }
    @Deprecated @Override public int registrar(BEVenta bean) {throw new UnsupportedOperationException("No Implementado..");} 
    @Deprecated @Override public int actualizarRegistro(BEVenta obj) {throw new UnsupportedOperationException("No Implementado..");}
    @Deprecated @Override public int eliminarRegistro(BEVenta obj) {throw new UnsupportedOperationException("No Implementado..");}
    @Deprecated @Override public ArrayList<BEVenta> buscarReferencia(String ref) {throw new UnsupportedOperationException("No Implementado..");}
    @Deprecated @Override public ArrayList<BEVenta> listar() {throw new UnsupportedOperationException("No Implementado..");}
    @Deprecated @Override public BEVenta buscar(int codigo) {throw new UnsupportedOperationException("No Implementado..");}     
}
