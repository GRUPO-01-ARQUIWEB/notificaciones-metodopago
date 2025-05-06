package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.CarritoCompraDTO;

import pe.edu.upc.arquiweb.dtos.OrdenCarritoCompraDTO;
import pe.edu.upc.arquiweb.dtos.OrdenarProductosPorFechaCreacionDTO;
import pe.edu.upc.arquiweb.entities.CarritoCompra;
import pe.edu.upc.arquiweb.servicesinterfaces.ICarritoCompraServices;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("CarritoCompra")
public class CarritoCompraController {
  @Autowired
    private ICarritoCompraServices uS;


    @GetMapping("/ListarProducto")
    public List<CarritoCompraDTO> listar() {
        return uS.list().stream().map(carritoCompra -> {
            CarritoCompraDTO dto = new CarritoCompraDTO();
            dto.setIdCarrito(carritoCompra.getIdCarrito());
            dto.setIdUsuario(carritoCompra.getUsuario().getIdUsuario());
            dto.setIdProducto(carritoCompra.getProducto().getIdProducto());
            dto.setFechaCreacion(carritoCompra.getFechaCreacion());
            dto.setIdMetodo(carritoCompra.getIdMetodo().getIdMetodo());
            dto.setPrecioBase(carritoCompra.getPrecioBase());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping("/InsertarProducto")
    public void agregarproduct (@RequestBody CarritoCompraDTO dto)
    {
        ModelMapper m =new ModelMapper();
        CarritoCompra a =m.map(dto, CarritoCompra.class);
        uS.insert(a);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int idProducto)
    {
        uS.delete(idProducto);
    }

    @PutMapping("/ActualizarProducto")
    public void actualizarProduct(@RequestBody CarritoCompraDTO dto){
        ModelMapper m=new ModelMapper();
        CarritoCompra a =m.map(dto, CarritoCompra.class);
        uS.update(a);
    }
    @GetMapping("/carrito-ordenado-porPrecio")
    public List<OrdenCarritoCompraDTO> listarCarritoOrdenado() {
        List<String[]> filaLista = uS.ordenarCarritoCompra();
        List<OrdenCarritoCompraDTO> dtoLista = new ArrayList<>();

        for (String[] columna : filaLista) {
            OrdenCarritoCompraDTO dto = new OrdenCarritoCompraDTO();
            dto.setIdCarrito(Integer.parseInt(columna[0]));
            dto.setIdUsuario(Integer.parseInt(columna[1]));
            dto.setIdProducto(Integer.parseInt(columna[2]));
            dto.setNombre(columna[3]);
            dto.setPrecioBase(Double.parseDouble(columna[4]));
            dto.setFechaCreacion(LocalDate.parse(columna[5]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @GetMapping("/CarritoPorFechaOrden")
    public List<OrdenarProductosPorFechaCreacionDTO> listarCarritoPorFechaOrden() {
        List<String[]> filaLista = uS.ordenarCarritoCompraUsuarioxFechaCreacion();
        List<OrdenarProductosPorFechaCreacionDTO> dtoLista=new ArrayList<>();
        for (String[] columna : filaLista) {
            OrdenarProductosPorFechaCreacionDTO dto = new OrdenarProductosPorFechaCreacionDTO();
            dto.setIdCarrito(Integer.parseInt(columna[0]));
            dto.setNombre(columna[1]);
            dto.setNombreProducto(columna[2]);
            dto.setPrecioBase(Double.parseDouble(columna[3]));
            dto.setFechaCreacion(LocalDate.parse(columna[4]));
            dtoLista.add(dto);


        }
        return dtoLista;
    }

}