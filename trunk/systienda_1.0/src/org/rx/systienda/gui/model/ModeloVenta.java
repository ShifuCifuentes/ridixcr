
package org.rx.systienda.gui.model;

import org.rx.cr.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.systienda.bean.BEProducto;


public class ModeloVenta extends AbstractTableModel<BEProducto> {   
      
    public ModeloVenta() {
        super.setTitles(new String[]{"Producto","Stock","S.Fraccionario","S.Sub-Fraccionario","Precio Unitario"});
    }
    
    @Override
    public Object getObjectCell(int fil, int col) {
        BEProducto bean = get(fil);        
        switch(col){
            case 0: return bean.getNom_comercial();            
            case 1: return bean.getStock();
            case 2: return bean.getStock_fraccionario();
            case 3: return bean.getStock_fraccionario_unitario();
            case 4: return numberFormat(bean.getPrecio_venta(),"#.#");                
            default: return null;
        }
    }
}
