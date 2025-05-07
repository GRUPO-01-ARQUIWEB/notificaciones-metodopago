package pe.edu.upc.arquiweb.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.arquiweb.entities.Descuento;

import java.util.List;

@Repository
public interface IDescuentoRepository extends JpaRepository <Descuento, Integer>{
    @Query(value = " SELECT \n" +
            "    id_descuento,\n" +
            "    cod_descuento,\n" +
            "    porcentaje,\n" +
            "    fecha_inicio,\n" +
            "    fecha_fin\n" +
            " FROM \n" +
            "    descuento\n" +
            " WHERE \n" +
            "    CURRENT_DATE BETWEEN fecha_inicio AND fecha_fin\n" +
            " ORDER BY \n" +
            "    fecha_fin ASC", nativeQuery = true)
    public List<String[]> ListarDescVigentes();
    @Query("SELECT d FROM Descuento d " +
            "WHERE CURRENT_DATE BETWEEN d.fechaInicio AND d.fechaFin " +
            "ORDER BY d.porcentaje DESC")
    List<Descuento> listarDescuentosOrdenadosPorPorcentaje();
}
