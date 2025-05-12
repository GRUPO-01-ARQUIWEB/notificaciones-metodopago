package pe.edu.upc.arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.arquiweb.entities.MetodoPago;
import pe.edu.upc.arquiweb.entities.Usuario;

import java.util.List;
@Repository
public interface IMetodoPagoRepository extends JpaRepository<MetodoPago,Integer>{
    @Query(" SELECT m FROM MetodoPago m WHERE m.usuario.idUsuario = :idUsuario")
    List<MetodoPago> buscarPorUsuario(@Param("idUsuario") int idUsuario);

@Query(value = " SELECT * FROM metodo_pago WHERE TO_DATE(vencimiento, 'YYYY-MM-DD') < CURRENT_DATE", nativeQuery = true)
    List<MetodoPago> buscarMetodosPagoVencidos();

@Query(" SELECT m FROM MetodoPago m WHERE LOWER(m.tipo) = LOWER(:tipo)")
    List<MetodoPago> buscarPorTipo(@Param("tipo") String tipo);

    @Query(value = """
        SELECT 
            mp.id_metodo_pago as id,
            mp.tipo,
            mp.titular,
            COUNT(cc.id_carrito) as totalUsos,
            ROUND(COUNT(cc.id_carrito) * 100.0 / 
                (SELECT COUNT(*) FROM carrito_compra WHERE id_metodopago IS NOT NULL), 1) as porcentaje
        FROM metodo_pago mp
        LEFT JOIN carrito_compra cc ON mp.id_metodo_pago = cc.id_metodopago
        GROUP BY mp.id_metodo_pago, mp.tipo, mp.titular
        ORDER BY totalUsos DESC
        LIMIT 1""",
            nativeQuery = true)
    List<Object[]> findMetodoPagoMasUsado();

}
