package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.ProductoDTO;
import pe.edu.upc.arquiweb.entities.Producto;
import pe.edu.upc.arquiweb.servicesinterfaces.ProductoServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Producto")
public class ProductoController {
    @Autowired
    private ProductoServices pR;
    @GetMapping
    public List<ProductoDTO> listar(){
        return pR.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ProductoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody ProductoDTO dto){
        ModelMapper m = new ModelMapper();
        Producto a =m.map(dto,Producto.class);
        pR.insert(a);
    }
}
