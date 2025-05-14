package pe.edu.upc.arquiweb.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "MensajeChat")
public class MensajeChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMensaje;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "url_video")
    private String urlVideo;

    @Column(name = "fecha_envio", nullable = false)
    private LocalDateTime fechaEnvio;


    @ManyToOne
    @JoinColumn(name = "id_chat")
    private MensajeChat MensajeChat;


    public MensajeChat() {
    }

    public MensajeChat(int idMensaje, String contenido, String urlVideo, String tipo, LocalDateTime fechaEnvio, MensajeChat mensajeChat) {
        this.idMensaje = idMensaje;
        this.contenido = contenido;
        this.urlVideo = urlVideo;
        this.tipo = tipo;
        this.fechaEnvio = fechaEnvio;
        MensajeChat = mensajeChat;
    }

    public MensajeChat getMensajeChat() {
        return MensajeChat;
    }

    public void setMensajeChat(MensajeChat mensajeChat) {
        MensajeChat = mensajeChat;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }


    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}

