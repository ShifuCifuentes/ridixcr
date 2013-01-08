
package org.rx.systienda.bean;

import java.sql.Date;

public final class BEVenta {
    private int cod_venta;
    private int cod_cuenta;
    private Date fecha_venta;
    
    //////////////////////////////
    //pertenecen a detalle de venta
    private int cant_venta;
    private int cod_producto;
    
    
    public BEVenta(){
        setCod_venta(0);
        setCod_cuenta(0);
        setFecha_venta(null);
        ////////////////////
        setCant_venta(0);
        setCod_producto(0);
    }

    public int getCod_venta() {
        return cod_venta;
    }

    public void setCod_venta(int cod_venta) {
        this.cod_venta = cod_venta;
    }

    public int getCod_cuenta() {
        return cod_cuenta;
    }

    public void setCod_cuenta(int cod_cuenta) {
        this.cod_cuenta = cod_cuenta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
    
    @Override
    public String toString(){
           String msg="";        
        msg+=" Codigo de venta        : "+getCod_venta()+"\n";
        msg+=" Codigo de cuenta       : "+getCod_cuenta()+"\n";
        msg+=" Fecha de Venta         : "+getFecha_venta()+"\n";
        msg+=" Cantidad venta         : "+getCant_venta()+"\n";
        msg+="Codigo Produco          : "+getCod_producto()+"\n";
               
    return msg;
    }

    public int getCant_venta() {
        return cant_venta;
    }

    public void setCant_venta(int cat_venta) {
        this.cant_venta = cat_venta;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }
                        
}
