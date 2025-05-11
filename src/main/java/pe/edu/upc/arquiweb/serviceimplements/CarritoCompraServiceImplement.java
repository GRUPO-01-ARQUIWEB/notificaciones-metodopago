package pe.edu.upc.arquiweb.serviceimplements;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.entities.CarritoCompra;
import pe.edu.upc.arquiweb.repositories.ICarritoCompraRepository;
import pe.edu.upc.arquiweb.serviceinterfaces.ICarritoCompraService;

import java.util.List;

@Service
public class CarritoCompraServiceImplement implements ICarritoCompraService {
    @Autowired
    private ICarritoCompraRepository ccR;
    @Autowired
    private ModelMapper modelMapper;


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
    public List<String[]> ordenarCarritoCompra() {
        return ccR.ordenarCarritoCompra();
    }
    @Override
    public List<String[]> ordenarCarritoCompraUsuarioxFechaCreacion() {
        return ccR.ordenarCarritoCompraUsuarioxFechaCreacion();
    }
}

