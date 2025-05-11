package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.LogAccesoDTO;
import pe.edu.upc.arquiweb.entities.LogAcceso;
import pe.edu.upc.arquiweb.serviceinterfaces.ILogAccesoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/logaccesos")
public class LogAccesoController {
    @Autowired
    private ILogAccesoService laS;

    @GetMapping
    public List<LogAccesoDTO> listar(){
        return laS.list().stream().map(u ->{
            ModelMapper m= new ModelMapper();
            return m.map(u,LogAccesoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody LogAccesoDTO dto) {
        ModelMapper m = new ModelMapper();
        LogAcceso l = m.map(dto, LogAcceso.class);
        laS.insert(l);
    }

    @PutMapping
    public void modificar(@RequestBody LogAccesoDTO dto) {
        ModelMapper m = new ModelMapper();
        LogAcceso l = m.map(dto, LogAcceso.class);
        laS.update(l);
    }

    @DeleteMapping("/eliminar{id}")
    public void eliminar(@PathVariable("id") int id) {
        laS.delete(id);
    }
}
