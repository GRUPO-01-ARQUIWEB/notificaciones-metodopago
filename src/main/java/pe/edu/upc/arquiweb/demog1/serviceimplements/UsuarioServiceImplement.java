package pe.edu.upc.arquiweb.demog1.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demog1.entities.Usuario;
import pe.edu.upc.demog1.repositories.UsuarioRepository;
import pe.edu.upc.demog1.servicesinterfaces.UsuarioServices;

import java.util.List;
@Service

public class UsuarioServiceImplement implements UsuarioServices {
    @Autowired
    private UsuarioRepository aR;

    @Override
    public List<Usuario> list() {
        return aR.findAll();
    }
}
