package co.unicauca.ra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.unicauca.ra.model.Docente;
import java.util.Optional;

// Extendemos MongoRepository para que nos genere los métodos básicos automáticamente
public interface DocenteRepository extends MongoRepository<Docente, String> {
     // Puedes agregar consultas personalizadas aquí si las necesitas después
    Optional<Docente> findByCorreo(String correo);
    Optional<Docente> findByCedula(int cedula);
}
