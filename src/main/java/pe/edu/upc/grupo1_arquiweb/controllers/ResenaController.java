package pe.edu.upc.grupo1_arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.grupo1_arquiweb.dtos.ResenaDTO;
import pe.edu.upc.grupo1_arquiweb.entities.Resena;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.IResenaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reseñas")
public class ResenaController {

    @Autowired
    private IResenaService rS;


    @GetMapping
    public List<ResenaDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ResenaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resena r= m.map(dto, Resena.class);
        rS.insert(r);
    }

    @PutMapping
    public void modificar(@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resena r = m.map(dto, Resena.class);
        rS.update(r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        rS.delete(id);
    }

}
