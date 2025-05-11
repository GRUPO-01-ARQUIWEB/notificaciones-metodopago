package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name="MetodoPago")
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMetodoPago;

    @Column(name = "tipo",nullable = false)
    private String tipo; // Tarjeta, Yape, Plin

    @Column(name = "titular",nullable = false,length = 20)
    private String titular;

    @Column(name = "numeroTelefonico",nullable = false,length = 9)
    private String numeroTelefonico;

    @Column(name = "vencimiento",nullable = false,length = 10)
    private String vencimiento;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;

    public MetodoPago() {
    }

    public MetodoPago(int idMetodoPago, String tipo, String titular, String numeroTelefonico, String vencimiento, Usuario usuario) {
        this.idMetodoPago = idMetodoPago;
        this.tipo = tipo;
        this.titular = titular;
        this.numeroTelefonico = numeroTelefonico;
        this.vencimiento = vencimiento;
        this.usuario = usuario;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
