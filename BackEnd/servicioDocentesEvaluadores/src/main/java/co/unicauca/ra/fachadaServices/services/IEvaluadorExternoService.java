package co.unicauca.ra.fachadaServices.services;

import co.unicauca.ra.fachadaServices.DTO.EvaluadorExternoDTOPeticion;
import co.unicauca.ra.fachadaServices.DTO.EvaluadorExternoDTORespuesta;
import java.util.List;

public interface IEvaluadorExternoService {
    EvaluadorExternoDTORespuesta crear(EvaluadorExternoDTOPeticion dto);
    EvaluadorExternoDTORespuesta actualizar(String id, EvaluadorExternoDTOPeticion dto);
    List<EvaluadorExternoDTORespuesta> listarTodos();
    EvaluadorExternoDTORespuesta buscarPorId(String id);
    EvaluadorExternoDTORespuesta buscarPorCorreo(String correo);
    List<String> obtenerIdCursos(String correo); 
    EvaluadorExternoDTORespuesta agregarIdCurso(String correo, String idCurso);
    void eliminar(String id);
}