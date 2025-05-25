/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.model;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author ashle
 */
import lombok.Getter;
import lombok.Setter;


@Document(collection = "evaluadores") 
@Getter
@Setter
@AllArgsConstructor
public class EvaluadorExterno {
    @Id
    private String id;

    private String nombres;
    private String apellidos;
    private String correo;
    private String contrasenia;
}
