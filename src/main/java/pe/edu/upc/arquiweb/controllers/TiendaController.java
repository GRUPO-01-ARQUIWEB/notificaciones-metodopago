package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.TiendaDTO;
import pe.edu.upc.arquiweb.entities.Tienda;
import pe.edu.upc.arquiweb.servicesinterfaces.ITiendaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {
    @Autowired
    private ITiendaService iS;

    @GetMapping
    public List<TiendaDTO> listar(){
        return iS.list().stream().map(i ->{
            ModelMapper m= new ModelMapper();
            return m.map(i,TiendaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody TiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        Tienda t = m.map(dto, Tienda.class);
        iS.insert(t);
    }

    @DeleteMapping("/eliminar{id}")
    public void eliminar(@PathVariable("id") int id) {
        iS.delete(id);
    }

    @GetMapping("/{id}")
    public TiendaDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        TiendaDTO dto = m.map(iS.searchId(id), TiendaDTO.class);
        return dto;
    }

}
