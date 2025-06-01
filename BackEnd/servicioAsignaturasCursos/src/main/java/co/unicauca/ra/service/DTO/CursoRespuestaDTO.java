/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.service.DTO;

import co.unicauca.ra.model.AsignaturaCurso;
import co.unicauca.ra.model.Docente;
import co.unicauca.ra.model.Periodo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ashle
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursoRespuestaDTO {
    private String id; 
    private AsignaturaCurso asignatura; 
    private Docente docente;
    private Periodo periodo; 
}
