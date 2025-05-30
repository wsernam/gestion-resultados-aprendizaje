package co.unicauca.ra.servicio_rubricas.fachadaServices.mapper;


import org.springframework.stereotype.Component;

import co.unicauca.ra.servicio_rubricas.capaAcesoAdatos.model.Nivel;
import co.unicauca.ra.servicio_rubricas.fachadaServices.DTO.NivelDTOPeticion;
import co.unicauca.ra.servicio_rubricas.fachadaServices.DTO.NivelDTORespuesta;

@Component
public class MapeadorNivel {

    public Nivel convertirPeticionAEntity(NivelDTOPeticion dto) {
        Nivel entity = new Nivel();
        entity.setDescripcion(dto.getDescripcion());
        entity.setNota(dto.getNota());
        return entity;
    }

    public NivelDTORespuesta convertirEntityARespuesta(Nivel entity) {
        NivelDTORespuesta dto = new NivelDTORespuesta();
        dto.setDescripcion(entity.getDescripcion());
        dto.setNota(entity.getNota());
        return dto;
    }
}

