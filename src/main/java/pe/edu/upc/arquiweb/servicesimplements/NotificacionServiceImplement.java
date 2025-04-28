package pe.edu.upc.arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.entities.Notificaciones;
import pe.edu.upc.arquiweb.repositories.INotificacionesRepository;
import pe.edu.upc.arquiweb.servicesinerfaces.INotificacionService;

import java.util.List;

@Service
public class NotificacionServiceImplement implements INotificacionService {

    @Autowired
    private INotificacionesRepository nR;

    @Override
    public List<Notificaciones> list() {
        return nR.findAll();
    }

    @Override
    public void insert(Notificaciones a) {
        nR.save(a);
    }


    @Override
    public Notificaciones searchID(int id) {
        return null;
    }


    @Override
    public void update(Notificaciones a) {
        nR.save(a);
    }

    @Override
    public void delete(int id) {
        nR.deleteById(id);
    }

    @Override
    public List<Notificaciones> search(String name) {
        return nR.buscar(name);
    }
}

