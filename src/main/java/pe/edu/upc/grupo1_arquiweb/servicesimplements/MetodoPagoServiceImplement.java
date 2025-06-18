package pe.edu.upc.grupo1_arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.grupo1_arquiweb.entities.MetodoPago;
import pe.edu.upc.grupo1_arquiweb.repositories.IMetodoPagoRepository;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.IMetodoPagoService;

import java.util.List;

@Service
public class MetodoPagoServiceImplement implements IMetodoPagoService {

    @Autowired
    private IMetodoPagoRepository mR;

    @Override
    public List<MetodoPago> list() {
        return mR.findAll();
    }

    @Override
    public void insert(MetodoPago mp) {
        mR.save(mp);
    }

    @Override
    public void update(MetodoPago mp) {
        mR.save(mp);
    }

    @Override
    public void delete(Long id) {
        mR.deleteById(id);
    }
}
