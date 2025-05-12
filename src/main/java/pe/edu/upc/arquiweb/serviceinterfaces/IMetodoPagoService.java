package pe.edu.upc.arquiweb.serviceinterfaces;

import pe.edu.upc.arquiweb.entities.MetodoPago;
import pe.edu.upc.arquiweb.repositories.IMetodoPagoRepository;

import java.util.List;

public interface IMetodoPagoService {
    public List<MetodoPago> list();
    public void insert(MetodoPago m);
    public MetodoPago searchID(int id);
    public void update(MetodoPago m);
    public void delete(int id);
    List<MetodoPago> search(String idUsuario);

}
