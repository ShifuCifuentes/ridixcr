package org.rx.systienda.dao;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.rx.systienda.bean.BEProducto;

public class DAOProducto extends DAOAbstract<BEProducto> {   
    public DAOProducto(Connection cn) {
       setConnection(cn);
    }
    @Override
    public int registrar(BEProducto bean) {
        try {           
            setStoreProcedure("dbo.registrar_producto(?,?,?,?,?,?,?,?,?,?,?,?)");             
            setParameterString(1,bean.getNom_comercial());
            setParameterString(2,bean.getPresentacion());
            setParameterDate(3,bean.getFecha_vencimiento());
            setParameterString(4,bean.getDenominacion_generico());
            setParameterString(5,bean.getEspecificacion());
            setParameterDouble(6,bean.getPrecio_compra());
            setParameterDouble(7,bean.getPorcentaje_utilidad());            
            setParameterInt(8,bean.getId_proveedor());
            setParameterInt(9,bean.getId_marca());
            setParameterInt(10,bean.getId_categoria());
            setParameterString(11,bean.getNum_lote());
            setParameterString(12,bean.getUnidad_medida());
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
            setStoreProcedure("dbo.actualizar_producto(?,?,?,?,?,?,?,?,?,?,?,?,?)");            
            setParameterInt(1,bean.getId_producto());
            setParameterString(2,bean.getNom_comercial());
            setParameterString(3,bean.getPresentacion());
            setParameterDate(4,bean.getFecha_vencimiento());
            setParameterString(5,bean.getDenominacion_generico());
            setParameterString(6,bean.getEspecificacion());
            setParameterDouble(7,bean.getPrecio_compra());
            setParameterDouble(8,bean.getPorcentaje_utilidad());
            setParameterInt(9,bean.getId_proveedor());
            setParameterInt(10,bean.getId_marca());
            setParameterInt(11,bean.getId_categoria());
            setParameterString(12,bean.getNum_lote());
            setParameterString(13,bean.getUnidad_medida());                      
            return Integer.parseInt(commit().toString());
        }catch (SQLException ex) {
           return rollback(ex);
        }finally{            
        } 
    }
    @Override
    public int eliminarRegistro(BEProducto bean) {        
        try {            
            setStoreProcedure("dbo.eliminar_producto(?)");            
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
              bean.setFecha_registro(getDataDate(20));
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
            setStoreProcedure("dbo.listar_producto()");            
            commitc();
            while (existResult()){ 
              BEProducto bean = new BEProducto();
              bean.setId_producto(getDataInt(1));
              bean.setId_proveedor(getDataInt(2)); 
              bean.setId_marca(getDataInt(3));
              bean.setId_categoria(getDataInt(4));
              bean.setNom_comercial(getDataString(5));  
              bean.setPresentacion(getDataString(6));
              bean.setLaboratorio(getDataString(7));
              bean.setFecha_vencimiento(getDataDate(8));
              bean.setDenominacion_generico(getDataString(9));
              bean.setEspecificacion(getDataString(10));
              bean.setPrecio_compra(getDataDouble(11));
              bean.setPorcentaje_utilidad(getDataDouble(12));
              bean.setNum_lote(getDataString(13));
              bean.setUnidad_medida(getDataString(14));                 
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
            setStoreProcedure("dbo.buscar_fabricante(?)");            
            setParameterInt(1,codigo);
            commitc();
            BEProducto bean=null;
            while (existResult()){ 
              bean = new BEProducto();
              bean.setId_proveedor(getDataInt(1));
              bean.setId_producto(getDataInt(2));
              bean.setDenominacion_generico(getDataString(3));
              bean.setPresentacion(getDataString(4));
              bean.setPrecio_compra(getDataDouble(5));
              bean.setPorcentaje_utilidad(getDataDouble(6));
              bean.setFecha_registro(getDataDate(7));
              bean.setNum_lote(getDataString(8));
              bean.setCod_referencia(getDataString(9));                
            }
          return bean;   
        } catch (SQLException ex) {
            rollback(ex);
            return null;
        }finally{ 
        } 
    }   
}
