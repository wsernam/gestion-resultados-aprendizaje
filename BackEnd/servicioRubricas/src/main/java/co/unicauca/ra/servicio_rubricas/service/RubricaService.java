/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.unicauca.ra.servicio_rubricas.service;

import co.unicauca.ra.servicio_rubricas.repository.RubricaRepository;
import co.unicauca.ra.servicio_rubricas.model.Rubrica;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author ashle
 */
@Service
public class RubricaService {
    
    @Autowired
    private RubricaRepository rubricaRepository; 
    
    public ResponseEntity save(Rubrica rubrica){
        rubricaRepository.save(rubrica); 
        return ResponseEntity.status(HttpStatus.CREATED).body(rubrica); 
    }
    
    public ResponseEntity findById(String id){
        Optional<Rubrica> rubrica = rubricaRepository.findById(id);
        if(!rubrica.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la rubrica con id" + id);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(rubrica.get());
    }
    
    public ResponseEntity deleteById(String id){
        Optional<Rubrica> rubrica = rubricaRepository.findById(id);
        if(!rubrica.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la rubrica con id" + id);
        }
        rubricaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("La rubrica fue eliminada");
    }
    
    public List<Rubrica> findByIdCurso (String id_curso){
        List<Rubrica> rubricas_curso = rubricaRepository.findByIdcurso(id_curso);
        return rubricas_curso;
    }
    
    public ResponseEntity updateById(String id, Rubrica nueva_rubrica){
        Optional<Rubrica> rubrica_antigua = rubricaRepository.findById(id);
        if(!rubrica_antigua.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro la rubrica con id" + id);
        }
        Rubrica rubrica = rubrica_antigua.get();
        rubrica.setId(nueva_rubrica.getDescripcion());
        rubrica.setIdcurso(nueva_rubrica.getIdcurso());
        rubrica.setId_raAsignatura(nueva_rubrica.getId_raAsignatura());
        rubrica.setCriterios(nueva_rubrica.getCriterios());
        rubricaRepository.save(rubrica);
        return ResponseEntity.status(HttpStatus.OK).body(rubrica);
    }
}
