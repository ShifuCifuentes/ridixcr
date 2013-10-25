package org.sysconpat.rx.da;

import java.sql.Connection;
import java.util.ArrayList;
import org.rx.cr.dao.DAAbstract;
import org.sysconpat.rx.be.BELocal;

public class DALocal extends DAAbstract<BELocal>{

    public DALocal(Connection conn) {
        setConnection(conn);
    }
    @Override
    public int registrar(BELocal bean) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try {
            setStoreProcedure("dbo.sp_ins_local");
            setParameterString(bean.getNombre());         
            setParameterInt(bean.getTipo_propiedad());         
            setParameterDouble(bean.getArea());         
            setParameterInt(bean.getUnidad_metrica());         
            setParameterInt(bean.getTipo_direccion());         
            setParameterString(bean.getDireccion());         
            setParameterString(bean.getNro());         
            setParameterString(bean.getManzana());         
            setParameterString(bean.getLote());         
            setParameterInt(bean.getId_ubigeo());                         
            setParameterInt(bean.getTipo_cuenta());         
            setParameterInt(bean.getTipo_moneda());    
            setParameterInt(bean.getId_cuenta());
            setParameterString(bean.getValor_contable());  
            setParameterInt(bean.getOficina_registral());  
            setParameterString(bean.getTomo());  
            setParameterString(bean.getFojas());  
            setParameterString(bean.getAsiento());  
            setParameterString(bean.getCodigo_predio());  
            setParameterString(bean.getPartida_electoral());  
            setParameterString(bean.getRegistro_sinabip());  
            setParameterString(bean.getPropiedad_registral());  
            setParameterString(bean.getBeneficiario());              
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
        //</editor-fold>
    }

    @Override
    public int actualizarRegistro(BELocal bean) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try {
            setStoreProcedure("dbo.sp_upd_local");
            setParameterInt(bean.getId_local());
            setParameterString(bean.getNombre());         
            setParameterInt(bean.getTipo_propiedad());         
            setParameterDouble(bean.getArea());         
            setParameterInt(bean.getUnidad_metrica());         
            setParameterInt(bean.getTipo_direccion());         
            setParameterString(bean.getDireccion());         
            setParameterString(bean.getNro());         
            setParameterString(bean.getManzana());         
            setParameterString(bean.getLote());         
            setParameterInt(bean.getId_ubigeo());                         
            setParameterInt(bean.getTipo_cuenta());         
            setParameterInt(bean.getTipo_moneda());    
            setParameterInt(bean.getId_cuenta());
            setParameterString(bean.getValor_contable());  
            setParameterInt(bean.getOficina_registral());  
            setParameterString(bean.getTomo());  
            setParameterString(bean.getFojas());  
            setParameterString(bean.getAsiento());  
            setParameterString(bean.getCodigo_predio());  
            setParameterString(bean.getPartida_electoral());  
            setParameterString(bean.getRegistro_sinabip());  
            setParameterString(bean.getPropiedad_registral());  
            setParameterString(bean.getBeneficiario());              
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
        //</editor-fold>
    }

    @Override
    public int eliminarRegistro(BELocal bean) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try {
            setStoreProcedure("dbo.sp_del_local");
            setParameterInt(bean.getId_local());                   
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
        //</editor-fold>
    }

    @Override
    public ArrayList<BELocal> buscarReferencia(String referencia) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try { 
            clear();
            setStoreProcedure("dbo.sp_sel_local"); 
            setParameterString(referencia);
            commitc();
            while (existResult()) {
                BELocal bean=new BELocal();
                          bean.setId_local(getDataInt(1));  
                          bean.setNombre(getDataString(2));  
                          bean.setTipo_propiedad(getDataInt(3));  
                          bean.setArea(getDataDouble(4));  
                          bean.setUnidad_metrica(getDataInt(5));                     
                          bean.setTipo_direccion(getDataInt(6));                     
                          bean.setDireccion(getDataString(7));  
                          bean.setNro(getDataString(8));  
                          bean.setManzana(getDataString(9));
                          bean.setLote(getDataString(10));
                          bean.setId_ubigeo(getDataInt(11));
                          bean.setTipo_cuenta(getDataInt(12));  
                          bean.setTipo_moneda(getDataInt(13));  
                          bean.setId_cuenta(getDataInt(14));  
                          bean.setValor_contable(getDataString(15));
                          bean.setOficina_registral(getDataInt(16));            
                          bean.setTomo(getDataString(17));            
                          bean.setFojas(getDataString(18)); 
                          bean.setAsiento(getDataString(19)); 
                          bean.setCodigo_predio(getDataString(20)); 
                          bean.setPartida_electoral(getDataString(21));   
                          bean.setRegistro_sinabip(getDataString(22));   
                          bean.setPropiedad_registral(getDataString(23)); 
                          bean.setBeneficiario(getDataString(24)); 
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
    public ArrayList<BELocal> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BELocal buscar(int id) throws Exception {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        try { 
            BELocal bean=null;            
            setStoreProcedure("dbo.sp_sel_local"); 
            setParameterInt(id);
            commitc();
            while (existResult()) {
                          bean=new BELocal();
                          bean.setId_local(getDataInt(1));  
                          bean.setNombre(getDataString(2));  
                          bean.setTipo_propiedad(getDataInt(3));  
                          bean.setArea(getDataDouble(4));  
                          bean.setUnidad_metrica(getDataInt(5));                     
                          bean.setTipo_direccion(getDataInt(6));                     
                          bean.setDireccion(getDataString(7));  
                          bean.setNro(getDataString(8));  
                          bean.setManzana(getDataString(9));
                          bean.setLote(getDataString(10));
                          bean.setId_ubigeo(getDataInt(11));
                          bean.setTipo_cuenta(getDataInt(12));  
                          bean.setTipo_moneda(getDataInt(13));  
                          bean.setId_cuenta(getDataInt(14));  
                          bean.setValor_contable(getDataString(15));
                          bean.setOficina_registral(getDataInt(16));            
                          bean.setTomo(getDataString(17));            
                          bean.setFojas(getDataString(18)); 
                          bean.setAsiento(getDataString(19)); 
                          bean.setCodigo_predio(getDataString(20)); 
                          bean.setPartida_electoral(getDataString(21));   
                          bean.setRegistro_sinabip(getDataString(22));   
                          bean.setPropiedad_registral(getDataString(23)); 
                          bean.setBeneficiario(getDataString(24));                 
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
