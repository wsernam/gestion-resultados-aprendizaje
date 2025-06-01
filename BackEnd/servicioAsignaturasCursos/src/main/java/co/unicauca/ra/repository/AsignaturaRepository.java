/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package co.unicauca.ra.repository;

import co.unicauca.ra.model.Asignatura;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author ashle
 */
public interface AsignaturaRepository extends MongoRepository<Asignatura, String>{
    public Optional<Asignatura> findByNombre(String nombre); 
}
