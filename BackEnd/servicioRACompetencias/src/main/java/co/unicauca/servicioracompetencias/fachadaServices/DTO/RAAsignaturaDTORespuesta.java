package co.unicauca.servicioracompetencias.fachadaServices.DTO;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.CompetenciaAsignatura;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RAAsignaturaDTORespuesta {
    private String id;
    private CompetenciaAsignatura competenciaAsignatura;
    private String nombre;
    private String descripcion;
}