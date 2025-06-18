package pe.edu.upc.grupo1_arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.grupo1_arquiweb.dtos.TiendaDTO;
import pe.edu.upc.grupo1_arquiweb.entities.Tienda;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.ITiendaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {

    @Autowired
    private ITiendaService tS;

    @GetMapping
    public List<TiendaDTO> listar() {
        return tS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TiendaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody TiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        Tienda t = m.map(dto, Tienda.class);
        tS.insert(t);
    }

    @PutMapping
    public void modificar(@RequestBody TiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        Tienda t = m.map(dto, Tienda.class);
        tS.update(t);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        tS.delete(id);
    }
}
