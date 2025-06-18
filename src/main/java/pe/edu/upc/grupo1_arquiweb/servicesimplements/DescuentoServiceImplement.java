package pe.edu.upc.grupo1_arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.grupo1_arquiweb.entities.Descuento;
import pe.edu.upc.grupo1_arquiweb.repositories.IDescuentoRepository;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.IDescuentoService;

import java.util.List;

@Service
public class DescuentoServiceImplement implements IDescuentoService {

    @Autowired
    private IDescuentoRepository dR;

    @Override
    public List<Descuento> list() {
        return dR.findAll();
    }

    @Override
    public void insert(Descuento d) {
        dR.save(d);
    }

    @Override
    public void update(Descuento d) {
        dR.save(d);
    }

    @Override
    public void delete(Long id) {
        dR.deleteById(id);
    }
}
