package pe.edu.upc.arquiweb.dtos.servicesinterfaces;

import pe.edu.upc.demog1.entities.Producto;

import java.util.List;

public interface ProductServices {
    public List<Producto> list();
    public void insert(Producto producto);

}
