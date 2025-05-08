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

    @ManyToOne
    @JoinColumn(name="idMensaje")
    private MensajeChat mensaje;

    public ChatProveedor() {
    }

    public ChatProveedor(int idChat, LocalDate fechainicio, Usuario usuario, Tienda tienda, MensajeChat mensaje) {
        this.idChat = idChat;
        this.fechainicio = fechainicio;
        this.usuario = usuario;
        this.tienda = tienda;
        this.mensaje = mensaje;
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

    public MensajeChat getMensaje() {
        return mensaje;
    }

    public void setMensaje(MensajeChat mensaje) {
        this.mensaje = mensaje;
    }
}
