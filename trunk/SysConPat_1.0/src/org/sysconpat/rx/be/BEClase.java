package org.sysconpat.rx.be;

public final class BEClase {
    private int id_clase;
    private String denominacion;

    public static final int VALOR_DEFECTO=1,VALOR_ITEM=2;
    private int tipo_item;
    
    public BEClase() {
        setId_clase(0);
        setDenominacion("");
        setTipo_item(VALOR_DEFECTO);
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getTipo_item() {
        return tipo_item;
    }

    public void setTipo_item(int tipo_item) {
        this.tipo_item = tipo_item;
    }
    
    @Override
    public String toString() {
        switch(getTipo_item()){
            case VALOR_DEFECTO: return "<Seleccionar>";
            case VALOR_ITEM: return getDenominacion();          
            default: return null;
        }        
    } 
    
}
