/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ashle
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor 
public class ConsultaCurso implements Serializable{
    
    private String nombreAsignatura;
    private Periodo periodo;
    private int docenteCedula; 
}
