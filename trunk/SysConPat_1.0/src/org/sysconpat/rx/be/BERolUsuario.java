package org.sysconpat.rx.be;

public final class BERolUsuario {
    private int id_rol;
    private int id_usuario;
    private int id_modulo;
    private String nombre_modulo;

    public BERolUsuario() {
        setId_rol(0);
        setId_usuario(0);
        setId_modulo(0);
        setNombre_Modulo(null);        
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_Modulo() {
        return nombre_modulo;
    }

    public void setNombre_Modulo(String modulo) {
        this.nombre_modulo = modulo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_modulo() {
        return id_modulo;
    }

    public void setId_modulo(int id_modulo) {
        this.id_modulo = id_modulo;
    }
}
