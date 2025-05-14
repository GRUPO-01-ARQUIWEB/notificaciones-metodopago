package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.ComentarioAppDTO;
import pe.edu.upc.arquiweb.entities.ComentarioApp;
import pe.edu.upc.arquiweb.serviceinterfaces.IComentarioAppService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentarios")
public class ComentarioAppController {
    @Autowired
    private IComentarioAppService caS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('GERENTE', 'ADMAPLICACION', 'ADMNEGOCIO', 'CLIENTE')")
    public List<ComentarioAppDTO> listar(){
        return caS.list().stream().map(c ->{
            ModelMapper m= new ModelMapper();
            return m.map(c,ComentarioAppDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('CLIENTE', 'ADMNEGOCIO')")
    public void insertar(@RequestBody ComentarioAppDTO dto) {
        ModelMapper m = new ModelMapper();
        ComentarioApp c = m.map(dto, ComentarioApp.class);
        caS.insert(c);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('GERENTE', 'ADMAPLICACION')")
    public void modificar(@RequestBody ComentarioAppDTO dto) {
        ModelMapper m = new ModelMapper();
        ComentarioApp c = m.map(dto, ComentarioApp.class);
        caS.update(c);
    }

    @DeleteMapping("/eliminar{id}")
    @PreAuthorize("hasAnyAuthority('GERENTE', 'ADMAPLICACION')")
    public void eliminar(@PathVariable("id") int id) {
        caS.delete(id);
    }
}
