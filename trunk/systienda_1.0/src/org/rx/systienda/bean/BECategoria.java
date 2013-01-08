
package org.rx.systienda.bean;

public final class BECategoria {
    private int id_categoria;
    private String denominacion_categoria;
    private String cod_resumen_genero;

    public BECategoria(){
    setId_categoria(0);
    setDenominacion_categoria(null);
    setCod_resumen_categoria(null);
    }
    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_genero) {
        this.id_categoria = id_genero;
    }

    public String getDenominacion_categoria() {
        return denominacion_categoria;
    }

    public void setDenominacion_categoria(String denominacion_genero) {
        this.denominacion_categoria = denominacion_genero;
    }

    public String getCod_resumen_categoria() {
        return cod_resumen_genero;
    }

    public void setCod_resumen_categoria(String cod_resumen_genero) {
        this.cod_resumen_genero = cod_resumen_genero;
    }
    
    
  }
