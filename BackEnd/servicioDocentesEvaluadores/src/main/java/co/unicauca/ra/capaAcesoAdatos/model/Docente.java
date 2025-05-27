package co.unicauca.ra.capaAcesoAdatos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "docentes") // Nombre de la colección en MongoDB
public class Docente {

    @Id
    private String id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String tipo; // Ej: Cátedra, Tiempo completo, etc.
    private int cedula; 
    private String titulo;
    private String contrasenia;
    private boolean coordinador; 

   

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

    @Override
    public String toString() {
        return "Docente{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + ", tipo=" + tipo + ", cedula=" + cedula + '}';
    }
    
    
    
}
