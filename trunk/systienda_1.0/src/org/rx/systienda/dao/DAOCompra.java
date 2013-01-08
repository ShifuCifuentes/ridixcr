package org.rx.systienda.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.rx.systienda.bean.BECompra;
import org.rx.systienda.bean.BEProducto;


public class DAOCompra extends DAOAbstract<BECompra> {  
    public DAOCompra(Connection cn) {
       setConnection(cn);
    }    
    public int registrar(int id_cu) {                
        try {           
            setStoreProcedure("dbo.registrar_compra(?)");
            setParameterInt(1,id_cu);
            return Integer.parseInt(commit().toString());
        }catch (SQLException ex) {
            return rollback(ex);
        }finally{            
        }
    }    
    public void registrar_detalle(int id_com,BEProducto bean) {                
        try {           
            setStoreProcedure("dbo.registrar_detalle_compra(?,?,?,?,?,?)"); 
            setParameterInt(1,id_com);
            setParameterInt(2,bean.getId_producto());
            setParameterInt(3,bean.getStock());
            setParameterInt(4,bean.getStock_fraccionario());
            setParameterInt(5,bean.getStock_fraccionario_unitario());  
            setParameterDate(6,bean.getFecha_vencimiento());
            commit();       
        }catch (SQLException ex) {
            rollback(ex);     
        }finally{
        }
    }
    public boolean consultaStockAlmacen(int id_producto) {               
        try {           
            setStoreProcedure("dbo.consulta_stock_almacen(?)");             
            setParameterInt(1,id_producto);   
            return Boolean.parseBoolean(commit().toString());
        }
        catch (SQLException ex) {
            rollback(ex); 
            return false;
        }finally{            
        }
    }
    @Deprecated @Override public int registrar(BECompra obj) {throw new UnsupportedOperationException("No Implementado..");} 
    @Deprecated @Override public int actualizarRegistro(BECompra obj) {throw new UnsupportedOperationException("No Implementado..");}
    @Deprecated @Override public int eliminarRegistro(BECompra obj) {throw new UnsupportedOperationException("No Implementado..");}
    @Deprecated @Override public ArrayList<BECompra> buscarReferencia(String ref) {throw new UnsupportedOperationException("No Implementado..");}   
    @Deprecated @Override public ArrayList<BECompra> listar() {throw new UnsupportedOperationException("No Implementado..");}
    @Deprecated @Override public BECompra buscar(int codigo) {throw new UnsupportedOperationException("No Implementado..");}   
}
