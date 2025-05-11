package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.ComparadorDTO;
import pe.edu.upc.arquiweb.dtos.ComparadorPrecioDTO;
import pe.edu.upc.arquiweb.entities.Comparador;
import pe.edu.upc.arquiweb.serviceinterfaces.IComparadorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comparadores")
public class ComparadorController {
    @Autowired
    private IComparadorService cpS;

    @GetMapping
    public List<ComparadorDTO> listar(){
        return cpS.list().stream().map(c ->{
            ModelMapper m= new ModelMapper();
            return m.map(c,ComparadorDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ComparadorDTO dto) {
        ModelMapper m = new ModelMapper();
        Comparador c = m.map(dto, Comparador.class);
        cpS.insert(c);
    }

    @PutMapping
    public void modificar(@RequestBody ComparadorDTO dto) {
        ModelMapper m = new ModelMapper();
        Comparador c = m.map(dto, Comparador.class);
        cpS.update(c);
    }

    @DeleteMapping("/eliminar{id}")
    public void eliminar(@PathVariable("id") int id) {
        cpS.delete(id);
    }


    @GetMapping("/CompararPrecio")
    public ResponseEntity<List<ComparadorPrecioDTO>> compararPrecio(
            @RequestParam List<Integer> productosId) {
        return ResponseEntity.ok(cpS.compararPrecio(productosId));
    }
}
