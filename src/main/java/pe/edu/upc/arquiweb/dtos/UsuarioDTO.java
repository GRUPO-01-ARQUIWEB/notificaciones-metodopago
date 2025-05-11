package pe.edu.upc.arquiweb.dtos;

import pe.edu.upc.arquiweb.entities.Rol;

public class UsuarioDTO {

    private int idUsuario;

    private String nombre;

    private String correo;

    private String contrasenahash;

    private String direccion;

    private String telefono;

    private boolean enabled;

    private Rol rol;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenahash() {
        return contrasenahash;
    }

    public void setContrasenahash(String contrasenahash) {
        this.contrasenahash = contrasenahash;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
