package pe.edu.upc.arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.entities.Tienda;
import pe.edu.upc.arquiweb.repositories.ITiendaRepository;
import pe.edu.upc.arquiweb.servicesinterfaces.ITiendaService;

import java.util.List;

@Service
public class TiendaServiceImplement implements ITiendaService {
    @Autowired
    private ITiendaRepository tR;

    @Override
    public List<Tienda> list() {
        return tR.findAll();
    }
}