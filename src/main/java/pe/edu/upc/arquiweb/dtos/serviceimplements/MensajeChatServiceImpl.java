package pe.edu.upc.arquiweb.dtos.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.demog1.dtos.MensajeChatDTO;
import pe.edu.upc.demog1.dtos.MensajeTipoContadorDTO;
import pe.edu.upc.demog1.entities.MensajeChat;
import pe.edu.upc.demog1.repositories.MensajeChatRepository;
import pe.edu.upc.demog1.servicesinterfaces.MensajeChatService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MensajeChatServiceImpl implements MensajeChatService {

    @Autowired
    private MensajeChatRepository mensajeChatRepository;

    @Override
    public void insert(MensajeChatDTO dto) {
        MensajeChat m = new MensajeChat();
        m.setIdChat(dto.getIdChat());
        m.setContenido(dto.getContenido());
        m.setTipo(dto.getTipo());
        m.setUrlVideo(dto.getUrlVideo());
        m.setFechaEnvio(dto.getFechaEnvio());
        mensajeChatRepository.save(m);
    }

    @Override
    public List<MensajeChatDTO> list() {
        List<MensajeChat> lista = mensajeChatRepository.findAll();
        List<MensajeChatDTO> dtoList = new ArrayList<>();
        for (MensajeChat m : lista) {
            MensajeChatDTO dto = new MensajeChatDTO();
            dto.setIdMensaje(m.getIdMensaje());
            dto.setIdChat(m.getIdChat());
            dto.setContenido(m.getContenido());
            dto.setTipo(m.getTipo());
            dto.setUrlVideo(m.getUrlVideo());
            dto.setFechaEnvio(m.getFechaEnvio());
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public void delete(int id) {
        mensajeChatRepository.deleteById(id);
    }

    @Override
    public void update(MensajeChatDTO dto) {
        MensajeChat m = new MensajeChat();
        m.setIdMensaje(dto.getIdMensaje());
        m.setIdChat(dto.getIdChat());
        m.setContenido(dto.getContenido());
        m.setTipo(dto.getTipo());
        m.setUrlVideo(dto.getUrlVideo());
        m.setFechaEnvio(dto.getFechaEnvio());
        mensajeChatRepository.save(m);
    }

    @Override
    public List<MensajeTipoContadorDTO> contarMensajesPorTipo() {
        List<Object[]> data = mensajeChatRepository.contarMensajesPorTipoRaw();
        List<MensajeTipoContadorDTO> lista = new ArrayList<>();
        for (Object[] obj : data) {
            MensajeTipoContadorDTO dto = new MensajeTipoContadorDTO(
                    (String) obj[0],
                    ((Number) obj[1]).intValue()
            );
            lista.add(dto);
        }
        return lista;
    }


}

