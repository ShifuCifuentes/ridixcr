package org.rx.cr.test;

import org.RidixCr;
import org.rx.cr.gui.table.AbstractTableModel;
import static org.rx.cr.util.Utilitarios.*;

public class TableModelTest extends AbstractTableModel<Object> {  
    private Object obj=null;
    public TableModelTest() {      
      super.setTitles(new String[]{"Columna 1","Columna 2"});  
    }    
    @RidixCr(author=RidixCr)
    @Override
    public Object getObjectCell(int fil, int col) {
        obj = (Object)get(fil);        
        switch(col){
            case 0: return obj.toString();                 
            default: return null;
        }
    }
}
