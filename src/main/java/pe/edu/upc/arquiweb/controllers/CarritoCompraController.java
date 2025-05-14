package pe.edu.upc.arquiweb.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.arquiweb.dtos.BuscarCarritoCompraIDDTO;
import pe.edu.upc.arquiweb.dtos.CarritoCompra2DTO;
import pe.edu.upc.arquiweb.dtos.CarritoCompraDTO;
import pe.edu.upc.arquiweb.dtos.OrdenCarritoCompraDTO;
import pe.edu.upc.arquiweb.entities.CarritoCompra;
import pe.edu.upc.arquiweb.serviceinterfaces.ICarritoCompraService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("CarritoCompra")
public class CarritoCompraController {
  @Autowired
    private ICarritoCompraService uS;


    @GetMapping("/ListarProducto")
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public List<CarritoCompra2DTO> listar() {
        return uS.list().stream().map(carritoCompra -> {
            CarritoCompra2DTO dto = new CarritoCompra2DTO();
            dto.setIdCarrito(carritoCompra.getIdCarrito());
            dto.setIdUsuario(carritoCompra.getUsuario().getIdUsuario());
            dto.setIdProducto(carritoCompra.getProducto().getIdProducto());
            dto.setNombreproducto(carritoCompra.getProducto().getNombreProducto());
            dto.setFechaCreacion(carritoCompra.getFechaCreacion());
            dto.setIdMetodo(carritoCompra.getIdMetodo().getIdMetodo());
            dto.setPrecioBase(carritoCompra.getPrecioBase());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public ResponseEntity<String> agregarproduct(@Valid @RequestBody CarritoCompraDTO dto) {
        ModelMapper m = new ModelMapper();
        CarritoCompra a = m.map(dto, CarritoCompra.class);
        uS.insert(a);
        String mensaje = "Producto agregado al carrito correctamente: " ;
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar{id}")
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public void eliminar(@Valid @PathVariable("id") @Min(1) Integer idProducto) {
        uS.delete(idProducto);
    }

    @PutMapping("/ActualizarProducto")
    public void actualizarProduct(@RequestBody CarritoCompraDTO dto){
        ModelMapper m=new ModelMapper();
        CarritoCompra a =m.map(dto, CarritoCompra.class);
        uS.update(a);
    }
    @GetMapping("/carrito-ordenado-porPrecio")
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
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
    @GetMapping("/BuscarCarritoPorID")
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public List<BuscarCarritoCompraIDDTO> buscarCarritoxID(@RequestParam("idUsuario") int idUsuario) {
        List<String[]> filaLista = uS.BuscarCarritoCompraXID(idUsuario);
        List<BuscarCarritoCompraIDDTO> dtoLista=new ArrayList<>();
        for (String[] columna : filaLista) {
            BuscarCarritoCompraIDDTO dto = new BuscarCarritoCompraIDDTO();
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