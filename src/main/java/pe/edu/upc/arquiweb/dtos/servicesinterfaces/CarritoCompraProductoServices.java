package pe.edu.upc.arquiweb.dtos.servicesinterfaces;

import pe.edu.upc.demog1.dtos.ProductoCompradoDTO;
import pe.edu.upc.demog1.entities.CarritoCompraProducto;

import java.util.List;

public interface CarritoCompraProductoServices {
    void insert(CarritoCompraProducto producto);
    List<CarritoCompraProducto> list();
    void delete(int id);
    void update(CarritoCompraProducto producto);

    List<ProductoCompradoDTO> productosMasComprados();

}