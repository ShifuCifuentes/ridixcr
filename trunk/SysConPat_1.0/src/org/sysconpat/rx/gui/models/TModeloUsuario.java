package org.sysconpat.rx.gui.models;

import org.rx.cr.gui.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;
import org.sysconpat.rx.be.BEUsuario;

public class TModeloUsuario extends AbstractTableModel<BEUsuario>{

    public TModeloUsuario() {
        setTitles(new String[]{"ID","Personal","Estado"});
    }

    
    @Override
    public Object getObjectCell(int i, int i1) {
        BEUsuario bean = get(i);        
        switch(i1){
            case 0: return numberFormat(bean.getId_usuario(),"####");
            case 1: return bean.getApellido_paterno().toUpperCase()+" "+bean.getApellido_materno().toUpperCase()+", "+toUpperCaseInit(bean.getNombres());
            case 2: return bean.getEstado()?"Activo":"Inactivo";
            default: return null;
        }
    }
    
}
