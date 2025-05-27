package co.unicauca.ra.fachadaServices.DTO;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluadorExternoDTOPeticion {

    @NotBlank(message = "Los nombres no pueden estar vacíos.")
    private String nombres;

    @NotBlank(message = "Los apellidos no pueden estar vacíos.")
    private String apellidos;

    @Email(message = "El correo debe ser válido.")
    @NotBlank(message = "El correo no puede estar vacío.")
    private String correo;

    @NotBlank(message = "La contraseña no puede estar vacía.")
    private String contrasenia;
}

