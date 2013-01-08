
package org.rx.systienda.bean;

public final class BEAlmacenVenta {
    private int cod_producto;
    private int stock;
    private int stock_fraccionario_referencia;
    private int stock_fraccionario_actual;
    private int stock_fraccionario_unitario_ref;
    private int stock_fraccionario_unitario_actual;
    
    public BEAlmacenVenta(){
        setCod_producto(0);
        setStock(0);
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString(){
           String msg="";        
        msg+=" Codigo de producto        : "+getCod_producto()+"\n";
        msg+=" Cantidad enn stock        : "+getCod_producto()+"\n";
               
    return msg;
    }

    public int getStock_fraccionario_referencia() {
        return stock_fraccionario_referencia;
    }

    public void setStock_fraccionario_referencia(int stock_fraccionario_referencia) {
        this.stock_fraccionario_referencia = stock_fraccionario_referencia;
    }

    public int getStock_fraccionario_actual() {
        return stock_fraccionario_actual;
    }

    public void setStock_fraccionario_actual(int stock_fraccionario_actual) {
        this.stock_fraccionario_actual = stock_fraccionario_actual;
    }

    public int getStock_fraccionario_unitario_ref() {
        return stock_fraccionario_unitario_ref;
    }

    public void setStock_fraccionario_unitario_ref(int stock_fraccionario_unitario_ref) {
        this.stock_fraccionario_unitario_ref = stock_fraccionario_unitario_ref;
    }

    public int getStock_fraccionario_unitario_actual() {
        return stock_fraccionario_unitario_actual;
    }

    public void setStock_fraccionario_unitario_actual(int stock_fraccionario_unitario_actual) {
        this.stock_fraccionario_unitario_actual = stock_fraccionario_unitario_actual;
    }
}
