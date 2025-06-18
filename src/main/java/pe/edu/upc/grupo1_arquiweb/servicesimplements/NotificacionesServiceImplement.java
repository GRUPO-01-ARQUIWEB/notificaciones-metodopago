package pe.edu.upc.grupo1_arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.grupo1_arquiweb.entities.Notificaciones;
import pe.edu.upc.grupo1_arquiweb.repositories.INotificacionesRepository;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.INotificacionesService;

import java.util.List;

@Service
public class NotificacionesServiceImplement implements INotificacionesService {

    @Autowired
    private INotificacionesRepository nR;

    @Override
    public List<Notificaciones> list() {
        return nR.findAll();
    }

    @Override
    public void insert(Notificaciones n) {
        nR.save(n);
    }

    @Override
    public void update(Notificaciones n) {
        nR.save(n);
    }

    @Override
    public void delete(Long id) {
        nR.deleteById(id);
    }
}
