package org.sysconpat.rx.be;

public final class BEOficina {
    private int id_oficina;
    private int id_local;
    private int id_area;
    private String nombre_oficina;
    private String sigla;
    
    public static final int VALOR_DEFECTO=1,VALOR_ITEM=2;
    private int tipo_item;

    public BEOficina() {
        setTipo_item(VALOR_DEFECTO);
    }

    public int getId_oficina() {
        return id_oficina;
    }

    public void setId_oficina(int id_oficina) {
        this.id_oficina = id_oficina;
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getNombre_oficina() {
        return nombre_oficina;
    }

    public void setNombre_oficina(String nombre_area) {
        this.nombre_oficina = nombre_area;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
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
            case VALOR_ITEM: return getNombre_oficina();         
            default: return null;
        }        
    }     
}
