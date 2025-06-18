package pe.edu.upc.grupo1_arquiweb.dtos;

import java.time.LocalDate;

public class ChatDTO {

    private Long idChat;
    private LocalDate fechaInicioChat;
    private Long idUser;
    private Long idTienda;

    public Long getIdChat() {
        return idChat;
    }

    public void setIdChat(Long idChat) {
        this.idChat = idChat;
    }

    public LocalDate getFechaInicioChat() {
        return fechaInicioChat;
    }

    public void setFechaInicioChat(LocalDate fechaInicioChat) {
        this.fechaInicioChat = fechaInicioChat;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Long idTienda) {
        this.idTienda = idTienda;
    }
}
