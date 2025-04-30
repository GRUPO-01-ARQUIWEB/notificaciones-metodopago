package pe.edu.upc.arquiweb.demog1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(name = "idTienda", nullable = false)
    private int idTienda;

    @Column(name = "idTipoCategoria", nullable = false)
    private int idTipoCategoria;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "precioBase", nullable = false)
    private double precioBase;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "categoria", nullable = false, length = 100)
    private String categoria;

    @Column(name = "fechaCreacion", nullable = false)
    private LocalDate fechaCreacion;

    public Producto() {
    }

    public Producto(int idProducto, int idTienda, int idTipoCategoria, String nombre, String descripcion, double precioBase, int stock, String categoria, LocalDate fechaCreacion) {
        this.idProducto = idProducto;
        this.idTienda = idTienda;
        this.idTipoCategoria = idTipoCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.stock = stock;
        this.categoria = categoria;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public int getIdTipoCategoria() {
        return idTipoCategoria;
    }

    public void setIdTipoCategoria(int idTipoCategoria) {
        this.idTipoCategoria = idTipoCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getId() {
        return idProducto;
    }

    public void setId(int id) {
        this.idProducto = id;
    }
}
