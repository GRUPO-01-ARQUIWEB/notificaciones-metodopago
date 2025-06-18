package pe.edu.upc.grupo1_arquiweb.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.grupo1_arquiweb.dtos.ProductoDTO;
import pe.edu.upc.grupo1_arquiweb.entities.Producto;
import pe.edu.upc.grupo1_arquiweb.servicesinterfaces.IProductoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService pS;

    @GetMapping
    public List<ProductoDTO> listar() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ProductoDTO dto) {
        ModelMapper m = new ModelMapper();
        Producto  p= m.map(dto, Producto.class);
        pS.insert(p);
    }

    @PutMapping
    public void modificar(@RequestBody ProductoDTO dto) {
        ModelMapper m = new ModelMapper();
        Producto p = m.map(dto, Producto.class);
        pS.update(p);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        pS.delete(id);
    }

}
