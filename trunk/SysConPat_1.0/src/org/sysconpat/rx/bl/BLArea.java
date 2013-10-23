package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.sysconpat.rx.be.BEArea;
import org.sysconpat.rx.da.DAArea;

public class BLArea extends BLAbstract<BEArea> {

    private DAArea dao = null;
    
    public BLArea(Config conf) {
        setConfig(conf);
    }
    
    @Override
    public int registrar(BEArea bean) throws Exception {
        dao = new DAArea(getConeccion());
        return dao.registrar(bean);
    }

    @Override
    public int actualizarRegistro(BEArea bean) throws Exception {
        dao = new DAArea(getConeccion());
        return dao.actualizarRegistro(bean);
    }

    @Override
    public int eliminarRegistro(BEArea bean) throws Exception {
        dao = new DAArea(getConeccion());
        return dao.eliminarRegistro(bean);
    }

    @Override
    public ArrayList<BEArea> buscarReferencia(String referencia) throws Exception {
        dao = new DAArea(getConeccion());
        return dao.buscarReferencia(referencia);
    }
    public ArrayList<BEArea> buscarReferencia(int id) throws Exception {
        dao = new DAArea(getConeccion());
        return dao.buscarReferencia(id);
    }

    @Override
    public ArrayList<BEArea> listar() throws Exception {
        dao = new DAArea(getConeccion());
        return dao.listar();
    }

    @Override
    public BEArea buscar(int id) throws Exception {
        dao = new DAArea(getConeccion());
        return dao.buscar(id);
    }
    
}
