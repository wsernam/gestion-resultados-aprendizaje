package co.unicauca.ra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.unicauca.ra.model.Docente;
import co.unicauca.ra.model.EvaluadorExterno;
import java.util.Optional;

// Extendemos MongoRepository para que nos genere los métodos básicos automáticamente
public interface EvaluadorRepository extends MongoRepository<EvaluadorExterno, String> {
     // Puedes agregar consultas personalizadas aquí si las necesitas después
    Optional<EvaluadorExterno> findByCorreo(String correo);
}
