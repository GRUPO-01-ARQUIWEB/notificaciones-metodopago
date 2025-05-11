package pe.edu.upc.arquiweb.serviceinterfaces;

import pe.edu.upc.arquiweb.entities.Descuento;
import java.util.List;

public interface IDescuentoService {
    public List<Descuento> list();
    public void insert(Descuento descuento);

    public void delete(int idProducto);
    public List<String[]> ListarDescVigentes();
    public List<Descuento>obtenerDescuentosOrdenados();
}
