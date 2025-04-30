package pe.edu.upc.projecarqui.servicesinterfaces;


import pe.edu.upc.projecarqui.entities.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> list();
    public void insert (Producto p);
    public void delete (int id);
    public Producto searchId(int id);
    public List<Producto> search(String name);
    public List<Producto> searchFilters(Double precioBase, String categoria);
    public List<Producto> compareProduct(int id1, int id2);



}
