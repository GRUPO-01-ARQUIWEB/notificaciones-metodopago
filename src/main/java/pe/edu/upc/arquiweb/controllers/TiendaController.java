package pe.edu.upc.arquiweb.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.arquiweb.dtos.TiendaDTO;
import pe.edu.upc.arquiweb.servicesinterfaces.ITiendaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {
    @Autowired
    private ITiendaService iS;
 //GETMPAPPIN SIRVE PARA TALLLLLL
    @GetMapping
    public List<TiendaDTO> listar(){
        return iS.list().stream().map(i ->{
            ModelMapper m= new ModelMapper();
            return m.map(i,TiendaDTO.class);
        }).collect(Collectors.toList());
    }
}
