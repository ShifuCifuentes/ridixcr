package org.sysconpat.rx.da;

import java.sql.Connection;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.sysconpat.rx.be.BEContenedor;
import org.sysconpat.rx.be.BERolUsuario;
import org.sysconpat.rx.be.BEUsuario;

public class DARolUsuario extends DAOAbstract<BERolUsuario> {

    public DARolUsuario(Connection conn) {
        setConnection(conn);
    }
    
    @Override
    public int registrar(BERolUsuario tipo) throws Exception {
        try {
            setStoreProcedure("dbo.registrar_rol_usuario");
            setParameterInt(tipo.getId_usuario());         
            setParameterString(tipo.getNombre_Modulo());  
            setParameterInt(tipo.getId_modulo());      
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }

    @Override
    public int actualizarRegistro(BERolUsuario tipo) throws Exception {
       try {
            setStoreProcedure("dbo.actualizar_rol_usuario");
            setParameterInt(tipo.getId_rol());
            setParameterInt(tipo.getId_usuario());
            setParameterString(tipo.getNombre_Modulo());   
            setParameterInt(tipo.getId_modulo()); 
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }

    @Override
    public int eliminarRegistro(BERolUsuario tipo) throws Exception {
        try {
            setStoreProcedure("dbo.eliminar_rol_usuario");
            setParameterInt(tipo.getId_usuario());    
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }

    public ArrayList<BERolUsuario> listar(int id) throws Exception {
        try { 
            clear();
            setStoreProcedure("dbo.listar_roles_usuario"); 
            setParameterInt(id);
            commitc();
            while (existResult()) {
                BERolUsuario bean=new BERolUsuario();
                          bean.setId_rol(getDataInt(1));
                          bean.setId_usuario(getDataInt(2));                
                          bean.setNombre_Modulo(getDataString(3));  
                          bean.setId_modulo(getDataInt(4));        
                add(bean);
            }
            close();
           return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;        
        }
    }
    
    @Deprecated @Override public ArrayList<BERolUsuario> buscarReferencia(String string) {throw  null;}
    @Deprecated @Override public ArrayList<BERolUsuario> listar() {throw  null;}

    @Override
    public BERolUsuario buscar(int i) throws Exception {
        try {         
            BERolUsuario bean=null;
            setStoreProcedure("dbo.buscar_rol_usuario"); 
            setParameterInt(i);
            commitc();
            while (existResult()) {
                bean=new BERolUsuario();                               
                bean.setId_rol(getDataInt(1));
                bean.setId_usuario(getDataInt(2));                
                bean.setNombre_Modulo(getDataString(3)); 
                bean.setId_modulo(getDataInt(4));   
                add(bean);
            }
            close();
           return bean;
        } catch (Exception ex) {
            rollback(ex);
            return null;        
        }
    }

    public ArrayList<BEContenedor> listar_modulos_usuario(int id) throws Exception {
        try { 
            clear();
            setStoreProcedure("dbo.listar_roles_usuario");   
            setParameterInt(id);
            commitc();
            while (existResult()) {
                BEContenedor beanc  = new BEContenedor();
                beanc.setId_contenedor(getDataInt(4));
                beanc.setNombre(getDataString(3));    
                add(beanc);
            }
            close();
           return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;        
        }
    }
     public int eliminarRolesUsuario(BEUsuario bean) throws Exception {
        try {
            setStoreProcedure("dbo.eliminar_roles_usuario");
            setParameterInt(bean.getId_usuario());    
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }
}
