package org.sysconpat.rx.gui.models;

import org.rx.cr.gui.table.AbstractTableModel;
import org.rx.cr.util.Utilitarios;
import org.sysconpat.rx.be.BEDivicionBienPatrimonial;

public class ModeloDivicionBienPatrimonial  extends AbstractTableModel<BEDivicionBienPatrimonial>{

    public ModeloDivicionBienPatrimonial() {
        setTitles(new String[]{"DENOMINACION","FECHA ADQ.","PRECIO ADQ."});
    }
    
    @Override
    public Object getObjectCell(int fil, int col) {
        BEDivicionBienPatrimonial bean = get(fil);        
        switch(col){
            case 0: return bean.getDenominacion();
            case 1: return bean.getFecha_adquisicion().toString();
            case 2: return Utilitarios.numberFormat(bean.getPrecio_adquisicion(),"#.##");
            default: return null;
        }
    }
    
}
