package pe.edu.upc.arquiweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.entities.Usuario;
import pe.edu.upc.arquiweb.repositories.UsuarioRepository;
import pe.edu.upc.arquiweb.servicesinterfaces.UsuarioServices;

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
