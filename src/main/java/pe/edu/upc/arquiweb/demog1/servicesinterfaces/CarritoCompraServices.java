package pe.edu.upc.arquiweb.demog1.servicesinterfaces;

import pe.edu.upc.demog1.entities.CarritoCompra;

import java.util.List;

public interface CarritoCompraServices {
    public List<CarritoCompra> list();
    public void insert(CarritoCompra carritoCompra);
    public void delete(int idProducto);
    public void update(CarritoCompra a);


}
