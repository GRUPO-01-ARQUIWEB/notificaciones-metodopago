package pe.edu.upc.arquiweb.serviceimplements;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.dtos.ComparadorPrecioDTO;
import pe.edu.upc.arquiweb.entities.ComparadorPrecio;
import pe.edu.upc.arquiweb.repositories.IComparadorPrecioRepository;
import pe.edu.upc.arquiweb.serviceinterfaces.IComparadorPrecioService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComparadorPrecioServiceImplement implements IComparadorPrecioService {
    @Autowired
    private IComparadorPrecioRepository cpR;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<ComparadorPrecio> list() {
        return cpR.findAll();
    }

    @Override
    public void insert(ComparadorPrecio cp) {
        cpR.save(cp);
    }

    @Override
    public void delete(int id) {
        cpR.deleteById(id);
    }

    @Override
    public void update(ComparadorPrecio cp) {
        cpR.save(cp);
    }

    @Override
    public List<ComparadorPrecioDTO> compararPrecio(List<Integer> prodID) {
        List<ComparadorPrecio> entities = cpR.findForComparison(prodID);

        return entities.stream()
                .map(entity -> {
                    ComparadorPrecioDTO dto = new ComparadorPrecioDTO();
                    modelMapper.map(entity, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
