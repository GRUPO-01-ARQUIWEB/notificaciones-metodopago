package pe.edu.upc.arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.entities.CarritoCompra;
import pe.edu.upc.arquiweb.repositories.ICarritoCompraRepository;
import pe.edu.upc.arquiweb.servicesinterfaces.ICarritoCompraServices;

import java.util.List;

@Service
public class CarritoCompraServiceImplements implements ICarritoCompraServices {
    @Autowired
    private ICarritoCompraRepository ccR;
    @Override
    public List<CarritoCompra> list(){
        return ccR.findAll();

    }

    @Override
    public void insert(CarritoCompra carritoCompra) {
        ccR.save(carritoCompra);
    }

    @Override
    public void delete(int idProducto) {
        ccR.deleteById(idProducto);
    }

    @Override
    public void update(CarritoCompra a) {
        ccR.save(a);
    }

    @Override
    public List<String[]> orderCartPurchase() {
        return ccR.ordenarCarritoCompra();
    }
    @Override
    public List<String[]> orderCartPurchaseUserdateCreaction() {
        return ccR.ordenarCarritoCompraUsuarioxFechaCreacion();
    }
}
