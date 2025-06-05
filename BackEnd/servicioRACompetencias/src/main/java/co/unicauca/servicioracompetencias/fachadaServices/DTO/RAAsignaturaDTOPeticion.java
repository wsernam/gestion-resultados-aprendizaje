package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.CompetenciaAsignatura;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RAAsignaturaDTOPeticion {
    
    private CompetenciaAsignatura competenciaAsignatura;
    @NotBlank(message = "el nombre de resultado aprendisaje asignatura no puede estar vacío.")
    private String nombre;
    private String descripcion;
}
