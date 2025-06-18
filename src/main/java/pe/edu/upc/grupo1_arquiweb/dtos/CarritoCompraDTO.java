package pe.edu.upc.grupo1_arquiweb.dtos;

import java.time.LocalDate;

public class CarritoCompraDTO {

    private Long idCarritoCompra;
    private LocalDate fechaCreaCarritoCompra;
    private Long idMetodoPago;
    private Long idProducto;
    private Long idUser;

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

    public Long getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Long idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
