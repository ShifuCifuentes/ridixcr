
package org.rx.systienda.bean;

public final class BEAlmacenPrimario {
    private int cod_producto;
    private int stock;
    private int stock_fraccionario_referencia;
    private int stock_fraccionario_unitario_referencia; 
    
    public BEAlmacenPrimario(){
        setId_producto(0);
        setStock(0);
        setStock_fraccionario_referencia(0);
        setStock_fraccionario_unitario_referencia(0);
    }

    public int getCod_producto() {
        return cod_producto;
    }

    public void setId_producto(int cod_producto) {
        this.cod_producto = cod_producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock_fraccionario_referencia() {
        return stock_fraccionario_referencia;
    }

    public void setStock_fraccionario_referencia(int stock_fraccionario_referencia) {
        this.stock_fraccionario_referencia = stock_fraccionario_referencia;
    }

    public int getStock_fraccionario_unitario_referencia() {
        return stock_fraccionario_unitario_referencia;
    }

    public void setStock_fraccionario_unitario_referencia(int stock_fraccionario_unitario_referencia) {
        this.stock_fraccionario_unitario_referencia = stock_fraccionario_unitario_referencia;
    }
    
    @Override
    public String toString(){
           String msg="";        
        msg+=" Codigo de producto        : "+getCod_producto()+"\n";
        msg+=" Stock minimo              : "+getStock()+"\n";
        msg+=" Stock actual              : "+getStock_fraccionario_referencia()+"\n";
        msg+=" Stock maximo              : "+getStock_fraccionario_unitario_referencia()+"\n";
        
    return msg;
    }
}
