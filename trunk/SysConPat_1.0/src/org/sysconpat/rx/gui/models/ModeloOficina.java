package org.sysconpat.rx.gui.models;

import org.rx.cr.gui.table.AbstractTableModel;
import org.sysconpat.rx.be.BEOficina;

public class ModeloOficina extends AbstractTableModel<BEOficina> {

    public ModeloOficina() {
        setTitles(new String[]{"Sigla","Oficina"});
    }

    
    @Override
    public Object getObjectCell(int fil, int col) {
        BEOficina bean = get(fil);        
        switch(col){
            case 0: return bean.getSigla();
            case 1: return bean.getNombre_oficina();
            default: return null;
        }
    }
    
}
