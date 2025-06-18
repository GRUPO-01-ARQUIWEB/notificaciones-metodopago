package pe.edu.upc.grupo1_arquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "MetodoPago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMetodoPago;

    @Column(name = "tipo", nullable = false, length = 100)
    private String tipo;

    @Column(name = "vencimientoMetodo", nullable = false)
    private LocalDate vencimientoMetodo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public MetodoPago() {
    }

    public MetodoPago(Long idMetodoPago, String tipo, LocalDate vencimientoMetodo, Users user) {
        this.idMetodoPago = idMetodoPago;
        this.tipo = tipo;
        this.vencimientoMetodo = vencimientoMetodo;
        this.user = user;
    }

    public Long getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Long idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getVencimientoMetodo() {
        return vencimientoMetodo;
    }

    public void setVencimientoMetodo(LocalDate vencimientoMetodo) {
        this.vencimientoMetodo = vencimientoMetodo;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
