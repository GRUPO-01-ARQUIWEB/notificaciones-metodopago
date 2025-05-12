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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.arquiweb.dtos.MetodoPagoDTO;
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
    public ResponseEntity<String> registrar(@Valid @RequestBody MetodoPagoDTO dto) {
        ModelMapper m = new ModelMapper();
        MetodoPago mp = m.map(dto, MetodoPago.class);
        mS.insert(mp);
        String mensaje = "El metodo de pago fue registrado correctamente: " + dto.getTipo();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
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

    @DeleteMapping("/eliminar{id}")
    public void eliminar(@Valid @PathVariable("id") @Min(1) Integer id) {
        mS.delete(id);
    }

    @GetMapping("/busquedas")
    public List<MetodoPagoDTO> buscar(@RequestParam String n){
        return mS.search(n).stream().map(h -> {
            ModelMapper m = new ModelMapper();
            return m.map(h, MetodoPagoDTO.class);
        }).collect(Collectors.toList());
    }

}
