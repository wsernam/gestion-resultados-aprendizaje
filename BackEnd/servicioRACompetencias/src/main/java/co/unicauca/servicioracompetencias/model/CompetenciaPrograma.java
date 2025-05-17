package co.unicauca.servicioracompetencias.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "competencias")
public class CompetenciaPrograma {
    @Id
    private String id;
    private String programa;
    private String descripcion;
    private String nivel; // Básico, Intermedio, Avanzado
}
