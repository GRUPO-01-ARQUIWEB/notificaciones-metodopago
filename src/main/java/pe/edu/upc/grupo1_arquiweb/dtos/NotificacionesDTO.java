package pe.edu.upc.grupo1_arquiweb.dtos;

import java.time.LocalDateTime;

public class NotificacionesDTO {

    private Long idNotificacion;
    private String mensaje;
    private LocalDateTime fechaEnvioNotificacion;
    private boolean leido;
    private Long idUser;

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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
