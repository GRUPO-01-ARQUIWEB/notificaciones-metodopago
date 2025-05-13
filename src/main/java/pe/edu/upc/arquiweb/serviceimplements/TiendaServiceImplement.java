package pe.edu.upc.arquiweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.entities.Tienda;
import pe.edu.upc.arquiweb.entities.Usuario;
import pe.edu.upc.arquiweb.repositories.ITiendaRepository;
import pe.edu.upc.arquiweb.serviceinterfaces.ITiendaService;

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
    public void delete(int id) {
        tR.deleteById(id);
    }

    @Override
    public void update(Tienda t) {
        tR.save(t);
    }

    @Override
    public Tienda searchId(int id) {
        return tR.findById(id).orElse(new Tienda());
    }
}