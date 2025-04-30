package pe.edu.upc.arquiweb.dtos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.demog1.entities.CarritoCompra;

@Repository
public interface CarritCompraRepository extends JpaRepository <CarritoCompra,Integer>{
}
