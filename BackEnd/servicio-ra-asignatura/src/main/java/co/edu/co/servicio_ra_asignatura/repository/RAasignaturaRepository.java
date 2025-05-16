package co.edu.co.servicio_ra_asignatura.repository;

import co.edu.co.servicio_ra_asignatura.model.RAasignatura;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RAasignaturaRepository extends MongoRepository<RAasignatura, String> {
    List<RAasignatura> findByAsignaturaId(String asignaturaId);
}
