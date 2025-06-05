package co.unicauca.servicioracompetencias.fachadaServices.mapper;

import org.springframework.context.annotation.Configuration;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.RAAsignatura;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.RAAsignaturaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.RAAsignaturaDTORespuesta;

@Configuration
public class MapeadorRAAsignatura {

    public RAAsignatura convertirPeticionAEntity(RAAsignaturaDTOPeticion dto) {
        RAAsignatura entity = new RAAsignatura();
        entity.setNombre(dto.getNombre());
        entity.setCompetenciaAsignatura(dto.getCompetenciaAsignatura());
        entity.setDescripcion(dto.getDescripcion());
        return entity;
    }

    public RAAsignaturaDTORespuesta convertirEntityARespuesta(RAAsignatura entity) {
        return new RAAsignaturaDTORespuesta(
            entity.getId(),
            entity.getCompetenciaAsignatura(),
            entity.getNombre(),
            entity.getDescripcion()
        );
    }
}
