
package org.rx.systienda.gui.model;

import org.rx.cr.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.systienda.bean.BEPersonal;


public class ModeloAdministrarEmpleado extends AbstractTableModel<BEPersonal> {   
    
    public ModeloAdministrarEmpleado() {
        super.setTitles(new String[]{"ID","Nombre y Apellido","Usuario"});
    }
    
    @Override
    public Object getObjectCell(int fil, int col) {
        BEPersonal bean = get(fil);        
        switch(col){
            case 0: return numberFormat(bean.getCodigo_empleado(),"####");
            case 1: return bean.getAp_paterno()+" "+bean.getAp_maternno()+", "+bean.getNombres();
            case 2: return bean.getNombre_cuenta();                          
            default: return null;
        }
    }
    
}
