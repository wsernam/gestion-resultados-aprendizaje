/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ashle
 */
@Getter
@Setter
@AllArgsConstructor
public class Credenciales {
    
    private String tipo; 
    
    private String nombreUsuario;
    
    private String contrasenia; 
    
    public Credenciales() {
    }
    
}
