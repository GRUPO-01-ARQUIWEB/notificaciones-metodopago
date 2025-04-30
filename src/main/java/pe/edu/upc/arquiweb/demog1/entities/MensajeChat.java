package pe.edu.upc.arquiweb.demog1.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "MensajeChat")
public class MensajeChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMensaje;

    @Column(name = "id_chat", nullable = false)
    private int idChat;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "url_video")
    private String urlVideo;

    @Column(name = "fecha_envio", nullable = false)
    private LocalDateTime fechaEnvio;

    public MensajeChat() {
    }


    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
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

