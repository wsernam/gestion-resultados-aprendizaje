package co.unicauca.ra.servicio_rubricas.fachadaServices.service;

import co.unicauca.ra.servicio_rubricas.fachadaServices.DTO.RubricaDTOPeticion;
import co.unicauca.ra.servicio_rubricas.fachadaServices.DTO.RubricaDTORespuesta;

import java.util.List;

public interface IRubricaService {
    RubricaDTORespuesta crear(RubricaDTOPeticion dto);
    RubricaDTORespuesta buscarPorId(String id);
    RubricaDTORespuesta actualizar(String id, RubricaDTOPeticion dto);
    void eliminar(String id);
    List<RubricaDTORespuesta> listarPorIdCurso(String idCurso);
}
