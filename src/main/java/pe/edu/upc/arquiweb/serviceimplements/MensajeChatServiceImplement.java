package pe.edu.upc.arquiweb.serviceimplements;

import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.dtos.MensajeChatDTO;
import pe.edu.upc.arquiweb.dtos.MensajeTipoContadorDTO;
import pe.edu.upc.arquiweb.serviceinterfaces.IMensajeChatService;

import java.util.List;

@Service
public class MensajeChatServiceImplement implements IMensajeChatService {

    @Override
    public void insert(MensajeChatDTO dto) {
        
    }

    @Override
    public List<MensajeChatDTO> list() {
        return List.of();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(MensajeChatDTO dto) {

    }

    @Override
    public List<MensajeTipoContadorDTO> contarMensajesPorTipo() {
        return List.of();
    }
}
