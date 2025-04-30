package pe.edu.upc.arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.arquiweb.entities.Producto;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Integer> {
}
