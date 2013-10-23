
package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.sysconpat.rx.be.BEContenedor;
import org.sysconpat.rx.be.BECuentaContable;
import org.sysconpat.rx.be.BETipoCuenta;
import org.sysconpat.rx.da.DAContenedor;

public class BLContenedor  extends BLAbstract<BEContenedor>{
    
     private DAContenedor dao = null;
    
     public BLContenedor(Config conf) {
        setConfig(conf);
    }
    //<editor-fold defaultstate="collapsed" desc="Funciones No Utilizadas">
    @Deprecated
    @Override
    public int registrar(BEContenedor bean) throws Exception {
        throw null;
    }
    @Deprecated
    @Override
    public int actualizarRegistro(BEContenedor bean) throws Exception {
        throw null;
    }
    @Deprecated
    @Override
    public int eliminarRegistro(BEContenedor bean) throws Exception {
        throw null;
    }
    @Deprecated
    @Override
    public ArrayList<BEContenedor> buscarReferencia(String referencia) throws Exception {
        throw null;
    }
    @Deprecated
    @Override
    public ArrayList<BEContenedor> listar() throws Exception {
        throw null;
    }
    @Deprecated
    @Override
    public BEContenedor buscar(int id) throws Exception {
        throw null;
    }
    //</editor-fold>
    public ArrayList<BETipoCuenta> listar_tipos_cuenta_locales() throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_tipos_cuenta_locales();
    }
    public ArrayList<BEContenedor> listar_oficinas_registral() throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_oficinas_registral();
    }
    public ArrayList<BEContenedor> listar_tipos_direccion() throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_tipos_direccion();
    }    
    public ArrayList<BEContenedor> listar_tipos_moneda() throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_tipos_moneda();
    }
    public ArrayList<BEContenedor> listar_tipos_propiedad() throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_tipos_propiedad();
    }
    public ArrayList<BEContenedor> listar_unidades_metricas() throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_unidades_metricas();
    }
    public ArrayList<BEContenedor> listar_tipo_documento() throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_tipo_documento();
    }
    public ArrayList<BEContenedor> listar_modalidad() throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_modalidad();
    }
    public ArrayList<BEContenedor> listar_forma_adquisicion() throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_forma_adquisicion();
    }
    public ArrayList<BEContenedor> listar_estados_bien() throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_estados_bien();
    }
    public ArrayList<BEContenedor> listar_sistema_contenedor() throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_sistema_contenedor();
    }
    public ArrayList<BEContenedor> listar_modulos() throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_modulos();
    }
    public ArrayList<BECuentaContable> listar_cuentas_contables(int id_tipo_cuenta) throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_cuentas_contables(id_tipo_cuenta);
    }
    public ArrayList<BECuentaContable> listar_cuentas_contables_bien_patrimonial() throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_cuentas_contables_bien_patrimonial();
    }
    public ArrayList<BEContenedor> listar_causal_baja() throws Exception {
        dao = new DAContenedor(getConeccion());
        return dao.listar_causal_baja();
    }
}
