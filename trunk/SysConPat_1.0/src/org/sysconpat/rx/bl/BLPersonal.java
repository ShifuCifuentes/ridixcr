package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.sysconpat.rx.be.BEPersonal;
import org.sysconpat.rx.da.DAPersonal;
import static org.sysconpat.rx.ds.DSUtil._DSConneccion;

public class BLPersonal extends BLAbstract<BEPersonal> {

    private DAPersonal dao = null;
    
    public BLPersonal(Config conf) {
        setConfig(conf);
    }

    public BLPersonal() {
        setDSConeccion(_DSConneccion());
    }
        
    @Override
    public int registrar(BEPersonal bean) throws Exception {
        dao = new DAPersonal(getConeccion());
        return dao.registrar(bean);
    }

    @Override
    public int actualizarRegistro(BEPersonal bean) throws Exception {
        dao = new DAPersonal(getConeccion());
        return dao.actualizarRegistro(bean);
    }

    @Override
    public int eliminarRegistro(BEPersonal bean) throws Exception {
        dao = new DAPersonal(getConeccion());
        return dao.eliminarRegistro(bean);
    }

    @Override
    public ArrayList<BEPersonal> buscarReferencia(String referencia) throws Exception {
        dao = new DAPersonal(getConeccion());
        return dao.buscarReferencia(referencia);
    }
    public ArrayList<BEPersonal> buscarReferencia(int id) throws Exception {
        dao = new DAPersonal(getConeccion());
        return dao.buscarReferencia(id);
    }

    @Override
    public ArrayList<BEPersonal> listar() throws Exception {
        dao = new DAPersonal(getConeccion());
        return dao.listar();
    }

    @Override
    public BEPersonal buscar(int id) throws Exception {
        dao = new DAPersonal(getConeccion());
        return dao.buscar(id);
    }
    
}
