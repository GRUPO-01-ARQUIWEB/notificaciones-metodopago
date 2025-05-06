package pe.edu.upc.arquiweb.servicesinterfaces;

import pe.edu.upc.arquiweb.entities.Resena;

import java.util.List;

public interface IResenaService {
    public List<Resena> list();
    public void insert (Resena r);
    public void delete (int id);
    public List<Resena> listReviewsRating();
}
