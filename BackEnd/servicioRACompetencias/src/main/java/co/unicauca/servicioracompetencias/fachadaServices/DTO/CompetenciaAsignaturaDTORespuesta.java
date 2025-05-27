package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetenciaAsignaturaDTORespuesta {
    private String id;
    private String competenciaProgramaId;
    private String asignaturaId;
    private String descripcion;
    private String estado;
}
