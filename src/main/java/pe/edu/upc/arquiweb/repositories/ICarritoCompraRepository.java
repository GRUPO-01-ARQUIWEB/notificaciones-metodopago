package pe.edu.upc.arquiweb.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.arquiweb.entities.CarritoCompra;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarritoCompraRepository extends JpaRepository <CarritoCompra,Integer>{


    @Repository
    public interface ICarritCompraRepository extends JpaRepository <CarritoCompra,Integer>{
        @Query(value = " SELECT \n" +
                "  cc.id_carrito,\n" +
                "  cc.id_usuario,\n" +
                "  cc.id_producto,\n" +
                "  p.nombre AS nombre_producto,\n" +
                "  p.precio_base,\n" +
                "  cc.fecha_creacion\n" +
                " FROM \n" +
                "  carrito_compra cc\n" +
                " JOIN \n" +
                "  producto p ON cc.id_producto = p.id_producto\n" +
                " ORDER BY \n" +
                "  p.precio_base DESC" ,nativeQuery = true)
        public List<String[]> ordenarCarritoCompra();

        @Query(value =" SELECT \n" +
                "    c.id_carrito,\n" +
                "    u.nombre AS nombre_usuario,\n" +
                "    p.nombre AS nombre_producto,\n" +
                "    p.precio_base,\n" +
                "    c.fecha_creacion\n" +
                " FROM carrito_compra c\n" +
                " JOIN producto p ON c.id_producto = p.id_producto\n" +
                " JOIN usuario u ON c.id_usuario = u.id_usuario\n" +
                " WHERE c.id_usuario = 5\n" +
                " ORDER BY c.fecha_creacion DESC",nativeQuery = true)
        public List<String[]> ordenarCarritoCompraUsuarioxFechaCreacion();
    }


}