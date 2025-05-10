package pe.edu.upc.arquiweb.serviceinterfaces;

import pe.edu.upc.arquiweb.dtos.ProductoCompradoDTO;
import pe.edu.upc.arquiweb.entities.CarritoCompraProducto;

import java.util.List;

public interface CarritoCompraProductoServices {
    void insert(CarritoCompraProducto producto);
    List<CarritoCompraProducto> list();
    void delete(int id);
    void update(CarritoCompraProducto producto);

    List<ProductoCompradoDTO> productosMasComprados();

}