package pe.edu.upc.arquiweb.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.Resena2DTO;
import pe.edu.upc.arquiweb.dtos.ResenaCalificaDTO;
import pe.edu.upc.arquiweb.dtos.ResenaDTO;
import pe.edu.upc.arquiweb.dtos.ResenaDTO3;
import pe.edu.upc.arquiweb.entities.Resena;
import pe.edu.upc.arquiweb.serviceinterfaces.IResenaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resenas")
public class ResenaController {

    @Autowired
    private IResenaService rS;

    @GetMapping
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public List<Resena2DTO> listar() {
        return rS.list().stream().map(r->{
            ModelMapper m = new ModelMapper();
            return m.map(r, Resena2DTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION')")
    public ResponseEntity<String> registrar(@Valid @RequestBody ResenaDTO3 dto) {
        ModelMapper m = new ModelMapper();
        Resena r = m.map(dto, Resena.class);
        rS.insert(r);
        String mensaje = "La reseña fue registrada correctamente ";
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION')")
    public void modificar(@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resena r = m.map(dto, Resena.class);
        rS.update(r);
    }

    @DeleteMapping("/eliminar{id}")
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION')")
    public void eliminar(@Valid @PathVariable("id") @Min(1) Integer id) {
        rS.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public Resena2DTO buscarId(@Valid @PathVariable("id") @Min(1) Integer id) {
        ModelMapper m=new ModelMapper();
        Resena2DTO dto=m.map(rS.searchId(id),Resena2DTO.class);
        return dto;
    }

    @GetMapping("/por_calificacion")
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public List<ResenaCalificaDTO> listarOrdenadasPorCalificacion() {
        return rS.listReviewsRating().stream().map(r -> {
            ResenaCalificaDTO dto = new ResenaCalificaDTO();
            ModelMapper m = new ModelMapper();
            return m.map(r, ResenaCalificaDTO.class);
        }).collect(Collectors.toList());
    }

}
