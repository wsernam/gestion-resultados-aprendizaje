package co.unicauca.servicioracompetencias.fachadaServices.mapper;

import org.springframework.context.annotation.Configuration;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.CompetenciaPrograma;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaProgramaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaProgramaDTORespuesta;

@Configuration
public class MapeadorCompetenciaPrograma {

    public CompetenciaPrograma convertirPeticionAEntity(CompetenciaProgramaDTOPeticion dto) {
        CompetenciaPrograma entity = new CompetenciaPrograma();
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrograma(dto.getPrograma());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    public CompetenciaProgramaDTORespuesta convertirEntityARespuesta(CompetenciaPrograma entity) {
        return new CompetenciaProgramaDTORespuesta(
            entity.getId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getPrograma(),
            entity.getEstado()
        );
    }
}
