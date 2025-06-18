package pe.edu.upc.grupo1_arquiweb.servicesinterfaces;

import pe.edu.upc.grupo1_arquiweb.entities.MetodoPago;

import java.util.List;

public interface IMetodoPagoService {

    public List<MetodoPago> list();
    public void insert (MetodoPago mp);
    public void update(MetodoPago mp);
    public void delete (Long id);
}
