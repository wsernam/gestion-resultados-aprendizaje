package co.unicauca.servicioracompetencias.fachadaServices.services;

import java.util.List;

import co.unicauca.servicioracompetencias.fachadaServices.DTO.RAProgramaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.RAProgramaDTORespuesta;

public interface IRAProgramaService {
    RAProgramaDTORespuesta crear(RAProgramaDTOPeticion dto);
    List<RAProgramaDTORespuesta> listarTodos();
    RAProgramaDTORespuesta buscarPorId(String id);
    void eliminar(String id);
    RAProgramaDTORespuesta actualizar(String id, RAProgramaDTOPeticion dto);
}
