package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.ComparadorPrecioDTO;
import pe.edu.upc.arquiweb.entities.ComparadorPrecio;
import pe.edu.upc.arquiweb.serviceinterfaces.IComparadorPrecioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comparadores")
public class ComparadorPrecioController {
    @Autowired
    private IComparadorPrecioService cpS;

    @GetMapping
    public List<ComparadorPrecioDTO> listar(){
        return cpS.list().stream().map(c ->{
            ModelMapper m= new ModelMapper();
            return m.map(c,ComparadorPrecioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ComparadorPrecioDTO dto) {
        ModelMapper m = new ModelMapper();
        ComparadorPrecio c = m.map(dto, ComparadorPrecio.class);
        cpS.insert(c);
    }

    @PutMapping
    public void modificar(@RequestBody ComparadorPrecioDTO dto) {
        ModelMapper m = new ModelMapper();
        ComparadorPrecio c = m.map(dto, ComparadorPrecio.class);
        cpS.update(c);
    }

    @DeleteMapping("/eliminar{id}")
    public void eliminar(@PathVariable("id") int id) {
        cpS.delete(id);
    }

    @GetMapping("/CompararaProducto")
    public ResponseEntity<List<ComparadorPrecioDTO>> compararProductos(
            @RequestParam List<Integer> productosIds) {
        return ResponseEntity.ok(cpS.compararproductos(productosIds));
    }
}
