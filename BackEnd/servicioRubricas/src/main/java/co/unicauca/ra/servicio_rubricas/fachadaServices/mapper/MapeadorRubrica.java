package co.unicauca.ra.servicio_rubricas.fachadaServices.mapper;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.unicauca.ra.servicio_rubricas.capaAcesoAdatos.model.Rubrica;
import co.unicauca.ra.servicio_rubricas.fachadaServices.DTO.RubricaDTOPeticion;
import co.unicauca.ra.servicio_rubricas.fachadaServices.DTO.RubricaDTORespuesta;

@Component
public class MapeadorRubrica {

    @Autowired
    private MapeadorCriterio mapeadorCriterio;

    public Rubrica convertirPeticionAEntity(RubricaDTOPeticion dto) {
        Rubrica entity = new Rubrica();
        entity.setDescripcion(dto.getDescripcion());
        entity.setIdCurso(dto.getIdCurso());
        entity.setPonderado(dto.getPonderado());
        entity.setIdRaAsignatura(dto.getIdRaAsignatura());
        entity.setCriterios(dto.getCriterios().stream()
            .map(mapeadorCriterio::convertirPeticionAEntity)
            .collect(Collectors.toList()));
        return entity;
    }

    public RubricaDTORespuesta convertirEntityARespuesta(Rubrica entity) {
        RubricaDTORespuesta dto = new RubricaDTORespuesta();
        dto.setId(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        dto.setIdCurso(entity.getIdCurso());
        dto.setPonderado(entity.getPonderado());
        dto.setIdRaAsignatura(entity.getIdRaAsignatura());
        dto.setCriterios(entity.getCriterios().stream()
            .map(mapeadorCriterio::convertirEntityARespuesta)
            .collect(Collectors.toList()));
        return dto;
    }
}
