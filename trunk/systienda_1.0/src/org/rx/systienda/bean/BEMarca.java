
package org.rx.systienda.bean;

public final class BEMarca {
    private int id_marca;
    private String denominacion;
    
    public BEMarca(){
    setId_marca(0);
    setDenominacion(null);
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
}
