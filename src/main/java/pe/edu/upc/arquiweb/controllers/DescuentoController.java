package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.DescuentoDTO;

import pe.edu.upc.arquiweb.dtos.ListarDescuentoVigentesDTO;
import pe.edu.upc.arquiweb.dtos.ListarDescuentosOrdenadosPorPorcentajeDTO;
import pe.edu.upc.arquiweb.entities.Descuento;
import pe.edu.upc.arquiweb.servicesinterfaces.DescuentoService;


import java.time.LocalDate;
import java.util.ArrayList;
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
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int idDescuento)
    {
        uS.delete(idDescuento);
    }
    @GetMapping("/listarDescVigente")
    public List<ListarDescuentoVigentesDTO> listardescuentvigentes() {
        List<String[]> filaLista = uS.ListarDescVigentes();
        List<ListarDescuentoVigentesDTO> dtoLista = new ArrayList<>();

        for (String[] columna : filaLista) {
            ListarDescuentoVigentesDTO dto = new ListarDescuentoVigentesDTO();
            dto.setIdDescuento(Integer.parseInt(columna[0]));
            dto.setCodDescuento((columna[1]));
            dto.setPorcentaje(Double.parseDouble(columna[2]));
            dto.setFechaInicio(LocalDate.parse(columna[3]));
            dto.setFechaFin(LocalDate.parse(columna[4]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @GetMapping("/ListarDescuentosOrdenadosXPorcentaje")
    public List<ListarDescuentosOrdenadosPorPorcentajeDTO> listarDescuentosOrdenadosPorPorcentaje() {
        List<Descuento> listaDescuentos = uS.obtenerDescuentosOrdenados();
        List<ListarDescuentosOrdenadosPorPorcentajeDTO> dtoLista = new ArrayList<>();

        for (Descuento d : listaDescuentos) {
            ListarDescuentosOrdenadosPorPorcentajeDTO dto = new ListarDescuentosOrdenadosPorPorcentajeDTO();
            dto.setIdDescuento(d.getIdDescuento());
            dto.setCodDescuento(d.getCodDescuento());
            dto.setPorcentaje(d.getPorcentaje());
            dto.setFechaInicio(d.getFechaInicio());
            dto.setFechaFin(d.getFechaFin());
            dtoLista.add(dto);
        }

        return dtoLista;
    }
}