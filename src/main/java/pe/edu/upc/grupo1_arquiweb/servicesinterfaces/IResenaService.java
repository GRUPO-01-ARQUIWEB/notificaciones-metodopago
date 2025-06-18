package pe.edu.upc.grupo1_arquiweb.servicesinterfaces;

import pe.edu.upc.grupo1_arquiweb.entities.Resena;

import java.util.List;

public interface IResenaService {

    public List<Resena> list();
    public void insert (Resena r);
    public void update(Resena r);
    public void delete (Long id);
}
