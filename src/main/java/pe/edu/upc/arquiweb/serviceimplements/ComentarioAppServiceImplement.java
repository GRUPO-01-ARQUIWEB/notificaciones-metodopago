package pe.edu.upc.arquiweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.entities.ComentarioApp;
import pe.edu.upc.arquiweb.repositories.IComentarioAppRepository;
import pe.edu.upc.arquiweb.serviceinterfaces.IComentarioAppService;

import java.util.List;


@Service
public class ComentarioAppServiceImplement implements IComentarioAppService {
    @Autowired
    private IComentarioAppRepository caR;

    @Override
    public List<ComentarioApp> list() {
        return caR.findAll();
    }

    @Override
    public void insert(ComentarioApp ca) {
        caR.save(ca);
    }

    @Override
    public void delete(int id) {
        caR.deleteById(id);
    }

    @Override
    public void update(ComentarioApp ca) {
        caR.save(ca);
    }
}
