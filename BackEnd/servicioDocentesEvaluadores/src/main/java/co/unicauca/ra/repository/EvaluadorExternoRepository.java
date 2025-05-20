package co.unicauca.ra.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.unicauca.ra.model.EvaluadorExterno;

public interface EvaluadorExternoRepository extends MongoRepository<EvaluadorExterno, String> {
    Optional<EvaluadorExterno> findByCorreoInstitucional(String correoInstitucional);
}