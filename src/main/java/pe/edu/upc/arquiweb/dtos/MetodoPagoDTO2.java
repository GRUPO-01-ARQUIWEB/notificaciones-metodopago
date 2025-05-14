package pe.edu.upc.arquiweb.dtos;

import pe.edu.upc.arquiweb.entities.Usuario;

import java.time.LocalDate;

public class MetodoPagoDTO2 {

    private int idMetodo;
    private String tipo; // Tarjeta, Yape, Plin
    private String numeroTelefonico;
    private LocalDate vencimiento;


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
}
