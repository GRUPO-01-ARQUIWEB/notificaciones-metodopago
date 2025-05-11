package pe.edu.upc.arquiweb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Producto")

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(name = "nombreProducto", nullable = false, length = 40)
    private String nombreProducto;

    @Column(name = "descripcion", nullable = false, length = 300)
    private String descripcion;

    @Column(name = "precioBase", nullable = false)
    private double precioBase;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDate fechaCreacion;

    //CLAVES FORANEAS
    @ManyToOne
    @JoinColumn(name = "idTienda")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "idTipoCategoria")
    private TipoCategoria tipoCategoria;

    public Producto() {
    }

    public Producto(int idProducto, String nombreProducto, String descripcion, double precioBase, int stock, String categoria, LocalDate fechaCreacion, Tienda tienda, TipoCategoria tipoCategoria) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.stock = stock;
        this.categoria = categoria;
        this.fechaCreacion = fechaCreacion;
        this.tienda = tienda;
        this.tipoCategoria = tipoCategoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public TipoCategoria getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(TipoCategoria tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }
}
