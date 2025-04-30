package pe.edu.upc.projecarqui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.projecarqui.entities.Producto;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("Select a from Producto a where a.nombreProducto like %:nombre%")
    public List<Producto> buscar(@Param("nombre") String nombre);

    @Query("SELECT p FROM Producto p WHERE (:precioBase IS NULL OR p.precioBase <= :precioBase) " +
            "AND (:categoria IS NULL OR p.categoria LIKE %:categoria%)")
    public List<Producto> buscarFiltros(@Param("precioBase") Double precioBase, @Param("categoria") String categoria);
}

