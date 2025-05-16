package co.edu.co.servicio_ra_asignatura.model;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "competencia_asignatura")
public class CompetenciaAsignatura {
    @Id
    private String id;
    private String descripcion;
    private String asignaturaId;
    private String nivel; // básico, intermedio, avanzado
    private String competenciaProgramaId;
}
