package org.sysconpat.rx.be;

public final class BECatalogo {
    private int id_catalogo;
    private String codigo_patrimonial;
    private String denominacion;
    private String clasificador;
    private int id_cuenta_contable;
    private int id_grupogenerico;
    private int cod_grupogenerico;
    private String grupo_generico;
    private int id_clase;
    private String clase;
    private int codigo_clase;
    private int anio_vida;
    private int id_cuenta_contable_co;

    public BECatalogo() {
        setId_catalogo(0);
        setCodigo_patrimonial("");
        setDenominacion("");
        setClasificador("");
        setId_cuenta_contable(0);
        setId_grupogenerico(0);
        setCod_grupogenerico(0);
        setId_clase(0);
        setCodigo_clase(0);
        setAnio_vida(0);
        setId_cuenta_contable_co(0);
        setGrupo_generico("");
        setClase("");
    }

    public int getId_catalogo() {
        return id_catalogo;
    }

    public void setId_catalogo(int id_catalogo) {
        this.id_catalogo = id_catalogo;
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

    public int getId_cuenta_contable() {
        return id_cuenta_contable;
    }

    public void setId_cuenta_contable(int id_cuenta_contable) {
        this.id_cuenta_contable = id_cuenta_contable;
    }

    public int getId_grupogenerico() {
        return id_grupogenerico;
    }

    public void setId_grupogenerico(int id_grupogenerico) {
        this.id_grupogenerico = id_grupogenerico;
    }

    public int getCod_grupogenerico() {
        return cod_grupogenerico;
    }

    public void setCod_grupogenerico(int cod_grupogenerico) {
        this.cod_grupogenerico = cod_grupogenerico;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public int getCodigo_clase() {
        return codigo_clase;
    }

    public void setCodigo_clase(int codigo_clase) {
        this.codigo_clase = codigo_clase;
    }

    public int getAnio_vida() {
        return anio_vida;
    }

    public void setAnio_vida(int anio_vida) {
        this.anio_vida = anio_vida;
    }

    public int getId_cuenta_contable_co() {
        return id_cuenta_contable_co;
    }

    public void setId_cuenta_contable_co(int id_cuenta_contable_co) {
        this.id_cuenta_contable_co = id_cuenta_contable_co;
    }

    public String getGrupo_generico() {
        return grupo_generico;
    }

    public void setGrupo_generico(String grupo_generico) {
        this.grupo_generico = grupo_generico;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
    
}
