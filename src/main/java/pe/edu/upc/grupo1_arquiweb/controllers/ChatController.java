package pe.edu.upc.grupo1_arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.grupo1_arquiweb.dtos.ChatDTO;
import pe.edu.upc.grupo1_arquiweb.entities.Chat;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.IChatService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private IChatService cS;

    @GetMapping
    public List<ChatDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ChatDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ChatDTO dto) {
        ModelMapper m = new ModelMapper();
        Chat c = m.map(dto, Chat.class);
        cS.insert(c);
    }

    @PutMapping
    public void modificar(@RequestBody ChatDTO dto) {
        ModelMapper m = new ModelMapper();
        Chat c = m.map(dto, Chat.class);
        cS.update(c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        cS.delete(id);
    }
}
