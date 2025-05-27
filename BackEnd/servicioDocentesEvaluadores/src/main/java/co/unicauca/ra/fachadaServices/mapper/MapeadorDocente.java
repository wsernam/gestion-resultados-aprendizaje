package co.unicauca.ra.fachadaServices.mapper;

import org.springframework.stereotype.Component;
import co.unicauca.ra.capaAcesoAdatos.model.Docente;
import co.unicauca.ra.fachadaServices.DTO.DocenteDTOPeticion;
import co.unicauca.ra.fachadaServices.DTO.DocenteDTORespuesta;

@Component
public class MapeadorDocente {

    public Docente convertirPeticionAEntity(DocenteDTOPeticion dto) {
        return new Docente(
            dto.getNombres(),
            dto.getApellidos(),
            dto.getCorreo(),
            dto.getTipo(),
            dto.getCedula(),
            dto.getTitulo(),
            dto.getContrasenia(),
            dto.isCoordinador()
        );
    }

    public DocenteDTORespuesta convertirEntityARespuesta(Docente docente) {
        DocenteDTORespuesta dto = new DocenteDTORespuesta();
        dto.setId(docente.getId());
        dto.setNombres(docente.getNombres());
        dto.setApellidos(docente.getApellidos());
        dto.setCorreo(docente.getCorreo());
        dto.setTipo(docente.getTipo());
        dto.setCedula(docente.getCedula());
        dto.setTitulo(docente.getTitulo());
        dto.setCoordinador(docente.isCoordinador());
        return dto;
    }
}

