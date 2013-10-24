package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.sysconpat.rx.be.BEGrupoGenerico;
import org.sysconpat.rx.da.DAGrupoGenerico;
import static org.sysconpat.rx.ds.DSUtil._DSConneccion;

public class BLGrupoGenerico  extends BLAbstract<BEGrupoGenerico>{
    
    private DAGrupoGenerico dao = null;
    
    public BLGrupoGenerico(Config conf) {
        setConfig(conf);
    }

    public BLGrupoGenerico() {
        setDSConeccion(_DSConneccion());
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
        dao = new DAGrupoGenerico(getConeccion());
        return dao.buscarReferencia(referencia);
    }

    @Override
    public ArrayList<BEGrupoGenerico> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BEGrupoGenerico buscar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public int buscar(BEGrupoGenerico be) throws Exception{
        dao = new DAGrupoGenerico(getConeccion());
        return dao.buscar(be);
    }
    
}
