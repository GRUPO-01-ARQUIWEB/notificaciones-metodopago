package pe.edu.upc.arquiweb.dtos;

import java.time.LocalDate;

public class ListarDescuentosOrdenadosPorPorcentajeDTO {
    private int idDescuento;
    private String codDescuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double porcentaje;
    private int idProducto;

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

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getCodDescuento() {
        return codDescuento;
    }

    public void setCodDescuento(String codDescuento) {
        this.codDescuento = codDescuento;
    }
}
