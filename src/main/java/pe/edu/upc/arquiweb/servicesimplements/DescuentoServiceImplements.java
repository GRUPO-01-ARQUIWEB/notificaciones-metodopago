package pe.edu.upc.arquiweb.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.entities.Descuento;
import pe.edu.upc.arquiweb.repositories.IDescuentoRepository;
import pe.edu.upc.arquiweb.servicesinterfaces.DescuentoService;

import java.util.List;

@Service
public class DescuentoServiceImplements implements DescuentoService {
    @Autowired
    private IDescuentoRepository dR;
    @Override
    public List<Descuento> list() {
        return dR.findAll();
    }
    @Override
    public void insert(Descuento descuento) {
        dR.save(descuento);
    }
    @Override
    public void delete(int idDescuento) {
        dR.deleteById(idDescuento);
    }
    @Override
    public List<String[]> ListarDescVigentes() {
        return dR.ListarDescVigentes();
    }
    @Override
    public List<Descuento> obtenerDescuentosOrdenados() {
        return dR.listarDescuentosOrdenadosPorPorcentaje();
    }

}
