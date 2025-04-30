package pe.edu.upc.arquiweb.servicesinterfaces;

import pe.edu.upc.arquiweb.entities.Notificaciones;

import java.util.List;

public interface INotificacionService {
    public List<Notificaciones> list();
    public void insert(Notificaciones a);
    public Notificaciones searchID(int id);
    public void update(Notificaciones a);
    public void delete(int id);
    public List<Notificaciones> search(String name);
}
