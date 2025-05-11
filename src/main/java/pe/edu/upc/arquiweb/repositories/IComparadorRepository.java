package pe.edu.upc.arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.arquiweb.entities.Comparador;

import java.util.List;

@Repository
public interface IComparadorRepository extends JpaRepository<Comparador, Integer> {
    @Query("SELECT cp FROM Comparador cp " +
            "JOIN FETCH cp.producto p " +
            "JOIN FETCH cp.tienda t " +
            "WHERE p.idProducto IN :productosIds")
    List<Comparador> findForComparison(@Param("productosIds") List<Integer> productosIds);
}
