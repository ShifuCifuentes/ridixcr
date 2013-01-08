
package org.rx.systienda.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.rx.systienda.bean.BEMarca;

public class DAOMarca extends DAOAbstract<BEMarca>{    
    public DAOMarca(Connection cn) {
       setConnection(cn);
    }
    @Override
    public int registrar(BEMarca bean) {
        try {           
            setStoreProcedure("dbo.registrar_marca(?)");             
            setParameterString(1,bean.getDenominacion());              
            return Integer.parseInt(commit().toString());
        }catch (SQLException ex) {
           return rollback(ex);
        }finally{            
        }
    }
    public int registrarMarca(BEMarca bean) {
        try {           
            setStoreProcedure("dbo.registrar_marca(?)");             
            setParameterString(1,bean.getDenominacion());
            return Integer.parseInt(commit().toString());
        }catch (SQLException ex) {
            return rollback(ex);
        }finally{            
        }
    }
    @Override
    public int actualizarRegistro(BEMarca bean) {        
        try {
            setStoreProcedure("dbo.actualizar_marca(?,?)");            
            setParameterInt(1,bean.getId_marca());
            setParameterString(2,bean.getDenominacion());
            return Integer.parseInt(commit().toString());
        }catch (SQLException ex) {
            return rollback(ex);
        }finally{
        }
    }
    @Override
    public int eliminarRegistro(BEMarca bean) {        
        try {            
            setStoreProcedure("dbo.eliminar_marca(?)");            
            setParameterInt(1,bean.getId_marca());
            return Integer.parseInt(commit().toString());
        } catch (SQLException ex) {
            return rollback(ex);
        }finally{
        }
    }
    @Override
    public ArrayList<BEMarca> buscarReferencia(String ref) {
        try { 
            clear();
            setStoreProcedure("dbo.busqueda_avanzada_marca(?)");            
            setParameterString(1,ref);
            commitc();
            while (existResult()){ 
              BEMarca bean = new BEMarca();
              bean.setId_marca(getDataInt(1));
              bean.setDenominacion(getDataString(2));
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
    public ArrayList<BEMarca> listar() {
         try { 
            clear();
            setStoreProcedure("dbo.listar_marca()");            
            commitc();
            while (existResult()){ 
              BEMarca bean = new BEMarca();              
              bean.setId_marca(getDataInt(1));
              bean.setDenominacion(getDataString(2));
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
    public BEMarca buscar(int id) {
         try { 
            clear();
            setStoreProcedure("dbo.buscar_marca(?)");            
            setParameterInt(1,id);
            commitc();
            BEMarca bean = null;
            while (existResult()){ 
              bean = new BEMarca();
              bean.setId_marca(getDataInt(1));
              bean.setDenominacion(getDataString(2));              
            }
           return bean;
        } catch (SQLException ex) {
            rollback(ex);
          return null;
        }finally{    
        }
    }
}
