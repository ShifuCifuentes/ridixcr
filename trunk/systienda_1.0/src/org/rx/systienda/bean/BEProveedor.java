
package org.rx.systienda.bean;

import java.sql.Date;

public final class BEProveedor {    
    private String razon_social;
    private String representante;
    private String direccion;
    private String telefono;
    private Date fecha_registro;
    private int id_proveedor;

    public BEProveedor() {
    setRepresentante(null);
    setDireccion(null);
    setTelefono(null);
    setFecha_registro(null);
    setId_proveedor(0);
    setRazon_social(null);
}
        
    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    @Override
    public String toString(){
        String msg="";        
        msg+=" Nombre fabricante        : "+getRepresentante()+"\n";
        msg+=" Razon Social             : "+getRazon_social()+"\n";
        msg+=" Direccion                : "+getDireccion()+"\n";
        msg+=" Telefono                 : "+getTelefono()+"\n";
        msg+=" Fecha de registro        : "+getFecha_registro()+"\n";
        msg+=" Codigo de fabricante      : "+getId_proveedor()+"\n";
        
    return msg;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }
 
}
