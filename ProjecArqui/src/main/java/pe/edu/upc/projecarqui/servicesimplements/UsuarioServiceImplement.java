package pe.edu.upc.projecarqui.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.projecarqui.entities.Usuario;
import pe.edu.upc.projecarqui.repositories.IUsuarioRepository;
import pe.edu.upc.projecarqui.servicesinterfaces.IUsuarioService;

import java.util.List;


@Service
public class UsuarioServiceImplement implements IUsuarioService {

    @Autowired
    private IUsuarioRepository uR;

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void insert(Usuario u) {
        uR.save(u);
    }
}
