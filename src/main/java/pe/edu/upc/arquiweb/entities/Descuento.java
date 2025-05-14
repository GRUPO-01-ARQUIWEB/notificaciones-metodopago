package pe.edu.upc.arquiweb.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Table(name = "Descuento")
public class Descuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDescuento;

    @Positive(message = "El porcentaje debe ser mayor que 0")
    @Column(name = "porcentaje", nullable = false)
    private double porcentaje;

    @NotNull(message = "El codigo de descuento es obligatorio")
    @Column(name = "codDescuento", nullable = false, length = 20)
    private String codDescuento;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    @Column(name = "fechaFin", nullable = false)
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    public Descuento() {
    }

    public Descuento(int idDescuento, double porcentaje, String codDescuento, LocalDate fechaInicio, LocalDate fechaFin, Producto producto) {
        this.idDescuento = idDescuento;
        this.porcentaje = porcentaje;
        this.codDescuento = codDescuento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.producto = producto;
    }

    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getCodDescuento() {
        return codDescuento;
    }

    public void setCodDescuento(String codDescuento) {
        this.codDescuento = codDescuento;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
