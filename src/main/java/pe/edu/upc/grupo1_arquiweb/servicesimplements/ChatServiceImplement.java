package pe.edu.upc.grupo1_arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.grupo1_arquiweb.entities.Chat;
import pe.edu.upc.grupo1_arquiweb.repositories.IChatRepository;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.IChatService;

import java.util.List;

@Service
public class ChatServiceImplement implements IChatService {

    @Autowired
    private IChatRepository cR;

    @Override
    public List<Chat> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Chat c) {
        cR.save(c);
    }

    @Override
    public void update(Chat c) {
        cR.save(c);
    }

    @Override
    public void delete(Long id) {
        cR.deleteById(id);
    }
}
