package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @NotBlank(message = "El username no puede estar vacío")
    @Size(max = 20, message = "El username no puede tener más de 20 caracteres")
    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @NotNull(message = "El password es obligatorio")
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(length = 200)
    private Boolean enabled;

    @NotBlank(message = "El correo no puede estar vacío")
    @Size(max = 100, message = "El correo no puede tener más de 100 caracteres")
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Size(max = 100, message = "La direccion no puede tener más de 100 caracteres")
    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Size(max = 9, message = "El telefono no puede tener más de 9 numeros")
    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;

    @NotNull(message = "La latitud es obligatoria")
    @Column(name = "latitud", nullable = false)
    private double latitud;

    @NotNull(message = "La longitud es obligatoria")
    @Column(name = "longitud", nullable = false)
    private double longitud;

    //FK

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private List<Rol> roles;

    public List<Rol> getRol() {
        return roles;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setRol(List<Rol> rol) {
        this.roles = rol;
    }

    public Usuario() {
    }

    public Usuario(int idUsuario, String username, String correo, String password, String direccion, String telefono, double latitud, double longitud) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.correo = correo;
        this.password = password;
        this.direccion = direccion;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
    }


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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