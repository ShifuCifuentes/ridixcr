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
              bean.setStock_fraccionario_referencia(getDataInt(21));
              bean.setStock_fraccionario_unitario_referencia(getDataInt(22));
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
    

