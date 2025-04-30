package pe.edu.upc.projecarqui.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.projecarqui.dto.ProductoDTO;
import pe.edu.upc.projecarqui.dto.ProductoDTO2;
import pe.edu.upc.projecarqui.dto.UsuarioDTO;
import pe.edu.upc.projecarqui.entities.Producto;
import pe.edu.upc.projecarqui.entities.Usuario;
import pe.edu.upc.projecarqui.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @GetMapping
    public List<UsuarioDTO> listar() {
        return uS.list().stream().map(u ->{
            ModelMapper m = new ModelMapper();
            return m.map(u, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar (@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uS.insert(u);
    }
}
