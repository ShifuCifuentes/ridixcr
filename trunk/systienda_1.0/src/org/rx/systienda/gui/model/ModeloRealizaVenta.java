
package org.rx.systienda.gui.model;

import org.rx.cr.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.systienda.bean.BEProducto;

public class ModeloRealizaVenta extends AbstractTableModel<BEProducto> { 
       
    public ModeloRealizaVenta() {
        super.setTitles(new String[]{"Producto","Cantidad","Sub total"});
    }
    
    public double importeTotal(){
        double monto=0;    
            for (int i = 0; i < size(); i++) {           
               monto+=get(i).getPrecio_venta();
            }  
        return monto;
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        BEProducto bean = get(fil);        
        switch(col){
            case 0: return bean.getDenominacion_generico();
            case 1: return bean.getStock();
            case 2: return numberFormat(bean.getPrecio_venta(),"#.#");                
            default: return null;
        }
    }
}
