package org.sysconpat.rx.gui.models;

import org.rx.cr.gui.table.AbstractTableModel;
import org.sysconpat.rx.be.BELocal;

public class ModeloLocal extends AbstractTableModel<BELocal> {

    public ModeloLocal() {
        setTitles(new String[]{"Local","Direccion"});
    }

    
    @Override
    public Object getObjectCell(int fil, int col) {
        BELocal bean = get(fil);        
        switch(col){
            case 0: return bean.getNombre();
            case 1: return bean.getDireccion();
            default: return null;
        }
    }
    
}
