package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.sysconpat.rx.be.BELocal;
import org.sysconpat.rx.da.DALocal;
import static org.sysconpat.rx.ds.DSUtil._DSConneccion;

public class BLLocal extends BLAbstract<BELocal> {

    private DALocal dao = null;
    
    public BLLocal(Config conf) {
        setConfig(conf);
    }

    public BLLocal() {
        setDSConeccion(_DSConneccion());
    }
    
    
    @Override
    public int registrar(BELocal bean) throws Exception {
        dao = new DALocal(getConeccion());
        return dao.registrar(bean);
    }

    @Override
    public int actualizarRegistro(BELocal bean) throws Exception {
        dao = new DALocal(getConeccion());
        return dao.actualizarRegistro(bean);
    }

    @Override
    public int eliminarRegistro(BELocal bean) throws Exception {
        dao = new DALocal(getConeccion());
        return dao.eliminarRegistro(bean);
    }

    @Override
    public ArrayList<BELocal> buscarReferencia(String referencia) throws Exception {
        dao = new DALocal(getConeccion());
        return dao.buscarReferencia(referencia);
    }

    @Override
    public ArrayList<BELocal> listar() throws Exception {
        dao = new DALocal(getConeccion());
        return dao.listar();
    }

    @Override
    public BELocal buscar(int id) throws Exception {
        dao = new DALocal(getConeccion());
        return dao.buscar(id);
    }
    
}
