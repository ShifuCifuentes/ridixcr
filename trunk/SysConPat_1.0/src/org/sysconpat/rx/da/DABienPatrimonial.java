package org.sysconpat.rx.da;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import org.rx.cr.dao.DAAbstract;
import org.sysconpat.rx.SysConPat;
import org.sysconpat.rx.be.BEBienPatrimonial;
import static org.rx.cr.util.Utilitarios.*;

public class DABienPatrimonial  extends DAAbstract<BEBienPatrimonial> {
    
    public DABienPatrimonial(Connection conn) {
        setConnection(conn);
    }
    @SysConPat(author=RidixCr)
    @Override
    public int registrar(BEBienPatrimonial bean) throws Exception {
        try {
            setStoreProcedure("dbo.sp_ins_bien_patrimonial");
            setParameterInt(bean.getId_entidad());
            setParameterInt(bean.getId_catalogo());
            setParameterInt(bean.getUl_correlativo());
            setParameterInt(bean.getTipo_cuenta());
            setParameterInt(bean.getCantidad());
            setParameterBoolean(bean.isEleccion_af_co());
            setParameterInt(bean.getId_cta_contable());
            setParameterDate(bean.getFecha_adquisicion());
            setParameterString(bean.getDoc_adquisicion());
            setParameterBoolean(bean.isAsegurado());
            setParameterBoolean(bean.isFichado());
            setParameterBoolean(bean.isInventariado());
            setParameterBoolean(bean.isEntransito());
            setParameterInt(bean.getEstado());
            setParameterInt(bean.getId_local());
            setParameterInt(bean.getId_area());
            setParameterInt(bean.getId_oficina());
            setParameterInt(bean.getId_personal());
            setParameterDouble(bean.getValor_adquisicion());
            setParameterString(bean.getMarca());
            setParameterString(bean.getTipo());
            setParameterString(bean.getSerie());
            setParameterString(bean.getClase());
            setParameterString(bean.getPlaca());
            setParameterString(bean.getNro_motor());
            setParameterString(bean.getMatricula());
            setParameterDouble(bean.getLongitud());
            setParameterDouble(bean.getAncho());
            setParameterString(bean.getModelo());
            setParameterString(bean.getColor());
            setParameterString(bean.getRaza());
            setParameterInt(bean.getAnio());
            setParameterString(bean.getPais());
            setParameterInt(bean.getNro_chasis());
            setParameterDouble(bean.getDimencion());
            setParameterDouble(bean.getAltura());
            setParameterString(bean.getTipo_combustible());
            setParameterString(bean.getCarroceria());
            setParameterString(bean.getTransmision());
            setParameterString(bean.getCertificado_soat());
            setParameterString(bean.getNro_tarjeta_propiedad());
            setParameterString(bean.getOtro());
            setParameterInt(bean.getForma_adquisicion());            
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }
    @SysConPat(author=RidixCr)
    @Override
    public int actualizarRegistro(BEBienPatrimonial bean) throws Exception {
        try {
            setStoreProcedure("dbo.sp_upd_bien_patrimonial");
            setParameterInt(bean.getId_bien_patrimonial());
            setParameterInt(bean.getId_entidad());
            setParameterInt(bean.getId_catalogo());
            setParameterInt(bean.getUl_correlativo());
            setParameterInt(bean.getTipo_cuenta());
            setParameterInt(bean.getCantidad());
            setParameterBoolean(bean.isEleccion_af_co());
            setParameterInt(bean.getId_cta_contable());
            setParameterDate(bean.getFecha_adquisicion());
            setParameterString(bean.getDoc_adquisicion());
            setParameterBoolean(bean.isAsegurado());
            setParameterBoolean(bean.isFichado());
            setParameterBoolean(bean.isInventariado());
            setParameterBoolean(bean.isEntransito());
            setParameterInt(bean.getEstado());
            setParameterInt(bean.getId_local());
            setParameterInt(bean.getId_area());
            setParameterInt(bean.getId_oficina());
            setParameterInt(bean.getId_personal());
            setParameterDouble(bean.getValor_adquisicion());
            setParameterString(bean.getMarca());
            setParameterString(bean.getTipo());
            setParameterString(bean.getSerie());
            setParameterString(bean.getClase());
            setParameterString(bean.getPlaca());
            setParameterString(bean.getNro_motor());
            setParameterString(bean.getMatricula());
            setParameterDouble(bean.getLongitud());
            setParameterDouble(bean.getAncho());
            setParameterString(bean.getModelo());
            setParameterString(bean.getColor());
            setParameterString(bean.getRaza());
            setParameterInt(bean.getAnio());
            setParameterString(bean.getPais());
            setParameterInt(bean.getNro_chasis());
            setParameterDouble(bean.getDimencion());
            setParameterDouble(bean.getAltura());
            setParameterString(bean.getTipo_combustible());
            setParameterString(bean.getCarroceria());
            setParameterString(bean.getTransmision());
            setParameterString(bean.getCertificado_soat());
            setParameterString(bean.getNro_tarjeta_propiedad());
            setParameterString(bean.getOtro());
            setParameterInt(bean.getForma_adquisicion());            
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }
    @SysConPat(author=RidixCr)
    @Override
    public int eliminarRegistro(BEBienPatrimonial bean) throws Exception {
        try {
            setStoreProcedure("dbo.sp_del_bien_patrimonial");
            setParameterInt(bean.getId_bien_patrimonial());            
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }
    @SysConPat(author=RidixCr)
    @Override
    public ArrayList<BEBienPatrimonial> buscarReferencia(String referencia) throws Exception {
        try { 
            clear();
            setStoreProcedure("dbo.sp_sel_bien_patrimonial"); 
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
    }
    @SysConPat(author=RidixCr)
    public ArrayList<BEBienPatrimonial> buscarReferencia(int id_personal) throws Exception {
        try { 
            clear();
            setStoreProcedure("dbo.sp_sel_bien_patrimonial"); 
            setParameterInt(id_personal);
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
    }
    @SysConPat(author=RidixCr)
    @Override
    public ArrayList<BEBienPatrimonial> listar() throws Exception {
        throw null;
    }
    @SysConPat(author=RidixCr)
    @Override
    public BEBienPatrimonial buscar(int id) throws Exception {
        try { 
            BEBienPatrimonial bean = null;
            setStoreProcedure("dbo.sp_sel_buscar_bien_patrimonial"); 
            setParameterInt(id);
            commitc();
            while (existResult()) {
                bean = new BEBienPatrimonial();
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
            }
            close();
           return bean;
        } catch (Exception ex) {
            rollback(ex);
            return null;        
        }
    }
    public int generar_deprecion_general(Date fecha_calculo) throws Exception {       
        try {
            setStoreProcedure("dbo.generar_depreciacion_general");
            setParameterDate(fecha_calculo); 
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }
    public int generar_deprecion_general_anual(int anio_calculo) throws Exception {       
        try {
            setStoreProcedure("dbo.generar_depreciacion_general_anual");
            setParameterInt(anio_calculo);
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }
    public int generar_deprecion_general_individual(Date fecha_calculo,int id_bien_patrimonial) throws Exception {       
        try {
            setStoreProcedure("dbo.generar_depreciacion_general_individual");
            setParameterDate(fecha_calculo);
            setParameterInt(id_bien_patrimonial);
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }
    public int generar_depreciacion_general_individual_anual(Date fecha_calculo,int id_bien_patrimonial) throws Exception {       
        try {
            setStoreProcedure("dbo.generar_depreciacion_general_individual_anual");
            setParameterDate(fecha_calculo);
            setParameterInt(id_bien_patrimonial);
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }
    
}
