package pe.edu.upc.arquiweb.servicesinterfaces;

import pe.edu.upc.arquiweb.entities.MetodoPago;
import pe.edu.upc.arquiweb.entities.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> list();
    public void insert (Producto p);
    public void update(Producto p);
    public void delete (int id);
    public Producto searchId(int id);
    public List<Producto> search(String name);
    public List<Producto> searchFilters(Double precioBase, String categoria);
    public List<Producto> compareProduct(int id1, int id2);
    public List<String[]> qualitybyStore();
    List<Producto> productsWithLowStock();
}
