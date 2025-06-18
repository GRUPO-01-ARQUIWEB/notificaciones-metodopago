package pe.edu.upc.grupo1_arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.grupo1_arquiweb.dtos.CarritoCompraDTO;
import pe.edu.upc.grupo1_arquiweb.entities.CarritoCompra;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.ICarritoCompraService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carrito_de_compra")
public class CarritoCompraController {

    @Autowired
    private ICarritoCompraService ccS;

    @GetMapping
    public List<CarritoCompraDTO> listar() {
        return ccS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CarritoCompraDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody CarritoCompraDTO dto) {
        ModelMapper m = new ModelMapper();
        CarritoCompra cc = m.map(dto, CarritoCompra.class);
        ccS.insert(cc);
    }

    @PutMapping
    public void modificar(@RequestBody CarritoCompraDTO dto) {
        ModelMapper m = new ModelMapper();
        CarritoCompra cc = m.map(dto, CarritoCompra.class);
        ccS.update(cc);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        ccS.delete(id);
    }
}
