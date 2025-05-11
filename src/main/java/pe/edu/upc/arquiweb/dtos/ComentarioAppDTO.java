package pe.edu.upc.arquiweb.dtos;


import pe.edu.upc.arquiweb.entities.Usuario;

import java.time.LocalDate;

public class ComentarioAppDTO {

    private int idComentarioApp;

    private String contenido;

    private LocalDate fecha;

    private Usuario usuario;

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
