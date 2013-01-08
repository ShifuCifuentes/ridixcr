package org.rx.systienda.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.rx.systienda.bean.BEProveedor;


public class DAOProveedor extends DAOAbstract<BEProveedor> {
    public DAOProveedor(Connection cn) {
       setConnection(cn);
    }
    @Override
    public int registrar(BEProveedor bean) {           
        try {           
            setStoreProcedure("dbo.registrar_fabricante(?,?,?,?)");             
            setParameterString(1,bean.getRazon_social());
            setParameterString(2,bean.getRepresentante());
            setParameterString(3,bean.getDireccion());
            setParameterString(4,bean.getTelefono());   
            return Integer.parseInt(commit().toString());
       }catch (SQLException ex) {
            return rollback(ex);
        }finally{
        }
    }
    @Override
    public int actualizarRegistro(BEProveedor bean) {       
        try {
            setStoreProcedure("dbo.actualizar_fabricante(?,?,?,?,?)");            
            setParameterInt(1,bean.getId_proveedor());
            setParameterString(2,bean.getRazon_social());
            setParameterString(3,bean.getRepresentante());
            setParameterString(4,bean.getDireccion());
            setParameterString(5,bean.getTelefono());
            return Integer.parseInt(commit().toString());
        }catch (SQLException ex) {
            return rollback(ex);
        }finally{
        }       
    }
    @Override
    public int eliminarRegistro(BEProveedor bean) {
        try {            
            setStoreProcedure("dbo.eliminar_fabricante(?)");            
            setParameterInt(1,bean.getId_proveedor());
            return Integer.parseInt(commit().toString());
        } catch (SQLException ex) {
            return rollback(ex);
        }finally{
        }
    }
    @Override
    public ArrayList<BEProveedor> buscarReferencia(String ref) {
        try { 
            clear();
            setStoreProcedure("dbo.busqueda_avanzada_proveedor(?)");            
            setParameterString(1,ref);
            commitc();
            while (existResult()){ 
              BEProveedor bean = new BEProveedor();
              bean.setId_proveedor(getDataInt(1));
              bean.setRazon_social(getDataString(2));
              bean.setRepresentante(getDataString(3));
              bean.setDireccion(getDataString(4));
              bean.setTelefono(getDataString(5));
              bean.setFecha_registro(getDataDate(6));
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
    public ArrayList<BEProveedor> listar() {
       try { 
            clear();
            setStoreProcedure("dbo.listar_fabricante()");            
            commitc();
            while (existResult()){ 
              BEProveedor bean = new BEProveedor();              
              bean.setId_proveedor(getDataInt(1));
              bean.setRazon_social(getDataString(2));
              bean.setRepresentante(getDataString(3));
              bean.setDireccion(getDataString(4));
              bean.setTelefono(getDataString(5));
              bean.setFecha_registro(getDataDate(6));  
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
    public BEProveedor buscar(int codigo) {
       try { 
            clear();
            setStoreProcedure("dbo.buscar_proveedor(?)");            
            setParameterInt(1,codigo);
            commitc();
            BEProveedor bean =null;
            while (existResult()){ 
              bean = new BEProveedor();
              bean.setId_proveedor(getDataInt(1));
              bean.setRazon_social(getDataString(2));
              bean.setRepresentante(getDataString(3));
              bean.setDireccion(getDataString(4));
              bean.setTelefono(getDataString(5));
              bean.setFecha_registro(getDataDate(6));  
            }
           return bean; 
        } catch (SQLException ex) {
            rollback(ex);
           return null;
        }finally{
        }        
    }    
}
