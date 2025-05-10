package pe.edu.upc.arquiweb.serviceinterfaces;

import pe.edu.upc.arquiweb.entities.CarritoCompra;

import java.util.List;

public interface CarritoCompraServices {
    public List<CarritoCompra> list();
    public void insert(CarritoCompra carritoCompra);
    public void delete(int idProducto);
    public void update(CarritoCompra a);


}
