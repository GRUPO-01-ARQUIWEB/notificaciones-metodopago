package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity

public class Notificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;

    private int idUsuario;

    @Column(name = "mensaje",nullable = false,length = 200)
    private String mensaje;

    @Column(name = "fechaEnvio",nullable = false)
    private LocalDateTime fechaEnvio;

    @Column(name = "leido",nullable = false)
    private boolean leido;

    public Notificaciones() {
    }

    public Notificaciones(int idNotificacion, int idUsuario, String mensaje, LocalDateTime fechaEnvio, boolean leido) {
        this.idNotificacion = idNotificacion;
        this.idUsuario = idUsuario;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.leido = leido;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }
}
