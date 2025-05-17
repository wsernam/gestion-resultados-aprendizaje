package co.unicauca.servicioracompetencias.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.unicauca.servicioracompetencias.model.ResultadoAprendizajeAsignatura;
import java.util.List;

public interface ResultadoAprendizajeAsignaturaRepository extends MongoRepository<ResultadoAprendizajeAsignatura, String> {
    List<ResultadoAprendizajeAsignatura> findByAsignaturaId(String asignaturaId);
}
