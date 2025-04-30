package pe.edu.upc.projecarqui.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.projecarqui.dto.ProductoComparaDTO;
import pe.edu.upc.projecarqui.dto.ProductoDTO;

import pe.edu.upc.projecarqui.dto.ProductoDTO2;
import pe.edu.upc.projecarqui.entities.Producto;
import pe.edu.upc.projecarqui.servicesinterfaces.IProductoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService pS;

    @GetMapping
    public List<ProductoDTO> listar() {
        return pS.list().stream().map(p -> {
            ModelMapper m = new ModelMapper();
            return m.map(p, ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ProductoDTO2 dto) {
        ModelMapper m = new ModelMapper();
        Producto p = m.map(dto, Producto.class);
        pS.insert(p);
    }

    @DeleteMapping("/eliminar{id}")
    public void eliminar(@PathVariable("id") int id) {
        pS.delete(id);
    }

    @GetMapping("/{id}")
    public ProductoDTO buscarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ProductoDTO dto = m.map(pS.searchId(id), ProductoDTO.class);
        return dto;
    }

    @GetMapping("/busquedas_nombre")
    public List<ProductoDTO> buscarNombre(String n) {
        return pS.search(n).stream().map(p -> {
            ModelMapper m = new ModelMapper();
            return m.map(p, ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/filtrar")
    public List<ProductoDTO> filtroProductos(
            @RequestParam(required = false) Double precioBase,
            @RequestParam(required = false) String categoria) {
        return pS.searchFilters(precioBase, categoria).stream().map(p -> {
            ModelMapper m = new ModelMapper();
            return m.map(p, ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/comparar")
    public List<ProductoComparaDTO> comparar(@RequestParam int id1, @RequestParam int id2) {
        return pS.compareProduct(id1, id2).stream().map(p -> {
            ModelMapper m = new ModelMapper();
            ProductoComparaDTO dto = m.map(p, ProductoComparaDTO.class);
            return dto;
        }).collect(Collectors.toList());
    }
}