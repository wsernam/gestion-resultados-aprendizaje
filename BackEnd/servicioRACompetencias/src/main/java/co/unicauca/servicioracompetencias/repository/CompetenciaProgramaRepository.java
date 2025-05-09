package co.unicauca.servicioracompetencias.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.unicauca.servicioracompetencias.model.CompetenciaPrograma;

// MongoRepository<Entidad, TipoDeID>
public interface CompetenciaProgramaRepository extends MongoRepository<CompetenciaPrograma, String> {
    // Si en el futuro necesitas consultas personalizadas, las agregas aquí
}
