package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaProgramaDTORespuesta {
    private String id;
    private String nombre;
    private String descripcion;
    private String programa;
    private String estado;
}