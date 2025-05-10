package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.arquiweb.dtos.ChatProveedorDTO;
import pe.edu.upc.arquiweb.serviceinterfaces.IChatProveedorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/chatspro")
public class ChatProveedorController {

    @Autowired
    private IChatProveedorService cS;

    @GetMapping
    public List<ChatProveedorDTO> listar(){
        return cS.list().stream().map(c ->{
            ModelMapper m= new ModelMapper();
            return m.map(c,ChatProveedorDTO.class);
        }).collect(Collectors.toList());
    }
}
