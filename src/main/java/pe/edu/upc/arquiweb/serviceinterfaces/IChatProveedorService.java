package pe.edu.upc.arquiweb.serviceinterfaces;

import pe.edu.upc.arquiweb.entities.ChatProveedor;
import pe.edu.upc.arquiweb.entities.Usuario;


import java.util.List;

public interface IChatProveedorService {
    public List<ChatProveedor> list();
    public void insert (ChatProveedor cp);
    public void update(ChatProveedor cp);
    public void delete (int id);
}
