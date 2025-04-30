package pe.edu.upc.arquiweb.demog1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demog1.dtos.ProductoDTO;
import pe.edu.upc.demog1.entities.Producto;
import pe.edu.upc.demog1.servicesinterfaces.ProductServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Producto")
public class ProductController {
    @Autowired
    private ProductServices pR;
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
