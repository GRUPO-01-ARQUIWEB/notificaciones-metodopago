package pe.edu.upc.grupo1_arquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Chat")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChat;

    @Column(name="fechaInicioChat", nullable = false)
    private LocalDate fechaInicioChat;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private Tienda tienda;

    public Chat() {
    }

    public Chat(Long idChat, LocalDate fechaInicioChat, Users user, Tienda tienda) {
        this.idChat = idChat;
        this.fechaInicioChat = fechaInicioChat;
        this.user = user;
        this.tienda = tienda;
    }

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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
