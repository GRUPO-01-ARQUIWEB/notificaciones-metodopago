package pe.edu.upc.arquiweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.dtos.ProductoMasCompradoDTO;
import pe.edu.upc.arquiweb.entities.CarritoCompraProducto;
import pe.edu.upc.arquiweb.repositories.CarritoCompraProductoRepository;
import pe.edu.upc.arquiweb.serviceinterfaces.CarritoCompraProductoServices;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoCompraProductoServiceImplement implements CarritoCompraProductoServices {

    @Autowired
    private CarritoCompraProductoRepository repo;

    @Override
    public void insert(CarritoCompraProducto producto) {
        repo.save(producto);
    }

    @Override
    public List<CarritoCompraProducto> list() {
        return repo.findAll();
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void update(CarritoCompraProducto producto) {
        repo.save(producto);
    }

    @Override
    public List<ProductoMasCompradoDTO> productosMasComprados() {
        List<Object[]> data = repo.productosMasCompradosRaw();
        List<ProductoMasCompradoDTO> lista = new ArrayList<>();
        for (Object[] obj : data) {
            ProductoMasCompradoDTO dto = new ProductoMasCompradoDTO(
                    (Integer) obj[0],
                    ((Number) obj[1]).intValue()
            );
            lista.add(dto);
        }
        return lista;
    }
}