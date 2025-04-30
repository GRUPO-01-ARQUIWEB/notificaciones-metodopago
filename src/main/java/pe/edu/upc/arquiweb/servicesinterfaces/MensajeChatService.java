package pe.edu.upc.arquiweb.servicesinterfaces;

import pe.edu.upc.arquiweb.dtos.MensajeChatDTO;
import pe.edu.upc.arquiweb.dtos.MensajeTipoContadorDTO;

import java.util.List;

public interface MensajeChatService {
    public void insert(MensajeChatDTO dto);
    public List<MensajeChatDTO> list();
    public void delete(int id);
    public void update(MensajeChatDTO dto);
    List<MensajeTipoContadorDTO> contarMensajesPorTipo();

}
