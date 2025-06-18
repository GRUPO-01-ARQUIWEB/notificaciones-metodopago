package pe.edu.upc.grupo1_arquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Notificaciones")
public class Notificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacion;

    @Column(name = "mensaje",nullable = false, length = 200)
    private String mensaje;

    @Column(name = "fechaEnvioNotificacion",nullable = false)
    private LocalDateTime fechaEnvioNotificacion;

    @Column(name = "leido",nullable = false)
    private boolean leido;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Notificaciones() {
    }

    public Notificaciones(Long idNotificacion, String mensaje, LocalDateTime fechaEnvioNotificacion, boolean leido, Users user) {
        this.idNotificacion = idNotificacion;
        this.mensaje = mensaje;
        this.fechaEnvioNotificacion = fechaEnvioNotificacion;
        this.leido = leido;
        this.user = user;
    }

    public Long getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Long idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaEnvioNotificacion() {
        return fechaEnvioNotificacion;
    }

    public void setFechaEnvioNotificacion(LocalDateTime fechaEnvioNotificacion) {
        this.fechaEnvioNotificacion = fechaEnvioNotificacion;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
