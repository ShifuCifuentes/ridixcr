package org.sysconpat.rx.da;

import java.sql.Connection;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.sysconpat.rx.be.BECuentaContable;

public class DACuentaContable extends DAOAbstract<BECuentaContable> {
    
    public DACuentaContable(Connection conn) {
        setConnection(conn);
    }
    
    @Override
    public int registrar(BECuentaContable tipo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizarRegistro(BECuentaContable tipo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int eliminarRegistro(BECuentaContable tipo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<BECuentaContable> buscarReferencia(String string) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<BECuentaContable> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BECuentaContable buscar(int i) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public int buscar(BECuentaContable be) throws Exception {
        try {             
            setStoreProcedure("dbo.buscar_cuenta_contable"); 
            setParameterString(be.getNro_cuenta_contable());
            commitc();
            while (existResult()) {
                be.setId_cuenta_contable(getDataInt(1));
            }
            close();
           return be.getId_cuenta_contable();
        } catch (Exception ex) {
            return rollback(ex);      
        }
    }
    
}
