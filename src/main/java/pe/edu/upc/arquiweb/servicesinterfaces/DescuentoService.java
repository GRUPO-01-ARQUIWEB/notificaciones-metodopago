package pe.edu.upc.arquiweb.servicesinterfaces;

import pe.edu.upc.arquiweb.entities.CarritoCompra;
import pe.edu.upc.arquiweb.entities.Descuento;
import java.util.List;

public interface DescuentoService {
    public List<Descuento> list();
    public void insert(Descuento descuento);
    public void delete(int idProducto);
}
