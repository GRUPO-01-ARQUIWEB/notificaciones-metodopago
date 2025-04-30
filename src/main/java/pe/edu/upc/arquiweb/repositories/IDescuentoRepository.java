package pe.edu.upc.arquiweb.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import pe.edu.upc.arquiweb.entities.Descuento;

@Repository
public interface IDescuentoRepository extends JpaRepository <Descuento, Integer>{
}
