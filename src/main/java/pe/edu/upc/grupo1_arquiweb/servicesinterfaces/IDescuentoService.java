package pe.edu.upc.grupo1_arquiweb.servicesinterfaces;

import pe.edu.upc.grupo1_arquiweb.entities.Descuento;

import java.util.List;

public interface IDescuentoService {

    public List<Descuento> list();
    public void insert (Descuento d);
    public void update(Descuento d);
    public void delete (Long id);
}
