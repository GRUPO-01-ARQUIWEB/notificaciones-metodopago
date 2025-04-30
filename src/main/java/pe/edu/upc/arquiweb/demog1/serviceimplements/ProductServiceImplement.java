package pe.edu.upc.arquiweb.demog1.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demog1.entities.Producto;
import pe.edu.upc.demog1.repositories.ProductRepository;
import pe.edu.upc.demog1.servicesinterfaces.ProductServices;

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
