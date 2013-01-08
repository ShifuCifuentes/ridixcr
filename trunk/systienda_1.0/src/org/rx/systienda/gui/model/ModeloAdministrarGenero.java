
package org.rx.systienda.gui.model;

import org.rx.cr.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.systienda.bean.BECategoria;

public class ModeloAdministrarGenero extends AbstractTableModel<BECategoria> {    
    
    public ModeloAdministrarGenero() {
        super.setTitles(new String[]{"ID","Genero"});
    }
    
    @Override
    public Object getObjectCell(int fil, int col) {
        BECategoria bean = get(fil);        
        switch(col){
            case 0: return numberFormat(bean.getId_categoria(),"####");
            case 1: return bean.getDenominacion_categoria();            
            default: return null;
        }
    }
}
