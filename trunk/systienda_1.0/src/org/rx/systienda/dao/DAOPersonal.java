package org.rx.systienda.dao;




import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.rx.systienda.bean.BEPersonal;


public class DAOPersonal extends DAOAbstract<BEPersonal> {   
    public DAOPersonal(Connection cn) {
       setConnection(cn);
    }
    @Override
    public int registrar(BEPersonal bean) {           
        try {           
            setStoreProcedure("dbo.registrar_empleado(?,?,?,?,?,?)");             
            setParameterString(1,bean.getNombres());
            setParameterString(2,bean.getAp_paterno());
            setParameterString(3,bean.getAp_maternno());   
            setParameterString(4,bean.getDireccion());   
            setParameterString(5,bean.getCorreo());   
            setParameterString(6,bean.getTelefono());   
            return Integer.parseInt(commit().toString());
        }
        catch (SQLException ex) {
            return rollback(ex);
        }finally{           
        }
    } 
    @Override
    public int actualizarRegistro(BEPersonal bean) {
        try {
            setStoreProcedure("dbo.actualizar_personal(?,?,?,?,?,?,?)");            
            setParameterInt(1,bean.getCodigo_empleado());
            setParameterString(2,bean.getNombres());
            setParameterString(3,bean.getAp_paterno());
            setParameterString(4,bean.getAp_maternno());
            setParameterString(5,bean.getDireccion());
            setParameterString(6,bean.getCorreo());
            setParameterString(7,bean.getTelefono());
            return Integer.parseInt(commit().toString());
        }catch (SQLException ex) {
           return rollback(ex);
        }finally{
        }
    }
    @Override
    public int eliminarRegistro(BEPersonal bean) {        
        try {            
            setStoreProcedure("dbo.eliminar_empleado(?)");            
            setParameterInt(1,bean.getCodigo_empleado());
            return Integer.parseInt(commit().toString());
        } catch (SQLException ex) {
            return rollback(ex);
        }finally{           
        }
    }
    @Override
    public ArrayList<BEPersonal> buscarReferencia(String ref) {
        try { 
            clear();
            setStoreProcedure("dbo.busqueda_avanzada_personal(?)");            
            setParameterString(1,ref);
            commitc();
            while (existResult()){             
              BEPersonal bean = new BEPersonal();
              bean.setId_empleado(getDataInt(1));
              bean.setNombres(getDataString(2));
              bean.setAp_paterno(getDataString(3));
              bean.setAp_maternno(getDataString(4));
              bean.setDireccion(getDataString(5));
              bean.setCorreo(getDataString(6));
              bean.setTelefono(getDataString(7));
              bean.setId_cuenta(getDataInt(8));
              bean.setNombre_cuenta(getDataString(9));
              bean.setClave_cuenta(getDataString(10));
              bean.setRol(getDataString(11));              
              bean.setEstado(getDataBoolean(12));
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
    public ArrayList<BEPersonal> listar() {
         try { 
            clear();
            setStoreProcedure("dbo.listar_fabricante()");            
            commitc();
            while (existResult()){ 
              BEPersonal bean = new BEPersonal();              
              bean.setId_empleado(getDataInt(1));
              bean.setNombres(getDataString(2));
              bean.setAp_paterno(getDataString(3));
              bean.setAp_maternno(getDataString(4));
              bean.setDireccion(getDataString(5));
              bean.setCorreo(getDataString(6));
              bean.setTelefono(getDataString(7));               
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
    public BEPersonal buscar(int id) {
         try { 
            setStoreProcedure("dbo.buscar_fabricante(?)");            
            setParameterInt(1,id);
            commitc();
            BEPersonal bean=null;
            while (existResult()){ 
              bean = new BEPersonal();
              bean.setId_empleado(getDataInt(1));
              bean.setNombres(getDataString(2));
              bean.setAp_paterno(getDataString(3));
              bean.setAp_maternno(getDataString(4));
              bean.setDireccion(getDataString(5));
              bean.setCorreo(getDataString(6));
              bean.setTelefono(getDataString(7));
            }
          return bean; 
        } catch (SQLException ex) {
            rollback(ex);
            return null;
        }finally{       
        }     
    }
  }    
