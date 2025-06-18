package pe.edu.upc.grupo1_arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.grupo1_arquiweb.entities.CarritoCompra;
import pe.edu.upc.grupo1_arquiweb.repositories.ICarritoCompraRepository;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.ICarritoCompraService;

import java.util.List;

@Service
public class CarritoCompraServiceImplement implements ICarritoCompraService {

    @Autowired
    private ICarritoCompraRepository ccR;

    @Override
    public List<CarritoCompra> list() {
        return ccR.findAll();
    }

    @Override
    public void insert(CarritoCompra cc) {
        ccR.save(cc);
    }

    @Override
    public void update(CarritoCompra cc) {
        ccR.save(cc);
    }

    @Override
    public void delete(Long id) {
        ccR.deleteById(id);
    }
}
