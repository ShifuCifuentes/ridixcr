package org.sysconpat.rx.be;

public final class BETipoCuenta {
    private int id_tipo;
    private String nombre_tipo;

    public static final int VALOR_DEFECTO=1,VALOR_ITEM=2;
    private int tipo_item;
    
    public BETipoCuenta() {
        setId_tipo(0);
        setNombre_tipo("");
        setTipo_item(VALOR_DEFECTO);
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
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
            case VALOR_ITEM: return getNombre_tipo();          
            default: return null;
        }        
    } 
    
}
