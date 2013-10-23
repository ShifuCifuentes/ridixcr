package org.sysconpat.rx.util;

import java.util.ArrayList;
import javax.swing.JComboBox;
import org.rx.cr.conf.Config;
import org.sysconpat.rx.be.BEArea;
import org.sysconpat.rx.be.BEClase;
import org.sysconpat.rx.be.BEContenedor;
import org.sysconpat.rx.be.BECuentaContable;
import org.sysconpat.rx.be.BEGrupoGenerico;
import org.sysconpat.rx.be.BELocal;
import org.sysconpat.rx.be.BEOficina;
import org.sysconpat.rx.be.BEPersonal;
import org.sysconpat.rx.be.BETipoCuenta;
import org.sysconpat.rx.bl.BLArea;
import org.sysconpat.rx.bl.BLClase;
import org.sysconpat.rx.bl.BLContenedor;
import org.sysconpat.rx.bl.BLGrupoGenerico;
import org.sysconpat.rx.bl.BLLocal;
import org.sysconpat.rx.bl.BLOficina;
import org.sysconpat.rx.bl.BLPersonal;

public class UtilContenedor {
    private Config config=null;
    
    public UtilContenedor(Config config) {
        this.config=config;
    }
    
    public void cargarTipoCuentaLocales(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLContenedor bl = new BLContenedor(config);
        ArrayList<BETipoCuenta> list = bl.listar_tipos_cuenta_locales();
        cbx.addItem(new BETipoCuenta());
        for (BETipoCuenta bEContenedor : list) {
            bEContenedor.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(bEContenedor);
        }
    }
    public void cargarOficinaRegistral(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLContenedor bl = new BLContenedor(config);
        ArrayList<BEContenedor> list = bl.listar_oficinas_registral();
        cbx.addItem(new BEContenedor());
        for (BEContenedor bEContenedor : list) {
            bEContenedor.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(bEContenedor);
        }
    }
    public void cargarTiposDireccion(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLContenedor bl = new BLContenedor(config);
        ArrayList<BEContenedor> list = bl.listar_tipos_direccion();
        cbx.addItem(new BEContenedor());
        for (BEContenedor bEContenedor : list) {
            bEContenedor.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(bEContenedor);
        }
    }
    public void cargarCausalBaja(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLContenedor bl = new BLContenedor(config);
        ArrayList<BEContenedor> list = bl.listar_causal_baja();
        cbx.addItem(new BEContenedor());
        for (BEContenedor bEContenedor : list) {
            bEContenedor.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(bEContenedor);
        }
    }
    public void cargarFormaAdquisicion(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLContenedor bl = new BLContenedor(config);
        ArrayList<BEContenedor> list = bl.listar_forma_adquisicion();
        cbx.addItem(new BEContenedor());
        for (BEContenedor bEContenedor : list) {
            bEContenedor.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(bEContenedor);
        }
    }
    public void cargarEstadosBien(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLContenedor bl = new BLContenedor(config);
        ArrayList<BEContenedor> list = bl.listar_estados_bien();
        cbx.addItem(new BEContenedor());
        for (BEContenedor bEContenedor : list) {
            bEContenedor.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(bEContenedor);
        }
    }
    public void cargarTiposMoneda(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLContenedor bl = new BLContenedor(config);
        ArrayList<BEContenedor> list = bl.listar_tipos_moneda();
        cbx.addItem(new BEContenedor());
        for (BEContenedor bEContenedor : list) {
            bEContenedor.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(bEContenedor);
        }
    }
    public void cargarTiposPropiedad(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLContenedor bl = new BLContenedor(config);
        ArrayList<BEContenedor> list = bl.listar_tipos_propiedad();
        cbx.addItem(new BEContenedor());
        for (BEContenedor bEContenedor : list) {
            bEContenedor.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(bEContenedor);
        }
    }
    public void cargarUnidadesMetricas(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLContenedor bl = new BLContenedor(config);
        ArrayList<BEContenedor> list = bl.listar_unidades_metricas();
        cbx.addItem(new BEContenedor());
        for (BEContenedor bEContenedor : list) {
            bEContenedor.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(bEContenedor);
        }
    }
    public void cargarTipoDocumento(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLContenedor bl = new BLContenedor(config);
        ArrayList<BEContenedor> list = bl.listar_tipo_documento();
        cbx.addItem(new BEContenedor());
        for (BEContenedor bEContenedor : list) {
            bEContenedor.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(bEContenedor);
        }
    }
    public void cargarModalidad(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLContenedor bl = new BLContenedor(config);
        ArrayList<BEContenedor> list = bl.listar_modalidad();
        cbx.addItem(new BEContenedor());
        for (BEContenedor bEContenedor : list) {
            bEContenedor.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(bEContenedor);
        }
    }
    public void cargarSistemaContenedor(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLContenedor bl = new BLContenedor(config);
        ArrayList<BEContenedor> list = bl.listar_sistema_contenedor();
        cbx.addItem(new BEContenedor());
        for (BEContenedor bEContenedor : list) {
            bEContenedor.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(bEContenedor);
        }
    }
    public void cargarCuentasContables(JComboBox cbx,int id_tipo) throws Exception {
        cbx.removeAllItems();
        BLContenedor bl = new BLContenedor(config);
        ArrayList<BECuentaContable> list = bl.listar_cuentas_contables(id_tipo);
        cbx.addItem(new BEContenedor());
        for (BECuentaContable bEContenedor : list) {
            bEContenedor.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(bEContenedor);
        }
    }
    public void cargarCuentasContablesBienPatrimonial(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLContenedor bl = new BLContenedor(config);
        ArrayList<BECuentaContable> list = bl.listar_cuentas_contables_bien_patrimonial();
        cbx.addItem(new BEContenedor());
        for (BECuentaContable bEContenedor : list) {
            bEContenedor.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(bEContenedor);
        }
    }
    public void seleccionarItemComboContenedor(JComboBox cbx,int id){
        for (int i=0;i<cbx.getItemCount();i++) {            
            if(cbx.getItemAt(i) instanceof BEContenedor && ((BEContenedor)cbx.getItemAt(i)).getId_contenedor()==id){
                cbx.setSelectedIndex(i);
                break;
            }
        }
    }
    public void seleccionarItemComboTipoCuenta(JComboBox cbx,int id){
        for (int i=0;i<cbx.getItemCount();i++) {            
            if(cbx.getItemAt(i) instanceof BETipoCuenta && ((BETipoCuenta)cbx.getItemAt(i)).getId_tipo()==id){
                cbx.setSelectedIndex(i);
                break;
            }else if(cbx.getItemAt(i) instanceof String){
                break;
            }
        }
    }
    public void seleccionarItemComboLocal(JComboBox cbx,int id){
        for (int i=0;i<cbx.getItemCount();i++) {            
            if(cbx.getItemAt(i) instanceof BELocal && ((BELocal)cbx.getItemAt(i)).getId_local()==id){
                cbx.setSelectedIndex(i);
                break;
            }else if(cbx.getItemAt(i) instanceof String){
                break;
            }
        }
    }
    public void seleccionarItemComboArea(JComboBox cbx,int id){
        for (int i=0;i<cbx.getItemCount();i++) {            
            if(cbx.getItemAt(i) instanceof BEArea && ((BEArea)cbx.getItemAt(i)).getId_area()==id){
                cbx.setSelectedIndex(i);
                break;
            }else if(cbx.getItemAt(i) instanceof String){
                break;
            }
        }
    }
    public void seleccionarItemComboOficina(JComboBox cbx,int id){
        for (int i=0;i<cbx.getItemCount();i++) {            
            if(cbx.getItemAt(i) instanceof BEOficina && ((BEOficina)cbx.getItemAt(i)).getId_oficina()==id){
                cbx.setSelectedIndex(i);
                break;
            }else if(cbx.getItemAt(i) instanceof String){
                break;
            }
        }
    }
    public void seleccionarItemComboPersonal(JComboBox cbx,int id){
        for (int i=0;i<cbx.getItemCount();i++) {            
            if(cbx.getItemAt(i) instanceof BEPersonal && ((BEPersonal)cbx.getItemAt(i)).getId_personal()==id){
                cbx.setSelectedIndex(i);
                break;
            }else if(cbx.getItemAt(i) instanceof String){
                break;
            }
        }
    }
    public void seleccionarItemComboCuenta(JComboBox cbx,int id){
        for (int i=0;i<cbx.getItemCount();i++) {            
            if(cbx.getItemAt(i) instanceof BECuentaContable && ((BECuentaContable)cbx.getItemAt(i)).getId_cuenta_contable()==id){
                cbx.setSelectedIndex(i);
                break;
            }else if(cbx.getItemAt(i) instanceof String){
                break;
            }
        }
    }
    public void cargarLocales(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLLocal bl = new BLLocal(config);
        ArrayList<BELocal> list = bl.buscarReferencia("");
        cbx.addItem(new BELocal());
        for (BELocal be : list) {
            be.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(be);
        }
    }
    public void cargarAreas(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLArea bl = new BLArea(config);
        ArrayList<BEArea> list = bl.buscarReferencia("");
        cbx.addItem(new BEArea());
        for (BEArea be : list) {
            be.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(be);
        }
    }
    public void cargarAreas(JComboBox cbx,int id) throws Exception {
        cbx.removeAllItems();
        BLArea bl = new BLArea(config);
        ArrayList<BEArea> list = bl.buscarReferencia(id);
        cbx.addItem(new BEArea());
        for (BEArea be : list) {
            be.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(be);
        }
    }
    public void cargarOficinas(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLOficina bl = new BLOficina(config);
        ArrayList<BEOficina> list = bl.buscarReferencia("");
        cbx.addItem(new BEOficina());
        for (BEOficina be : list) {
            be.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(be);
        }
    }
    public void cargarOficinas(JComboBox cbx,int id) throws Exception {
        cbx.removeAllItems();
        BLOficina bl = new BLOficina(config);
        ArrayList<BEOficina> list = bl.buscarReferencia(id);
        cbx.addItem(new BEOficina());
        for (BEOficina be : list) {
            be.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(be);
        }
    }
    public void cargarPersonal(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLPersonal bl = new BLPersonal(config);
        ArrayList<BEPersonal> list = bl.buscarReferencia("");
        cbx.addItem(new BEPersonal());
        for (BEPersonal be : list) {
            be.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(be);
        }
    }
    public void cargarClase(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLClase bl = new BLClase(config);
        ArrayList<BEClase> list = bl.buscarReferencia("");
        cbx.addItem(new BEClase());
        for (BEClase be : list) {
            be.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(be);
        }
    }
    public void cargarGrupoGenerico(JComboBox cbx) throws Exception {
        cbx.removeAllItems();
        BLGrupoGenerico bl = new BLGrupoGenerico(config);
        ArrayList<BEGrupoGenerico> list = bl.buscarReferencia("");
        cbx.addItem(new BEGrupoGenerico());
        for (BEGrupoGenerico be : list) {
            be.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(be);
        }
    }
    public void cargarPersonal(JComboBox cbx,int id) throws Exception {
        cbx.removeAllItems();
        BLPersonal bl = new BLPersonal(config);
        ArrayList<BEPersonal> list = bl.buscarReferencia(id);
        cbx.addItem(new BEPersonal());
        for (BEPersonal be : list) {
            be.setTipo_item(BEContenedor.VALOR_ITEM);
            cbx.addItem(be);
        }
        cbx.setSelectedIndex(0);
    }
}
