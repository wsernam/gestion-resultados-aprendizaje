package co.unicauca.ra.servicio_rubricas.capaAcesoAdatos.model;

import java.io.Serializable;
import lombok.*;

/**
 *
 * @author ashle
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Nivel implements Serializable{
    private String descripcion; 
    private int nota; 
}
