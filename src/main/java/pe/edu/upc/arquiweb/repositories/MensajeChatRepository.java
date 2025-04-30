package pe.edu.upc.arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.arquiweb.entities.MensajeChat;

import java.util.List;

public interface MensajeChatRepository extends JpaRepository<MensajeChat, Integer> {
    @Query(value = "SELECT tipo, COUNT(*) AS cantidad FROM mensaje_chat GROUP BY tipo ORDER BY cantidad DESC", nativeQuery = true)
    List<Object[]> contarMensajesPorTipoRaw();

}
