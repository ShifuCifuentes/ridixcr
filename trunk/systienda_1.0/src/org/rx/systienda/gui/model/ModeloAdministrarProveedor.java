
package org.rx.systienda.gui.model;

import org.rx.cr.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.systienda.bean.BEProveedor;


public class ModeloAdministrarProveedor extends AbstractTableModel<BEProveedor> {    
       
    public ModeloAdministrarProveedor() {
        super.setTitles(new String[]{"ID","Nombre Fabricante","Fecha Registro"});
    }
    
    @Override
    public Object getObjectCell(int fil, int col) {
        BEProveedor bean = get(fil);        
        switch(col){
            case 0: return numberFormat(bean.getId_proveedor(),"####");
            case 1: return bean.getRazon_social();
            case 2: return bean.getFecha_registro();
            default: return null;
        }
    }
}
