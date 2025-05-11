package pe.edu.upc.arquiweb.dtos;

public class MetodoPagoPopularDTO {
    private int idMetodo;
    private String tipo;
    private String titular;
    private long totalUsos;
    private double porcentaje;


    public MetodoPagoPopularDTO(int idMetodo, String tipo, String titular, long totalUsos, double porcentaje) {
        this.idMetodo = idMetodo;
        this.tipo = tipo;
        this.titular = titular;
        this.totalUsos = totalUsos;
        this.porcentaje = porcentaje;
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

    public long getTotalUsos() {
        return totalUsos;
    }

    public void setTotalUsos(long totalUsos) {
        this.totalUsos = totalUsos;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
