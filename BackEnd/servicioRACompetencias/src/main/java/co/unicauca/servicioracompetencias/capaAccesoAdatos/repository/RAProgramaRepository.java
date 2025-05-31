package co.unicauca.servicioracompetencias.capaAccesoAdatos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.RAPrograma;

public interface RAProgramaRepository extends MongoRepository<RAPrograma, String> {
   boolean existsByCompetenciaProgramaId(String id);
}
