package org.sysconpat.rx.be;

public final class BELocal {
    private int id_local;
    private String nombre;
    private int tipo_propiedad;
    private double  area;
    private int unidad_metrica;
    private int tipo_direccion;
    private String direccion;
    private String nro;
    private String manzana;
    private String lote;
    private int id_ubigeo;
    private int tipo_cuenta;
    private int tipo_moneda;
    private int id_cuenta;
    private String valor_contable;
    private int oficina_registral;
    private String tomo;
    private String fojas;
    private String asiento;
    private String codigo_predio;
    private String partida_electoral;
    private String registro_sinabip;
    private String propiedad_registral;
    private String beneficiario;
    
    public static final int VALOR_DEFECTO=1,VALOR_ITEM=2;
    private int tipo_item;

    public BELocal() {
        setTipo_item(VALOR_DEFECTO);
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo_propiedad() {
        return tipo_propiedad;
    }

    public void setTipo_propiedad(int tipo_propiedad) {
        this.tipo_propiedad = tipo_propiedad;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getUnidad_metrica() {
        return unidad_metrica;
    }

    public void setUnidad_metrica(int unidad_metrica) {
        this.unidad_metrica = unidad_metrica;
    }

    public int getTipo_direccion() {
        return tipo_direccion;
    }

    public void setTipo_direccion(int tipo_direccion) {
        this.tipo_direccion = tipo_direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getManzana() {
        return manzana;
    }

    public void setManzana(String mazana) {
        this.manzana = mazana;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getId_ubigeo() {
        return id_ubigeo;
    }

    public void setId_ubigeo(int id_ubigeo) {
        this.id_ubigeo = id_ubigeo;
    }

    public int getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(int tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public int getTipo_moneda() {
        return tipo_moneda;
    }

    public void setTipo_moneda(int tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getValor_contable() {
        return valor_contable;
    }

    public void setValor_contable(String valor_contable) {
        this.valor_contable = valor_contable;
    }

    public int getOficina_registral() {
        return oficina_registral;
    }

    public void setOficina_registral(int oficina_registral) {
        this.oficina_registral = oficina_registral;
    }

    public String getTomo() {
        return tomo;
    }

    public void setTomo(String tomo) {
        this.tomo = tomo;
    }

    public String getFojas() {
        return fojas;
    }

    public void setFojas(String fojas) {
        this.fojas = fojas;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getCodigo_predio() {
        return codigo_predio;
    }

    public void setCodigo_predio(String codigo_predio) {
        this.codigo_predio = codigo_predio;
    }

    public String getPartida_electoral() {
        return partida_electoral;
    }

    public void setPartida_electoral(String partida_electoral) {
        this.partida_electoral = partida_electoral;
    }

    public String getRegistro_sinabip() {
        return registro_sinabip;
    }

    public void setRegistro_sinabip(String registro_sinabip) {
        this.registro_sinabip = registro_sinabip;
    }

    public String getPropiedad_registral() {
        return propiedad_registral;
    }

    public void setPropiedad_registral(String propiedad_registral) {
        this.propiedad_registral = propiedad_registral;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public int getTipo_item() {
        return tipo_item;
    }

    public void setTipo_item(int tipo_item) {
        this.tipo_item = tipo_item;
    }
    @Override
    public String toString() {
        switch(getTipo_item()){
            case VALOR_DEFECTO: return "<Seleccionar>";
            case VALOR_ITEM: return getNombre();          
            default: return null;
        }        
    }     
}
