package pe.edu.upc.arquiweb.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.arquiweb.dtos.TiendaDTO;
import pe.edu.upc.arquiweb.entities.Tienda;
import pe.edu.upc.arquiweb.serviceinterfaces.ITiendaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {
    @Autowired
    private ITiendaService iS;

    @GetMapping
    public List<TiendaDTO> listar(){
        return iS.list().stream().map(i ->{
            ModelMapper m= new ModelMapper();
            return m.map(i,TiendaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> registrar(@Valid @RequestBody TiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        Tienda t = m.map(dto, Tienda.class);
        iS.insert(t);
        String mensaje = "Tienda registrada correctamente: " + dto.getNombre();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar{id}")
    public void eliminar(@Valid @PathVariable("id") @Min(1) Integer id) {
        iS.delete(id);
    }


    @GetMapping("/{id}")
    public TiendaDTO buscarId(@Valid @PathVariable("id") @Min(1) Integer id) {
        ModelMapper m=new ModelMapper();
        TiendaDTO dto=m.map(iS.searchId(id),TiendaDTO.class);
        return dto;
    }

}
