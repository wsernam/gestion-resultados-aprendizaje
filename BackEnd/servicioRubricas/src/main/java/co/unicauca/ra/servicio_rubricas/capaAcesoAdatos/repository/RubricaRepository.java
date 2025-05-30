package co.unicauca.ra.servicio_rubricas.capaAcesoAdatos.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import co.unicauca.ra.servicio_rubricas.capaAcesoAdatos.model.Rubrica;

/**
 *
 * @author ashle
 */
public interface RubricaRepository extends MongoRepository<Rubrica, String>{

    public List<Rubrica> findByIdCurso(String id_curso); 
}
