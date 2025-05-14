package pe.edu.upc.arquiweb.serviceinterfaces;


import pe.edu.upc.arquiweb.entities.Tienda;
import pe.edu.upc.arquiweb.entities.Usuario;


import java.util.List;

public interface ITiendaService {
    public List<Tienda> list();
    public void insert (Tienda t);
    public void update(Tienda t);
    public void delete (int id);
    public void update (Tienda t);
    public Tienda searchId(int id);
}
