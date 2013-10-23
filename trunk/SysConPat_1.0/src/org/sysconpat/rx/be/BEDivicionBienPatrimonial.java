package org.sysconpat.rx.be;

import java.sql.Date;

public final class BEDivicionBienPatrimonial {
  private int id_bien_patrimonial;
  private String denominacion;
  private double precio_adquisicion;
  private Date fecha_adquisicion;
  private int estado;
  private String observacion;
  private int sistema_contenedor;
  private int id_divicion_bien_patrimonial;

    public BEDivicionBienPatrimonial() {
        setId_bien_patrimonial(0);
        setDenominacion("");
        setPrecio_adquisicion(0);
        setFecha_adquisicion(new Date(-1900,0,1));
        setEstado(0);
        setObservacion("");
        setSistema_contenedor(0);
        setId_divicion_bien_patrimonial(0);
    }

    public int getId_bien_patrimonial() {
        return id_bien_patrimonial;
    }

    public void setId_bien_patrimonial(int id_bien_patrimonial) {
        this.id_bien_patrimonial = id_bien_patrimonial;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public double getPrecio_adquisicion() {
        return precio_adquisicion;
    }

    public void setPrecio_adquisicion(double precio_adquisicion) {
        this.precio_adquisicion = precio_adquisicion;
    }

    public Date getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    public void setFecha_adquisicion(Date fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getSistema_contenedor() {
        return sistema_contenedor;
    }

    public void setSistema_contenedor(int sistema_contenedor) {
        this.sistema_contenedor = sistema_contenedor;
    }

    public int getId_divicion_bien_patrimonial() {
        return id_divicion_bien_patrimonial;
    }

    public void setId_divicion_bien_patrimonial(int id_divicion_bien_patrimonial) {
        this.id_divicion_bien_patrimonial = id_divicion_bien_patrimonial;
    }
  
  
}
