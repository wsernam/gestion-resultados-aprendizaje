package co.unicauca.servicioracompetencias.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.unicauca.servicioracompetencias.model.CompetenciaAsignatura;

import java.util.List;

public interface CompetenciaAsignaturaRepository extends MongoRepository<CompetenciaAsignatura, String> {
    List<CompetenciaAsignatura> findByAsignaturaId(String asignaturaId);
}