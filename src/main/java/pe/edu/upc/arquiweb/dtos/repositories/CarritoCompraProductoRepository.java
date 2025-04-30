package pe.edu.upc.arquiweb.dtos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.demog1.entities.CarritoCompraProducto;

import java.util.List;

public interface CarritoCompraProductoRepository extends JpaRepository<CarritoCompraProducto, Integer> {
    @Query(value = "SELECT id_producto AS idProducto, SUM(cantidad) AS totalComprado FROM carrito_compra_producto" +
            " GROUP BY id_producto ORDER BY totalComprado DESC LIMIT 5", nativeQuery = true)
    List<Object[]> productosMasCompradosRaw();
}
