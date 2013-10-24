package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.sysconpat.rx.be.BEBajaBienPatrimonial;
import org.sysconpat.rx.be.BEBienPatrimonial;
import org.sysconpat.rx.da.DABajaBienPatrimonial;
import static org.sysconpat.rx.ds.DSUtil._DSConneccion;

public class BLBajaBienPatrimonial extends BLAbstract<BEBajaBienPatrimonial>{

    private DABajaBienPatrimonial dao = null;
    public BLBajaBienPatrimonial(Config conf) {
        setConfig(conf);
    }

    public BLBajaBienPatrimonial() {
        setDSConeccion(_DSConneccion());
    }
    
    
    @Override
    public int registrar(BEBajaBienPatrimonial bean) throws Exception {
      dao = new DABajaBienPatrimonial(getConeccion());
      return dao.registrar(bean);
    }

    @Override
    public int actualizarRegistro(BEBajaBienPatrimonial bean) throws Exception {
        dao = new DABajaBienPatrimonial(getConeccion());
      return dao.actualizarRegistro(bean);
    }

    @Override
    public int eliminarRegistro(BEBajaBienPatrimonial bean) throws Exception {
       dao = new DABajaBienPatrimonial(getConeccion());
      return dao.eliminarRegistro(bean);
    }

    @Deprecated @Override public ArrayList<BEBajaBienPatrimonial> buscarReferencia(String referencia) throws Exception {throw null;}
    
    public ArrayList<BEBienPatrimonial> buscarReferenciaBajaBienPatrimonial(String referencia) throws Exception {
        dao = new DABajaBienPatrimonial(getConeccion());
      return dao.buscarReferenciaBajaBienPatrimonial(referencia);
    }

    @Override
    public ArrayList<BEBajaBienPatrimonial> listar() throws Exception {
        dao = new DABajaBienPatrimonial(getConeccion());
      return dao.listar();
    }

    @Override
    public BEBajaBienPatrimonial buscar(int id) throws Exception {
        dao = new DABajaBienPatrimonial(getConeccion());
      return dao.buscar(id);
    }
    
}
