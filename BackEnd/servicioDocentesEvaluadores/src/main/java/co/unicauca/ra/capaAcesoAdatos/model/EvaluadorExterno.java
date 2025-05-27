package co.unicauca.ra.capaAcesoAdatos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "evaluadores")
public class EvaluadorExterno {

    @Id
    private String id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String contrasenia;
}
