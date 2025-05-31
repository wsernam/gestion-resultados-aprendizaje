package co.unicauca.servicioracompetencias.fachadaServices.mapper;

import org.springframework.context.annotation.Configuration;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.RAPrograma;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.RAProgramaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.RAProgramaDTORespuesta;

@Configuration
public class MapeadorRAPrograma {

    public RAPrograma convertirPeticionAEntity(RAProgramaDTOPeticion dto) {
        RAPrograma entity = new RAPrograma();
        entity.setNombre(dto.getNombre());
        entity.setCompetenciaProgramaId(dto.getCompetenciaProgramaId());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrograma(dto.getPrograma());
        return entity;
    }

    public RAProgramaDTORespuesta convertirEntityARespuesta(RAPrograma entity) {
        return new RAProgramaDTORespuesta(
            entity.getId(),
            entity.getCompetenciaProgramaId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getPrograma()
        );
    }
}
