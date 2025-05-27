package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoAprendizajeProgramaDTOPeticion {
    @NotBlank(message = "competenciaProgramaId no puede estar vacío.")
    private String competenciaProgramaId;
    private String descripcion;
    @NotBlank(message = "programa no puede estar vacío.")
    @NotNull(message = "programa no puede ser null.")
    private String programa;
}
