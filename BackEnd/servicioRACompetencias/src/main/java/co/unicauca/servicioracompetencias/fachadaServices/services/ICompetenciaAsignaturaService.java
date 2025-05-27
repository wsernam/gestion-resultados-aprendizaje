package co.unicauca.servicioracompetencias.fachadaServices.services;

import java.util.List;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaAsignaturaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaAsignaturaDTORespuesta;

public interface ICompetenciaAsignaturaService {
    CompetenciaAsignaturaDTORespuesta crear(CompetenciaAsignaturaDTOPeticion dto);
    List<CompetenciaAsignaturaDTORespuesta> listarTodos();
    List<CompetenciaAsignaturaDTORespuesta> listarPorAsignatura(String asignaturaId);
    CompetenciaAsignaturaDTORespuesta buscarPorId(String id);
    void eliminar(String id);
    CompetenciaAsignaturaDTORespuesta actualizar(String id, CompetenciaAsignaturaDTOPeticion dto);

}