package pe.edu.upc.arquiweb.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.MensajeChatDTO;
import pe.edu.upc.arquiweb.dtos.MensajeTipoContadorDTO;

import java.util.List;

@RestController
@RequestMapping("/mensajechat")
public class MensajeChatController {

    @Autowired
    private IMensajeChatService IMensajeChatService;

    @PostMapping
    public void insertar(@RequestBody MensajeChatDTO dto) {
        IMensajeChatService.insert(dto);
    }

    @GetMapping
    public List<MensajeChatDTO> listar() {
        return IMensajeChatService.list();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        IMensajeChatService.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody MensajeChatDTO dto) {
        IMensajeChatService.update(dto);
    }

    @GetMapping("/tipos")
    public List<MensajeTipoContadorDTO> contarMensajesPorTipo() {
        return IMensajeChatService.contarMensajesPorTipo();
    }
}

