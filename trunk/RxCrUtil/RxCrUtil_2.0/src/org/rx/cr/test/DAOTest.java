package org.rx.cr.test;

import java.sql.Connection;
import java.util.ArrayList;
import org.RidixCr;
import org.rx.cr.dao.DAOAbstract;
import static org.rx.cr.util.Utilitarios.*;

public class DAOTest extends DAOAbstract<Object> {

    public DAOTest(Connection conn) {
    
    }
    
    @RidixCr(author=RidixCr)
    @Override
    public int registrar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @RidixCr(author=RidixCr)
    @Override
    public int actualizarRegistro(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @RidixCr(author=RidixCr)
    @Override
    public int eliminarRegistro(Object obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @RidixCr(author=RidixCr)
    @Override
    public ArrayList<Object> buscarReferencia(String referencia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @RidixCr(author=RidixCr)
    @Override
    public ArrayList<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @RidixCr(author=RidixCr)
    @Override
    public Object buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object autenticarUsuario(String user, String password) {
        return super.autenticarUsuario(user, password);
    }
    
}
