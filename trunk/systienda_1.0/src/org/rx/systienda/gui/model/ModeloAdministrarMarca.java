
package org.rx.systienda.gui.model;

import org.rx.cr.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.systienda.bean.BEMarca;

public class ModeloAdministrarMarca extends AbstractTableModel<BEMarca> {   
      
    public ModeloAdministrarMarca() {
        super.setTitles(new String[]{"ID","Marca"});
    }    
    @Override
    public Object getObjectCell(int fil, int col) {
       BEMarca bean = get(fil);        
        switch(col){
            case 0: return numberFormat(bean.getId_marca(),"####");
            case 1: return bean.getDenominacion();                              
            default: return null;
        }
    }
}
