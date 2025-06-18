package pe.edu.upc.grupo1_arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.grupo1_arquiweb.dtos.NotificacionesDTO;
import pe.edu.upc.grupo1_arquiweb.entities.Notificaciones;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.INotificacionesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionesController {

    @Autowired
    private INotificacionesService nS;

    @GetMapping
    public List<NotificacionesDTO> listar() {
        return nS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody NotificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones n= m.map(dto, Notificaciones.class);
        nS.insert(n);
    }

    @PutMapping
    public void modificar(@RequestBody NotificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones n = m.map(dto, Notificaciones.class);
        nS.update(n);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        nS.delete(id);
    }
}
