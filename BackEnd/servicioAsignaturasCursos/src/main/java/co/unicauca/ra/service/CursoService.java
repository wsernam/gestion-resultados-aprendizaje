/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.service;

import co.unicauca.ra.model.Curso;
import co.unicauca.ra.model.Periodo;
import co.unicauca.ra.repository.CursoRepository;
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
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public ResponseEntity save(Curso curso) {
        Optional<Curso> c = cursoRepository.findByPeriodoAndAsignaturaNombreAndDocenteCedula(curso.getPeriodo(), curso.getAsignatura().getNombre(), curso.getDocente().getCedula());
        if (c.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El curso ya esta registrado");
        }
        cursoRepository.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body("El curso fue registrado");
    }

    public ResponseEntity findByPeriodoAndAsignaturaNombreAndDocenteCedula(Periodo periodo, String asignatura, int cedulaDocente) {
        Optional<Curso> c = cursoRepository.findByPeriodoAndAsignaturaNombreAndDocenteCedula(periodo, asignatura, cedulaDocente);
        if (c.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(c);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el curso");         

    }
    
    public List<Curso> findByPeriodo(Periodo periodo){
        return cursoRepository.findByPeriodo(periodo);
    }
    public List<Curso> findByAsignaturaNombre(String nombre){
        return cursoRepository.findByAsignaturaNombre(nombre); 
    }
    public List<Curso> findByDocenteCedula(int cedula){
        return cursoRepository.findByDocenteCedula(cedula);
    }
    
    public List<Curso> findAll(){
    return cursoRepository.findAll();
    }
    
    public ResponseEntity deteleById(String id){
        Optional<Curso> c = cursoRepository.findById(id);
        if(c.isPresent()){
            cursoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body("El curso fue eliminado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El curso no fue eliminado");
    }
    
    public List<Curso> findByYear(int year){
    return cursoRepository.findByPeriodoAnio(year);
    }
}
