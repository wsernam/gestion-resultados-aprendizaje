package co.unicauca.ra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "docentes") // Nombre de la colección en MongoDB
public class Docente {

    @Id
    private String id;

    private String nombres;
    private String apellidos;
    @Indexed
    private String correo;
    private String tipo; // Ej: Cátedra, Tiempo completo, etc.
    @Indexed
    private int cedula; 
    private String titulo;
    private String contrasenia;
    private boolean coordinador; 

  
    // Constructor vacío
    public Docente() {}

    // Constructor con todos los campos (excepto id)

    public Docente(String nombres, String apellidos, String correo, String tipo, int cc, String titulo, String contrasenia, boolean coordinador) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.tipo = tipo;
        this.cedula = cc;
        this.titulo = titulo;
        this.contrasenia = contrasenia;
        this.coordinador = coordinador;
    }
    

    
}
