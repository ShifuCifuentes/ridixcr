
package org.rx.systienda.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.rx.systienda.bean.BECategoria;


public class DAOCategoria extends DAOAbstract<BECategoria>{       
    public DAOCategoria(Connection cn) {
       setConnection(cn);
    }
    @Override
    public int registrar(BECategoria bean) {                
        try {           
            setStoreProcedure("dbo.registrar_categoria(?,?)"); 
            setParameterString(1,bean.getCod_resumen_categoria());              
            setParameterString(2,bean.getDenominacion_categoria());              
            return Integer.parseInt(commit().toString());
        }catch (SQLException ex) {
            return rollback(ex);
        }finally{
            
        }
    }   
    @Override
    public int actualizarRegistro(BECategoria bean) {        
        try {
            setStoreProcedure("dbo.actualizar_categoria(?,?,?)");            
            setParameterInt(1,bean.getId_categoria());            
            setParameterString(2,bean.getCod_resumen_categoria());
            setParameterString(3,bean.getDenominacion_categoria());                                   
            return Integer.parseInt(commit().toString());
        }catch (SQLException ex) {            
            return rollback(ex);
        }finally{
            
        }
    }    
    @Override
    public ArrayList<BECategoria> buscarReferencia(String ref) {
        try { 
            clear();
            setStoreProcedure("dbo.busqueda_avanzada_categoria(?)");            
            setParameterString(1,ref);
            commitc();
            while (existResult()){ 
              BECategoria bean = new BECategoria();
              bean.setId_categoria(getDataInt(1));              
              bean.setDenominacion_categoria(getDataString(2));
              bean.setCod_resumen_categoria(getDataString(3));                                        
              add(bean);
            }
          return getLista();
        } catch (SQLException ex) {
            rollback(ex);
          return null;
        }finally{
            
        } 
    }
    @Deprecated @Override public int eliminarRegistro(BECategoria bean) {throw new UnsupportedOperationException("No Implementado..");}
    @Deprecated @Override public ArrayList<BECategoria> listar() {throw new UnsupportedOperationException("No Implementado..");}
    @Deprecated @Override public BECategoria buscar(int codigo) {throw new UnsupportedOperationException("No Implementado..");}
}
