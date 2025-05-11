package co.unicauca.ra.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Docente implements Serializable{

    private String nombres;
    private String apellidos;
    private String correo;
    private String tipo; // Ej: Cátedra, Tiempo completo, etc.
    private int cedula; 
    private boolean coordinador; 

    
}
