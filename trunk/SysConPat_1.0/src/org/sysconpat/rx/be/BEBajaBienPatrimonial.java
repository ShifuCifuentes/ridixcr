package org.sysconpat.rx.be;

import java.sql.Date;

public final class BEBajaBienPatrimonial {
  private int id_baja;
  private int id_bien;
  private int id_cta_contable;
  private int id_personal;
  private Date fecha_baja;
  private int cantidad;
  private String resolucion_baja;
  private String doc_sbn;
  private int tipo_cuenta;
  private int causal_baja;

    public BEBajaBienPatrimonial() {
        setId_baja(0);
        setId_bien(0);
        setId_cta_contable(0);
        setId_personal(0);
        setFecha_baja(new Date(-1900,0,1));        
        setCantidad(0);
        setResolucion_baja("");
        setDoc_sbn("");
        setTipo_cuenta(0);
        setCausal_baja(0);
    }

    public int getId_baja() {
        return id_baja;
    }

    public void setId_baja(int id_baja) {
        this.id_baja = id_baja;
    }

    public int getId_bien() {
        return id_bien;
    }

    public void setId_bien(int id_bien) {
        this.id_bien = id_bien;
    }

    public int getId_cta_contable() {
        return id_cta_contable;
    }

    public void setId_cta_contable(int id_cta_contable) {
        this.id_cta_contable = id_cta_contable;
    }

    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getResolucion_baja() {
        return resolucion_baja;
    }

    public void setResolucion_baja(String resolucion_baja) {
        this.resolucion_baja = resolucion_baja;
    }

    public String getDoc_sbn() {
        return doc_sbn;
    }

    public void setDoc_sbn(String doc_sbn) {
        this.doc_sbn = doc_sbn;
    }

    public int getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(int tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public int getCausal_baja() {
        return causal_baja;
    }

    public void setCausal_baja(int causal_baja) {
        this.causal_baja = causal_baja;
    }
  
  
}
