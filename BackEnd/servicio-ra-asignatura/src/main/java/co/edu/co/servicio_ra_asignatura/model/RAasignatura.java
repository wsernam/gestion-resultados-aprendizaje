package co.edu.co.servicio_ra_asignatura.model;

import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "resultado_aprendizaje_asignatura")
public class RAasignatura {
    @Id
    private String id;
    private String descripcion;
    private String asignaturaId;
    private String competenciaAsignaturaId;
    private String periodo;
}
