
package org.rx.systienda.gui.model;

import org.rx.cr.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.systienda.bean.BEPersonal;

public class ModeloRegistrarProducto extends AbstractTableModel<BEPersonal> {    
      
    public ModeloRegistrarProducto() {
        super.setTitles(new String[]{"Codigo","Denominacion","Cantidad"});
    }    
    @Override
    public Object getObjectCell(int fil, int col) {
        BEPersonal bean = get(fil);        
        switch(col){
            case 0: return numberFormat(bean.getCodigo_empleado(),"####");
            case 1: return bean.getAp_paterno()+" "+bean.getAp_maternno()+" "+bean.getNombres();
            case 2: return null;
            default: return null;
        }
    }
}
