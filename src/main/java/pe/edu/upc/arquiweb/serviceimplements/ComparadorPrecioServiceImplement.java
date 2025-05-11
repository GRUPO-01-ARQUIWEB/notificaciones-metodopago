package pe.edu.upc.arquiweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.dtos.ComparadorPrecioDTO;
import pe.edu.upc.arquiweb.entities.ComparadorPrecio;
import pe.edu.upc.arquiweb.repositories.IComparadorPrecioRepository;
import pe.edu.upc.arquiweb.serviceinterfaces.IComparadorPrecioService;

import java.util.List;

@Service
public class ComparadorPrecioServiceImplement implements IComparadorPrecioService {
    @Autowired
    private IComparadorPrecioRepository cpR;


    @Override
    public List<ComparadorPrecio> list() {
        return cpR.findAll();
    }

    @Override
    public void insert(ComparadorPrecio cp) {
        cpR.save(cp);
    }

    @Override
    public void delete(int id) {
        cpR.deleteById(id);
    }

    @Override
    public void update(ComparadorPrecio cp) {
        cpR.save(cp);
    }

    @Override
    public List<ComparadorPrecioDTO> compararproductos(List<Integer> producID) {
        return cpR.compararproductos(producID);
    }
}
