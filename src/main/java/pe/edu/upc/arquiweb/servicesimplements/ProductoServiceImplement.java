package pe.edu.upc.arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.repositories.IProductoRepository;
import pe.edu.upc.arquiweb.servicesinerfaces.IProductoService;
import pe.edu.upc.arquiweb.entities.Producto;

import java.util.Arrays;
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
    public void delete(int id) {
        pR.deleteById(id);
    }

    @Override
    public Producto searchId(int id) {
        return pR.findById(id).orElse(new Producto());
    }

    @Override
    public List<Producto> search(String name) {
        return pR.buscar(name);
    }

    @Override
    public List<Producto> searchFilters(Double precioBase, String categoria) {
        return pR.buscarFiltros(precioBase, categoria);
    }

    @Override
    public List<Producto> compareProduct(int id1, int id2) {
        Producto producto1 = pR.findById(id1).orElse(null);
        Producto producto2 = pR.findById(id2).orElse(null);
        return Arrays.asList(producto1, producto2);
    }

    @Override
    public List<String[]> qualitybyStore() {
        return pR.cantidadProductos();
    }
}
