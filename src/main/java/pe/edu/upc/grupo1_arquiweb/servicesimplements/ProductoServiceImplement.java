package pe.edu.upc.grupo1_arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.grupo1_arquiweb.entities.Producto;
import pe.edu.upc.grupo1_arquiweb.repositories.IProductoRepository;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.IProductoService;

import java.util.List;

@Service
public class ProductoServiceImplement implements IProductoService {

    @Autowired
    private IProductoRepository pR;

    @Override
    public List<Producto> list() {
        return pR.findAll();
    }

    @Override
    public void insert(Producto p) {
        pR.save(p);
    }

    @Override
    public void update(Producto p) {
        pR.save(p);
    }

    @Override
    public void delete(Long id) {
        pR.deleteById(id);
    }
}
