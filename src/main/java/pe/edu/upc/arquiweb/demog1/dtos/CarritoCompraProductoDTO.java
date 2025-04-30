package pe.edu.upc.arquiweb.demog1.dtos;

public class CarritoCompraProductoDTO {
    private int id;
    private int cantidad;
    private String status;
    private int idProducto;
    private int idCarrito;
    private double montoTotal;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public int getIdCarrito() { return idCarrito; }
    public void setIdCarrito(int idCarrito) { this.idCarrito = idCarrito; }

    public double getMontoTotal() { return montoTotal; }
    public void setMontoTotal(double montoTotal) { this.montoTotal = montoTotal; }
}
