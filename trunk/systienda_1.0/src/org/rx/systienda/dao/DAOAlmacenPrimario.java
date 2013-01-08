package org.rx.systienda.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.rx.systienda.bean.BEProducto;

public class DAOAlmacenPrimario extends DAOAbstract<BEProducto> {    
    public DAOAlmacenPrimario(Connection cn) {
       setConnection(cn);
    }    
    @Override
    public int registrar(BEProducto bean) {               
        try {           
            setStoreProcedure("dbo.registrar_almacen(?,?,?,?)"); 
            setParameterInt(1,bean.getId_producto());
            setParameterInt(2,bean.getStock());
            setParameterInt(3,bean.getStock_fraccionario());
            setParameterInt(4,bean.getStock_fraccionario_unitario());   
            return Integer.parseInt(commit().toString());
        }
        catch (SQLException ex) {
            return rollback(ex);
        }finally{
        }
    }
    @Override
    public int actualizarRegistro(BEProducto bean) {        
        try {
            setStoreProcedure("dbo.actualizar_almacen(?,?,?,?)");  
            setParameterInt(1,bean.getId_producto());
            setParameterInt(2,bean.getStock());
            setParameterInt(3,bean.getStock_fraccionario());
            setParameterInt(4,bean.getStock_fraccionario_unitario());
            return Integer.parseInt(commit().toString());
        }catch (SQLException ex) {
            return rollback(ex);
        }finally{
        }
    }
    @Override
    public int eliminarRegistro(BEProducto bean) {        
        try {            
            setStoreProcedure("dbo.eliminar_almacen(?)");            
            setParameterInt(1,bean.getId_producto());
            return Integer.parseInt(commit().toString());
        } catch (SQLException ex) {
            return rollback(ex);
        }finally{
            
        }
    }
    @Override
    public ArrayList<BEProducto> buscarReferencia(String ref) {
        try { 
            clear();
            setStoreProcedure("dbo.busqueda_avanzada_producto(?)");
            setParameterString(1,ref);
            commitc();            
            while (existResult()){ 
              BEProducto bean = new BEProducto();
              bean.setId_producto(getDataInt(1));
              bean.setNom_comercial(getDataString(2));
              bean.setPresentacion(getDataString(3));
              bean.setLaboratorio(getDataString(4));
              bean.setFecha_vencimiento(getDataDate(5));
              bean.setDenominacion_generico(getDataString(6));
              bean.setEspecificacion(getDataString(7));
              bean.setPrecio_compra(getDataDouble(8));
              bean.setPorcentaje_utilidad(getDataDouble(9));
              bean.setId_proveedor(getDataInt(10)); 
              bean.setId_marca(getDataInt(11));
              bean.setId_categoria(getDataInt(12));
              bean.setNum_lote(getDataString(13));
              bean.setUnidad_medida(getDataString(14)); 
              bean.setStock(getDataInt(15));
              bean.setStock_fraccionario(getDataInt(16));
              bean.setStock_fraccionario_unitario(getDataInt(17));
              bean.setRef_categoria(getDataString(18));
              bean.setRef_marca(getDataString(19));
              bean.setRef_proveedor(getDataString(20));
              bean.setRef_terapeutico(getDataString(21));
              add(bean);
            }
          return getLista();
        } catch (SQLException ex) {
            rollback(ex);
            return null;
        }finally{
        }    
    }    
    @Override
    public ArrayList<BEProducto> listar() {
        try { 
            clear();
            setStoreProcedure("dbo.listar_almacen()");            
            commitc();
            while (existResult()){ 
              BEProducto bean = new BEProducto();              
              bean.setId_producto(getDataInt(1));
              bean.setStock(getDataInt(2));
              bean.setStock_fraccionario(getDataInt(3));
              bean.setStock_fraccionario_unitario(getDataInt(4)); 
              add(bean);
            }
         return getLista();
        } catch (SQLException ex) {
            rollback(ex);
          return null;
        }finally{ 
        }
    }
    @Override
    public BEProducto buscar(int id) {
       try { 
            clear();
            setStoreProcedure("dbo.buscar_almacen(?)");            
            setParameterInt(1,id);
            commitc();
            BEProducto bean =null;
            while (existResult()){ 
              bean = new BEProducto();
              bean.setId_producto(getDataInt(1));
              bean.setStock(getDataInt(2));
              bean.setStock_fraccionario(getDataInt(3));
              bean.setStock_fraccionario_unitario(getDataInt(4));                
            }
         return bean;   
        } catch (SQLException ex) {
            rollback(ex);
          return null;
        }finally{
        }        
    }    
    public void actualizarStockAlmacenEntregaRealizada(BEProducto bean){                
        try {           
            setStoreProcedure("dbo.actualizar_stock_almacen_entrega_realizada(?,?)");          
            setParameterInt(1, bean.getId_producto());
            setParameterInt(2, bean.getStock());
            commit();        
        }
        catch (SQLException ex) {
            rollback(ex);    
        }finally{
            
        }    
    }
    public void actualizarStockAlmacenEntregaCancelada(BEProducto bean){             
        try {           
            setStoreProcedure("dbo.actualizar_stock_almacen_entrega_cancelada(?,?)");          
            setParameterInt(1, bean.getId_producto());
            setParameterInt(2, bean.getStock()); 
            commit();        
        }catch (SQLException ex) {
            rollback(ex);        
        }finally{
            
        }    
    }    
    public int registrarEntrega(int user_id) {               
        try {           
            setStoreProcedure("dbo.registrar_entrega(?)");             
            setParameterInt(1,user_id);   
            return Integer.parseInt(commit().toString());
        }
        catch (SQLException ex) {
            return rollback(ex);
        }finally{
            
        }
    }    
    public void registrar_detalle_Entrega(BEProducto bean,int cod_venta) {        
        try {           
            setStoreProcedure("dbo.registrar_detalle_entrega(?,?,?,?,?)");          
            setParameterInt(1,cod_venta);
            setParameterInt(2, bean.getId_producto());
            setParameterInt(3, bean.getStock());
            setParameterInt(4, bean.getStock_fraccionario());
            setParameterInt(5, bean.getStock_fraccionario_unitario());            
            commit();       
        }
        catch (SQLException ex) {
            rollback(ex);        
        }finally{
           
        }
    }  
    public boolean consultaStockAlmacenVenta(int id_producto) {               
        try {           
            setStoreProcedure("dbo.consulta_stock_almacen_venta(?)");             
            setParameterInt(1,id_producto);   
            return Boolean.parseBoolean(commit().toString());
        }
        catch (SQLException ex) {
            rollback(ex);  
            return false;
        }finally{
            
        }
    }
  }   
