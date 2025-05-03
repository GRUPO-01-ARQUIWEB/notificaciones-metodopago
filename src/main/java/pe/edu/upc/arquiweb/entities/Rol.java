package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Roles", uniqueConstraints = {@UniqueConstraint(columnNames = {"idUsuario", "nombre_rol"})})
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "nombre_rol", nullable = false, length = 25)
    private String nombre_rol;

    @Column(name = "descripcion", nullable = false, length = 25)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public Rol() {
    }

    public Rol(int idRol, String nombre_rol, String descripcion, Usuario usuario) {
        this.idRol = idRol;
        this.nombre_rol = nombre_rol;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
