package pe.edu.upc.grupo1_arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.grupo1_arquiweb.entities.Descuento;

@Repository
public interface IDescuentoRepository extends JpaRepository<Descuento, Long> {
}
