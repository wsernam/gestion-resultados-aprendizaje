package co.unicauca.servicioracompetencias.capaAccesoAdatos.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "resultado_aprendizaje_asignatura")
public class ResultadoAprendizajeAsignatura {
    @Id
    private String id;
    private String competenciaAsignaturaId;
    private String descripcion;
}
