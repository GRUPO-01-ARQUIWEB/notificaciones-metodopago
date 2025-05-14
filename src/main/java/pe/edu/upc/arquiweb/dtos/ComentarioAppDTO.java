package pe.edu.upc.arquiweb.dtos;

import java.time.LocalDate;

public class ComentarioAppDTO {

    private int idComentarioApp;

    private String contenido;

    private LocalDate fecha;

    private int idUsuario;

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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
