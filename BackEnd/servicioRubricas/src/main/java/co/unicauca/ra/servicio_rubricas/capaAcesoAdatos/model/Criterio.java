package co.unicauca.ra.servicio_rubricas.capaAcesoAdatos.model;

import java.io.Serializable;
import java.util.List;
import lombok.*;
/**
 *
 * @author ashle
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Criterio implements Serializable{
    private String descripcion; 
    private List<Nivel> niveles; 
}
