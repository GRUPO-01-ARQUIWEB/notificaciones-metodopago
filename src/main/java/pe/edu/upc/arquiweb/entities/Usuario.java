package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @NotNull(message = "El username es obligatorio")
    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @NotNull(message = "El password es obligatorio")
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(length = 200)
    private Boolean enabled;

    @Size(max = 60, message = "El correo no puede tener más de 60 caracteres")
    @Column(name = "correo", nullable = false, length = 60)
    private String correo;

    @Size(max = 60, message = "La direccion no puede tener más de 60 caracteres")
    @Column(name = "direccion", nullable = false, length = 60)
    private String direccion;

    @Size(max = 9, message = "El telefono no puede tener más de 9 digitos")
    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;

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

    public Usuario(int idUsuario, String username, String correo, String password, String direccion, String telefono) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.correo = correo;
        this.password = password;
        this.direccion = direccion;
        this.telefono = telefono;
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


}