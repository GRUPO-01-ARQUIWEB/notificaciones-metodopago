package pe.edu.upc.arquiweb.dtos.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demog1.dtos.ProductoCompradoDTO;
import pe.edu.upc.demog1.entities.CarritoCompraProducto;
import pe.edu.upc.demog1.repositories.CarritoCompraProductoRepository;
import pe.edu.upc.demog1.servicesinterfaces.CarritoCompraProductoServices;

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
    public List<ProductoCompradoDTO> productosMasComprados() {
        List<Object[]> data = repo.productosMasCompradosRaw();
        List<ProductoCompradoDTO> lista = new ArrayList<>();
        for (Object[] obj : data) {
            ProductoCompradoDTO dto = new ProductoCompradoDTO(
                    (Integer) obj[0],
                    ((Number) obj[1]).intValue()
            );
            lista.add(dto);
        }
        return lista;
    }


}