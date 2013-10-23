package org.sysconpat.rx.be;

public final class BEContenedor {
    private int id_contenedor;
    private String id_tabla;
    private String id_subtabla;
    private String nombre;
    private String valor;
    private boolean estado;

   public static final int VALOR_DEFECTO=1,VALOR_ITEM=2;
    private int tipo_item;
    
    public BEContenedor() {
        setId_contenedor(0);
        setId_tabla("");
        setId_subtabla("");
        setNombre("");
        setValor("");
        setEstado(false);
        setTipo_item(VALOR_DEFECTO);
    }   

    public int getId_contenedor() {
        return id_contenedor;
    }

    public void setId_contenedor(int id_contenedor) {
        this.id_contenedor = id_contenedor;
    }

    public String getId_tabla() {
        return id_tabla;
    }

    public void setId_tabla(String id_tabla) {
        this.id_tabla = id_tabla;
    }

    public String getId_subtabla() {
        return id_subtabla;
    }

    public void setId_subtabla(String id_subtabla) {
        this.id_subtabla = id_subtabla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
            case VALOR_ITEM: return getNombre();          
            default: return null;
        }        
    } 
}
