package co.unicauca.servicioracompetencias.fachadaServices.mapper;

import org.springframework.context.annotation.Configuration;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.RAPrograma;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeProgramaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeProgramaDTORespuesta;

@Configuration
public class MapeadorRAPrograma {

    public RAPrograma convertirPeticionAEntity(ResultadoAprendizajeProgramaDTOPeticion dto) {
        RAPrograma entity = new RAPrograma();
        entity.setNombre(dto.getNombre());
        entity.setCompetenciaProgramaId(dto.getCompetenciaProgramaId());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrograma(dto.getPrograma());
        return entity;
    }

    public ResultadoAprendizajeProgramaDTORespuesta convertirEntityARespuesta(RAPrograma entity) {
        return new ResultadoAprendizajeProgramaDTORespuesta(
            entity.getId(),
            entity.getCompetenciaProgramaId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getPrograma()
        );
    }
}
