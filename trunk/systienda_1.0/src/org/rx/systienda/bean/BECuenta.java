
package org.rx.systienda.bean;

public final class BECuenta {
    private int id_cuenta;
    private int codigo_empleado;
    private String nombre_cuenta;
    private String clave_cuenta;
    private String rol;
    private boolean estado;

    public BECuenta() {
        setId_empleado(0);
        setId_cuenta(0);
        setNombre_cuenta(null);
        setClave_cuenta(null);
        setRol(null);
        setEstado(false);
    }
    
    
    public int getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setId_empleado(int codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
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
    
    @Override
    public String toString(){
        String msn="";
        msn+="Codigo Empleado   :"+getCodigo_empleado()+"\n";
        msn+="codigo Cuenta     :"+getId_cuenta()+"\n";
        msn+="Nombre Cuenta     :"+getNombre_cuenta()+"\n";
        msn+="Clave Cuenta      :"+getClave_cuenta()+"\n";
        msn+="Rol               :"+getRol()+"\n";
        msn+="Estado            :"+getEstado()+"\n";
               
        return msn;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }
    
}
