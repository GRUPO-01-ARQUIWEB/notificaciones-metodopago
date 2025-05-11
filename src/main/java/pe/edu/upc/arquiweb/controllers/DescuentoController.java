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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.arquiweb.dtos.DescuentoDTO;

import pe.edu.upc.arquiweb.dtos.ListarDescuentoVigentesDTO;
import pe.edu.upc.arquiweb.dtos.ListarDescuentosOrdenadosPorPorcentajeDTO;
import pe.edu.upc.arquiweb.entities.Descuento;
import pe.edu.upc.arquiweb.serviceinterfaces.IDescuentoService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("descuentos")
public class DescuentoController {
    @Autowired
    private IDescuentoService uS;

    @GetMapping
    public List<DescuentoDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DescuentoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> aplicar(@Valid @RequestBody DescuentoDTO dto) {
        ModelMapper m = new ModelMapper();
        Descuento a = m.map(dto, Descuento.class);
        uS.insert(a);
        String mensaje = "El codigo de descuento registrado correctamente: " + dto.getCodDescuento();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar{id}")
    public void eliminar(@Valid @PathVariable("id") @Min(1) Integer idDescuento) {
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