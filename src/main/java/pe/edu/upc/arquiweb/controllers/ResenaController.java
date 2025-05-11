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
import pe.edu.upc.arquiweb.dtos.Resena2DTO;
import pe.edu.upc.arquiweb.dtos.ResenaCalificaDTO;
import pe.edu.upc.arquiweb.dtos.ResenaDTO;
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
    public List<Resena2DTO> listar() {
        return rS.list().stream().map(r->{
            ModelMapper m = new ModelMapper();
            return m.map(r, Resena2DTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> registrar(@Valid @RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resena r = m.map(dto, Resena.class);
        rS.insert(r);
        String mensaje = "La reseña fue registrada correctamente ";
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar{id}")
    public void eliminar(@Valid @PathVariable("id") @Min(1) Integer id) {
        rS.delete(id);
    }

    @GetMapping("/por_calificacion")
    public List<ResenaCalificaDTO> listarOrdenadasPorCalificacion() {
        return rS.listReviewsRating().stream().map(r -> {
            ResenaCalificaDTO dto = new ResenaCalificaDTO();
            ModelMapper m = new ModelMapper();
            return m.map(r, ResenaCalificaDTO.class);
        }).collect(Collectors.toList());
    }

}
