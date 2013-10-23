package org.sysconpat.rx.be;

import java.sql.Date;

public final class BEBienPatrimonial {
  //<editor-fold defaultstate="collapsed" desc="Datos referenciales">  
    private String clasificador;    
    private String grupo_generico;
    private String clase_bien;
  //</editor-fold>
  private String codigo_patrimonial;
  private String denominacion;
  private int id_bien_patrimonial;
  private int id_entidad;
  private int id_catalogo;
  private int ul_correlativo;
  private int tipo_cuenta;
  private int cantidad;
  private boolean eleccion_af_co;
  private int id_cta_contable;
  private int forma_adquisicion;
  private Date fecha_adquisicion;
  private String doc_adquisicion;
  private boolean asegurado;
  private boolean fichado;
  private boolean inventariado;
  private boolean entransito;
  private int estado;
  private int id_local;
  private int id_area;
  private int id_oficina;
  private int id_personal;
  private double valor_adquisicion;
  private String marca;
  private String tipo;
  private String serie;
  private String clase;
  private String especie;
  private String placa;
  private String nro_motor;
  private String matricula;
  private double longitud;
  private double ancho;
  private String modelo;
  private String color;
  private String raza;
  private int anio;
  private String pais;
  private int nro_chasis;
  private double dimencion;
  private double altura;
  private String tipo_combustible;
  private String carroceria;
  private String transmision;
  private String certificado_soat;
  private String nro_tarjeta_propiedad;
  private String otro;

    public BEBienPatrimonial() {
        setId_bien_patrimonial(0);
        setId_entidad(0);
        setId_catalogo(0);
        setUl_correlativo(0);
        setTipo_cuenta(0);
        setCantidad(0);
        setEleccion_af_co(false);
        setId_cta_contable(0);
        setForma_adquisicion(0);
        setFecha_adquisicion(new Date(-1900,0,1));
        setDoc_adquisicion("");
        setAsegurado(false);
        setFichado(false);
        setInventariado(false);
        setEntransito(false);
        setEstado(0);
        setId_local(0);
        setId_area(0);
        setId_oficina(0);
        setId_personal(0);
        setValor_adquisicion(0);
        setMarca("");
        setTipo("");
        setSerie("");
        setClase("");
        setPlaca("");
        setNro_motor("");
        setMatricula("");
        setLongitud(0);
        setAncho(0);
        setModelo("");
        setColor("");
        setEspecie("");
        setRaza("");
        setAnio(0);
        setPais("");
        setNro_chasis(0);
        setDimencion(0);
        setAltura(0);
        setTipo_combustible("");
        setCarroceria("");
        setTransmision("");
        setCertificado_soat("");
        setNro_tarjeta_propiedad("");
        setOtro("");        
        setCodigo_patrimonial("");
        setDenominacion("");
        setClasificador("");
        setGrupo_generico("");
        setClase_bien("");
    }

    public int getId_bien_patrimonial() {
        return id_bien_patrimonial;
    }

    public void setId_bien_patrimonial(int id_bien_patrimonial) {
        this.id_bien_patrimonial = id_bien_patrimonial;
    }

    public int getId_entidad() {
        return id_entidad;
    }

    public void setId_entidad(int id_entidad) {
        this.id_entidad = id_entidad;
    }

    public int getId_catalogo() {
        return id_catalogo;
    }

    public void setId_catalogo(int id_catalogo) {
        this.id_catalogo = id_catalogo;
    }

    public int getUl_correlativo() {
        return ul_correlativo;
    }

    public void setUl_correlativo(int ul_correlativo) {
        this.ul_correlativo = ul_correlativo;
    }

    public int getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(int tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEleccion_af_co() {
        return eleccion_af_co;
    }

    public void setEleccion_af_co(boolean eleccion_af_co) {
        this.eleccion_af_co = eleccion_af_co;
    }

    public int getId_cta_contable() {
        return id_cta_contable;
    }

    public void setId_cta_contable(int id_cta_contable) {
        this.id_cta_contable = id_cta_contable;
    }

    public int getForma_adquisicion() {
        return forma_adquisicion;
    }

    public void setForma_adquisicion(int forma_adquisicion) {
        this.forma_adquisicion = forma_adquisicion;
    }

    public Date getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    public void setFecha_adquisicion(Date fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }

    public String getDoc_adquisicion() {
        return doc_adquisicion;
    }

    public void setDoc_adquisicion(String doc_adquisicion) {
        this.doc_adquisicion = doc_adquisicion;
    }

    public boolean isAsegurado() {
        return asegurado;
    }

    public void setAsegurado(boolean asegurado) {
        this.asegurado = asegurado;
    }

    public boolean isFichado() {
        return fichado;
    }

    public void setFichado(boolean fichado) {
        this.fichado = fichado;
    }

    public boolean isInventariado() {
        return inventariado;
    }

    public void setInventariado(boolean inventariado) {
        this.inventariado = inventariado;
    }

    public boolean isEntransito() {
        return entransito;
    }

    public void setEntransito(boolean entransito) {
        this.entransito = entransito;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public int getId_oficina() {
        return id_oficina;
    }

    public void setId_oficina(int id_oficina) {
        this.id_oficina = id_oficina;
    }

    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
    }

    public double getValor_adquisicion() {
        return valor_adquisicion;
    }

    public void setValor_adquisicion(double valor_adquisicion) {
        this.valor_adquisicion = valor_adquisicion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNro_motor() {
        return nro_motor;
    }

    public void setNro_motor(String nro_motor) {
        this.nro_motor = nro_motor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNro_chasis() {
        return nro_chasis;
    }

    public void setNro_chasis(int nro_chasis) {
        this.nro_chasis = nro_chasis;
    }

    public double getDimencion() {
        return dimencion;
    }

    public void setDimencion(double dimencion) {
        this.dimencion = dimencion;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getCertificado_soat() {
        return certificado_soat;
    }

    public void setCertificado_soat(String certificado_soat) {
        this.certificado_soat = certificado_soat;
    }

    public String getNro_tarjeta_propiedad() {
        return nro_tarjeta_propiedad;
    }

    public void setNro_tarjeta_propiedad(String nro_tarjeta_propiedad) {
        this.nro_tarjeta_propiedad = nro_tarjeta_propiedad;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }

    public String getCodigo_patrimonial() {
        return codigo_patrimonial;
    }

    public void setCodigo_patrimonial(String codigo_patrimonial) {
        this.codigo_patrimonial = codigo_patrimonial;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getClasificador() {
        return clasificador;
    }

    public void setClasificador(String clasificador) {
        this.clasificador = clasificador;
    }

    public String getGrupo_generico() {
        return grupo_generico;
    }

    public void setGrupo_generico(String grupo_generico) {
        this.grupo_generico = grupo_generico;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getClase_bien() {
        return clase_bien;
    }

    public void setClase_bien(String clase_bien) {
        this.clase_bien = clase_bien;
    }
  
  
}
