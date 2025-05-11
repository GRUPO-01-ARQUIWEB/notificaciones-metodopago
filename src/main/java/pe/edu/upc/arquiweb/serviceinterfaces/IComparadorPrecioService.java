package pe.edu.upc.arquiweb.serviceinterfaces;

import pe.edu.upc.arquiweb.dtos.ComparadorPrecioDTO;
import pe.edu.upc.arquiweb.entities.ComparadorPrecio;

import java.util.List;

public interface IComparadorPrecioService {
    public List<ComparadorPrecio> list();
    public void insert (ComparadorPrecio cp);
    public void delete (int id);
    public void update(ComparadorPrecio cp);
    public List<ComparadorPrecioDTO> compararproductos(List<Integer> producID);
}
