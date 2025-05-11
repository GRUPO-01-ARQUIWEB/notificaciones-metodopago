package pe.edu.upc.arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.arquiweb.dtos.ComparadorPrecioDTO;
import pe.edu.upc.arquiweb.entities.ComparadorPrecio;

import java.util.List;

@Repository
public interface IComparadorPrecioRepository extends JpaRepository<ComparadorPrecio, Integer> {
    @Query("SELECT cp FROM ComparadorPrecio cp " +
            "JOIN FETCH cp.producto p " +
            "JOIN FETCH cp.tienda t " +
            "WHERE p.idProducto IN :productosIds")
    List<ComparadorPrecio> findForComparison(@Param("productosIds") List<Integer> productosIds);
}
