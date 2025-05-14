package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.ChatProveedorDTO;
import pe.edu.upc.arquiweb.entities.ChatProveedor;
import pe.edu.upc.arquiweb.serviceinterfaces.IChatProveedorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chatspro")
public class ChatProveedorController {

    @Autowired
    private IChatProveedorService cS;

    @GetMapping
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public List<ChatProveedorDTO> listar(){
        return cS.list().stream().map(c ->{
            ModelMapper m= new ModelMapper();
            return m.map(c,ChatProveedorDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public void insertar(@RequestBody ChatProveedorDTO dto) {
        ModelMapper m = new ModelMapper();
        ChatProveedor c = m.map(dto, ChatProveedor.class);
        cS.insert(c);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public void modificar(@RequestBody ChatProveedorDTO dto) {
        ModelMapper m = new ModelMapper();
        ChatProveedor c = m.map(dto, ChatProveedor.class);
        cS.update(c);
    }

    @DeleteMapping("/eliminar{id}")
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public void eliminar(@PathVariable("id") int id) {
        cS.delete(id);
    }
}
