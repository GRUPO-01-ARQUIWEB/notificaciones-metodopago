package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.DescuentoDTO;

import pe.edu.upc.arquiweb.entities.Descuento;
import pe.edu.upc.arquiweb.servicesinterfaces.DescuentoService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("descuentos")
public class DescuentoController {
    @Autowired
    private DescuentoService uS;

    @GetMapping
    public List<DescuentoDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DescuentoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping("/AplicarDescuento")
    public void aplicar (@RequestBody DescuentoDTO dto)
    {
        ModelMapper m =new ModelMapper();
        Descuento a =m.map(dto, Descuento.class);
        uS.insert(a);
    }
    @DeleteMapping("/{Descuento}")
    public void eliminar(@PathVariable("id") int idDescuento)
    {
        uS.delete(idDescuento);
    }

}