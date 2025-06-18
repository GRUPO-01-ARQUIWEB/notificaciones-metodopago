package pe.edu.upc.grupo1_arquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(name = "nombreProducto", nullable = false, length = 100)
    private String nombreProducto;

    @Column(name = "descripcionProducto", nullable = false, length = 200)
    private String descripcionProducto;

    @Column(name = "precioProducto", nullable = false)
    private double precioProducto;

    @Column(name = "categoriaProducto", nullable = false, length = 100)
    private String categoriaProducto;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "fechaCreacionProducto", nullable = false)
    private LocalDate fechaCreacionProducto;

    @ManyToOne
    @JoinColumn(name = "Tienda_id")
    private Tienda tienda;

    public Producto() {
    }

    public Producto(Long idProducto, String nombreProducto, String descripcionProducto, double precioProducto, String categoriaProducto, int stock, LocalDate fechaCreacionProducto, Tienda tienda) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.categoriaProducto = categoriaProducto;
        this.stock = stock;
        this.fechaCreacionProducto = fechaCreacionProducto;
        this.tienda = tienda;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getFechaCreacionProducto() {
        return fechaCreacionProducto;
    }

    public void setFechaCreacionProducto(LocalDate fechaCreacionProducto) {
        this.fechaCreacionProducto = fechaCreacionProducto;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
