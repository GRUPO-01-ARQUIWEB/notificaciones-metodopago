package pe.edu.upc.arquiweb.serviceinterfaces;

import pe.edu.upc.arquiweb.dtos.ComparadorPrecioDTO;
import pe.edu.upc.arquiweb.entities.Comparador;

import java.util.List;

public interface IComparadorService {
    public List<Comparador> list();
    public void insert (Comparador cp);
    public void delete (int id);
    public void update(Comparador cp);
    public List<ComparadorPrecioDTO> compararPrecio(List<Integer> prodID);
}
