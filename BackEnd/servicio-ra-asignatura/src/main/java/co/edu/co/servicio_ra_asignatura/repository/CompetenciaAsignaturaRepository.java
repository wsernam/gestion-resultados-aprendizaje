package co.edu.co.servicio_ra_asignatura.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.edu.co.servicio_ra_asignatura.model.CompetenciaAsignatura;
import java.util.List;

public interface CompetenciaAsignaturaRepository extends MongoRepository<CompetenciaAsignatura, String> {
    List<CompetenciaAsignatura> findByAsignaturaId(String asignaturaId);
}