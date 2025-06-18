package pe.edu.upc.grupo1_arquiweb.servicesinterfaces;

import pe.edu.upc.grupo1_arquiweb.entities.LogAcceso;

import java.util.List;

public interface ILogAccesoService {

    public List<LogAcceso> list();
    public void insert (LogAcceso la);
    public void update(LogAcceso la);
    public void delete (Long id);
}
