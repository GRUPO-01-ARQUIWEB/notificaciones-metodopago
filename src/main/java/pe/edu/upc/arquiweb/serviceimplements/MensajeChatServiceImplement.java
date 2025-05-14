package pe.edu.upc.arquiweb.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.arquiweb.dtos.MensajeChatDTO;
import pe.edu.upc.arquiweb.dtos.MensajeTipoContadorDTO;
import pe.edu.upc.arquiweb.entities.MensajeChat;
import pe.edu.upc.arquiweb.repositories.IMensajeChatRepository;
import pe.edu.upc.arquiweb.serviceinterfaces.IMensajeChatService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MensajeChatServiceImplement implements IMensajeChatService {

    @Autowired
    private IMensajeChatRepository mR;

    @Override
    public void insert(MensajeChatDTO dto) {
        MensajeChat m = new MensajeChat();
        m.setContenido(dto.getContenido());
        m.setTipo(dto.getTipo());
        m.setUrlVideo(dto.getUrlVideo());
        m.setFechaEnvio(dto.getFechaEnvio());
        mR.save(m);
    }

    @Override
    public List<MensajeChatDTO> list() {
        List<MensajeChat> lista = mR.findAll();
        List<MensajeChatDTO> dtoList = new ArrayList<>();
        for (MensajeChat m : lista) {
            MensajeChatDTO dto = new MensajeChatDTO();
            dto.setIdMensaje(m.getIdMensaje());
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
        mR.deleteById(id);
    }

    @Override
    public void update(MensajeChatDTO dto) {
        MensajeChat m = new MensajeChat();
        m.setIdMensaje(dto.getIdMensaje());
        m.setContenido(dto.getContenido());
        m.setTipo(dto.getTipo());
        m.setUrlVideo(dto.getUrlVideo());
        m.setFechaEnvio(dto.getFechaEnvio());
        mR.save(m);
    }

    @Override
    public List<MensajeTipoContadorDTO> contarMensajesPorTipo() {
        List<Object[]> data = mR.contarMensajesPorTipoRaw();
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
