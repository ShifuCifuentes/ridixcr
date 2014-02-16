package org.sysconpat.rx.gui.models;

import org.rx.cr.gui.table.AbstractTableModel;
import org.sysconpat.rx.be.BEBienPatrimonial;

public class ModeloBienPatrimonial extends AbstractTableModel<BEBienPatrimonial>{

    public ModeloBienPatrimonial() {
         setTitles(new String[]{"COD. PAT.","DENOMINACION"});
    }

    
    @Override
    public Object getObjectCell(int fil, int col) {
        BEBienPatrimonial bean = get(fil);        
        switch(col){
            case 0: return bean.getCodigo_patrimonial();
            case 1: return bean.getDenominacion();
            default: return null;
        }
    }
    
}
