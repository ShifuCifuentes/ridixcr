package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.sysconpat.rx.be.BEClase;
import org.sysconpat.rx.da.DAClase;
import static org.sysconpat.rx.ds.DSUtil._DSConneccion;

public class BLClase extends BLAbstract<BEClase> {
    
    private DAClase dao = null;
    
    public BLClase(Config conf) {
        setConfig(conf);
    }

    public BLClase() {
        setDSConeccion(_DSConneccion());
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
        dao = new DAClase(getConeccion());
        return dao.buscarReferencia(referencia);
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
        dao = new DAClase(getConeccion());
        return dao.buscar(be);
    }
}
