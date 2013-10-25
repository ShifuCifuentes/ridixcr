package org.sysconpat.rx.da;

import java.sql.Connection;
import java.util.ArrayList;
import org.rx.cr.dao.DAAbstract;
import org.sysconpat.rx.be.BEGrupoGenerico;

public class DAGrupoGenerico  extends DAAbstract<BEGrupoGenerico> {
    
    public DAGrupoGenerico(Connection conn) {
        setConnection(conn);
    }
    
    @Override
    public int registrar(BEGrupoGenerico bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizarRegistro(BEGrupoGenerico bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int eliminarRegistro(BEGrupoGenerico bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<BEGrupoGenerico> buscarReferencia(String referencia) throws Exception {
        try { 
            clear();
            setStoreProcedure("dbo.sp_sel_grupo_generico"); 
            setParameterString(referencia);
            commitc();
            while (existResult()) {
                BEGrupoGenerico bean=new BEGrupoGenerico();
                       bean.setId_grupo_generico(getDataInt(1));
                       bean.setDenominacion(getDataString(2));                      
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
    public ArrayList<BEGrupoGenerico> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BEGrupoGenerico buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public int buscar(BEGrupoGenerico be) throws Exception {
        try {             
            setStoreProcedure("dbo.buscar_grupo_generico"); 
            setParameterString(be.getDenominacion());
            commitc();
            while (existResult()) {
                be.setId_grupo_generico(getDataInt(1));
            }
            close();
           return be.getId_grupo_generico();
        } catch (Exception ex) {
            return rollback(ex);      
        }
    }
    
}
