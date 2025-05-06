package pe.edu.upc.arquiweb.servicesinterfaces;


import pe.edu.upc.arquiweb.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert (Usuario u);
    public void update(Usuario u);
    public void delete (int id);
}

