package co.unicauca.servicioracompetencias.fachadaServices.services;

import java.util.List;

import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeProgramaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeProgramaDTORespuesta;

public interface IResultadoAprendizajeProgramaService {
    ResultadoAprendizajeProgramaDTORespuesta crear(ResultadoAprendizajeProgramaDTOPeticion dto);
    List<ResultadoAprendizajeProgramaDTORespuesta> listarTodos();
    ResultadoAprendizajeProgramaDTORespuesta buscarPorId(String id);
    void eliminar(String id);
    ResultadoAprendizajeProgramaDTORespuesta actualizar(String id, ResultadoAprendizajeProgramaDTOPeticion dto);
}
