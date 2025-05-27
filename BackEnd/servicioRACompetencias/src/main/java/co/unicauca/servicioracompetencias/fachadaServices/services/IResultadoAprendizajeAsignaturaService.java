package co.unicauca.servicioracompetencias.fachadaServices.services;

import java.util.List;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeAsignaturaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeAsignaturaDTORespuesta;

public interface IResultadoAprendizajeAsignaturaService {
    ResultadoAprendizajeAsignaturaDTORespuesta crear(ResultadoAprendizajeAsignaturaDTOPeticion dto);
    List<ResultadoAprendizajeAsignaturaDTORespuesta> listarTodos();
    List<ResultadoAprendizajeAsignaturaDTORespuesta> listarPorAsignatura(String asignaturaId);
    ResultadoAprendizajeAsignaturaDTORespuesta buscarPorId(String id);
    void eliminar(String id);
    ResultadoAprendizajeAsignaturaDTORespuesta actualizar(String id, ResultadoAprendizajeAsignaturaDTOPeticion dto);
}
