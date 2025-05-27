package co.unicauca.servicioracompetencias.fachadaServices.mapper;

import org.springframework.context.annotation.Configuration;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.ResultadoAprendizajeAsignatura;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeAsignaturaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeAsignaturaDTORespuesta;

@Configuration
public class MapeadorResultadoAprendizajeAsignatura {

    public ResultadoAprendizajeAsignatura convertirPeticionAEntity(ResultadoAprendizajeAsignaturaDTOPeticion dto) {
        ResultadoAprendizajeAsignatura entity = new ResultadoAprendizajeAsignatura();
        entity.setCompetenciaAsignaturaId(dto.getCompetenciaAsignaturaId());
        entity.setDescripcion(dto.getDescripcion());
        return entity;
    }

    public ResultadoAprendizajeAsignaturaDTORespuesta convertirEntityARespuesta(ResultadoAprendizajeAsignatura entity) {
        return new ResultadoAprendizajeAsignaturaDTORespuesta(
            entity.getId(),
            entity.getCompetenciaAsignaturaId(),
            entity.getDescripcion()
        );
    }
}
