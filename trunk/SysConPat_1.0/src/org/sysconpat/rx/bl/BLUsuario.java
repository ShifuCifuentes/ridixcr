package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.sysconpat.rx.be.BEUsuario;
import org.sysconpat.rx.da.DAUsuario;

public class BLUsuario extends BLAbstract<BEUsuario> {

    private DAUsuario dao = null;
    
    public BLUsuario(Config conf) {
        setConfig(conf);
    }
     public BLUsuario(DSConeccion ds) {
        setDSConeccion(ds);
    }
    
    @Override
    public int registrar(BEUsuario tipo) throws Exception {
        dao = new DAUsuario(getConeccion());
        return dao.registrar(tipo);
    }

    @Override
    public int actualizarRegistro(BEUsuario tipo) throws Exception {
        dao = new DAUsuario(getConeccion());
        return dao.actualizarRegistro(tipo);
    }

    @Override
    public int eliminarRegistro(BEUsuario tipo) throws Exception {
        dao = new DAUsuario(getConeccion());
        return dao.eliminarRegistro(tipo);
    }

    @Override
    public ArrayList<BEUsuario> buscarReferencia(String string) throws Exception {
        dao = new DAUsuario(getConeccion());
        return dao.buscarReferencia(string);
    }

    @Override
    public ArrayList<BEUsuario> listar() {
       dao = new DAUsuario(getConeccion());
       return dao.listar();
    }

    @Override
    public BEUsuario buscar(int i) throws Exception {
        dao = new DAUsuario(getConeccion());
        return dao.buscar(i);
    }

    @Override
    public BEUsuario autenticarUsuario(String user, String password) {
        dao = new DAUsuario(getConeccion());
        return dao.autenticarUsuario(user,password);
    }
}
