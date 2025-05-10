package pe.edu.upc.arquiweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.entities.Producto;
import pe.edu.upc.arquiweb.repositories.ProductRepository;

import java.util.List;
@Service
public class ProductServiceImplement implements ProductServices {
    @Autowired
    private ProductRepository pR;
    @Override
    public List<Producto> list(){
        return pR.findAll();
    }

    @Override
    public void insert(Producto producto) {

    }
}
