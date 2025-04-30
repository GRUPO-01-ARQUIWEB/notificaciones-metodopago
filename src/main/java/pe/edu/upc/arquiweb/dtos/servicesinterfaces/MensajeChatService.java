package pe.edu.upc.arquiweb.dtos.servicesinterfaces;

import pe.edu.upc.demog1.dtos.MensajeChatDTO;
import pe.edu.upc.demog1.dtos.MensajeTipoContadorDTO;

import java.util.List;

public interface MensajeChatService {
    public void insert(MensajeChatDTO dto);
    public List<MensajeChatDTO> list();
    public void delete(int id);
    public void update(MensajeChatDTO dto);
    List<MensajeTipoContadorDTO> contarMensajesPorTipo();

}
