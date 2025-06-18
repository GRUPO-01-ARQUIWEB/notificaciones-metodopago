package pe.edu.upc.grupo1_arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.grupo1_arquiweb.dtos.DescuentoDTO;
import pe.edu.upc.grupo1_arquiweb.entities.Descuento;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.IDescuentoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/descuentos")
public class DescuentoController {

    @Autowired
    private IDescuentoService dS;

    @GetMapping
    public List<DescuentoDTO> listar() {
        return dS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DescuentoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody DescuentoDTO dto) {
        ModelMapper m = new ModelMapper();
        Descuento d = m.map(dto, Descuento.class);
        dS.insert(d);
    }

    @PutMapping
    public void modificar(@RequestBody DescuentoDTO dto) {
        ModelMapper m = new ModelMapper();
        Descuento d = m.map(dto, Descuento.class);
        dS.update(d);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        dS.delete(id);
    }
}
