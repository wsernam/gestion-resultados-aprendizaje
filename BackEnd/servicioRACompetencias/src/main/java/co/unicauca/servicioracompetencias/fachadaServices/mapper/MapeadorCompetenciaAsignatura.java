package co.unicauca.servicioracompetencias.fachadaServices.mapper;

import org.springframework.context.annotation.Configuration;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.CompetenciaAsignatura;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaAsignaturaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaAsignaturaDTORespuesta;

@Configuration
public class MapeadorCompetenciaAsignatura {

    public CompetenciaAsignatura convertirPeticionAEntity(CompetenciaAsignaturaDTOPeticion dto) {
        CompetenciaAsignatura entity = new CompetenciaAsignatura();
        entity.setCompetenciaProgramaId(dto.getCompetenciaProgramaId());
        entity.setNombre(dto.getNombre());
        entity.setAsignaturaId(dto.getAsignaturaId());
        entity.setDescripcion(dto.getDescripcion());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    public CompetenciaAsignaturaDTORespuesta convertirEntityARespuesta(CompetenciaAsignatura entity) {
        return new CompetenciaAsignaturaDTORespuesta(
            entity.getId(),
            entity.getCompetenciaProgramaId(),
            entity.getAsignaturaId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getEstado()
        );
    }
}