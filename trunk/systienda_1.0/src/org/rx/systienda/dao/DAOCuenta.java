package org.rx.systienda.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.rx.systienda.bean.BECuenta;

public class DAOCuenta extends DAOAbstract<BECuenta>{
    public DAOCuenta(Connection cn) {
       setConnection(cn);
    }    
    @Override
    public int registrar(BECuenta bean) {
        try {           
            setStoreProcedure("dbo.registrar_usuario(?,?,?,?,?)");             
            setParameterInt(1,bean.getCodigo_empleado());
            setParameterString(2,bean.getNombre_cuenta());
            setParameterString(3,bean.getClave_cuenta());   
            setParameterString(4,bean.getRol());   
            setParameterBoolean(5,bean.getEstado()); 
            return Integer.parseInt(commit().toString());
        }catch (SQLException ex) {
            return rollback(ex);
        }finally{
            
        }
    }
    @Override
    public int actualizarRegistro(BECuenta bean) {        
        try {
            setStoreProcedure("dbo.actualizar_usuario(?,?,?,?,?,?)");            
            setParameterInt(1,bean.getId_cuenta());
            setParameterInt(2,bean.getCodigo_empleado());
            setParameterString(3,bean.getNombre_cuenta());
            setParameterString(4,bean.getClave_cuenta());
            setParameterString(5,bean.getRol());
            setParameterBoolean(6,bean.getEstado());             
            return Integer.parseInt(commit().toString());
        }catch (SQLException ex) {
            return rollback(ex);
        }finally{
            
        } 
    }
    @Override
    public int eliminarRegistro(BECuenta bean) {        
        try {            
            setStoreProcedure("dbo.eliminar_cuenta(?)");            
            setParameterInt(1,bean.getId_cuenta());
            return Integer.parseInt(commit().toString());
        } catch (SQLException ex) {
            return rollback(ex);
        }finally{
            
        }
    }
    @Override
    public ArrayList<BECuenta> buscarReferencia(String ref) {
        try { 
            clear();
            setStoreProcedure("dbo.busqueda_avanzada_cuenta(?)");            
            setParameterString(1,ref);
            commitc();
            while (existResult()){ 
              BECuenta bean = new BECuenta();
              bean.setId_cuenta(getDataInt(1));
              bean.setId_empleado(getDataInt(2));
              bean.setNombre_cuenta(getDataString(3));
              bean.setClave_cuenta(getDataString(4));
              bean.setRol(getDataString(5));
              bean.setEstado(getDataBoolean(6));
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
    public ArrayList<BECuenta> listar() {
        try { 
            clear();
            setStoreProcedure("dbo.listar_cuenta()");            
            commitc();
            while (existResult()){ 
              BECuenta bean = new BECuenta();              
              bean.setId_cuenta(getDataInt(1));
              bean.setId_empleado(getDataInt(2));
              bean.setNombre_cuenta(getDataString(3));
              bean.setClave_cuenta(getDataString(4));
              bean.setRol(getDataString(5));  
              bean.setEstado(getDataBoolean(6));
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
    public BECuenta buscar(int codigo) {
        try { 
            clear();
            setStoreProcedure("dbo.buscar_fabricante(?)");
            setParameterInt(1,codigo);
            commitc();
            BECuenta bean=null;
            while (existResult()){ 
              bean = new BECuenta();
              bean.setId_cuenta(getDataInt(1));
              bean.setId_empleado(getDataInt(2));
              bean.setNombre_cuenta(getDataString(3));
              bean.setClave_cuenta(getDataString(4));
              bean.setRol(getDataString(5)); 
              bean.setEstado(getDataBoolean(6));              
            }
           return bean;            
        } catch (SQLException ex) {
            rollback(ex);
            return null;
        }finally{ 
        }
    }    
    public boolean consultaExistenciaAdministradores(){
        try {             
            clear();
            setStoreProcedure("dbo.consulta_existencia_administradores()");                          
            return Boolean.parseBoolean(commit().toString());            
        } catch (SQLException ex) {            
            rollback(ex);
            return false;
        }finally{            
            
        }   
    }    
    public boolean buscarExistenciaUsuario(String ref){
        try {
            setStoreProcedure("dbo.buscar_existencia_cuenta(?)");            
            setParameterString(1,ref);
            return Boolean.parseBoolean(commit().toString()); 
        } catch (SQLException ex) {            
            rollback(ex);
            return false;
        }finally{            
            
        }   
    }
    public BECuenta validarLoguinPersonal(String ref,String ref2){
       try {            
            setStoreProcedure("dbo.buscar_cuenta(?,?)");                        
            setParameterString(1, ref);
            setParameterString(2, ref2);
            commitc();
            BECuenta bean=null;
            while (existResult()){ 
              bean = new BECuenta();   
              bean.setId_cuenta(getDataInt(1));              
              bean.setRol(getDataString(2)); 
              bean.setEstado(getDataBoolean(3));               
            }
            return bean;            
        } catch (SQLException ex) {
            rollback(ex);
            return null;
        }finally{ 
        }       
    }
 }
    
