package org.sysconpat.rx.gui.models;

import org.rx.cr.gui.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;
import org.sysconpat.rx.be.BEContenedor;

public class TModeloRol extends AbstractTableModel<BEContenedor> {

    public TModeloRol() {
        setTitles(new String[]{"ID","Modulo"});
    }

    
    @Override
    public Object getObjectCell(int i, int i1) {
        BEContenedor bean = get(i);        
        switch(i1){
            case 0: return numberFormat(bean.getId_contenedor(),"####");
            case 1: return bean.getNombre();
            default: return null;
        }
    }
    
}
