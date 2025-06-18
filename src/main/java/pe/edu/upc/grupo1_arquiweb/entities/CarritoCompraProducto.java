package pe.edu.upc.grupo1_arquiweb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CarritoCompraProducto")
public class CarritoCompraProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarritoCompraProducto;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "carritoCompra_id")
    private CarritoCompra carritoCompra;

    public CarritoCompraProducto() {
    }

    public CarritoCompraProducto(Long idCarritoCompraProducto, Boolean estado, CarritoCompra carritoCompra) {
        this.idCarritoCompraProducto = idCarritoCompraProducto;
        this.estado = estado;
        this.carritoCompra = carritoCompra;
    }

    public Long getIdCarritoCompraProducto() {
        return idCarritoCompraProducto;
    }

    public void setIdCarritoCompraProducto(Long idCarritoCompraProducto) {
        this.idCarritoCompraProducto = idCarritoCompraProducto;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public CarritoCompra getCarritoCompra() {
        return carritoCompra;
    }

    public void setCarritoCompra(CarritoCompra carritoCompra) {
        this.carritoCompra = carritoCompra;
    }
}
