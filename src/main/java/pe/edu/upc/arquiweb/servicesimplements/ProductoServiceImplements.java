package pe.edu.upc.arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.entities.Producto;
import pe.edu.upc.arquiweb.repositories.IProductoRepository;
import pe.edu.upc.arquiweb.servicesinterfaces.ProductoServices;


import java.util.List;
@Service
public class ProductoServiceImplements implements ProductoServices {
    @Autowired
    private IProductoRepository pR;
    @Override
    public List<Producto> list(){
        return pR.findAll();
    }

    @Override
    public void insert(Producto producto) {

    }
}
