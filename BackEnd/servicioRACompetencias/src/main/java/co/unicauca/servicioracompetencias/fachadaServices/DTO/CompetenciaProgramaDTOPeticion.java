package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaProgramaDTOPeticion {
    @NotBlank(message = "El nombre de programa no puede estar vacío.")
    private String nombre;
    private String descripcion;
    @NotBlank(message = "El programa no puede estar vacío.")
    private String programa;
    @NotBlank(message = "El estado no puede estar vacío.")
    private String estado;
}
