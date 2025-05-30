package co.unicauca.ra.servicio_rubricas.capaAcesoAdatos.model;

import java.util.List;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author ashle
 */
@Document(collection = "rubricas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rubrica {
    @Id
    private String id;

    private String idCurso; 
    private String descripcion;
    private float ponderado; 
    private String idRaAsignatura;
    private List<Criterio> criterios;
}
