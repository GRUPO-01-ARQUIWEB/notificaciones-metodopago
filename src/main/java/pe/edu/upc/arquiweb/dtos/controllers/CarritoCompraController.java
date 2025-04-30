package pe.edu.upc.arquiweb.dtos.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demog1.dtos.CarritoCompraDTO;
import pe.edu.upc.demog1.entities.CarritoCompra;
import pe.edu.upc.demog1.servicesinterfaces.CarritoCompraServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("CarritoCompra")
public class CarritoCompraController {
    @Autowired
    private CarritoCompraServices uS;

    @GetMapping("/ListarProducto")
    public List<CarritoCompraDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CarritoCompraDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping("/InsertarProducto")
    public void agregarproduct (@RequestBody CarritoCompraDTO dto)
    {
        ModelMapper m =new ModelMapper();
        CarritoCompra a =m.map(dto, CarritoCompra.class);
        uS.insert(a);
    }
    @DeleteMapping("/{Producto}")
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


}
