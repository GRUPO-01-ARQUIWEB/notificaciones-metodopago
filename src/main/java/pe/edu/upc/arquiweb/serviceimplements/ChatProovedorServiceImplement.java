package pe.edu.upc.arquiweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.entities.ChatProveedor;
import pe.edu.upc.arquiweb.repositories.IChatProveedorRepository;
import pe.edu.upc.arquiweb.serviceinterfaces.IChatProveedorService;

import java.util.List;

@Service
public class ChatProovedorServiceImplement implements IChatProveedorService {
    @Autowired
    private IChatProveedorRepository cR;

    @Override
    public List<ChatProveedor> list() {
        return cR.findAll();
    }

    @Override
    public void insert(ChatProveedor cp) {
        cR.save(cp);
    }

    @Override
    public void update(ChatProveedor cp) {
        cR.save(cp);
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }
}
