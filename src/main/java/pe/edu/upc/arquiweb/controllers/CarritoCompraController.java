package pe.edu.upc.arquiweb.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.CarritoCompraDTO;
import pe.edu.upc.arquiweb.dtos.OrdenarCarritoCompraPRecioBaseDTO;
import pe.edu.upc.arquiweb.dtos.OrdenarProductosFechaCreacionDTO;
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
    private ICarritoCompraServices  cS ;

    @GetMapping("/ListarProducto")
    public List<CarritoCompraDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CarritoCompraDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping("/InsertarProducto")
    public void agregarproduct (@RequestBody CarritoCompraDTO dto)
    {
        ModelMapper m =new ModelMapper();
        CarritoCompra a =m.map(dto, CarritoCompra.class);
        cS.insert(a);
    }
    @DeleteMapping("/{Producto}")
    public void eliminar(@PathVariable("id") int idProducto)
    {
        cS.delete(idProducto);
    }

    @PutMapping("/ActualizarProducto")
    public void actualizarProduct(@RequestBody CarritoCompraDTO dto){
        ModelMapper m=new ModelMapper();
        CarritoCompra a =m.map(dto, CarritoCompra.class);
        cS.update(a);
    }
    @GetMapping("/carrito-ordenado")
    public List<OrdenarCarritoCompraPRecioBaseDTO> listarCarritoOrdenado() {
        List<String[]> filaLista = cS.ordenarCarritoCompra();
        List<OrdenarCarritoCompraPRecioBaseDTO> dtoLista = new ArrayList<>();

        for (String[] columna : filaLista) {
            OrdenarCarritoCompraPRecioBaseDTO dto = new OrdenarCarritoCompraPRecioBaseDTO();
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
    public List<OrdenarProductosFechaCreacionDTO> listarCarritoPorFechaOrden() {
        List<String[]> filaLista = cS.ordenarCarritoCompraUsuarioxFechaCreacion();
        List<OrdenarProductosFechaCreacionDTO> dtoLista=new ArrayList<>();
        for (String[] columna : filaLista) {
            OrdenarProductosFechaCreacionDTO dto = new OrdenarProductosFechaCreacionDTO();
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