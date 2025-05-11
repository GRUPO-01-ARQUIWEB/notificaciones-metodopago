package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.NotificacionDTO;
import pe.edu.upc.arquiweb.entities.Notificaciones;
import pe.edu.upc.arquiweb.servicesinterfaces.INotificacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Notificaciones")

public class NotificacionController {
    @Autowired
    private INotificacionService nS;
    @GetMapping
    public List<NotificacionDTO> listar(){
        return nS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,NotificacionDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody NotificacionDTO dto){
        ModelMapper m=new ModelMapper();
        Notificaciones a=m.map(dto,Notificaciones.class);
        nS.insert(a);
    }
    @GetMapping("/{id}")
    public NotificacionDTO listarID(@PathVariable("id") int id){
        ModelMapper m=new ModelMapper();
        NotificacionDTO dto =m.map(nS.searchID(id),NotificacionDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody NotificacionDTO dto){
        ModelMapper m=new ModelMapper();
        Notificaciones a=m.map(dto, Notificaciones.class);
        nS.update(a);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id){
        nS.delete(id);
    }

    @GetMapping("/busquedas")
    public List<NotificacionDTO> buscar(@RequestParam String n){
        return nS.search(n).stream().map(h->{
            ModelMapper m=new ModelMapper();
            return m.map(h, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping("/producto-disponible")
    public String notificarDisponibilidad(@RequestBody NotificacionDTO notificacion) {
        INotificacionService.enviarNotificacion(notificacion.getCorreo(), notificacion.getMensaje());
        return "Notificación enviada correctamente";
    }
}
