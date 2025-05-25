/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.unicauca.ra.controller;


import co.unicauca.ra.model.AsignaturaCurso;
import co.unicauca.ra.model.ConsultaCurso;
import co.unicauca.ra.model.Curso;
import co.unicauca.ra.model.Periodo;
import co.unicauca.ra.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ashle
 */
@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    
    @Autowired 
    private CursoService cursoService;
    
    @PostMapping("/guardar")
    public ResponseEntity crearCurso(@RequestBody Curso curso){
        AsignaturaCurso a = curso.getAsignatura();
        a.setNombre(a.getNombre().toUpperCase());
        return cursoService.save(curso); 
    }
    @GetMapping("/buscar-curso")
    public ResponseEntity buscarCurso(@RequestBody ConsultaCurso consulta){
    
        return cursoService.findByPeriodoAndAsignaturaNombreAndDocenteCedula(
                consulta.getPeriodo(), 
                consulta.getNombreAsignatura(), 
                consulta.getDocenteCedula());
    }
    @GetMapping
    public List<Curso> buscarCursos(){
        return cursoService.findAll();
    }
    
    
    @GetMapping("/buscar-cursos/periodo")
    public List<Curso> buscarCursosPorPeriodos( 
            @RequestParam(required = true) int anio,  
            @RequestParam(required = false) Integer semestre)
    {
        if(semestre==null){
            return cursoService.findByYear(anio);
        }
        Periodo periodo = new Periodo(anio,semestre);
        return cursoService.findByPeriodo(periodo);
    }
    
    @GetMapping("/buscar-cursos/cedula/{cedula}")
    public List<Curso> buscarCursosPorDocente(@PathVariable int cedula){

        return cursoService.findByDocenteCedula(cedula);
    }
    
    @GetMapping("/buscar-cursos/asignatura/{asignatura}")
    public List<Curso> buscarCursosPorPeriodos(@PathVariable String asignatura){
        return cursoService.findByAsignaturaNombre(asignatura);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarCurso(@PathVariable String id){
        return cursoService.deteleById(id); 
    }
}
