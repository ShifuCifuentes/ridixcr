package org.rx.systienda.dao;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.rx.systienda.bean.BEProducto;


public class DAOAlmacenVenta extends DAOAbstract<BEProducto> {     
    public DAOAlmacenVenta(Connection cn) {
       setConnection(cn);      
    }    
    @Override
    public int registrar(BEProducto bean) {              
        try {           
            setStoreProcedure("public.registrar_almacen_venta(?,?,?,?)");             
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
            setStoreProcedure("public.actualizar_almacen_venta(?,?)");            
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
            setStoreProcedure("public.eliminar_almacen_venta(?)");            
            setParameterInt(1,bean.getStock());
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
            setStoreProcedure("dbo.busqueda_avanzada_producto_venta(?)");            
            setParameterString(1, ref);
            commitc();
            while (existResult()){ 
              BEProducto bean = new BEProducto();
              bean.setId_producto(getDataInt(1));
              bean.setNom_comercial(getDataString(2));
              bean.setPresentacion(getDataString(3));
              bean.setFecha_vencimiento(getDataDate(4));
              bean.setDenominacion_generico(getDataString(5));
              bean.setEspecificacion(getDataString(6));
              bean.setPrecio_compra(getDataDouble(7));
              bean.setPorcentaje_utilidad(getDataDouble(8));
              bean.setId_proveedor(getDataInt(9)); 
              bean.setId_marca(getDataInt(10));
              bean.setId_categoria(getDataInt(11));
              bean.setNum_lote(getDataString(12));
              bean.setUnidad_medida(getDataString(13)); 
              bean.setStock(getDataInt(14));
              bean.setStock_fraccionario(getDataInt(15));
              bean.setStock_fraccionario_unitario(getDataInt(16));
              bean.setRef_categoria(getDataString(17));
              bean.setRef_marca(getDataString(18));
              bean.setRef_proveedor(getDataString(19));
              bean.setStock_fraccionario_referencia(getDataInt(20));
              bean.setStock_fraccionario_unitario_referencia(getDataInt(21));
              bean.setPrecio_venta((bean.getPrecio_compra()+(bean.getPrecio_compra()*(bean.getPorcentaje_utilidad()/100))));              
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
            setStoreProcedure("public.listar_almacen_venta()");            
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
    public BEProducto buscar(int codigo) {
        try { 
            clear();
            setStoreProcedure("public.buscar_almacen_venta(?)");            
            setParameterInt(1,codigo);
            commitc();
            BEProducto bean=null;
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
  }
    

