package pe.edu.upc.arquiweb.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<String> registrar(@Valid @RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones a = m.map(dto, Notificaciones.class);
        nS.insert(a);
        String mensaje = "Notificacion registrado correctamente: ";
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
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

    @DeleteMapping("/eliminar{id}")
    public void eliminar(@Valid @PathVariable("id") @Min(1) Integer id) {
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
