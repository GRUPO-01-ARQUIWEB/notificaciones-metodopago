package pe.edu.upc.grupo1_arquiweb.servicesinterfaces;

import pe.edu.upc.grupo1_arquiweb.entities.Chat;

import java.util.List;

public interface IChatService {

    public List<Chat> list();
    public void insert (Chat c);
    public void update(Chat c);
    public void delete (Long id);
}
