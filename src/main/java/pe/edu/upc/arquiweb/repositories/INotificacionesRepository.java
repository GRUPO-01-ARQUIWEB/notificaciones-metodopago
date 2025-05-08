package pe.edu.upc.arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.arquiweb.entities.Notificaciones;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface INotificacionesRepository extends JpaRepository<Notificaciones, Integer> {
   @Query("select a from Notificaciones a where a.mensaje like %:mensaje")
   public List<Notificaciones> buscar(@Param("mensaje")String mensaje);

   @Query(value = "SELECT * FROM notificaciones WHERE fecha_envio >= CURRENT_DATE - INTERVAL :intervalo", nativeQuery = true)
   List<Notificaciones> buscarNotificacionesPorIntervalo(@Param("intervalo") String intervalo);
}
