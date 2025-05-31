package co.unicauca.servicioracompetencias.capaAccesoAdatos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "resultados_aprendizaje_programa")
public class ResultadoAprendizajePrograma {

    @Id
    private String id;
    private String competenciaProgramaId; // ID de la competencia asociada
    private String nombre;
    private String descripcion;
    private String programa;
}