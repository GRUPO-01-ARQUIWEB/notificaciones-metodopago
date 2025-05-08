package pe.edu.upc.arquiweb.dtos;

import pe.edu.upc.arquiweb.entities.Tienda;
import pe.edu.upc.arquiweb.entities.Usuario;

import java.time.LocalDate;

public class ChatProveedorDTO {

    private int idChat;

    private LocalDate fechainicio;

    private Usuario usuario;
    /*
    private Chat chat;

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
    */

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

    private Tienda tienda;


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
        this.fechainicio = fechainicio;}
}