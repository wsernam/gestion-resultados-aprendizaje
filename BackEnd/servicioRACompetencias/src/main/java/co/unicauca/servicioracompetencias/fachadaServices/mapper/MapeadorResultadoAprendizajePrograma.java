package co.unicauca.servicioracompetencias.fachadaServices.mapper;

import org.springframework.context.annotation.Configuration;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.ResultadoAprendizajePrograma;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeProgramaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeProgramaDTORespuesta;

@Configuration
public class MapeadorResultadoAprendizajePrograma {

    public ResultadoAprendizajePrograma convertirPeticionAEntity(ResultadoAprendizajeProgramaDTOPeticion dto) {
        ResultadoAprendizajePrograma entity = new ResultadoAprendizajePrograma();
        entity.setNombre(dto.getNombre());
        entity.setCompetenciaProgramaId(dto.getCompetenciaProgramaId());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrograma(dto.getPrograma());
        return entity;
    }

    public ResultadoAprendizajeProgramaDTORespuesta convertirEntityARespuesta(ResultadoAprendizajePrograma entity) {
        return new ResultadoAprendizajeProgramaDTORespuesta(
            entity.getId(),
            entity.getCompetenciaProgramaId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getPrograma()
        );
    }
}
