package pe.edu.upc.arquiweb.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.MensajeChatDTO;
import pe.edu.upc.arquiweb.dtos.MensajeTipoContadorDTO;
import pe.edu.upc.arquiweb.serviceinterfaces.IMensajeChatService;

import java.util.List;

@RestController
@RequestMapping("/mensajechat")
public class MensajeChatController {

    @Autowired
    private IMensajeChatService IMensajeChatService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public void insertar(@RequestBody MensajeChatDTO dto) {
        IMensajeChatService.insert(dto);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('GERENTE')")
    public List<MensajeChatDTO> listar() {
        return IMensajeChatService.list();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMAPLICACION')")
    public void eliminar(@PathVariable("id") Integer id) {
        IMensajeChatService.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMAPLICACION') or hasAuthority('CLIENTE')")
    public void modificar(@RequestBody MensajeChatDTO dto) {
        IMensajeChatService.update(dto);
    }

    @GetMapping("/tipos")
    @PreAuthorize("hasAuthority('ADMAPLICACION') or hasAuthority('GERENTE')")
    public List<MensajeTipoContadorDTO> contarMensajesPorTipo() {
        return IMensajeChatService.contarMensajesPorTipo();
    }
}

