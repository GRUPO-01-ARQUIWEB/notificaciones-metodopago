package pe.edu.upc.arquiweb.serviceinterfaces;

import pe.edu.upc.arquiweb.entities.ComentarioApp;
import pe.edu.upc.arquiweb.entities.ComparadorPrecio;

import java.util.List;

public interface IComentarioAppService {
    public List<ComentarioApp> list();
    public void insert (ComentarioApp ca);
    public void delete (int id);
    public void update(ComentarioApp ca);
}
