package pe.edu.upc.arquiweb.serviceimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.entities.MetodoPago;
import pe.edu.upc.arquiweb.repositories.IMetodoPagoRepository;
import pe.edu.upc.arquiweb.serviceinterfaces.IMetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;

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
    public void insert(MetodoPago m) {
        mR.save(m);
    }

    @Override
    public MetodoPago searchID(int id) {
        return mR.findById(id).orElse(null);
    }

    @Override
    public void update(MetodoPago m) {
        mR.save(m);
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }


    @Override
    public List<MetodoPago> search(String idUsuario) {
    int id = Integer.parseInt(idUsuario);
    return mR.buscarPorUsuario(id);
    }
}
