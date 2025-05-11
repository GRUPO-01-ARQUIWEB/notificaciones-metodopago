package pe.edu.upc.arquiweb.dtos;

import pe.edu.upc.arquiweb.entities.Producto;
import pe.edu.upc.arquiweb.entities.Tienda;

import java.time.LocalDate;

public class ComparadorDTO {

    private int idComparador;
    private double precio;
    private LocalDate fechaActualizacion;
    private Producto producto;
    private Tienda tienda;

    public int getIdComparador() {
        return idComparador;
    }

    public void setIdComparador(int idComparador) {
        this.idComparador = idComparador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDate fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}

