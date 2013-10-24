package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.rx.cr.ds.DSConeccion;
import org.sysconpat.rx.be.BEContenedor;
import org.sysconpat.rx.be.BERolUsuario;
import org.sysconpat.rx.be.BEUsuario;
import org.sysconpat.rx.da.DARolUsuario;
import static org.sysconpat.rx.ds.DSUtil._DSConneccion;

public class BLRolUsuario extends BLAbstract<BERolUsuario> {

    private DARolUsuario dao = null;    
    
    public BLRolUsuario(Config conf) {
        setConfig(conf);
    }

    public BLRolUsuario() {
        setDSConeccion(_DSConneccion());
    }   
    
    @Override
    public int registrar(BERolUsuario tipo) throws Exception {
        dao = new DARolUsuario(getConeccion());
        return dao.registrar(tipo);
    }

    @Override
    public int actualizarRegistro(BERolUsuario tipo) throws Exception {
        dao = new DARolUsuario(getConeccion());
        return dao.actualizarRegistro(tipo);
    }

    @Override
    public int eliminarRegistro(BERolUsuario tipo) throws Exception {
        dao = new DARolUsuario(getConeccion());
        return dao.eliminarRegistro(tipo);
    }

    @Override
    public ArrayList<BERolUsuario> buscarReferencia(String string) {
        dao = new DARolUsuario(getConeccion());
        return dao.buscarReferencia(string);
    }

    @Override
    public ArrayList<BERolUsuario> listar() {
        dao = new DARolUsuario(getConeccion());
        return dao.listar();
    }

    @Override
    public BERolUsuario buscar(int i) throws Exception {
        dao = new DARolUsuario(getConeccion());
        return dao.buscar(i);
    }
    
    public  ArrayList<BEContenedor> listar_modulos_usuario(int id) throws Exception{
        dao = new DARolUsuario(getConeccion());
        return dao.listar_modulos_usuario(id);
    }
    public int eliminarRolesUsuario(BEUsuario bean) throws Exception{
        dao = new DARolUsuario(getConeccion());
        return dao.eliminarRolesUsuario(bean);
    }
    
}
