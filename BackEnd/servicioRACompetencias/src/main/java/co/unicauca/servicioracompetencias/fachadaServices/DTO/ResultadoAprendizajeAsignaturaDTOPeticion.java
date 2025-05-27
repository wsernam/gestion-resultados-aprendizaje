package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoAprendizajeAsignaturaDTOPeticion {
    @NotBlank(message = "competenciaAsignaturaId no puede estar vacío.")
    @NotNull(message = "competenciaAsignaturaId no puede ser null.")
    private String competenciaAsignaturaId;
    private String descripcion;
}
