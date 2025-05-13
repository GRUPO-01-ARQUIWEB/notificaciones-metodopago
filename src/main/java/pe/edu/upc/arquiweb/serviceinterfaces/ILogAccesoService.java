package pe.edu.upc.arquiweb.serviceinterfaces;

import pe.edu.upc.arquiweb.entities.LogAcceso;
import pe.edu.upc.arquiweb.entities.Usuario;

import java.util.List;

public interface ILogAccesoService {
    public List<LogAcceso> list();
    public void insert (LogAcceso la);
    public void delete (int id);
    public void update(LogAcceso la);
}
