package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.Resena2DTO;
import pe.edu.upc.arquiweb.dtos.ResenaCalificaDTO;
import pe.edu.upc.arquiweb.dtos.ResenaDTO;
import pe.edu.upc.arquiweb.entities.Resena;
import pe.edu.upc.arquiweb.servicesinterfaces.IResenaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resenas")
public class ResenaController {

    @Autowired
    private IResenaService rS;

    @GetMapping
    @PreAuthorize("hasAuthority('GERENTE')")
    public List<Resena2DTO> listar() {
        return rS.list().stream().map(r->{
            ModelMapper m = new ModelMapper();
            return m.map(r, Resena2DTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('PRESIDENTE')")
    public void insertar (@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resena r = m.map(dto, Resena.class);
        rS.insert(r);
    }

    @DeleteMapping("/eliminar{id}")
    public void eliminar(@PathVariable("id") int id){
        rS.delete(id);
    }

    @GetMapping("/por_calificacion")
    public List<ResenaCalificaDTO> listarOrdenadasPorCalificacion() {
        return rS.listReviewsRating().stream().map(r -> {
            ResenaCalificaDTO dto = new ResenaCalificaDTO();
            ModelMapper m = new ModelMapper();
            return m.map(r, ResenaCalificaDTO.class);
        }).collect(Collectors.toList());
    }

}
