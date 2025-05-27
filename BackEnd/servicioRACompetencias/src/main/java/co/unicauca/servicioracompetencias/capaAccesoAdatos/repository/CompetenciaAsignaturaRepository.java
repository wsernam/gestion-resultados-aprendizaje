package co.unicauca.servicioracompetencias.capaAccesoAdatos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.CompetenciaAsignatura;

import java.util.List;

public interface CompetenciaAsignaturaRepository extends MongoRepository<CompetenciaAsignatura, String> {
    List<CompetenciaAsignatura> findByAsignaturaId(String asignaturaId);
    boolean existsByCompetenciaProgramaId(String idCompetenciaPrograma);
}