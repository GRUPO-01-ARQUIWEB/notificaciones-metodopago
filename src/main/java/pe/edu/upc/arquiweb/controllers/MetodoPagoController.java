package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.arquiweb.dtos.MetodoPagoDTO;
import pe.edu.upc.arquiweb.dtos.MetodoPagoDTO2;
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
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public List<MetodoPagoDTO2> listar() {
        return mS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MetodoPagoDTO2.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public void insertar(@RequestBody MetodoPagoDTO2 dto) {
        ModelMapper m = new ModelMapper();
        MetodoPago mp = m.map(dto, MetodoPago.class);
        mS.insert(mp);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public MetodoPagoDTO2 listarID(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        MetodoPagoDTO2 dto = m.map(mS.searchID(id), MetodoPagoDTO2.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public void modificar(@RequestBody MetodoPagoDTO dto) {
        ModelMapper m = new ModelMapper();
        MetodoPago mp = m.map(dto, MetodoPago.class);
        mS.update(mp);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public void eliminar(@PathVariable int id) {
        mS.delete(id);
    }
    @GetMapping("/busquedas")
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public List<MetodoPagoDTO> buscar(@RequestParam String n){
        return mS.search(n).stream().map(h -> {
            ModelMapper m = new ModelMapper();
            return m.map(h, MetodoPagoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/mas-usados")
    @PreAuthorize("hasAuthority('GERENTE') or hasAuthority('ADMAPLICACION') or hasAuthority('ADMNEGOCIO') or hasAuthority('CLIENTE')")
    public ResponseEntity<List<MetodoPagoPopularDTO>> listarMetodosPagoMasUsados() {
        List<MetodoPagoPopularDTO> metodos = mS.obtenerMetodosPagoMasUsados();
        return new ResponseEntity<>(metodos, HttpStatus.OK);
    }

}
