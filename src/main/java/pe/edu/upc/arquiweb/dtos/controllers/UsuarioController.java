package pe.edu.upc.arquiweb.dtos.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.demog1.dtos.UsuarioDTO;
import pe.edu.upc.demog1.servicesinterfaces.UsuarioServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioServices uS;

    @GetMapping
    public List<UsuarioDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
}