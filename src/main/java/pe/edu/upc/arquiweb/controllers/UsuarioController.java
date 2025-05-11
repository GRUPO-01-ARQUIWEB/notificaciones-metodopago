package pe.edu.upc.arquiweb.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.arquiweb.dtos.UsuarioDTO;
import pe.edu.upc.arquiweb.dtos.UsuarioRegistroDTO;
import pe.edu.upc.arquiweb.entities.Usuario;
import pe.edu.upc.arquiweb.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;

    @GetMapping
    @PreAuthorize("hasAuthority('GERENTE')")
    public List<UsuarioRegistroDTO> listar(){
        return uS.list().stream().map(u ->{
            ModelMapper m= new ModelMapper();
            return m.map(u,UsuarioRegistroDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> registrar(@Valid @RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uS.insert(u);
        String mensaje = "Usuario registrado correctamente: " + dto.getUsername();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uS.update(u);
    }

    @DeleteMapping("/eliminar{id}")
    public void eliminar(@Valid @PathVariable("id") @Min(1) Integer id) {
        uS.delete(id);
    }
}
