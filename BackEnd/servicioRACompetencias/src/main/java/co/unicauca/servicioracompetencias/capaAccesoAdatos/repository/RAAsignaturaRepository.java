package co.unicauca.servicioracompetencias.capaAccesoAdatos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.RAAsignatura;

import java.util.List;

public interface RAAsignaturaRepository extends MongoRepository<RAAsignatura, String> {
    List<RAAsignatura> findByCompetenciaAsignaturaId(String competenciaAsignaturaId);

}
