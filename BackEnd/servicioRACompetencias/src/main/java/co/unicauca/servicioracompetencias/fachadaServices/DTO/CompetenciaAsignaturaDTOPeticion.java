package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaAsignaturaDTOPeticion {
    @NotBlank(message = "El ID de competencia del programa no puede estar vacío.")
    @NotNull(message = "El ID de competencia del programa no puede ser null.")
    private String competenciaProgramaId;
    @NotBlank(message = "El ID de la asignatura no puede estar vacío.")
    @NotNull(message = "El ID de la asignatura no puede ser null.")
    private String asignaturaId;
    private String descripcion;
    @NotBlank(message = "El estado no puede estar vacío.")
    @NotNull(message = "El estado no puede ser null.")
    private String estado;
}
