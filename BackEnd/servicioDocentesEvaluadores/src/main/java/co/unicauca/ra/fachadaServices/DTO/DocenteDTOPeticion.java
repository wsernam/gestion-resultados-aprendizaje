package co.unicauca.ra.fachadaServices.DTO;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocenteDTOPeticion {

    @NotBlank(message = "Los nombres no pueden estar vacíos.")
    private String nombres;

    @NotBlank(message = "Los apellidos no pueden estar vacíos.")
    private String apellidos;

    @Email(message = "El correo debe ser válido.")
    @NotBlank(message = "El correo no puede estar vacío.")
    private String correo;

    @NotBlank(message = "El tipo de docente no puede estar vacío.")
    private String tipo; // Ej: Cátedra, Tiempo completo, etc.

    @Positive(message = "La cédula debe ser un número positivo.")
    private int cedula;

    @NotBlank(message = "El título no puede estar vacío.")
    private String titulo;

    @NotBlank(message = "La contraseña no puede estar vacía.")
    private String contrasenia;

    private boolean coordinador;
}