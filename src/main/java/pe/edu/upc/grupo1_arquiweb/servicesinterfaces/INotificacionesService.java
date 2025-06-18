package pe.edu.upc.grupo1_arquiweb.servicesinterfaces;

import pe.edu.upc.grupo1_arquiweb.entities.Notificaciones;

import java.util.List;

public interface INotificacionesService {

    public List<Notificaciones> list();
    public void insert (Notificaciones n);
    public void update(Notificaciones n);
    public void delete (Long id);
}
