package co.unicauca.ra.servicio_rubricas.fachadaServices.mapper;


import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.unicauca.ra.servicio_rubricas.capaAcesoAdatos.model.Criterio;
import co.unicauca.ra.servicio_rubricas.fachadaServices.DTO.CriterioDTOPeticion;
import co.unicauca.ra.servicio_rubricas.fachadaServices.DTO.CriterioDTORespuesta;

@Component
public class MapeadorCriterio {

    @Autowired
    private MapeadorNivel mapeadorNivel;

    public Criterio convertirPeticionAEntity(CriterioDTOPeticion dto) {
        Criterio entity = new Criterio();
        entity.setDescripcion(dto.getDescripcion());
        entity.setNiveles(dto.getNiveles().stream()
            .map(mapeadorNivel::convertirPeticionAEntity)
            .collect(Collectors.toList()));
        return entity;
    }

    public CriterioDTORespuesta convertirEntityARespuesta(Criterio entity) {
        CriterioDTORespuesta dto = new CriterioDTORespuesta();
        dto.setDescripcion(entity.getDescripcion());
        dto.setNiveles(entity.getNiveles().stream()
            .map(mapeadorNivel::convertirEntityARespuesta)
            .collect(Collectors.toList()));
        return dto;
    }
}
