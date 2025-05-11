package pe.edu.upc.arquiweb.serviceinterfaces;

import pe.edu.upc.arquiweb.entities.ComparadorPrecio;
import pe.edu.upc.arquiweb.entities.LogAcceso;

import java.util.List;

public interface IComparadorPrecioService {
    public List<ComparadorPrecio> list();
    public void insert (ComparadorPrecio cp);
    public void delete (int id);
    public void update(ComparadorPrecio cp);
}
