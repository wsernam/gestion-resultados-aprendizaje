package co.unicauca.servicioracompetencias.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import co.unicauca.servicioracompetencias.model.ResultadoAprendizajePrograma;

public interface ResultadoAprendizajeProgramaRepository extends MongoRepository<ResultadoAprendizajePrograma, String> {
    // Aquí podrías agregar métodos personalizados si los necesitas
}
