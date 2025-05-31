package co.unicauca.servicioracompetencias.fachadaServices.services;

import java.util.List;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.RAAsignaturaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.RAAsignaturaDTORespuesta;

public interface IRAAsignaturaService {
    RAAsignaturaDTORespuesta crear(RAAsignaturaDTOPeticion dto);
    List<RAAsignaturaDTORespuesta> listarTodos();
    List<RAAsignaturaDTORespuesta> listarPorAsignatura(String asignaturaId);
    RAAsignaturaDTORespuesta buscarPorId(String id);
    void eliminar(String id);
    RAAsignaturaDTORespuesta actualizar(String id, RAAsignaturaDTOPeticion dto);
}
