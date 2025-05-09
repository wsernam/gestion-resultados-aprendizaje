package co.unicauca.servicioracompetencias.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "resultados_aprendizaje")
public class ResultadoAprendizajePrograma {

    @Id
    private String id;
    private String descripcion;
    private String competenciaId; // ID de la competencia asociada

}