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
    @Query("SELECT NEW pe.edu.upc.arquiweb.dtos.ComparadorPrecioDTO(" +
            "p.nombreProducto, t.nombre, cp.precio, cp.fechaActualizacion) \n" +
            "FROM ComparadorPrecio cp \n" +
            "JOIN cp.producto p \n" +
            "JOIN cp.tienda t \n" +
            "WHERE p.idProducto IN :productosIds \n" +
            "ORDER BY p.nombreProducto, cp.precio ASC \n")
    List<ComparadorPrecioDTO> compar(@Param("producID") List<Integer> producID);
}
