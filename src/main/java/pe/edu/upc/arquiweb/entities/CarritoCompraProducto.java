package pe.edu.upc.arquiweb.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "carrito_compra_producto")
public class CarritoCompraProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int cantidad;

    private String status;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_carrito")
    private CarritoCompra carrito;

    @Column(name = "id_montototal")
    private double montoTotal;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public CarritoCompra getCarrito() { return carrito; }
    public void setCarrito(CarritoCompra carrito) { this.carrito = carrito; }

    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }
}