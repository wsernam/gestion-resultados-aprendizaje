package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaAsignaturaDTOPeticion {
    @NotBlank(message = "El ID de competencia del programa no puede estar vacío.")
    private String competenciaProgramaId;
    @NotBlank(message = "El ID de la asignatura no puede estar vacío.")
    private String asignaturaId;
    @NotBlank(message = "El nombre de la asignatura no puede estar vacío.")
    private String nombre;
    private String descripcion;
    @NotBlank(message = "El estado no puede estar vacío.")
    private String estado;
}
