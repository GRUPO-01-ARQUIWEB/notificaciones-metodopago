package pe.edu.upc.grupo1_arquiweb.servicesinterfaces;

import pe.edu.upc.grupo1_arquiweb.entities.CarritoCompra;

import java.util.List;

public interface ICarritoCompraService {

    public List<CarritoCompra> list();
    public void insert (CarritoCompra cc);
    public void update(CarritoCompra cc);
    public void delete (Long id);
}
