package pe.edu.upc.arquiweb.dtos;
import pe.edu.upc.arquiweb.entities.MensajeChat;
import pe.edu.upc.arquiweb.entities.Tienda;
import pe.edu.upc.arquiweb.entities.Usuario;

import java.time.LocalDate;

public class ChatProveedorDTO {
    private int idChat;

    private LocalDate fechainicio;

    private MensajeChat MensajeChat;


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

    public MensajeChat getMensajeChat() {
        return MensajeChat;
    }

    public void setMensajeChat(MensajeChat mensajeChat) {
        MensajeChat = mensajeChat;
    }
}
