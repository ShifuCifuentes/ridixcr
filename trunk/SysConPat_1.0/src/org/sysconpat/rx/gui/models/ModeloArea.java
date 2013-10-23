package org.sysconpat.rx.gui.models;

import org.rx.cr.gui.table.AbstractTableModel;
import org.sysconpat.rx.be.BEArea;

public class ModeloArea extends AbstractTableModel<BEArea> {

    public ModeloArea() {
        setTitles(new String[]{"Sigla","Area"});
    }

    
    @Override
    public Object getObjectCell(int fil, int col) {
        BEArea bean = get(fil);        
        switch(col){
            case 0: return bean.getSigla();
            case 1: return bean.getNombre_area();
            default: return null;
        }
    }
    
}
