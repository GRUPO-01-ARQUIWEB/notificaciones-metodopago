package pe.edu.upc.arquiweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.CarritoCompraProductoDTO;
import pe.edu.upc.arquiweb.dtos.ProductoMasCompradoDTO;
import pe.edu.upc.arquiweb.entities.CarritoCompra;
import pe.edu.upc.arquiweb.entities.CarritoCompraProducto;
import pe.edu.upc.arquiweb.entities.Producto;
import pe.edu.upc.arquiweb.serviceinterfaces.CarritoCompraProductoServices;

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
            dto.setIdProducto(x.getProducto().getIdProducto());
            dto.setIdCarrito(x.getCarrito().getIdCarrito());
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
        p.setIdProducto(dto.getIdProducto());
        producto.setProducto(p);

        CarritoCompra c = new CarritoCompra();
        c.setIdCarrito(dto.getIdCarrito());
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
        p.setIdProducto(dto.getIdProducto());
        producto.setProducto(p);

        CarritoCompra c = new CarritoCompra();
        c.setIdCarrito(dto.getIdCarrito());
        producto.setCarrito(c);

        producto.setMontoTotal(dto.getMontoTotal());

        service.update(producto);
    }

    @GetMapping("/top-productos")
    public List<ProductoMasCompradoDTO> productosMasComprados() {
        return service.productosMasComprados();
    }
}
