package co.unicauca.ra.servicio_rubricas.fachadaServices.DTO;

import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RubricaDTORespuesta {
    private String id;
    private String idCurso;
    private String descripcion;
    private float ponderado;
    private String idRaAsignatura;
    private List<CriterioDTORespuesta> criterios;
}
