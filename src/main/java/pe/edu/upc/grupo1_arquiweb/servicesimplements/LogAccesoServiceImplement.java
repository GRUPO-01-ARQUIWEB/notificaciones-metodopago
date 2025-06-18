package pe.edu.upc.grupo1_arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.grupo1_arquiweb.entities.LogAcceso;
import pe.edu.upc.grupo1_arquiweb.repositories.ILogAccesoRepository;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.ILogAccesoService;

import java.util.List;

@Service
public class LogAccesoServiceImplement implements ILogAccesoService {

    @Autowired
    private ILogAccesoRepository laR;

    @Override
    public List<LogAcceso> list() {
        return laR.findAll();
    }

    @Override
    public void insert(LogAcceso la) {
        laR.save(la);
    }

    @Override
    public void update(LogAcceso la) {
        laR.save(la);
    }

    @Override
    public void delete(Long id) {
        laR.deleteById(id);
    }
}
