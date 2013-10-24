package org.sysconpat.rx.da;

import java.sql.Connection;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.sysconpat.rx.be.BECatalogo;

public class DACatalogo extends DAOAbstract<BECatalogo>{

    public DACatalogo(Connection conn) {
        setConnection(conn);
    }
    
    @Override
    public int registrar(BECatalogo bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizarRegistro(BECatalogo bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int eliminarRegistro(BECatalogo bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public ArrayList<BECatalogo> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public BECatalogo buscar(int id) throws Exception {
       throw null;
    }
    @Override
    public ArrayList<BECatalogo> buscarReferencia(String referencia) throws Exception {
        try { 
            clear();
            setStoreProcedure("dbo.sp_sel_catalogo"); 
            setParameterString(referencia);
            commitc();
            while (existResult()) {
                BECatalogo bean=new BECatalogo();
                          bean.setId_catalogo(getDataInt(1));
                          bean.setCodigo_patrimonial(getDataString(2));
                          bean.setDenominacion(getDataString(3));
                          bean.setClasificador(getDataString(4));
                          bean.setId_cuenta_contable(getDataInt(5));
                          bean.setId_grupogenerico(getDataInt(6));
                          bean.setGrupo_generico(getDataString(7));
                          bean.setCod_grupogenerico(getDataInt(8));
                          bean.setId_clase(getDataInt(9));
                          bean.setClase(getDataString(10));
                          bean.setCodigo_clase(getDataInt(11));
                          bean.setAnio_vida(getDataInt(12));                          
                          bean.setId_cuenta_contable_co(getDataInt(13));     
                add(bean);
            }
            close();
           return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;        
        }
    }   
    public int actualizar(BECatalogo be) throws Exception {
        try {
            setStoreProcedure("dbo.actualizar_catalogo");
            setParameterString(be.getCodigo_patrimonial());
            setParameterString(be.getDenominacion());
            setParameterString(be.getClasificador());
            setParameterInt(be.getCod_grupogenerico());
            setParameterInt(be.getCodigo_clase());
            setParameterInt(be.getAnio_vida());
            setParameterInt(be.getId_cuenta_contable());
            setParameterInt(be.getId_grupogenerico());
            setParameterInt(be.getId_clase());
            setParameterInt(be.getId_cuenta_contable_co());
            return Integer.parseInt(commit().toString());
        }catch (Exception ex) {
            return rollback(ex);
        } 
    }
     public int ultimo_correlativo_bien_patrimonial(String cod_pat,int cod_gg,int cod_clase) throws Exception {
        try { 
            int ul_correlativo=0;
            setStoreProcedure("dbo.ultimo_correlativo_bien_patrimonial"); 
            setParameterString(cod_pat);
            setParameterInt(cod_gg);
            setParameterInt(cod_clase);
            commitc();
            while (existResult()) {
                ul_correlativo=getDataInt(1);
            }
            close();
           return ul_correlativo;
        } catch (Exception ex) {
            return rollback(ex);      
        }
    }   
}
