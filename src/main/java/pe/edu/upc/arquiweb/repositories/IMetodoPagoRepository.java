package pe.edu.upc.arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.arquiweb.entities.MetodoPago;
import pe.edu.upc.arquiweb.entities.Producto;
import pe.edu.upc.arquiweb.entities.Usuario;

import java.util.List;
@Repository
public interface IMetodoPagoRepository extends JpaRepository<MetodoPago,Integer>{

   @Query(" SELECT m FROM MetodoPago m WHERE m.usuario.idUsuario = :nombre")
    List<MetodoPago> buscarPorNombre(@Param("nombre") String nombre);


    @Query(value = " SELECT * FROM metodo_pago WHERE TO_DATE(vencimiento, 'YYYY-MM-DD') < CURRENT_DATE", nativeQuery = true)
    List<MetodoPago> buscarMetodosPagoVencidos();


    @Query("Select m from MetodoPago m where m.tipo like %:tipo%")
    public List<MetodoPago> buscarPorTipo(@Param("tipo") String tipo);

    @Query(value = """
            SELECT\s
            tipo,
            COUNT(tipo) as cantidad
        FROM\s
            "metodo_pago"
        GROUP BY\s
            tipo
        ORDER BY\s
            cantidad DESC;""",
            nativeQuery = true)
    List<Object[]> contMetodoPagoUsado();

}
