package org.rx.systienda.gui.model;


import java.util.ArrayList;
import org.rx.cr.table.AbstractTableModel;
import org.rx.systienda.bean.BEProducto;

public class ModeloRalizarEntrega extends AbstractTableModel<BEProducto> {
    private ArrayList<BEProducto> listaAux=null;
        
    public ModeloRalizarEntrega() {
        super.setTitles(new String[]{"Producto","Presentacion","Stock","S.Fraccionario","S.Sub-Fraccionario"});
        listaAux = new ArrayList<BEProducto>();
    }
    
    @Override
    public void addAll(ArrayList lst){  
      lst.addAll(listaAux);
      super.addAll(lst);   
    }
    
    @Override
    public void add(BEProducto obj){
        super.add(obj);         
        listaAux.add(obj);        
    }
    
    public ArrayList<BEProducto> getListaAux() {
        return listaAux;
    }

    @Override
    public Object getObjectCell(int fil, int col) {
        BEProducto bean = get(fil);        
        switch(col){
            case 0: return bean.getNom_comercial();
            case 1: return bean.getPresentacion();
            case 2: return bean.getStock();
            case 3: return bean.getStock_fraccionario();
            case 4: return bean.getStock_fraccionario_unitario();
            default: return null;
        }
    }
}
