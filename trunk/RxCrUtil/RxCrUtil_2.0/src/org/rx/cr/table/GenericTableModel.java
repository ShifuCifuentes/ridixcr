package org.rx.cr.table;

import org.RidixCr;
import static org.rx.cr.util.Utilitarios.*;

public interface GenericTableModel<Tipo> {
    @RidixCr(author=RidixCr)
    public Object getObjectCell(int fil,int col);
}
