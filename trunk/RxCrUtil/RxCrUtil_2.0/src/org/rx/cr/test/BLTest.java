package org.rx.cr.test;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;

public class BLTest extends BLAbstract<Object>{
    DAOTest dao = null;
    public BLTest(Config conf) {
        setConfig(conf);
    }
    
    @Override
    public int registrar(Object bean) {
        dao = new DAOTest(getConeccion());
        return dao.registrar(bean);
    }

    @Override
    public int actualizarRegistro(Object bean) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int eliminarRegistro(Object bean) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Object> buscarReferencia(String referencia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
