package co.unicauca.ra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.unicauca.ra.model.Docente;

// Extendemos MongoRepository para que nos genere los métodos básicos automáticamente
public interface DocenteRepository extends MongoRepository<Docente, String> {
    // Puedes agregar consultas personalizadas aquí si las necesitas después
}
