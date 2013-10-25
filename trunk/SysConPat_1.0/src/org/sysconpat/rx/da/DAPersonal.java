package org.sysconpat.rx.da;

import java.sql.Connection;
import java.util.ArrayList;
import org.rx.cr.dao.DAAbstract;
import org.sysconpat.rx.be.BEPersonal;

public class DAPersonal extends DAAbstract<BEPersonal> {

    public DAPersonal(Connection conn) {
        setConnection(conn);
    }
    
    @Override
    public int registrar(BEPersonal bean) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try {
            setStoreProcedure("dbo.sp_ins_personal");
            setParameterString(bean.getNombres());         
            setParameterString(bean.getApellidos());         
            setParameterInt(bean.getTipo_documento());         
            setParameterString(bean.getNro_documento());         
            setParameterInt(bean.getModalidad());         
            setParameterInt(bean.getId_local());         
            setParameterInt(bean.getId_area());         
            setParameterInt(bean.getId_oficina());                               
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
        //</editor-fold>
    }

    @Override
    public int actualizarRegistro(BEPersonal bean) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try {
            setStoreProcedure("dbo.sp_upd_personal");
            setParameterInt(bean.getId_personal());         
            setParameterString(bean.getNombres());         
            setParameterString(bean.getApellidos());         
            setParameterInt(bean.getTipo_documento());         
            setParameterString(bean.getNro_documento());         
            setParameterInt(bean.getModalidad());         
            setParameterInt(bean.getId_local());         
            setParameterInt(bean.getId_area());         
            setParameterInt(bean.getId_oficina());                               
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
        //</editor-fold>
    }

    @Override
    public int eliminarRegistro(BEPersonal bean) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try {
            setStoreProcedure("dbo.sp_del_personal");
            setParameterInt(bean.getId_personal());   
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
        //</editor-fold>
    }

    @Override
    public ArrayList<BEPersonal> buscarReferencia(String referencia) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try { 
            clear();
            setStoreProcedure("dbo.sp_sel_personal"); 
            setParameterString(referencia);
            commitc();
            while (existResult()) {
                BEPersonal bean=new BEPersonal();
                          bean.setId_personal(getDataInt(1));
                          bean.setNombres(getDataString(2));
                          bean.setApellidos(getDataString(3));
                          bean.setTipo_documento(getDataInt(4));
                          bean.setNro_documento(getDataString(5));
                          bean.setModalidad(getDataInt(6));
                          bean.setId_local(getDataInt(7));
                          bean.setId_area(getDataInt(8));
                          bean.setId_oficina(getDataInt(9));
                add(bean);
            }
            close();
           return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;        
        }
        //</editor-fold>
    }
    public ArrayList<BEPersonal> buscarReferencia(int id) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try { 
            clear();
            setStoreProcedure("dbo.sp_sel_personal"); 
            setParameterInt(id);
            commitc();
            while (existResult()) {
                BEPersonal bean=new BEPersonal();
                          bean.setId_personal(getDataInt(1));
                          bean.setNombres(getDataString(2));
                          bean.setApellidos(getDataString(3));
                          bean.setTipo_documento(getDataInt(4));
                          bean.setNro_documento(getDataString(5));
                          bean.setModalidad(getDataInt(6));
                          bean.setId_local(getDataInt(7));
                          bean.setId_area(getDataInt(8));
                          bean.setId_oficina(getDataInt(9));
                add(bean);
            }
            close();
           return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;        
        }
        //</editor-fold>
    }

    @Override
    public ArrayList<BEPersonal> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BEPersonal buscar(int id) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try { 
            BEPersonal bean=null;
            setStoreProcedure("dbo.sp_sel_personal"); 
            setParameterInt(id);
            commitc();
            while (existResult()) {
                          bean=new BEPersonal();
                          bean.setId_personal(getDataInt(1));
                          bean.setNombres(getDataString(2));
                          bean.setApellidos(getDataString(3));
                          bean.setTipo_documento(getDataInt(4));
                          bean.setNro_documento(getDataString(5));
                          bean.setModalidad(getDataInt(6));
                          bean.setId_local(getDataInt(7));
                          bean.setId_area(getDataInt(8));
                          bean.setId_oficina(getDataInt(9));
            }
            close();
           return bean;
        } catch (Exception ex) {
            rollback(ex);
            return null;        
        }
       //</editor-fold>
    }
    
}
