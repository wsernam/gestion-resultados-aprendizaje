package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoAprendizajeProgramaDTORespuesta {
    private String id;
    private String competenciaProgramaId;
    private String nombre;
    private String descripcion;
    private String programa;
}