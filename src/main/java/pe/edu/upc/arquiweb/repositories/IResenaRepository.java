package pe.edu.upc.arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.arquiweb.entities.Resena;

import java.util.List;

@Repository
public interface IResenaRepository extends JpaRepository<Resena, Integer> {

    @Query("select r from Resena r order by r.calificacion desc")
    public List<Resena> listarResenasCalificacion();
}
