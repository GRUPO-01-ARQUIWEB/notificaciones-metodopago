package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
@Entity

public class Notificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;

    @Size(max = 200, message = "El mensaje no puede tener más de 200 caracteres")
    @Column(name = "mensaje",nullable = false,length = 200)
    private String mensaje;

    @NotNull(message = "La fecha de envio es obligatoria")
    @Column(name = "fechaEnvio",nullable = false)
    private LocalDateTime fechaEnvio;

    @Column(name = "leido",nullable = false)
    private boolean leido;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Notificaciones() {
    }

    public Notificaciones(int idNotificacion, Usuario usuario, String mensaje, LocalDateTime fechaEnvio, boolean leido) {
        this.idNotificacion = idNotificacion;
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
