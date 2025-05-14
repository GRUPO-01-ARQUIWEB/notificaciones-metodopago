package pe.edu.upc.arquiweb.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.TiendaDTO;
import pe.edu.upc.arquiweb.dtos.TiendaDTO2;
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
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public List<TiendaDTO2> listar(){
        return iS.list().stream().map(i ->{
            ModelMapper m= new ModelMapper();
            return m.map(i,TiendaDTO2.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO')")
    public ResponseEntity<String> registrar(@Valid @RequestBody TiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        Tienda t = m.map(dto, Tienda.class);
        iS.insert(t);
        String mensaje = "Tienda registrada correctamente: " + dto.getNombre();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO')")
    public void modificar(@RequestBody TiendaDTO2 dto) {
        ModelMapper m = new ModelMapper();
        Tienda t = m.map(dto, Tienda.class);
        iS.update(t);
    }

    @DeleteMapping("/eliminar{id}")
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('GERENTE')")
    public void eliminar(@Valid @PathVariable("id") @Min(1) Integer id) {
        iS.delete(id);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public TiendaDTO2 buscarId(@Valid @PathVariable("id") @Min(1) Integer id) {
        ModelMapper m=new ModelMapper();
        TiendaDTO2 dto=m.map(iS.searchId(id),TiendaDTO2.class);
        return dto;
    }

}
