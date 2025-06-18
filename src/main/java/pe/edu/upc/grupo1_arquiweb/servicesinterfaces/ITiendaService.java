package pe.edu.upc.grupo1_arquiweb.servicesinterfaces;

import pe.edu.upc.grupo1_arquiweb.entities.Tienda;

import java.util.List;

public interface ITiendaService {

    public List<Tienda> list();
    public void insert (Tienda t);
    public void update(Tienda t);
    public void delete (Long id);
}
