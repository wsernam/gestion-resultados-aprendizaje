package co.unicauca.servicioracompetencias.fachadaServices.mapper;

import org.springframework.context.annotation.Configuration;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.RAAsignatura;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeAsignaturaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeAsignaturaDTORespuesta;

@Configuration
public class MapeadorRAAsignatura {

    public RAAsignatura convertirPeticionAEntity(ResultadoAprendizajeAsignaturaDTOPeticion dto) {
        RAAsignatura entity = new RAAsignatura();
        entity.setNombre(dto.getNombre());
        entity.setCompetenciaAsignaturaId(dto.getCompetenciaAsignaturaId());
        entity.setDescripcion(dto.getDescripcion());
        return entity;
    }

    public ResultadoAprendizajeAsignaturaDTORespuesta convertirEntityARespuesta(RAAsignatura entity) {
        return new ResultadoAprendizajeAsignaturaDTORespuesta(
            entity.getId(),
            entity.getNombre(),
            entity.getCompetenciaAsignaturaId(),
            entity.getDescripcion()
        );
    }
}
