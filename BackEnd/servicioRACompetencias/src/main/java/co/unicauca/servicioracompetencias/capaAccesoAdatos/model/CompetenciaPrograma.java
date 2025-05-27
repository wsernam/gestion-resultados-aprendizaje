package co.unicauca.servicioracompetencias.capaAccesoAdatos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "competencias_programa")
public class CompetenciaPrograma {
    @Id
    private String id;
    private String descripcion;
    private String programa;
    private String estado; // activo inactivo
}
