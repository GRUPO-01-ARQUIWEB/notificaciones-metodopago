package pe.edu.upc.grupo1_arquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CarritoCompra")
public class CarritoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarritoCompra;

    @Column(name = "fechaCreaCarritoCompra", nullable = false)
    private LocalDate fechaCreaCarritoCompra;

    @ManyToOne
    @JoinColumn(name = "metodopago_id")
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public CarritoCompra() {
    }

    public CarritoCompra(Long idCarritoCompra, LocalDate fechaCreaCarritoCompra, MetodoPago metodoPago, Producto producto, Users user) {
        this.idCarritoCompra = idCarritoCompra;
        this.fechaCreaCarritoCompra = fechaCreaCarritoCompra;
        this.metodoPago = metodoPago;
        this.producto = producto;
        this.user = user;
    }

    public Long getIdCarritoCompra() {
        return idCarritoCompra;
    }

    public void setIdCarritoCompra(Long idCarritoCompra) {
        this.idCarritoCompra = idCarritoCompra;
    }

    public LocalDate getFechaCreaCarritoCompra() {
        return fechaCreaCarritoCompra;
    }

    public void setFechaCreaCarritoCompra(LocalDate fechaCreaCarritoCompra) {
        this.fechaCreaCarritoCompra = fechaCreaCarritoCompra;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
