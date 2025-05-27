package co.unicauca.servicioracompetencias.capaAccesoAdatos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.ResultadoAprendizajeAsignatura;

import java.util.List;

public interface ResultadoAprendizajeAsignaturaRepository extends MongoRepository<ResultadoAprendizajeAsignatura, String> {
    List<ResultadoAprendizajeAsignatura> findByCompetenciaAsignaturaId(String competenciaAsignaturaId);

}
