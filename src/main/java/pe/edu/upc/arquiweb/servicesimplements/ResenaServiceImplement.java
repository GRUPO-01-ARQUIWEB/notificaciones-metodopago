package pe.edu.upc.arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.entities.Resena;
import pe.edu.upc.arquiweb.repositories.IResenaRepository;
import pe.edu.upc.arquiweb.servicesinterfaces.IResenaService;

import java.util.List;

@Service
public class ResenaServiceImplement implements IResenaService {

    @Autowired
    private IResenaRepository rP;

    @Override
    public List<Resena> list() {
        return rP.findAll();
    }

    @Override
    public void insert(Resena r) {
        rP.save(r);
    }

    @Override
    public void delete(int id) {
        rP.deleteById(id);
    }

    @Override
    public List<Resena> listReviewsRating() {
        return rP.listarResenasCalificacion();
    }
}
