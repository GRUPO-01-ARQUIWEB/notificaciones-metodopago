package pe.edu.upc.arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.arquiweb.entities.MetodoPago;
import pe.edu.upc.arquiweb.entities.Notificaciones;

import java.util.List;
@Repository
public interface IMetodopagoRepository extends JpaRepository<MetodoPago,Integer>{
@Query("select m from MetodoPago m where m.titular like %:titular%")
List<MetodoPago> buscarPorTitular(@Param("titular") String titular);
}
