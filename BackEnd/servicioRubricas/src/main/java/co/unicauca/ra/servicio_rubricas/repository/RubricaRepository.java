/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package co.unicauca.ra.servicio_rubricas.repository;

import co.unicauca.ra.servicio_rubricas.model.Rubrica;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author ashle
 */
public interface RubricaRepository extends MongoRepository<Rubrica, String>{

    public List<Rubrica> findByIdCurso(String id_curso); 
}
