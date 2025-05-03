package pe.edu.upc.projecarqui.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.projecarqui.entities.Producto;
import pe.edu.upc.projecarqui.entities.Resena;

import java.util.List;

@Repository
public interface IResenaRepository extends JpaRepository<Resena, Integer> {

    @Query("SELECT r FROM Resena r ORDER BY r.calificacion DESC")
    public List<Resena> listarResenasCalificacion();
}
