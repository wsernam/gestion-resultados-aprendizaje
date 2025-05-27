package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaProgramaDTOPeticion {
    private String descripcion;
    @NotBlank(message = "El programa no puede estar vacío.")
    @NotNull(message = "El programa no puede ser null.")
    private String programa;
    @NotBlank(message = "El estado no puede estar vacío.")
    @NotNull(message = "El estado no puede ser null.")
    private String estado;
}
