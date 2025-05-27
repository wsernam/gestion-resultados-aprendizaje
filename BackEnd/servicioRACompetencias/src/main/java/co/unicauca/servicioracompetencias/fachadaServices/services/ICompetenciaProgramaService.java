package co.unicauca.servicioracompetencias.fachadaServices.services;

import java.util.List;

import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaProgramaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaProgramaDTORespuesta;

public interface ICompetenciaProgramaService {
    CompetenciaProgramaDTORespuesta crear(CompetenciaProgramaDTOPeticion dto);
    List<CompetenciaProgramaDTORespuesta> listarTodos();
    CompetenciaProgramaDTORespuesta buscarPorId(String id);
    void eliminar(String id);
    CompetenciaProgramaDTORespuesta actualizar(String id, CompetenciaProgramaDTOPeticion dto);

}