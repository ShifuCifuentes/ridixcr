package org.rx.systienda.gui.model;

import org.rx.cr.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.systienda.bean.BEProducto;

public class ModeloIngresarCompra extends AbstractTableModel<BEProducto> {    
       
    public ModeloIngresarCompra() {
        super.setTitles(new String[]{"ID","Producto","S.Actual","S.Fraccionario","S.Unitario"});
    }
    
    @Override
    public Object getObjectCell(int fil, int col) {
        BEProducto bean = get(fil);        
        switch(col){
            case 0: return numberFormat(bean.getId_producto(),"####");
            case 1: return bean.getNom_comercial();
            case 2: return bean.getStock();
            case 3: return bean.getStock_fraccionario();
            case 4: return bean.getStock_fraccionario_unitario();
            default: return null;
        }
    }
    
}
