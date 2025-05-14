package pe.edu.upc.arquiweb.dtos;

public class ProductoMasCompradoDTO {
    private int idProducto;
    private int totalComprado;

    public ProductoMasCompradoDTO() {}

    public ProductoMasCompradoDTO(int idProducto, int totalComprado) {
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
