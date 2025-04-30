package pe.edu.upc.projecarqui.servicesinterfaces;

import pe.edu.upc.projecarqui.entities.Producto;
import pe.edu.upc.projecarqui.entities.Resena;

import java.util.List;

public interface IResenaService {

    public List<Resena> list();
    public void insert (Resena r);
    public void delete (int id);
    public List<Resena> listReviewsRating();
}
