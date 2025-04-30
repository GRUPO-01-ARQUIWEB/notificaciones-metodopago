package pe.edu.upc.arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.arquiweb.entities.Producto;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("Select a from Producto a where a.nombreProducto like %:nombre%")
    public List<Producto> buscar(@Param("nombre") String nombre);

    @Query("select p from Producto p where (:precioBase is null or p.precioBase <= :precioBase) " +
            "and (:categoria is null or p.categoria like %:categoria%)")
    public List<Producto> buscarFiltros(@Param("precioBase") Double precioBase, @Param("categoria") String categoria);

    @Query(value = "select t.nombre, COUNT (p.id_producto) \n" +
            "from tienda t inner join producto p \n" +
            "on t.id_tienda = p.id_tienda   \n" +
            "group by t.nombre", nativeQuery = true)
    List<String[]> cantidadProductos();
}
