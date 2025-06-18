package pe.edu.upc.grupo1_arquiweb.servicesinterfaces;

import pe.edu.upc.grupo1_arquiweb.entities.Users;

import java.util.List;

public interface IUsersService {

    public List<Users> list();
    public void insert (Users u);
    public void update(Users u);
    public void delete (Long id);
}
