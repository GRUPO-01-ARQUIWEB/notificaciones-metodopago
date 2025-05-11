package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name="MetodoPago")
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMetodo;

    @NotNull(message = "El tipo de metodo de pago es obligatorio")
    @Column(name = "tipo",nullable = false)
    private String tipo; // Tarjeta, Yape, Plin

    @NotBlank(message = "El número de telefono no puede estar vacío")
    @Size(max = 9, message = "El telefono no puede tener más de 9 numeros")
    @Column(name = "numeroTelefonico",nullable = false,length = 9)
    private String numeroTelefonico;

    @NotNull(message = "La fecha de vencimiento es obligatoria")
    @Column(name = "vencimiento",nullable = false)
    private LocalDate vencimiento;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public MetodoPago() {
    }

    public MetodoPago(LocalDate vencimiento, String numeroTelefonico, String tipo, Usuario usuario, int idMetodo) {
        this.vencimiento = vencimiento;
        this.numeroTelefonico = numeroTelefonico;
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

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(LocalDate vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
