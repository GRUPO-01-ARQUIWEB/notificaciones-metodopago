package pe.edu.upc.grupo1_arquiweb.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Descuento")
public class Descuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDescuento;

    @Column(name = "porcentajeDescuento", nullable = false)
    private double porcentajeDescuento;

    @Column(name = "codigoDescuento", nullable = false, length = 100)
    private String codigoDescuento;

    @Column(name = "fechaInicioDescuento", nullable = false)
    private LocalDate fechaInicioDescuento;

    @Column(name = "fechaFinDescuento", nullable = false)
    private LocalDate fechaFinDescuento;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public Descuento() {
    }

    public Descuento(Long idDescuento, double porcentajeDescuento, String codigoDescuento, LocalDate fechaInicioDescuento, LocalDate fechaFinDescuento, Producto producto) {
        this.idDescuento = idDescuento;
        this.porcentajeDescuento = porcentajeDescuento;
        this.codigoDescuento = codigoDescuento;
        this.fechaInicioDescuento = fechaInicioDescuento;
        this.fechaFinDescuento = fechaFinDescuento;
        this.producto = producto;
    }

    public Long getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(Long idDescuento) {
        this.idDescuento = idDescuento;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getCodigoDescuento() {
        return codigoDescuento;
    }

    public void setCodigoDescuento(String codigoDescuento) {
        this.codigoDescuento = codigoDescuento;
    }

    public LocalDate getFechaInicioDescuento() {
        return fechaInicioDescuento;
    }

    public void setFechaInicioDescuento(LocalDate fechaInicioDescuento) {
        this.fechaInicioDescuento = fechaInicioDescuento;
    }

    public LocalDate getFechaFinDescuento() {
        return fechaFinDescuento;
    }

    public void setFechaFinDescuento(LocalDate fechaFinDescuento) {
        this.fechaFinDescuento = fechaFinDescuento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
