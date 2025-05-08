package pe.edu.upc.arquiweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.arquiweb.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findOneByUsername(String username);

    @Query("select count(u.username) from Usuario u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);
}
