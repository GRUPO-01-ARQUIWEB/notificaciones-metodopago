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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.arquiweb.dtos.CantidadProductoDTO;
import pe.edu.upc.arquiweb.dtos.ProductoComparaDTO;
import pe.edu.upc.arquiweb.dtos.ProductoDTO;
import pe.edu.upc.arquiweb.dtos.ProductoDTO2;
import pe.edu.upc.arquiweb.entities.Producto;
import pe.edu.upc.arquiweb.serviceinterfaces.IProductoService;

import java.util.ArrayList;
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
    public ResponseEntity<String> registrar(@Valid @RequestBody ProductoDTO2 dto) {
        ModelMapper m = new ModelMapper();
        Producto p = m.map(dto, Producto.class);
        pS.insert(p);
        String mensaje = "El producto" + dto.getNombreProducto() + "fue registrada correctamente";
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PutMapping
    public void modificar(@RequestBody ProductoDTO2 dto) {
        ModelMapper m = new ModelMapper();
        Producto p = m.map(dto, Producto.class);
        pS.update(p);
    }

    @DeleteMapping("/eliminar{id}")
    public void eliminar(@Valid @PathVariable("id") @Min(1) Integer id) {
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

    @GetMapping("/stockbajo")
    public List<Producto> listarProductosConStockBajo() {
        return pS.productsWithLowStock();
    }
}
