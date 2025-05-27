package co.unicauca.servicioracompetencias.capaAccesoAdatos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.CompetenciaPrograma;

// MongoRepository<Entidad, TipoDeID>
public interface CompetenciaProgramaRepository extends MongoRepository<CompetenciaPrograma, String> {
}
