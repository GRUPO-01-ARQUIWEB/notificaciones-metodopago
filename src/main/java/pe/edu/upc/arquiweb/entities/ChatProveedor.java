package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name="ChatProveedor")
public class ChatProveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChat;

    @Column(name="fechainicio", nullable = false)
    private LocalDate fechainicio;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idTienda")
    private Tienda tienda;


    /*
    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    @ManyToOne
    @JoinColumn(name = "idChat")
    private Chat chat;

    public ChatProveedor(Chat chat) {
        this.chat = chat;
    }
    */

    public ChatProveedor() {
    }

    public ChatProveedor(int idChat, LocalDate fechainicio, Usuario usuario, Tienda tienda) {
        this.idChat = idChat;
        this.fechainicio = fechainicio;
        this.usuario = usuario;
        this.tienda = tienda;
    }

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
}
