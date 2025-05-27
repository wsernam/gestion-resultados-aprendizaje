package co.unicauca.servicioracompetencias.capaAccesoAdatos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.ResultadoAprendizajePrograma;

public interface ResultadoAprendizajeProgramaRepository extends MongoRepository<ResultadoAprendizajePrograma, String> {
   boolean existsByCompetenciaProgramaId(String id);
}
