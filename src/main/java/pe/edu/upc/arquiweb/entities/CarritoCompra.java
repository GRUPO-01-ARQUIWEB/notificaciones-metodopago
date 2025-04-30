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

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @Column(name = "id_metodo", nullable = false)
    private int idMetodo; // Si después tienes una entidad MetodoPago, puedes relacionarla igual con @ManyToOne

    @Column(name = "id_montototal", nullable = false)
    private int idMontototal;

    public CarritoCompra() {
    }

    public CarritoCompra(int idCarrito, Usuario usuario, Producto producto, LocalDate fechaCreacion, int idMetodo, int idMontototal) {
        this.idCarrito = idCarrito;
        this.usuario = usuario;
        this.producto = producto;
        this.fechaCreacion = fechaCreacion;
        this.idMetodo = idMetodo;
        this.idMontototal = idMontototal;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdMetodo() {
        return idMetodo;
    }

    public void setIdMetodo(int idMetodo) {
        this.idMetodo = idMetodo;
    }

    public int getIdMontototal() {
        return idMontototal;
    }

    public void setIdMontototal(int idMontototal) {
        this.idMontototal = idMontototal;
    }
}