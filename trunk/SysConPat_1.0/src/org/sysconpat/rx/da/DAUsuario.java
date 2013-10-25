package org.sysconpat.rx.da;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.rx.cr.dao.DAAbstract;
import org.sysconpat.rx.be.BEUsuario;

public class DAUsuario extends DAAbstract<BEUsuario> {

    public DAUsuario(Connection conn) {
        setConnection(conn);
    }
    
    @Override
    public int registrar(BEUsuario tipo) throws Exception {
        try {
            setStoreProcedure("dbo.registrar_usuario");
            setParameterString(tipo.getNombres());         
            setParameterString(tipo.getApellido_paterno());         
            setParameterString(tipo.getApellido_materno());         
            setParameterString(tipo.getNro_documento());         
            setParameterString(tipo.getGenero());         
            setParameterString(tipo.getNombre_usuario());         
            setParameterString(tipo.getClave_usuario());         
            setParameterBoolean(tipo.getEstado()); 
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }

    @Override
    public int actualizarRegistro(BEUsuario tipo) throws Exception {
        try {
            setStoreProcedure("dbo.actualizar_usuario");
            setParameterInt(tipo.getId_usuario());
            setParameterString(tipo.getNombres());
            setParameterString(tipo.getApellido_paterno());
            setParameterString(tipo.getApellido_materno());
            setParameterString(tipo.getNombre_usuario());
            setParameterString(tipo.getClave_usuario());
            setParameterString(tipo.getNro_documento());
            setParameterString(tipo.getGenero());            
            setParameterBoolean(tipo.getEstado());
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }

    @Override
    public int eliminarRegistro(BEUsuario tipo) throws Exception {
        try {
            setStoreProcedure("dbo.eliminar_usuario");
            setParameterInt(tipo.getId_usuario());    
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }

    @Override
    public ArrayList<BEUsuario> buscarReferencia(String string) throws Exception {
        try { 
            clear();
            setStoreProcedure("dbo.buscar_referencia_usuario"); 
            setParameterString(string);
            commitc();
            while (existResult()) {
                BEUsuario bean=new BEUsuario();
                          bean.setId_usuario(getDataInt(1));                
                          bean.setNombres(getDataString(2));
                          bean.setApellido_paterno(getDataString(3));
                          bean.setApellido_materno(getDataString(4));
                          bean.setNro_documento(getDataString(5));
                          bean.setGenero(getDataString(6));
                          bean.setNombre_usuario(getDataString(7));
                          bean.setClave_usuario(getDataString(8));
                          bean.setEstado(getDataBoolean(9));  
                add(bean);
            }
            close();
           return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;        
        }
    }

    @Override
    public ArrayList<BEUsuario> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BEUsuario buscar(int i) throws Exception {        
        try {         
            BEUsuario bean=null;
            setStoreProcedure("dbo.buscar_usuario"); 
            setParameterInt(i);
            commitc();
            while (existResult()) {
                bean=new BEUsuario();
                bean.setId_usuario(getDataInt(1));                
                bean.setNombres(getDataString(2));
                bean.setApellido_paterno(getDataString(3));
                bean.setApellido_materno(getDataString(4));
                bean.setNro_documento(getDataString(5));
                bean.setGenero(getDataString(6));
                bean.setNombre_usuario(getDataString(7));
                bean.setClave_usuario(getDataString(8));
                bean.setEstado(getDataBoolean(9));  
                add(bean);
            }
            close();
           return bean;
        } catch (Exception ex) {
            rollback(ex);
            return null;        
        }
    }

    @Override
    public BEUsuario autenticarUsuario(String user, String password) {
        BEUsuario bean=null;
        try {            
            setStoreProcedure("dbo.autenticar_usuario"); 
            setParameterString(user);
            setParameterString(password);
            commitc();
            while (existResult()) {
                bean=new BEUsuario();
                bean.setId_usuario(getDataInt(1));                
                bean.setNombres(getDataString(2));
                bean.setApellido_paterno(getDataString(3));
                bean.setApellido_materno(getDataString(4));
                bean.setNro_documento(getDataString(5));
                bean.setGenero(getDataString(6));
                bean.setNombre_usuario(getDataString(7));
                bean.setClave_usuario(getDataString(8));
                bean.setEstado(getDataBoolean(9));  
            }
            close();
           return bean;
        } catch (Exception ex) {
            try {
                rollback(ex);
            } catch (Exception ex1) {
                Logger.getLogger(DAUsuario.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return null;        
        }
    }
}
