package org.sysconpat.rx.be;

public final class BEUbigeo {
    private int id_ubigeo;
    private String nombre_region;
    private int codigo_region;
    private String nombre_provincia;
    private int codigo_provincia;
    private String nombre_distrito;
    private int codigo_distrito;

    public static final int REGIONES=1,PROVINCIAS=2,DISTRITOS=3;
    private int tipo_item;

    public BEUbigeo() {
        setId_ubigeo(0);
        setNombre_region("");
        setCodigo_region(0);
        setNombre_provincia("");
        setCodigo_provincia(0);
        setNombre_distrito("");
        setCodigo_distrito(0);
    }

    public int getId_ubigeo() {
        return id_ubigeo;
    }

    public void setId_ubigeo(int id_ubigeo) {
        this.id_ubigeo = id_ubigeo;
    }

    public String getNombre_region() {
        return nombre_region;
    }

    public void setNombre_region(String nombre_region) {
        this.nombre_region = nombre_region;
    }

    public int getCodigo_region() {
        return codigo_region;
    }

    public void setCodigo_region(int codigo_region) {
        this.codigo_region = codigo_region;
    }

    public String getNombre_provincia() {
        return nombre_provincia;
    }

    public void setNombre_provincia(String nombre_provincia) {
        this.nombre_provincia = nombre_provincia;
    }

    public int getCodigo_provincia() {
        return codigo_provincia;
    }

    public void setCodigo_provincia(int codigo_provincia) {
        this.codigo_provincia = codigo_provincia;
    }

    public String getNombre_distrito() {
        return nombre_distrito;
    }

    public void setNombre_distrito(String nombre_distrito) {
        this.nombre_distrito = nombre_distrito;
    }

    public int getCodigo_distrito() {
        return codigo_distrito;
    }

    public void setCodigo_distrito(int codigo_distrito) {
        this.codigo_distrito = codigo_distrito;
    }

    public int getTipo_item() {
        return tipo_item;
    }

    public void setTipo_item(int tipo_item) {
        this.tipo_item = tipo_item;
    }
    @Override
    public String toString(){
     switch(getTipo_item()){
         case REGIONES: return getNombre_region();
         case PROVINCIAS: return getNombre_provincia();
         case DISTRITOS: return getNombre_distrito();
         default:return "<Seleccionar>";
     }     
    }
}
