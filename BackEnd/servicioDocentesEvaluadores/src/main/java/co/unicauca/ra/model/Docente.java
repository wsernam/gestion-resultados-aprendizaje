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
    private String tipo; // Ej: Cátedra, Tiempo completo, etc.
    private int cedula; 
    private String titulo;
    private String contrasenia;
    private boolean coordinador; 

    public boolean isCoordinador() {
        return coordinador;
    }

    public void setCoordinador(boolean coordinador) {
        this.coordinador = coordinador;
    }
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


    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cc) {
        this.cedula = cc;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Docente{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo + ", tipo=" + tipo + ", cedula=" + cedula + '}';
    }
    
    
    
}
