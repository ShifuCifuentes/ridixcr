package org.sysconpat.rx.da;

import java.sql.Connection;
import java.util.ArrayList;
import org.rx.cr.dao.DAAbstract;
import org.sysconpat.rx.be.BEArea;
import org.sysconpat.rx.be.BEClase;

public class DAClase  extends DAAbstract<BEClase> {
    
    public DAClase(Connection conn) {
        setConnection(conn);
    }
    
    @Override
    public int registrar(BEClase bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizarRegistro(BEClase bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int eliminarRegistro(BEClase bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<BEClase> buscarReferencia(String referencia) throws Exception {
         try { 
            clear();
            setStoreProcedure("dbo.sp_sel_clase"); 
            setParameterString(referencia);
            commitc();
            while (existResult()) {
                BEClase bean=new BEClase();
                       bean.setId_clase(getDataInt(1));
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
    public ArrayList<BEClase> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BEClase buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public int buscar(BEClase be) throws Exception {
        try {             
            setStoreProcedure("dbo.buscar_clase"); 
            setParameterString(be.getDenominacion());
            commitc();
            while (existResult()) {
                be.setId_clase(getDataInt(1));
            }
            close();
           return be.getId_clase();
        } catch (Exception ex) {
            return rollback(ex);      
        }
    }
    
}
