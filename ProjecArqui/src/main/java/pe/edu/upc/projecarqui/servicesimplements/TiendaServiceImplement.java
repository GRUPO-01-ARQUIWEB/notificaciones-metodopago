package pe.edu.upc.projecarqui.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.projecarqui.entities.Tienda;
import pe.edu.upc.projecarqui.repositories.ITiendaRepository;
import pe.edu.upc.projecarqui.servicesinterfaces.ITiendaService;

@Service
public class TiendaServiceImplement implements ITiendaService {

    @Autowired
    private ITiendaRepository tR;

    @Override
    public void insert(Tienda t) {
        tR.save(t);
    }
}
