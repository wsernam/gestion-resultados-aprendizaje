package co.unicauca.ra.capaAcesoAdatos.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import co.unicauca.ra.capaAcesoAdatos.model.EvaluadorExterno;

public interface EvaluadorExternoRepository extends MongoRepository<EvaluadorExterno, String> {
    Optional<EvaluadorExterno> findByCorreo(String correoInstitucional);
}