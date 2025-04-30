package pe.edu.upc.arquiweb.demog1.dtos;

import java.time.LocalDate;

public class CarritoCompraDTO {
    private int idCarrito;
    private int idUsuario; //USUARIO FK
    private int idProducto; //PRODUCTO FK
    private LocalDate fechaCreacion;
    private int idMetodo; //METODO FK
    private int idMontototal;


    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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
