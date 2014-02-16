package org.sysconpat.rx.gui.models;

import org.rx.cr.gui.table.AbstractTableModel;
import org.sysconpat.rx.be.BECatalogo;

public class ModeloCatalogo extends AbstractTableModel<BECatalogo>{

    public ModeloCatalogo() {
        setTitles(new String[]{"COD. PAT.","DENOMINACION"});
    }
    
    @Override
    public Object getObjectCell(int fil, int col) {
       BECatalogo bean = get(fil);        
        switch(col){
            case 0: return bean.getCodigo_patrimonial();
            case 1: return bean.getDenominacion();
            default: return null;
        }
    }
    
}
