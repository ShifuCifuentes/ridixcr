
package org.rx.systienda.bean;

import java.sql.Date;

public final class  BEProducto {
    private int id_producto;
    private int id_proveedor;
    private int id_categoria;
    private int id_marca;
    private String denominacion_generico;
    private String nom_comercial;
    private String presentacion;
    private String laboratorio;
    private String unidad_medida;
    private double precio_compra;
    private double porcentaje_utilidad;
    private String num_lote;
    private String cod_referencia;
    private String especificacion;
    private Date fecha_registro;
    private int stock;
    private int stock_fraccionario;
    private int stock_fraccionario_unitario; 
    private int stock_fraccionario_referencia;
    private int stock_fraccionario_unitario_referencia; 
    private double precio_venta;
    private Date fecha_vencimiento;    
    private String ref_marca;
    private String ref_terapeutico;
    private String ref_proveedor;
    private String ref_genero;
    
    private boolean band_entrega=false;
    
    private int tip_compra;
    public BEProducto(){
        setId_producto(0);
        setId_proveedor(0);
        setDenominacion_generico(null);
        setNom_comercial(null);
        setPresentacion(null);
        setPrecio_compra(0);
        setPorcentaje_utilidad(0);
        setNum_lote(null);        
        setCod_referencia(null);
        setFecha_registro(null);
        setPrecio_venta(0);
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int cod_producto) {
        this.id_producto = cod_producto;
    }

    public String getDenominacion_generico() {
        return denominacion_generico;
    }

    public void setDenominacion_generico(String denominacion_generico) {
        this.denominacion_generico = denominacion_generico;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPorcentaje_utilidad() {
        return porcentaje_utilidad;
    }

    public void setPorcentaje_utilidad(double porcentaje_utilidad) {
        this.porcentaje_utilidad = porcentaje_utilidad;
    }

    public String getNum_lote() {
        return num_lote;
    }

    public void setNum_lote(String num_lote) {
        this.num_lote = num_lote;
    }

    public String getCod_referencia() {
        return cod_referencia;
    }

    public void setCod_referencia(String cod_referencia) {
        this.cod_referencia = cod_referencia;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    @Override
   public String toString(){
        String msn="";
        msn+="Codigo Producto       :"+getId_producto()+"\n";
        msn+="codigo Fabricante     :"+getId_proveedor()+"\n";
        msn+="Denominacion          :"+getDenominacion_generico()+"\n";
        msn+="Presentacion          :"+getPresentacion()+"\n";
        msn+="Precio de Compra      :"+getPrecio_compra()+"\n";
        msn+="Porcentaje utilidad   :"+getPorcentaje_utilidad()+"\n";
        msn+="Num. de lote          :"+getNum_lote()+"\n";
        msn+="Codigo de referencia  :"+getCod_referencia()+"\n";
        msn+="fecha de registro     :"+getFecha_registro()+"\n";
        
        return msn;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock_fraccionario_unitario() {
        return stock_fraccionario_unitario;
    }

    public void setStock_fraccionario_unitario(int stock_farccionario_unitario) {
        this.stock_fraccionario_unitario = stock_farccionario_unitario;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getNom_comercial() {
        return nom_comercial;
    }

    public void setNom_comercial(String nom_comercial) {
        this.nom_comercial = nom_comercial;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getRef_marca() {
        return ref_marca;
    }

    public void setRef_marca(String ref_marca) {
        this.ref_marca = ref_marca;
    }

    public String getRef_terapeutico() {
        return ref_terapeutico;
    }

    public void setRef_terapeutico(String ref_terapeutico) {
        this.ref_terapeutico = ref_terapeutico;
    }

    public String getRef_proveedor() {
        return ref_proveedor;
    }

    public void setRef_proveedor(String ref_proveedor) {
        this.ref_proveedor = ref_proveedor;
    }

    public String getRef_genero() {
        return ref_genero;
    }

    public void setRef_categoria(String ref_genero) {
        this.ref_genero = ref_genero;
    }

    public int getTip_compra() {
        return tip_compra;
    }

    public void setTip_compra(int tip_compra) {
        this.tip_compra = tip_compra;
    }

    public int getStock_fraccionario() {
        return stock_fraccionario;
    }

    public void setStock_fraccionario(int stock_fraccionario) {
        this.stock_fraccionario = stock_fraccionario;
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

    public boolean isBand_entrega() {
        return band_entrega;
    }

    public void setBand_entrega(boolean band_entrega) {
        this.band_entrega = band_entrega;
    }
}
