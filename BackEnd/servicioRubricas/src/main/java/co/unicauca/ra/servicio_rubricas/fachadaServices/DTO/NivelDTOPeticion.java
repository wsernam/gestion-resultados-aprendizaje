package co.unicauca.ra.servicio_rubricas.fachadaServices.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NivelDTOPeticion {
    @NotBlank(message = "La descripción del nivel no puede estar vacía.")
    private String descripcion;

    @Min(value = 0, message = "La nota debe ser mayor o igual a 0.")
    private int nota;
}