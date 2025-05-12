package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.MetodoPagoDTO;
import pe.edu.upc.arquiweb.dtos.MetodoPagoPopularDTO;
import pe.edu.upc.arquiweb.entities.MetodoPago;
import pe.edu.upc.arquiweb.serviceinterfaces.IMetodoPagoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metodospago")
public class MetodoPagoController {
    @Autowired
    private IMetodoPagoService mS;

    //mdasindasbi

    @GetMapping
    public List<MetodoPagoDTO> listar() {
        return mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MetodoPagoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody MetodoPagoDTO dto) {
        ModelMapper m = new ModelMapper();
        MetodoPago mp = m.map(dto, MetodoPago.class);
        mS.insert(mp);
    }

    @GetMapping("/{id}")
    public MetodoPagoDTO listarID(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        MetodoPagoDTO dto = m.map(mS.searchID(id), MetodoPagoDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody MetodoPagoDTO dto) {
        ModelMapper m = new ModelMapper();
        MetodoPago mp = m.map(dto, MetodoPago.class);
        mS.update(mp);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        mS.delete(id);
    }
    @GetMapping("/busquedas")
    public List<MetodoPagoDTO> buscar(@RequestParam String n){
        return mS.search(n).stream().map(h -> {
            ModelMapper m = new ModelMapper();
            return m.map(h, MetodoPagoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/mas-usado")
    public ResponseEntity<MetodoPagoPopularDTO> obtenerMetodoMasPopular() {
        MetodoPagoPopularDTO resultado = mS.buscarMetodoPagoMasUsado();
        return resultado != null ?
                ResponseEntity.ok(resultado) :
                ResponseEntity.noContent().build();
    }

}
