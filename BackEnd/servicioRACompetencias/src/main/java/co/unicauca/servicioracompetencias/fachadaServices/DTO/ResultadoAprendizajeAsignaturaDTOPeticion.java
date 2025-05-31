package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoAprendizajeAsignaturaDTOPeticion {
    @NotBlank(message = "competenciaAsignaturaId no puede estar vacío.")
    private String competenciaAsignaturaId;
    @NotBlank(message = "el nombre de resultado aprendisaje asignatura no puede estar vacío.")
    private String nombre;
    private String descripcion;
}
