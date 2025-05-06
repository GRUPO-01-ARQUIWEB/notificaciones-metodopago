package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CarritoCompra")
public class CarritoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrito;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;
    @JoinColumn(name = "id_preciobase")
    private double precioBase;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_metodopago", nullable = false)
    private MetodoPago idMetodo; // Si después tienes una entidad MetodoPago, puedes relacionarla igual con @ManyToOne


    public CarritoCompra() {
    }

    public CarritoCompra(int idCarrito, MetodoPago idMetodo, LocalDate fechaCreacion, double precioBase, Producto producto, Usuario usuario) {
        this.idCarrito = idCarrito;
        this.idMetodo = idMetodo;
        this.fechaCreacion = fechaCreacion;
        this.precioBase = precioBase;
        this.producto = producto;
        this.usuario = usuario;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public MetodoPago getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(MetodoPago idMetodo) {
        this.idMetodo = idMetodo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
