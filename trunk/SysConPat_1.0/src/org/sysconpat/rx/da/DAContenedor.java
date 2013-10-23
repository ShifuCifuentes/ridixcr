package org.sysconpat.rx.da;

import java.sql.Connection;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.sysconpat.rx.be.BEContenedor;
import org.sysconpat.rx.be.BECuentaContable;
import org.sysconpat.rx.be.BETipoCuenta;

public class DAContenedor extends DAOAbstract<BEContenedor> {

    public DAContenedor(Connection conn) {
        setConnection(conn);
    }
    //<editor-fold defaultstate="collapsed" desc="Funciones No Utilizadas">
    @Deprecated
    @Override
    public int registrar(BEContenedor tipo) throws Exception {
        throw null;
    }
    @Deprecated
    @Override
    public int actualizarRegistro(BEContenedor tipo) throws Exception {
        throw null;
    }
    @Deprecated
    @Override
    public int eliminarRegistro(BEContenedor tipo) throws Exception {
        throw null;
    }
    @Deprecated
    @Override
    public ArrayList<BEContenedor> buscarReferencia(String string) {
        throw null;
    }
    @Deprecated
    @Override
    public ArrayList<BEContenedor> listar() throws Exception {
        throw null;
    }
    @Deprecated
    @Override
    public BEContenedor buscar(int i) throws Exception {
        throw null;
    }
    //</editor-fold>
    public ArrayList<BETipoCuenta> listar_tipos_cuenta_locales() throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_tipos_cuenta_locales");
            commitc();
            while (existResult()) {
                BETipoCuenta bean = new BETipoCuenta();
                bean.setId_tipo(getDataInt(1));
                bean.setNombre_tipo(getDataString(2));   
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
    public ArrayList<BEContenedor> listar_oficinas_registral() throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_oficinas_registral");
            commitc();
            while (existResult()) {
                BEContenedor bean = new BEContenedor();
                bean.setId_contenedor(getDataInt(1));
                bean.setId_tabla(getDataString(2));
                bean.setId_subtabla(getDataString(3));
                bean.setNombre(getDataString(4));
                bean.setValor(getDataString(5));
                bean.setEstado(getDataBoolean(6));
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
    public ArrayList<BEContenedor> listar_tipos_direccion() throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_tipos_direccion");
            commitc();
            while (existResult()) {
                BEContenedor bean = new BEContenedor();
                bean.setId_contenedor(getDataInt(1));
                bean.setId_tabla(getDataString(2));
                bean.setId_subtabla(getDataString(3));
                bean.setNombre(getDataString(4));
                bean.setValor(getDataString(5));
                bean.setEstado(getDataBoolean(6));
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
    public ArrayList<BEContenedor> listar_tipos_moneda() throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_tipos_moneda");
            commitc();
            while (existResult()) {
                BEContenedor bean = new BEContenedor();
                bean.setId_contenedor(getDataInt(1));
                bean.setId_tabla(getDataString(2));
                bean.setId_subtabla(getDataString(3));
                bean.setNombre(getDataString(4));
                bean.setValor(getDataString(5));
                bean.setEstado(getDataBoolean(6));
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
    public ArrayList<BEContenedor> listar_tipos_propiedad() throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_tipos_propiedad");
            commitc();
            while (existResult()) {
                BEContenedor bean = new BEContenedor();
                bean.setId_contenedor(getDataInt(1));
                bean.setId_tabla(getDataString(2));
                bean.setId_subtabla(getDataString(3));
                bean.setNombre(getDataString(4));
                bean.setValor(getDataString(5));
                bean.setEstado(getDataBoolean(6));
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
    public ArrayList<BEContenedor> listar_unidades_metricas() throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_unidades_metricas");
            commitc();
            while (existResult()) {
                BEContenedor bean = new BEContenedor();
                bean.setId_contenedor(getDataInt(1));
                bean.setId_tabla(getDataString(2));
                bean.setId_subtabla(getDataString(3));
                bean.setNombre(getDataString(4));
                bean.setValor(getDataString(5));
                bean.setEstado(getDataBoolean(6));
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
    public ArrayList<BEContenedor> listar_tipo_documento() throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_tipo_documento");
            commitc();
            while (existResult()) {
                BEContenedor bean = new BEContenedor();
                bean.setId_contenedor(getDataInt(1));
                bean.setId_tabla(getDataString(2));
                bean.setId_subtabla(getDataString(3));
                bean.setNombre(getDataString(4));
                bean.setValor(getDataString(5));
                bean.setEstado(getDataBoolean(6));
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
    public ArrayList<BEContenedor> listar_modalidad() throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_modalidades");
            commitc();
            while (existResult()) {
                BEContenedor bean = new BEContenedor();
                bean.setId_contenedor(getDataInt(1));
                bean.setId_tabla(getDataString(2));
                bean.setId_subtabla(getDataString(3));
                bean.setNombre(getDataString(4));
                bean.setValor(getDataString(5));
                bean.setEstado(getDataBoolean(6));
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
    public ArrayList<BEContenedor> listar_forma_adquisicion() throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_forma_adquisicion");
            commitc();
            while (existResult()) {
                BEContenedor bean = new BEContenedor();
                bean.setId_contenedor(getDataInt(1));
                bean.setId_tabla(getDataString(2));
                bean.setId_subtabla(getDataString(3));
                bean.setNombre(getDataString(4));
                bean.setValor(getDataString(5));
                bean.setEstado(getDataBoolean(6));
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
    public ArrayList<BEContenedor> listar_estados_bien() throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_estados_bien");
            commitc();
            while (existResult()) {
                BEContenedor bean = new BEContenedor();
                bean.setId_contenedor(getDataInt(1));
                bean.setId_tabla(getDataString(2));
                bean.setId_subtabla(getDataString(3));
                bean.setNombre(getDataString(4));
                bean.setValor(getDataString(5));
                bean.setEstado(getDataBoolean(6));
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
    public ArrayList<BEContenedor> listar_sistema_contenedor() throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_sistema_contenedor");
            commitc();
            while (existResult()) {
                BEContenedor bean = new BEContenedor();
                bean.setId_contenedor(getDataInt(1));
                bean.setId_tabla(getDataString(2));
                bean.setId_subtabla(getDataString(3));
                bean.setNombre(getDataString(4));
                bean.setValor(getDataString(5));
                bean.setEstado(getDataBoolean(6));
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
    public ArrayList<BECuentaContable> listar_cuentas_contables(int id_tipo_cuenta) throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_cuentas_contables");
            setParameterInt(id_tipo_cuenta);
            commitc();
            while (existResult()) {
                BECuentaContable bean = new BECuentaContable();
                bean.setId_cuenta_contable(getDataInt(1));
                bean.setNro_cuenta_contable(getDataString(2));
                bean.setNombre_cuenta_contable(getDataString(3));
                bean.setTipo(getDataString(4));
                bean.setId_tipo(getDataInt(5));
                bean.setId_tipox(getDataString(6));
                bean.setDepreciacion(getDataInt(7));
                bean.setParent(getDataString(8));
                bean.setNivel(getDataInt(9));
                bean.setDepresiable(getDataString(10));                
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
    public ArrayList<BECuentaContable> listar_cuentas_contables_bien_patrimonial() throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_cuentas_contables_bien_patrimonial");
            commitc();
            while (existResult()) {
                BECuentaContable bean = new BECuentaContable();
                                bean.setId_cuenta_contable(getDataInt(1));
                                bean.setNro_cuenta_contable(getDataString(2));
                                bean.setNombre_cuenta_contable(getDataString(3));
                                bean.setTipo(getDataString(4));
                                bean.setId_tipo(getDataInt(5));
                                bean.setId_tipox(getDataString(6));
                                bean.setDepreciacion(getDataInt(7));
                                bean.setParent(getDataString(8));
                                bean.setNivel(getDataInt(9));
                                bean.setDepresiable(getDataString(10));                
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
    public ArrayList<BEContenedor> listar_modulos() throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_modulos");
            commitc();
            while (existResult()) {
                BEContenedor bean = new BEContenedor();
                bean.setId_contenedor(getDataInt(1));
                bean.setId_tabla(getDataString(2));
                bean.setId_subtabla(getDataString(3));
                bean.setNombre(getDataString(4));
                bean.setValor(getDataString(5));
                bean.setEstado(getDataBoolean(6));
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
    public ArrayList<BEContenedor> listar_causal_baja() throws Exception {
        try {
            clear();
            setStoreProcedure("dbo.listar_causal_baja");
            commitc();
            while (existResult()) {
                BEContenedor bean = new BEContenedor();
                bean.setId_contenedor(getDataInt(1));
                bean.setId_tabla(getDataString(2));
                bean.setId_subtabla(getDataString(3));
                bean.setNombre(getDataString(4));
                bean.setValor(getDataString(5));
                bean.setEstado(getDataBoolean(6));
                add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }
    }
}
