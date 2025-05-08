package pe.edu.upc.arquiweb.dtos;

import jakarta.persistence.*;
import pe.edu.upc.arquiweb.entities.MensajeChat;
import pe.edu.upc.arquiweb.entities.Tienda;
import pe.edu.upc.arquiweb.entities.Usuario;

import java.time.LocalDate;

public class ChatProveedorDTO {
    private int idChat;

    private LocalDate fechainicio;

    private Usuario usuario;

    private Tienda tienda;

    private MensajeChat mensaje;

    public int getIdChat() {
        return idChat;
    }

    public void setIdChat(int idChat) {
        this.idChat = idChat;
    }

    public LocalDate getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(LocalDate fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public MensajeChat getMensaje() {
        return mensaje;
    }

    public void setMensaje(MensajeChat mensaje) {
        this.mensaje = mensaje;
    }
}
