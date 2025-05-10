package pe.edu.upc.arquiweb.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public List<UsuarioRegistroDTO> listar(){
        return uS.list().stream().map(u ->{
            ModelMapper m= new ModelMapper();
            return m.map(u,UsuarioRegistroDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registrar(@Valid @RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uS.insert(u);
        String mensaje = "Aplicación registrada correctamente: " + dto.getUsername();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        uS.update(u);
    }

    @DeleteMapping("/eliminar{id}")
    public void eliminar(@PathVariable("id") int id) {
        uS.delete(id);
    }
}
