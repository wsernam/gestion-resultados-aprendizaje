package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaProgramaDTORespuesta {
    private String id;
    private String descripcion;
    private String programa;
    private String estado;
}