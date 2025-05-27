package co.unicauca.servicioracompetencias.capaAccesoAdatos.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "competencia_asignatura")
public class CompetenciaAsignatura {
    @Id
    private String id;
    private String competenciaProgramaId;
    private String asignaturaId;
    private String descripcion;
    private String estado; // activo
}
