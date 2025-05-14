package pe.edu.upc.arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.arquiweb.entities.ChatProveedor;

import java.util.List;

@Repository
public interface IChatProveedorRepository extends JpaRepository<ChatProveedor, Integer> {
    @Query(value = """
        SELECT 
            EXTRACT(MONTH FROM cp.fechainicio) AS mes,
            EXTRACT(YEAR FROM cp.fechainicio) AS anio,
            COUNT(cp.id_chat) AS cantidad_chats
        FROM 
            chat_proveedor cp
        GROUP BY 
            EXTRACT(YEAR FROM cp.fechainicio),
            EXTRACT(MONTH FROM cp.fechainicio)
        ORDER BY 
            anio, mes
        """, nativeQuery = true)
    List<Object[]> cantidadChatXTiempo();

}