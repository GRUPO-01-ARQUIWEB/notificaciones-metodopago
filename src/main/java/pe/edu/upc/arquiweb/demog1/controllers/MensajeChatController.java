package pe.edu.upc.arquiweb.demog1.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demog1.dtos.MensajeChatDTO;
import pe.edu.upc.demog1.dtos.MensajeTipoContadorDTO;
import pe.edu.upc.demog1.servicesinterfaces.MensajeChatService;

import java.util.List;

@RestController
@RequestMapping("/mensajechat")
public class MensajeChatController {

    @Autowired
    private MensajeChatService mensajeChatService;

    @PostMapping
    public void insertar(@RequestBody MensajeChatDTO dto) {
        mensajeChatService.insert(dto);
    }

    @GetMapping
    public List<MensajeChatDTO> listar() {
        return mensajeChatService.list();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        mensajeChatService.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody MensajeChatDTO dto) {
        mensajeChatService.update(dto);
    }

    @GetMapping("/tipos")
    public List<MensajeTipoContadorDTO> contarMensajesPorTipo() {
        return mensajeChatService.contarMensajesPorTipo();
    }
}

