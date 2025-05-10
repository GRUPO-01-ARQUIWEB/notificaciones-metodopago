package pe.edu.upc.arquiweb.servicesinterfaces;

import pe.edu.upc.arquiweb.entities.CarritoCompra;
import java.util.List;

public interface ICarritoCompraServices {
    public List<CarritoCompra> list();
    public void insert(CarritoCompra carritoCompra);
    public void delete(int idProducto);
    public void update(CarritoCompra a);
    public List<String[]> ordenarCarritoCompra();
    public List<String[]> BuscarCarritoCompraXID(int idUsuario);

}
