package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="ComentarioApp")
public class ComentarioApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentarioApp;

    @Column(name="contenido", nullable = false, length = 200)
    private String contenido;

    @Column(name="fecha",nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    public ComentarioApp() {
    }

    public ComentarioApp(int idComentarioApp, String contenido, LocalDate fecha, Usuario usuario) {
        this.idComentarioApp = idComentarioApp;
        this.contenido = contenido;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public int getIdComentarioApp() {
        return idComentarioApp;
    }

    public void setIdComentarioApp(int idComentarioApp) {
        this.idComentarioApp = idComentarioApp;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
