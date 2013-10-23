package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.sysconpat.rx.be.BEDivicionBienPatrimonial;
import org.sysconpat.rx.da.DADivicionBienPatrimonial;

public class BLDivicionBienPatrimonial extends BLAbstract<BEDivicionBienPatrimonial>{

    private DADivicionBienPatrimonial dao = null;
    
    public BLDivicionBienPatrimonial(Config conf) {
        setConfig(conf);
    }
    
    @Override
    public int registrar(BEDivicionBienPatrimonial bean) throws Exception {
        dao = new DADivicionBienPatrimonial(getConeccion());
        return dao.registrar(bean);
    }

    @Override
    public int actualizarRegistro(BEDivicionBienPatrimonial bean) throws Exception {
        dao = new DADivicionBienPatrimonial(getConeccion());
        return dao.actualizarRegistro(bean);
    }

    @Override
    public int eliminarRegistro(BEDivicionBienPatrimonial bean) throws Exception {
        dao = new DADivicionBienPatrimonial(getConeccion());
        return dao.eliminarRegistro(bean);
    }

    @Override
    public ArrayList<BEDivicionBienPatrimonial> buscarReferencia(String referencia) throws Exception {
        dao = new DADivicionBienPatrimonial(getConeccion());
        return dao.buscarReferencia(referencia);
    }

    @Override
    public ArrayList<BEDivicionBienPatrimonial> listar() throws Exception {
        dao = new DADivicionBienPatrimonial(getConeccion());
        return dao.listar();
    }
    public ArrayList<BEDivicionBienPatrimonial> buscarReferencia(int id_bien_patrimonial) throws Exception {
        dao = new DADivicionBienPatrimonial(getConeccion());
        return dao.buscarReferencia(id_bien_patrimonial);
    }

    @Override
    public BEDivicionBienPatrimonial buscar(int id) throws Exception {
        dao = new DADivicionBienPatrimonial(getConeccion());
        return dao.buscar(id);
    }
    public int eliminar_diviciones_bien_patrimonial(int id_bien_patrimonial) throws Exception{
        dao = new DADivicionBienPatrimonial(getConeccion());
        return dao.eliminar_diviciones_bien_patrimonial(id_bien_patrimonial);
    }
    
}
