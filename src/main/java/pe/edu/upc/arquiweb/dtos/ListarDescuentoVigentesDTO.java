package pe.edu.upc.arquiweb.dtos;

import java.time.LocalDate;

public class ListarDescuentoVigentesDTO {
    private int idDescuento;
    private String codDescuento;
    private double porcentaje;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCodDescuento() {
        return codDescuento;
    }

    public void setCodDescuento(String codDescuento) {
        this.codDescuento = codDescuento;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
