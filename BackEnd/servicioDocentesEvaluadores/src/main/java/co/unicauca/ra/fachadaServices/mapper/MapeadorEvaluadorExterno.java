package co.unicauca.ra.fachadaServices.mapper;

import org.springframework.stereotype.Component;
import co.unicauca.ra.capaAcesoAdatos.model.EvaluadorExterno;
import co.unicauca.ra.fachadaServices.DTO.EvaluadorExternoDTOPeticion;
import co.unicauca.ra.fachadaServices.DTO.EvaluadorExternoDTORespuesta;

@Component
public class MapeadorEvaluadorExterno {

    public EvaluadorExterno convertirPeticionAEntity(EvaluadorExternoDTOPeticion dto) {
        EvaluadorExterno entity = new EvaluadorExterno();
        entity.setNombres(dto.getNombres());
        entity.setApellidos(dto.getApellidos());
        entity.setCorreo(dto.getCorreo());
        entity.setContrasenia(dto.getContrasenia());
        return entity;
    }

    public EvaluadorExternoDTORespuesta convertirEntityARespuesta(EvaluadorExterno entity) {
        EvaluadorExternoDTORespuesta dto = new EvaluadorExternoDTORespuesta();
        dto.setId(entity.getId());
        dto.setNombres(entity.getNombres());
        dto.setApellidos(entity.getApellidos());
        dto.setCorreo(entity.getCorreo());
        return dto;
    }
}

