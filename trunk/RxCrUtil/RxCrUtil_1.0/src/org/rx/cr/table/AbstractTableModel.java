
package org.rx.cr.table;

import java.util.ArrayList;
import org.RidixCr;
import static org.rx.cr.util.Utilitarios.*;

public abstract class AbstractTableModel<Tipo> extends javax.swing.table.AbstractTableModel implements GenericTableModel<Tipo> {
    private ArrayList<Tipo> listObjects=new ArrayList<Tipo>();    
    private String[] titles=null;
    @Override
    public String getColumnName(int column){
        return getTitles()[column];
    }
      
    @Override
    public int getRowCount() {
        return listObjects.size();
    }

    @Override
    public int getColumnCount() {
        return getTitles().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return getObjectCell(rowIndex, columnIndex);
    }
    @RidixCr(author=RidixCr)
    public void actualizarEstructuraTabla(){
     fireTableStructureChanged();
    }
    @RidixCr(author=RidixCr)
    public void actualizarDatosEstructuraTabla(){
     fireTableDataChanged();
    }
    @RidixCr(author=RidixCr)
    public void addAll(ArrayList lst){
      clear();
      listObjects.addAll(lst);
      actualizarEstructuraTabla();
    }
    @RidixCr(author=RidixCr)
    public void add(Tipo obj){
     listObjects.add(obj);
     actualizarEstructuraTabla();
    }
    @RidixCr(author=RidixCr)
    public void clear(){
     listObjects.clear();
     actualizarEstructuraTabla();
    }
    @RidixCr(author=RidixCr)
    public void remove(int index){
     listObjects.remove(index);
     actualizarEstructuraTabla();
    }
    @RidixCr(author=RidixCr)
    public Object get(int index){
     return listObjects.get(index);
    }
    @RidixCr(author=RidixCr)
    public int size() {
        return listObjects.size();
    }
    @RidixCr(author=RidixCr)
    public String[] getTitles() {
        return titles;
    }
    @RidixCr(author=RidixCr)
    public void setTitles(String[] titles) {
        this.titles = titles;
    }

}
