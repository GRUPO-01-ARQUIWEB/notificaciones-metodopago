package pe.edu.upc.arquiweb.serviceimplements;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.dtos.ComparadorPrecioDTO;
import pe.edu.upc.arquiweb.entities.Comparador;
import pe.edu.upc.arquiweb.repositories.IComparadorRepository;
import pe.edu.upc.arquiweb.serviceinterfaces.IComparadorService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComparadorServiceImplement implements IComparadorService {
    @Autowired
    private IComparadorRepository cpR;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<Comparador> list() {
        return cpR.findAll();
    }

    @Override
    public void insert(Comparador cp) {
        cpR.save(cp);
    }

    @Override
    public void delete(int id) {
        cpR.deleteById(id);
    }

    @Override
    public void update(Comparador cp) {
        cpR.save(cp);
    }

    @Override
    public List<ComparadorPrecioDTO> compararPrecio(List<Integer> prodID) {
        List<Comparador> entities = cpR.findForComparison(prodID);

        return entities.stream()
                .map(entity -> {
                    ComparadorPrecioDTO dto = new ComparadorPrecioDTO();
                    modelMapper.map(entity, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
