package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.sysconpat.rx.be.BECatalogo;
import org.sysconpat.rx.da.DACatalogo;
import static org.sysconpat.rx.ds.DSUtil._DSConneccion;

public class BLCatalogo extends BLAbstract<BECatalogo>{
    
    private DACatalogo dao = null;
    
    public BLCatalogo(Config conf) {
        setConfig(conf);
    }

    public BLCatalogo() {
        setDSConeccion(_DSConneccion());
    }
    
    @Override
    public int registrar(BECatalogo bean) throws Exception {
        dao = new DACatalogo(getConeccion());
        return dao.registrar(bean);
    }

    @Override
    public int actualizarRegistro(BECatalogo bean) throws Exception {
        dao = new DACatalogo(getConeccion());
        return dao.actualizarRegistro(bean);
    }

    @Override
    public int eliminarRegistro(BECatalogo bean) throws Exception {
        dao = new DACatalogo(getConeccion());
        return dao.eliminarRegistro(bean);
    }

    @Override
    public ArrayList<BECatalogo> buscarReferencia(String referencia) throws Exception {
        dao = new DACatalogo(getConeccion());
        return dao.buscarReferencia(referencia);
    }

    @Override
    public ArrayList<BECatalogo> listar() throws Exception {
        dao = new DACatalogo(getConeccion());
        return dao.listar();
    }

    @Override
    public BECatalogo buscar(int id) throws Exception {
        dao = new DACatalogo(getConeccion());
        return dao.buscar(id);
    }
    public int actualizar(BECatalogo be) throws Exception{
        dao = new DACatalogo(getConeccion());
        return dao.actualizar(be);
    }
    public int ultimo_correlativo_bien_patrimonial(String cod_pat,int cod_gg,int cod_clase) throws Exception{
        dao = new DACatalogo(getConeccion());
        return dao.ultimo_correlativo_bien_patrimonial(cod_pat, cod_gg, cod_clase);
    }
    public int ultimo_correlativo_bien_patrimonial() throws Exception{
        dao = new DACatalogo(getConeccion());
        return dao.ultimo_correlativo_bien_patrimonial();
    }
    
}
