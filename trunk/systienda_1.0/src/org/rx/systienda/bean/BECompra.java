
package org.rx.systienda.bean;

import java.sql.Date;



public final class BECompra {
    private int cod_compra;
    private int cod_cuenta;
    private Date fecha_compra;
    //////////////////////////
    //pertenece a detalle de compra
    private int cant_comprada;
    private Date fecha_vencimiento;
    private int cod_producto;
    
    public BECompra(){
        setCod_compra(0);
        setCod_cuenta(0);
        setFecha_compra(null);
        //////////////////////
        setCant_comprada(0);
        setFecha_vencimiento(null);
        setCod_producto(0);
    }

    public int getCod_compra() {
        return cod_compra;
    }

    public void setCod_compra(int cod_compra) {
        this.cod_compra = cod_compra;
    }

    public int getCod_cuenta() {
        return cod_cuenta;
    }

    public void setCod_cuenta(int cod_cuenta) {
        this.cod_cuenta = cod_cuenta;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }
    
    @Override
    public String toString(){
       String msg="";        
        msg+=" Codigo de Compra       : "+getCod_compra()+"\n";
        msg+=" Codigo de Cuenta       : "+getCod_cuenta()+"\n";
        msg+=" Fecha de Compra        : "+getFecha_compra()+"\n";
        msg+=" Cantidad comprada      : "+getCant_comprada()+"\n";
        msg+=" Fecha de vencimiento   : "+getFecha_vencimiento()+"\n";
        msg+=" Codigo de producto     : "+getCod_producto()+"\n";
              
    return msg;
    }

    public int getCant_comprada() {
        return cant_comprada;
    }

    public void setCant_comprada(int cant_comprada) {
        this.cant_comprada = cant_comprada;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }
   
}
