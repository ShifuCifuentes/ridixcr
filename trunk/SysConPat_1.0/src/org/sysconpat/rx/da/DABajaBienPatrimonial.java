package org.sysconpat.rx.da;

import java.sql.Connection;
import java.util.ArrayList;
import org.rx.cr.dao.DAAbstract;
import org.sysconpat.rx.SysConPat;
import org.sysconpat.rx.be.BEBajaBienPatrimonial;
import org.sysconpat.rx.be.BEBienPatrimonial;
import static org.rx.cr.util.Utilitarios.*;

public class DABajaBienPatrimonial extends DAAbstract<BEBajaBienPatrimonial>{

    public DABajaBienPatrimonial(Connection conn) {
        setConnection(conn);
    }
    @SysConPat(author=RidixCr)
    @Override
    public int registrar(BEBajaBienPatrimonial bean) throws Exception {
        try {
            setStoreProcedure("dbo.sp_ins_baja_bien_patrimonial");
            setParameterInt(bean.getId_bien());            
            setParameterInt(bean.getId_cta_contable());            
            setParameterInt(bean.getId_personal());            
            setParameterDate(bean.getFecha_baja());
            setParameterInt(bean.getCantidad());
            setParameterString(bean.getResolucion_baja());
            setParameterString(bean.getDoc_sbn());
            setParameterInt(bean.getTipo_cuenta());
            setParameterInt(bean.getCausal_baja());
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }
    @SysConPat(author=RidixCr)
    @Override
    public int actualizarRegistro(BEBajaBienPatrimonial bean) throws Exception {
        try {
            setStoreProcedure("dbo.sp_upd_baja_bien_patrimonial");
            setParameterInt(bean.getId_baja());            
            setParameterInt(bean.getId_bien());            
            setParameterInt(bean.getId_cta_contable());            
            setParameterInt(bean.getId_personal());            
            setParameterDate(bean.getFecha_baja());
            setParameterInt(bean.getCantidad());
            setParameterString(bean.getResolucion_baja());
            setParameterString(bean.getDoc_sbn());
            setParameterInt(bean.getTipo_cuenta());
            setParameterInt(bean.getCausal_baja());
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }
    @SysConPat(author=RidixCr)
    @Override
    public int eliminarRegistro(BEBajaBienPatrimonial bean) throws Exception {
        try {
            setStoreProcedure("dbo.sp_del_baja_bien_patrimonial");
            setParameterInt(bean.getId_baja()); 
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }
    @SysConPat(author=RidixCr)
    @Deprecated @Override public ArrayList<BEBajaBienPatrimonial> buscarReferencia(String referencia) throws Exception {throw null;}
    public ArrayList<BEBienPatrimonial> buscarReferenciaBajaBienPatrimonial(String referencia) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try { 
            clear();
            setStoreProcedure("dbo.sp_sel_baja_bien_patrimonial"); 
            setParameterString(referencia);
            commitc();
            while (existResult()) {
                BEBienPatrimonial bean = new BEBienPatrimonial();
                bean.setId_bien_patrimonial(getDataInt(1));
                bean.setId_entidad(getDataInt(2));
                bean.setId_catalogo(getDataInt(3));
                bean.setUl_correlativo(getDataInt(4));
                bean.setTipo_cuenta(getDataInt(5));
                bean.setCantidad(getDataInt(6));
                bean.setEleccion_af_co(getDataBoolean(7));
                bean.setId_cta_contable(getDataInt(8));
                bean.setFecha_adquisicion(getDataDate(9));
                bean.setDoc_adquisicion(getDataString(10));
                bean.setAsegurado(getDataBoolean(11));
                bean.setFichado(getDataBoolean(12));
                bean.setInventariado(getDataBoolean(13));
                bean.setEntransito(getDataBoolean(14));
                bean.setEstado(getDataInt(15));
                bean.setId_local(getDataInt(16));
                bean.setId_area(getDataInt(17));
                bean.setId_oficina(getDataInt(18));
                bean.setId_personal(getDataInt(19));
                bean.setValor_adquisicion(getDataDouble(20));
                bean.setMarca(getDataString(21));
                bean.setTipo(getDataString(22));
                bean.setSerie(getDataString(23));
                bean.setClase(getDataString(24));
                bean.setPlaca(getDataString(25));
                bean.setNro_motor(getDataString(26));
                bean.setMatricula(getDataString(27));
                bean.setLongitud(getDataDouble(28));
                bean.setAncho(getDataDouble(29));
                bean.setModelo(getDataString(30));
                bean.setColor(getDataString(31));
                bean.setRaza(getDataString(32));
                bean.setAnio(getDataInt(33));
                bean.setPais(getDataString(34));
                bean.setNro_chasis(getDataInt(35));
                bean.setDimencion(getDataDouble(36));
                bean.setAltura(getDataDouble(37));
                bean.setTipo_combustible(getDataString(38));
                bean.setCarroceria(getDataString(39));
                bean.setTransmision(getDataString(40));
                bean.setCertificado_soat(getDataString(41));
                bean.setNro_tarjeta_propiedad(getDataString(42));
                bean.setOtro(getDataString(43));
                bean.setForma_adquisicion(getDataInt(44));
                bean.setCodigo_patrimonial(getDataString(45));
                bean.setDenominacion(getDataString(46));
                bean.setGrupo_generico(getDataString(47));
                bean.setClase_bien(getDataString(48));
                bean.setClasificador(getDataString(49));
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
    @Deprecated @Override public ArrayList<BEBajaBienPatrimonial> listar() throws Exception {throw null;}
    @SysConPat(author=RidixCr)
    @Override
    public BEBajaBienPatrimonial buscar(int id) throws Exception {
        try { 
            BEBajaBienPatrimonial bean=null;
            setStoreProcedure("dbo.sp_sel_baja_bien_patrimonial"); 
            setParameterInt(id);
            commitc();
            while (existResult()) {
                bean = new BEBajaBienPatrimonial();
                bean.setId_baja(getDataInt(1));
                bean.setId_bien(getDataInt(2));
                bean.setId_cta_contable(getDataInt(3));
                bean.setId_personal(getDataInt(4));
                bean.setFecha_baja(getDataDate(5));
                bean.setCantidad(getDataInt(6));
                bean.setResolucion_baja(getDataString(7));
                bean.setDoc_sbn(getDataString(8));
                bean.setTipo_cuenta(getDataInt(9));
                bean.setCausal_baja(getDataInt(10));
            }
            close();
           return bean;
        } catch (Exception ex) {
            rollback(ex);
            return null;        
        }
    }
    
}
