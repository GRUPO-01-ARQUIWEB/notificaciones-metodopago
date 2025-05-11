package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.*;

@Entity
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMetodo;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Column(name = "tipo",nullable = false)
    private String tipo; // Tarjeta, Yape, Plin

    @Column(name = "titular",nullable = false,length = 20)
    private String titular;

    @Column(name = "numeroTelefonico",nullable = false,length = 9)
    private String numeroTelefonico;

    @Column(name = "vencimiento",nullable = false,length = 10)
    private String vencimiento;

    public MetodoPago() {
    }

    public MetodoPago(String vencimiento, String numeroTelefonico, String titular, String tipo, Usuario usuario, int idMetodo) {
        this.vencimiento = vencimiento;
        this.numeroTelefonico = numeroTelefonico;
        this.titular = titular;
        this.tipo = tipo;
        this.usuario = usuario;
        this.idMetodo = idMetodo;
    }

    public int getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(int idMetodo) {
        this.idMetodo = idMetodo;
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
