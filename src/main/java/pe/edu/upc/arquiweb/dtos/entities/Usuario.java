package pe.edu.upc.arquiweb.dtos.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "contrasenahash", nullable = false, length = 100)
    private String contrasenahash;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;;

    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;

    @Column(name = "rolClAd", nullable = false, length = 20)
    private String rolClAd;

    @Column(name = "latitud", nullable = false)
    private double latitud;

    @Column(name = "longitud", nullable = false)
    private double longitud;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String correo, String contrasenahash, String direccion, String telefono, String rolClAd, double latitud, double longitud) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenahash = contrasenahash;
        this.direccion = direccion;
        this.telefono = telefono;
        this.rolClAd = rolClAd;
        this.latitud = latitud;
        this.longitud = longitud;
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

    public String getRolClAd() {
        return rolClAd;
    }

    public void setRolClAd(String rolClAd) {
        this.rolClAd = rolClAd;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

}

