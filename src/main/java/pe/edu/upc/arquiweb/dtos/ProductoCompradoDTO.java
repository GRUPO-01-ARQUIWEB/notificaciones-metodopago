package pe.edu.upc.arquiweb.dtos;

public class ProductoCompradoDTO {
    private int idProducto;
    private int totalComprado;

    public ProductoCompradoDTO() {}

    public ProductoCompradoDTO(int idProducto, int totalComprado) {
        this.idProducto = idProducto;
        this.totalComprado = totalComprado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getTotalComprado() {
        return totalComprado;
    }

    public void setTotalComprado(int totalComprado) {
        this.totalComprado = totalComprado;
    }
}
