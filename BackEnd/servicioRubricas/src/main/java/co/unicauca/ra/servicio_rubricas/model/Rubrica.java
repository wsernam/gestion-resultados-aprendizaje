/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package co.unicauca.ra.servicio_rubricas.model;

import java.util.List;
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
@Document(collection = "rubricas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rubrica {
    @Id
    private String id;
    private String idcurso; 
    private String descripcion;
    private float ponderado; 
    private String id_raAsignatura;
    private List<Criterio> criterios;
}
