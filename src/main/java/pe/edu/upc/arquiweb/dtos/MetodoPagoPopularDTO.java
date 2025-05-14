package pe.edu.upc.arquiweb.dtos;

public class MetodoPagoPopularDTO {
    private String tipo;
    private Long cantidad;

    public MetodoPagoPopularDTO(String tipo, Long cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
