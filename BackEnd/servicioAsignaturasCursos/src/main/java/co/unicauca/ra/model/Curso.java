/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.unicauca.ra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
*
 * @author ashle
 */
@Document(collection = "cursos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    private String id; 
    private AsignaturaCurso asignatura; 
    private Docente docente;
    private Periodo periodo; 
}
