package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.sysconpat.rx.be.BECuentaContable;
import org.sysconpat.rx.da.DAArea;
import org.sysconpat.rx.da.DACuentaContable;
import static org.sysconpat.rx.ds.DSUtil._DSConneccion;

public class BLCuentaContable extends BLAbstract<BECuentaContable> {
    
    private DACuentaContable dao = null;
    
    public BLCuentaContable(Config conf) {
        setConfig(conf);
    }

    public BLCuentaContable() {
        setDSConeccion(_DSConneccion());
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
    public int buscar(BECuentaContable be) throws Exception{
        dao = new DACuentaContable(getConeccion());
        return dao.buscar(be);
    }
    
}
