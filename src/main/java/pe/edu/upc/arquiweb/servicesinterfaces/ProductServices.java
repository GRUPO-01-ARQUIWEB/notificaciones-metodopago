package pe.edu.upc.arquiweb.servicesinterfaces;

import pe.edu.upc.arquiweb.entities.Producto;

import java.util.List;

public interface ProductServices {
    public List<Producto> list();
    public void insert(Producto producto);

}
