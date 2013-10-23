package org.sysconpat.rx.be;

public final class BEGrupoGenerico {
    private int id_grupo_generico;
    private String denominacion;
    
    public static final int VALOR_DEFECTO=1,VALOR_ITEM=2;
    private int tipo_item;
    
    public BEGrupoGenerico() {
        setId_grupo_generico(0);
        setDenominacion("");
        setTipo_item(VALOR_DEFECTO);
    }

    public int getId_grupo_generico() {
        return id_grupo_generico;
    }

    public void setId_grupo_generico(int id_grupo_generico) {
        this.id_grupo_generico = id_grupo_generico;
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
