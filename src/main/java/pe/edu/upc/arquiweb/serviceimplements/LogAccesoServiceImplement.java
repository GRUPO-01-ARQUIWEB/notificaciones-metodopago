package pe.edu.upc.arquiweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.arquiweb.entities.LogAcceso;
import pe.edu.upc.arquiweb.repositories.ILogAccesoRepository;
import pe.edu.upc.arquiweb.serviceinterfaces.ILogAccesoService;

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
    public void delete(int id) {
        laR.deleteById(id);
    }

    @Override
    public void update(LogAcceso la) {
        laR.save(la);
    }
}
