package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoAprendizajeProgramaDTOPeticion {
    @NotBlank(message = "competenciaProgramaId no puede estar vacío.")
    private String competenciaProgramaId;
    @NotBlank(message = "el nombre de resultado aprendisaje programa no puede estar vacío.")
    private String nombre;
    private String descripcion;
    @NotBlank(message = "programa no puede estar vacío.")
    private String programa;
}
