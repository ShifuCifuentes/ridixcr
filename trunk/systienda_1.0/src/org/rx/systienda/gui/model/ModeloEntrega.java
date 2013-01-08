
package org.rx.systienda.gui.model;

import org.rx.cr.table.AbstractTableModel;
import org.rx.systienda.bean.BEProducto;


public class ModeloEntrega extends AbstractTableModel<BEProducto> {
    
    public ModeloEntrega() {
        super.setTitles(new String[]{"Producto","Presentacion","Stock"});
    }
    
    @Override
    public Object getObjectCell(int fil, int col) {
       BEProducto bean = get(fil);        
        switch(col){
            case 0: return bean.getNom_comercial();
            case 1: return bean.getPresentacion();
            case 2: return bean.getStock();             
            default: return null;
        }
    }
}
