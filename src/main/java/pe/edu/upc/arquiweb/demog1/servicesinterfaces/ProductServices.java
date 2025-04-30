package pe.edu.upc.arquiweb.demog1.servicesinterfaces;

import pe.edu.upc.demog1.entities.Producto;

import java.util.List;

public interface ProductServices {
    public List<Producto> list();
    public void insert(Producto producto);

}
