package org.sysconpat.rx.da;

import java.sql.Connection;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.sysconpat.rx.SysConPat;
import org.sysconpat.rx.be.BEArea;
import static org.rx.cr.util.Utilitarios.*;

public class DAArea extends DAOAbstract<BEArea> {
    
    public DAArea(Connection conn) {
        setConnection(conn);
    }
    
    @SysConPat(author=RidixCr)
    @Override
    public int registrar(BEArea bean) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try {
            setStoreProcedure("dbo.sp_ins_area");
            setParameterInt(bean.getId_local());         
            setParameterString(bean.getNombre_area());         
            setParameterString(bean.getSigla());   
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
        //</editor-fold>
    }
    @SysConPat(author=RidixCr)
    @Override
    public int actualizarRegistro(BEArea bean) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try {
            setStoreProcedure("dbo.sp_upd_area");
            setParameterInt(bean.getId_area());         
            setParameterInt(bean.getId_local());         
            setParameterString(bean.getNombre_area());         
            setParameterString(bean.getSigla());   
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
        //</editor-fold>
    }
    @SysConPat(author=RidixCr)
    @Override
    public int eliminarRegistro(BEArea bean) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try {
            setStoreProcedure("dbo.sp_del_area");
            setParameterInt(bean.getId_area()); 
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
        //</editor-fold>
    }
    @SysConPat(author=RidixCr)
    @Override
    public ArrayList<BEArea> buscarReferencia(String referencia) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try { 
            clear();
            setStoreProcedure("dbo.sp_sel_area"); 
            setParameterString(referencia);
            commitc();
            while (existResult()) {
                BEArea bean=new BEArea();
                       bean.setId_area(getDataInt(1));
                       bean.setId_local(getDataInt(2));
                       bean.setNombre_area(getDataString(3));
                       bean.setSigla(getDataString(4));
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
    @SysConPat(author=RidixCr)
    public ArrayList<BEArea> buscarReferencia(int id) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try { 
            clear();
            setStoreProcedure("dbo.sp_sel_area"); 
            setParameterInt(id);
            commitc();
            while (existResult()) {
                BEArea bean=new BEArea();
                       bean.setId_area(getDataInt(1));
                       bean.setId_local(getDataInt(2));
                       bean.setNombre_area(getDataString(3));
                       bean.setSigla(getDataString(4));
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
    @SysConPat(author=RidixCr)
    @Override
    public ArrayList<BEArea> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @SysConPat(author=RidixCr)
    @Override
    public BEArea buscar(int id) throws Exception {
         //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try { 
            BEArea bean=null;
            setStoreProcedure("dbo.sp_sel_area"); 
            setParameterInt(id);
            commitc();
            while (existResult()) {
                       bean=new BEArea();
                       bean.setId_area(getDataInt(1));
                       bean.setId_local(getDataInt(2));
                       bean.setNombre_area(getDataString(3));
                       bean.setSigla(getDataString(4));
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
