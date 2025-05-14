package pe.edu.upc.arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.arquiweb.entities.Resena;

import java.util.List;

@Repository
public interface IResenaRepository extends JpaRepository<Resena, Integer> {

    @Query("SELECT r FROM Resena r JOIN FETCH r.usuario u JOIN FETCH r.producto p ORDER BY r.calificacion DESC")
    public List<Resena> listarResenasCalificacion();

}
