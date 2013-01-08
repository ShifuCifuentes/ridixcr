package org.rx.systienda.gui.model;

import org.rx.cr.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.systienda.bean.BEProducto;


public class ModeloAdministrarProducto extends AbstractTableModel<BEProducto> {       
    
    public ModeloAdministrarProducto() {
        super.setTitles(new String[]{"ID","Producto","Stok"});
    }
    
    @Override
    public Object getObjectCell(int fil, int col) {
        BEProducto bean = get(fil);        
        switch(col){
            case 0: return numberFormat(bean.getId_producto(),"####");
            case 1: return bean.getNom_comercial();
            case 2: return bean.getStock_fraccionario_unitario()*bean.getStock_fraccionario()*bean.getStock();///Atencion al Stock 
            default: return null;
        }
    }
}
