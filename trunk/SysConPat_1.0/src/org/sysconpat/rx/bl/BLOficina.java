package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.sysconpat.rx.be.BEOficina;
import org.sysconpat.rx.da.DAOficina;
import static org.sysconpat.rx.ds.DSUtil._DSConneccion;

public class BLOficina extends BLAbstract<BEOficina> {

   private DAOficina dao = null;
    
    public BLOficina(Config conf) {
        setConfig(conf);
    }

    public BLOficina() {
        setDSConeccion(_DSConneccion());
    }
    
    @Override
    public int registrar(BEOficina bean) throws Exception {
        dao = new DAOficina(getConeccion());
        return dao.registrar(bean);
    }

    @Override
    public int actualizarRegistro(BEOficina bean) throws Exception {
        dao = new DAOficina(getConeccion());
        return dao.actualizarRegistro(bean);
    }

    @Override
    public int eliminarRegistro(BEOficina bean) throws Exception {
        dao = new DAOficina(getConeccion());
        return dao.eliminarRegistro(bean);
    }

    @Override
    public ArrayList<BEOficina> buscarReferencia(String referencia) throws Exception {
        dao = new DAOficina(getConeccion());
        return dao.buscarReferencia(referencia);
    }
    public ArrayList<BEOficina> buscarReferencia(int id) throws Exception {
        dao = new DAOficina(getConeccion());
        return dao.buscarReferencia(id);
    }

    @Override
    public ArrayList<BEOficina> listar() throws Exception {
        dao = new DAOficina(getConeccion());
        return dao.listar();
    }

    @Override
    public BEOficina buscar(int id) throws Exception {
        dao = new DAOficina(getConeccion());
        return dao.buscar(id);
    }
    
}
