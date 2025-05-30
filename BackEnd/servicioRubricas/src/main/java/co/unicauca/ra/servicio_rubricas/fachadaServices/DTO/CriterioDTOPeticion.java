package co.unicauca.ra.servicio_rubricas.fachadaServices.DTO;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriterioDTOPeticion {
    @NotBlank(message = "La descripción del criterio no puede estar vacía.")
    private String descripcion;

    @NotEmpty(message = "El criterio debe tener al menos un nivel.")
    private List<NivelDTOPeticion> niveles;
}