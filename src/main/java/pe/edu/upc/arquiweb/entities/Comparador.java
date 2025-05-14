package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="ComparadorPrecio")
public class Comparador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComparador;

    @JoinColumn(name="precio",nullable = false)
    private double precio;

    @JoinColumn(name="fechaActualizacion",nullable = false)
    private LocalDate fechaActualizacion;

    @ManyToOne
    @JoinColumn(name="idProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name="idTienda")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name="idDescuento")
    private Descuento descuento;

    public Comparador() {
    }

    public Comparador(int idComparador, double precio, LocalDate fechaActualizacion, Producto producto, Tienda tienda, Descuento descuento) {
        this.idComparador = idComparador;
        this.precio = precio;
        this.fechaActualizacion = fechaActualizacion;
        this.producto = producto;
        this.tienda = tienda;
        this.descuento = descuento;
    }

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

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }
}
