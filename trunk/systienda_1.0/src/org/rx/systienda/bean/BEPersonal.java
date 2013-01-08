
package org.rx.systienda.bean;

public final class BEPersonal {    
    
    private int codigo_empleado;
    private String nombres;
    private String ap_paterno;
    private String ap_maternno;
    private String direccion;
    private String correo;
    private String telefono;
    private int codigo_cuenta;
    private String nombre_cuenta;
    private String clave_cuenta;
    private String rol;
    private boolean estado;
    
    public BEPersonal() { 
        setId_empleado(0);
        setNombres(null);
        setAp_paterno(null);
        setAp_maternno(null);
        setDireccion(null);
        setCorreo(null);
        setTelefono(null);
    }

    public int getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setId_empleado(int codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_maternno() {
        return ap_maternno;
    }

    public void setAp_maternno(String ap_maternno) {
        this.ap_maternno = ap_maternno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString(){
        String msg="";
        msg+=" Codigo Empleado      : "+getCodigo_empleado()+"\n";
        msg+=" Nombres              : "+getNombres()+"\n";
        msg+=" Apellido Paterno     : "+getAp_paterno()+"\n";
        msg+=" Apellido Materno     : "+getAp_maternno()+"\n";
        msg+=" Direccion            : "+getDireccion()+"\n";
        msg+=" Correo               : "+getCorreo()+"\n"; 
        msg+=" telefono             : "+getTelefono()+"\n"; 
        
    return msg;
    }

    public int getCodigo_cuenta() {
        return codigo_cuenta;
    }

    public void setId_cuenta(int codigo_cuenta) {
        this.codigo_cuenta = codigo_cuenta;
    }

    public String getNombre_cuenta() {
        return nombre_cuenta;
    }

    public void setNombre_cuenta(String nombre_cuenta) {
        this.nombre_cuenta = nombre_cuenta;
    }

    public String getClave_cuenta() {
        return clave_cuenta;
    }

    public void setClave_cuenta(String clave_cuenta) {
        this.clave_cuenta = clave_cuenta;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
