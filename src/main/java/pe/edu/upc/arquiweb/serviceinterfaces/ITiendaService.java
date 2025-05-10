package pe.edu.upc.arquiweb.serviceinterfaces;


import pe.edu.upc.arquiweb.entities.Tienda;


import java.util.List;

public interface ITiendaService {
    public List<Tienda> list();
    public void insert (Tienda t);
    public void delete (int id);
    public Tienda searchId(int id);
}
