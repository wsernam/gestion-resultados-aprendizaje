package co.unicauca.ra.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "docentes") // Nombre de la colección en MongoDB
public class Docente {

    @Id
    private String id;

    private String nombres;
    private String apellidos;
    private String correo;
    private String tipoDocente; // Ej: Cátedra, Tiempo completo, etc.

    // Constructor vacío
    public Docente() {}

    // Constructor con todos los campos (excepto id)
    public Docente(String nombres, String apellidos, String correo, String tipoDocente) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.tipoDocente = tipoDocente;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoDocente() {
        return tipoDocente;
    }

    public void setTipoDocente(String tipoDocente) {
        this.tipoDocente = tipoDocente;
    }
}
