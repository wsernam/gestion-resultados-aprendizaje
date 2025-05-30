package co.unicauca.ra.servicio_rubricas.fachadaServices.DTO;

import java.util.List;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RubricaDTOPeticion {
    @NotBlank(message = "El id del curso no puede estar vacío.")
    private String idCurso;
    @NotBlank(message = "La descripción no puede estar vacía.")
    private String descripcion;
    @DecimalMin(value = "0.0", inclusive = false, message = "El ponderado debe ser mayor que cero.")
    private float ponderado;
    @NotBlank(message = "El id del resultado de aprendizaje no puede estar vacío.")
    private String idRaAsignatura;
    @NotEmpty(message = "Debe incluir al menos un criterio.")
    private List<CriterioDTOPeticion> criterios;
}
