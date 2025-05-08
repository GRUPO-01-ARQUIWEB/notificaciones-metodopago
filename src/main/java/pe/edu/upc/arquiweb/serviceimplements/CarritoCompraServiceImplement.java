package pe.edu.upc.arquiweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.entities.CarritoCompra;
import pe.edu.upc.arquiweb.repositories.CarritCompraRepository;
import pe.edu.upc.arquiweb.servicesinterfaces.CarritoCompraServices;

import java.util.List;

@Service
public class CarritoCompraServiceImplement implements CarritoCompraServices {
    @Autowired
    private CarritCompraRepository ccR;
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


}
