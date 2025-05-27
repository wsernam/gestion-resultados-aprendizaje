package co.unicauca.ra.fachadaServices.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocenteDTORespuesta {
    private String id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String tipo;
    private int cedula;
    private String titulo;
    private boolean coordinador;
}

