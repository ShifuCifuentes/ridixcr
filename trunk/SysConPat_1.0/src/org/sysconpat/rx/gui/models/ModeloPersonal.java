package org.sysconpat.rx.gui.models;

import org.rx.cr.gui.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;
import org.sysconpat.rx.be.BEPersonal;

public class ModeloPersonal extends AbstractTableModel<BEPersonal>  {

    public ModeloPersonal() {
        setTitles(new String[]{"DNI","Personal"});
    }

    
    @Override
    public Object getObjectCell(int fil, int col) {
        BEPersonal bean = get(fil);        
        switch(col){
            case 0: return bean.getNro_documento();
            case 1: return bean.getApellidos().toUpperCase()+", "+toUpperCaseInit(bean.getNombres());
            default: return null;
        }
    }
    
}
