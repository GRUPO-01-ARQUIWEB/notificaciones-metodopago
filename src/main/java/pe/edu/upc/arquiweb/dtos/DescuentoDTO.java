package pe.edu.upc.arquiweb.dtos;

import java.time.LocalDate;

public class DescuentoDTO {
    private int idDescuento;
    private int idProducto; // (FK)
    private double porcentaje;
    private String codDescuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getCodDescuento() {
        return codDescuento;
    }

    public void setCodDescuento(String codDescuento) {
        this.codDescuento = codDescuento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
