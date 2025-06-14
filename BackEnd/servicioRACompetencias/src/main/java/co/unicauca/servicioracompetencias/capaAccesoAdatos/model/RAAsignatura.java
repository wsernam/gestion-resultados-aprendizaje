package co.unicauca.servicioracompetencias.capaAccesoAdatos.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "resultado_aprendizaje_asignatura")
public class RAAsignatura {
    @Id
    private String id;
    private CompetenciaAsignatura competenciaAsignatura; 
    private String nombre;
    private String descripcion;
}
