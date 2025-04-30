package pe.edu.upc.projecarqui.servicesinterfaces;


import pe.edu.upc.projecarqui.entities.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> list();
    public void insert (Usuario u);
}
