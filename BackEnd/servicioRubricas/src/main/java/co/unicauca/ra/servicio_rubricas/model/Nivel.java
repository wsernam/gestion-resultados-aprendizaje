/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.servicio_rubricas.model;

import java.io.Serializable;
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
public class Nivel implements Serializable{
    private String descripcion; 
    private int nota; 
}
