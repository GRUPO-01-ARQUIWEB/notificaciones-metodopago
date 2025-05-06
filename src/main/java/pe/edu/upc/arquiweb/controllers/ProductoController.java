package pe.edu.upc.arquiweb.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.CantidadProductoDTO;
import pe.edu.upc.arquiweb.dtos.ProductoComparaDTO;
import pe.edu.upc.arquiweb.dtos.ProductoDTO;
import pe.edu.upc.arquiweb.dtos.ProductoDTO2;
import pe.edu.upc.arquiweb.entities.Producto;
import pe.edu.upc.arquiweb.servicesinerfaces.IProductoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService pS;

    @GetMapping
    @PreAuthorize("hasAuthority('GERENTE')")
    public List<ProductoDTO> listar() {
        return pS.list().stream().map(p -> {
            ModelMapper m = new ModelMapper();
            return m.map(p, ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('PRESIDENTE')")
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


    @GetMapping("/cantidades_productos")
    public List<CantidadProductoDTO> ListarCantidadProductos() {
        List<String[]> filaLista= pS.qualitybyStore();
        List<CantidadProductoDTO> dtoLista = new ArrayList<>();
        for(String[] columna:filaLista) {
            CantidadProductoDTO dto = new CantidadProductoDTO();
            dto.setNombre(columna[0]);
            dto.setCantidadProductos(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
