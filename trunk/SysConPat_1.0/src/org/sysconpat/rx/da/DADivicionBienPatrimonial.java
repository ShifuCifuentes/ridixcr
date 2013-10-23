package org.sysconpat.rx.da;

import java.sql.Connection;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.sysconpat.rx.be.BEDivicionBienPatrimonial;

public class DADivicionBienPatrimonial   extends DAOAbstract<BEDivicionBienPatrimonial> {

    public DADivicionBienPatrimonial(Connection conn) {
        setConnection(conn);
    }
    
    @Override
    public int registrar(BEDivicionBienPatrimonial bean) throws Exception {
        try {
            setStoreProcedure("dbo.sp_ins_divicion_bien_patrimonial");
            setParameterInt(bean.getId_bien_patrimonial());
            setParameterString(bean.getDenominacion());
            setParameterDouble(bean.getPrecio_adquisicion());
            setParameterDate(bean.getFecha_adquisicion());            
            setParameterString(bean.getObservacion());
            setParameterInt(bean.getSistema_contenedor());
            setParameterInt(bean.getEstado());
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }

    @Override
    public int actualizarRegistro(BEDivicionBienPatrimonial bean) throws Exception {
        try {
            setStoreProcedure("dbo.sp_upd_divicion_bien_patrimonial");
            setParameterInt(bean.getId_divicion_bien_patrimonial());
            setParameterInt(bean.getId_bien_patrimonial());
            setParameterString(bean.getDenominacion());
            setParameterDouble(bean.getPrecio_adquisicion());
            setParameterDate(bean.getFecha_adquisicion());
            setParameterInt(bean.getEstado());
            setParameterString(bean.getObservacion());
            setParameterInt(bean.getSistema_contenedor());
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }

    @Override
    public int eliminarRegistro(BEDivicionBienPatrimonial bean) throws Exception {
        try {
            setStoreProcedure("dbo.sp_del_divicion_bien_patrimonial");
            setParameterInt(bean.getId_divicion_bien_patrimonial());           
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }

    @Override
    public ArrayList<BEDivicionBienPatrimonial> buscarReferencia(String referencia) throws Exception {
        throw null;
    }
    @Override
    public ArrayList<BEDivicionBienPatrimonial> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BEDivicionBienPatrimonial buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public ArrayList<BEDivicionBienPatrimonial> buscarReferencia(int id) throws Exception {
        try { 
            clear();
            setStoreProcedure("dbo.sp_sel_divicion_bien_patrimonial"); 
            setParameterInt(id);
            commitc();
            while (existResult()) {
                BEDivicionBienPatrimonial bean = new BEDivicionBienPatrimonial();
                                        bean.setId_divicion_bien_patrimonial(getDataInt(1));
                                        bean.setId_bien_patrimonial(getDataInt(2));
                                        bean.setDenominacion(getDataString(3));
                                        bean.setPrecio_adquisicion(getDataDouble(4));
                                        bean.setFecha_adquisicion(getDataDate(5));
                                        bean.setObservacion(getDataString(6));
                                        bean.setSistema_contenedor(getDataInt(7));
                                        bean.setEstado(getDataInt(8));
                add(bean);
            }
            close();
           return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;        
        }
    }
    
    public int eliminar_diviciones_bien_patrimonial(int id_bien_patrimonial) throws Exception {
        try {
            setStoreProcedure("dbo.sp_del_divicion_bien_patrimonial");
            setParameterInt(id_bien_patrimonial);           
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }
}
