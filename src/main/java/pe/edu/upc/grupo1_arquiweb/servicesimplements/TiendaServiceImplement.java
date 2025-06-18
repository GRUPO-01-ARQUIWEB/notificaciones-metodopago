package pe.edu.upc.grupo1_arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.grupo1_arquiweb.entities.Tienda;
import pe.edu.upc.grupo1_arquiweb.repositories.ITiendaRepository;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.ITiendaService;

import java.util.List;

@Service
public class TiendaServiceImplement implements ITiendaService {
    @Autowired
    private ITiendaRepository tR;

    @Override
    public List<Tienda> list() {
        return tR.findAll();
    }

    @Override
    public void insert(Tienda t) {
        tR.save(t);
    }

    @Override
    public void update(Tienda t) {
        tR.save(t);
    }

    @Override
    public void delete(Long id) {
        tR.deleteById(id);
    }
}
