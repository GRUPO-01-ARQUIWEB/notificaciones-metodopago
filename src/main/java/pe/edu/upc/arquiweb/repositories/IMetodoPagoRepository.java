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

    Usuario usuario(Usuario usuario);

}
