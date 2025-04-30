package pe.edu.upc.arquiweb.dtos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demog1.dtos.CarritoCompraProductoDTO;
import pe.edu.upc.demog1.dtos.ProductoCompradoDTO;
import pe.edu.upc.demog1.entities.CarritoCompra;
import pe.edu.upc.demog1.entities.CarritoCompraProducto;
import pe.edu.upc.demog1.entities.Producto;
import pe.edu.upc.demog1.servicesinterfaces.CarritoCompraProductoServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carrito-compra-producto")
public class CarritoCompraProductoController {

    @Autowired
    private CarritoCompraProductoServices service;

    @GetMapping
    public List<CarritoCompraProductoDTO> listar() {
        return service.list().stream().map(x -> {
            CarritoCompraProductoDTO dto = new CarritoCompraProductoDTO();
            dto.setId(x.getId());
            dto.setCantidad(x.getCantidad());
            dto.setStatus(x.getStatus());
            dto.setIdProducto(x.getProducto().getId());
            dto.setIdCarrito(x.getCarrito().getId());
            dto.setMontoTotal(x.getMontoTotal());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody CarritoCompraProductoDTO dto) {
        CarritoCompraProducto producto = new CarritoCompraProducto();
        producto.setCantidad(dto.getCantidad());
        producto.setStatus(dto.getStatus());

        Producto p = new Producto();
        p.setId(dto.getIdProducto());
        producto.setProducto(p);

        CarritoCompra c = new CarritoCompra();
        c.setId(dto.getIdCarrito());
        producto.setCarrito(c);

        producto.setMontoTotal(dto.getMontoTotal());

        service.insert(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        service.delete(id);
    }

    @PutMapping
    public void actualizar(@RequestBody CarritoCompraProductoDTO dto) {
        CarritoCompraProducto producto = new CarritoCompraProducto();
        producto.setId(dto.getId());
        producto.setCantidad(dto.getCantidad());
        producto.setStatus(dto.getStatus());

        Producto p = new Producto();
        p.setId(dto.getIdProducto());
        producto.setProducto(p);

        CarritoCompra c = new CarritoCompra();
        c.setId(dto.getIdCarrito());
        producto.setCarrito(c);

        producto.setMontoTotal(dto.getMontoTotal());

        service.update(producto);
    }

    @GetMapping("/top-productos")
    public List<ProductoCompradoDTO> productosMasComprados() {
        return service.productosMasComprados();
    }
}
