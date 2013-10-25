package org.sysconpat.rx.da;

import java.sql.Connection;
import java.util.ArrayList;
import org.rx.cr.dao.DAAbstract;
import org.sysconpat.rx.be.BEArea;
import org.sysconpat.rx.be.BEOficina;

public class DAOficina extends DAAbstract<BEOficina>{

    public DAOficina(Connection conn) {
        setConnection(conn);
    }
    @Override
    public int registrar(BEOficina bean) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try {
            setStoreProcedure("dbo.sp_ins_oficina");                     
            setParameterInt(bean.getId_local());         
            setParameterInt(bean.getId_area());         
            setParameterString(bean.getNombre_oficina());         
            setParameterString(bean.getSigla());   
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
        //</editor-fold>
    }

    @Override
    public int actualizarRegistro(BEOficina bean) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try {
            setStoreProcedure("dbo.sp_upd_oficina");
            setParameterInt(bean.getId_oficina());
            setParameterInt(bean.getId_local());         
            setParameterInt(bean.getId_area());         
            setParameterString(bean.getNombre_oficina());         
            setParameterString(bean.getSigla());   
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
        //</editor-fold>
    }

    @Override
    public int eliminarRegistro(BEOficina bean) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try {
            setStoreProcedure("dbo.sp_del_oficina");
            setParameterInt(bean.getId_oficina());
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
        //</editor-fold>
    }

    @Override
    public ArrayList<BEOficina> buscarReferencia(String referencia) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try { 
            clear();
            setStoreProcedure("dbo.sp_sel_oficina"); 
            setParameterString(referencia);
            commitc();
            while (existResult()) {
                BEOficina bean=new BEOficina();
                       bean.setId_oficina(getDataInt(1));                       
                       bean.setId_local(getDataInt(2));
                       bean.setId_area(getDataInt(3));
                       bean.setNombre_oficina(getDataString(4));
                       bean.setSigla(getDataString(5));                       
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
    public ArrayList<BEOficina> buscarReferencia(int id) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try { 
            clear();
            setStoreProcedure("dbo.sp_sel_oficina"); 
            setParameterInt(id);
            commitc();
            while (existResult()) {
                BEOficina bean=new BEOficina();
                       bean.setId_oficina(getDataInt(1));                       
                       bean.setId_local(getDataInt(2));
                       bean.setId_area(getDataInt(3));
                       bean.setNombre_oficina(getDataString(4));
                       bean.setSigla(getDataString(5));                       
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
    public ArrayList<BEOficina> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BEOficina buscar(int id) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try { 
            BEOficina bean=null;            
            setStoreProcedure("dbo.sp_sel_oficina"); 
            setParameterInt(id);
            commitc();
            while (existResult()) {
                       bean=new BEOficina();
                       bean.setId_oficina(getDataInt(1));                       
                       bean.setId_local(getDataInt(2));
                       bean.setId_area(getDataInt(3));
                       bean.setNombre_oficina(getDataString(4));
                       bean.setSigla(getDataString(5));   
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
