package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.sysconpat.rx.be.BEUbigeo;
import org.sysconpat.rx.da.DAOUbigeo;
import static org.sysconpat.rx.ds.DSUtil._DSConneccion;

public class BLUbigeo extends BLAbstract<BEUbigeo> {
    private DAOUbigeo dao = null;
    public BLUbigeo(Config conf) {
        setConfig(conf);
    }

    public BLUbigeo() {
        setDSConeccion(_DSConneccion());
    }
    
    //<editor-fold defaultstate="collapsed" desc="Funciones No Utilizadas">
    @Override
    public int registrar(BEUbigeo bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizarRegistro(BEUbigeo bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int eliminarRegistro(BEUbigeo bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<BEUbigeo> buscarReferencia(String referencia) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<BEUbigeo> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BEUbigeo buscar(int id) throws Exception {
        dao = new DAOUbigeo(getConeccion());
        return dao.buscar(id);
    }
    //</editor-fold>
    public ArrayList<BEUbigeo> listar_regiones() throws Exception {      
      dao = new DAOUbigeo(getConeccion());
      return dao.listar_regiones();
    }    
    public ArrayList<BEUbigeo> listar_provincias_region(int cod_region) throws Exception{      
        dao = new DAOUbigeo(getConeccion());
        return dao.listar_provincias_region(cod_region);
    }    
    public ArrayList<BEUbigeo> listar_distritos_provincia_region(int cod_region, int cod_provincia) throws Exception{      
       dao = new DAOUbigeo(getConeccion());
        return dao.listar_distritos_provincia_region(cod_region, cod_provincia);
    }
}
