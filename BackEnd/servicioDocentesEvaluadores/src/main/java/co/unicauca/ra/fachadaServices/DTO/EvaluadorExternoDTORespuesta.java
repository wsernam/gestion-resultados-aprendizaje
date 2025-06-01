package co.unicauca.ra.fachadaServices.DTO;

import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluadorExternoDTORespuesta {
    private String id;
    private String nombres;
    private String apellidos;
    private String correo;
    private List<String> idCursos; 
}

