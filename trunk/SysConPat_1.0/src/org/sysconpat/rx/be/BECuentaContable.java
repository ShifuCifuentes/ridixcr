package org.sysconpat.rx.be;

public final class BECuentaContable {
    private int id_cuenta_contable;
    private String nro_cuenta_contable;
    private String nombre_cuenta_contable;
    private String tipo;
    private int id_tipo;
    private String id_tipox;
    private int depreciacion;
    private String parent;
    private int nivel;
    private String depresiable;
    
    public static final int VALOR_DEFECTO=1,VALOR_ITEM=2;
    private int tipo_item;
    

    public BECuentaContable() {
        setId_cuenta_contable(0);
        setNro_cuenta_contable("");
        setNombre_cuenta_contable("");
        setTipo("");
        setId_tipo(0);
        setId_tipox("");
        setDepreciacion(0);
        setParent("");
        setNivel(0);
        setDepresiable("");
        setTipo_item(VALOR_DEFECTO);
    }

    public int getId_cuenta_contable() {
        return id_cuenta_contable;
    }

    public void setId_cuenta_contable(int id_cuenta_contable) {
        this.id_cuenta_contable = id_cuenta_contable;
    }

    public String getNro_cuenta_contable() {
        return nro_cuenta_contable;
    }

    public void setNro_cuenta_contable(String nro_cuenta_contable) {
        this.nro_cuenta_contable = nro_cuenta_contable;
    }

    public String getNombre_cuenta_contable() {
        return nombre_cuenta_contable;
    }

    public void setNombre_cuenta_contable(String nombre_cuenta_contable) {
        this.nombre_cuenta_contable = nombre_cuenta_contable;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getId_tipox() {
        return id_tipox;
    }

    public void setId_tipox(String id_tipox) {
        this.id_tipox = id_tipox;
    }

    public int getDepreciacion() {
        return depreciacion;
    }

    public void setDepreciacion(int depreciacion) {
        this.depreciacion = depreciacion;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getDepresiable() {
        return depresiable;
    }

    public void setDepresiable(String depresiable) {
        this.depresiable = depresiable;
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
            case VALOR_ITEM: return (getNro_cuenta_contable()+"|"+getNombre_cuenta_contable()).toUpperCase();     
            default: return null;
        }        
    } 
}
