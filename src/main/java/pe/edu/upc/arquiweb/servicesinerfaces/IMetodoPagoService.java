package pe.edu.upc.arquiweb.servicesinerfaces;

import pe.edu.upc.arquiweb.entities.MetodoPago;

import java.util.List;

public interface IMetodoPagoService {
    public List<MetodoPago> list();
    public void insert(MetodoPago m);
    public MetodoPago searchID(int id);
    public void update(MetodoPago m);
    public void delete(int id);
    public List<MetodoPago> search(String titular);
}
