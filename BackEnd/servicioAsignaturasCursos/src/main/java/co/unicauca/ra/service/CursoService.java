/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.service;

import co.unicauca.ra.controller.ExceptionController.Exceptions.AsignaturaNotFoundException;
import co.unicauca.ra.controller.ExceptionController.Exceptions.CursoAlreadyCreatedException;
import co.unicauca.ra.controller.ExceptionController.Exceptions.CursoNotFoundException;
import co.unicauca.ra.controller.ExceptionController.Exceptions.DocenteNotFoundException;
import co.unicauca.ra.model.Curso;
import co.unicauca.ra.model.Asignatura;
import co.unicauca.ra.model.AsignaturaCurso;
import co.unicauca.ra.model.Docente;
import co.unicauca.ra.model.Periodo;
import co.unicauca.ra.repository.AsignaturaRepository;
import co.unicauca.ra.repository.CursoRepository;
import co.unicauca.ra.service.DTO.CursoPeticionDTO;
import co.unicauca.ra.service.DTO.CursoRespuestaDTO;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
    
    @Autowired
    private AsignaturaRepository asignaturaRepository; 
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private DocenteService servicioDocente; 

    public CursoRespuestaDTO save(CursoPeticionDTO curso) {
        Optional<Asignatura> a = asignaturaRepository.findById(curso.getIdAsignatura());
        if(!a.isPresent()){
            throw new AsignaturaNotFoundException("Error al crear curso, no se encontro una asignatura con id " + curso.getIdAsignatura());
        }
        
        Docente d = servicioDocente.findDocenteByCorreo(curso.getCorreoDocente()); 
        
        if(d==null){
            throw new DocenteNotFoundException("Error al crear curso, no se encontro un docente con correo " + curso.getCorreoDocente());
        }
        Optional<Curso> c = cursoRepository.findByPeriodoAndAsignaturaNombreAndDocenteCedula(curso.getPeriodo(), a.get().getNombre(), d.getCedula());
        if (c.isPresent()) {
            throw new CursoAlreadyCreatedException("Error, un curso con el periodo, asignatura y docente ingresado ya ha sido registrado");
        }
        
        Curso nuevoCurso = new Curso(); 
        nuevoCurso.setDocente(d);
        nuevoCurso.setAsignatura(this.modelMapper.map(a.get(),new TypeToken<AsignaturaCurso>() {}.getType()));
        nuevoCurso.setPeriodo(curso.getPeriodo());
        cursoRepository.save(nuevoCurso);
        
        return this.modelMapper.map(nuevoCurso,new TypeToken<CursoRespuestaDTO>() {}.getType());
    }

    public CursoRespuestaDTO findByPeriodoAndAsignaturaNombreAndDocenteCedula(Periodo periodo, String asignatura, int cedulaDocente) {
        Optional<Curso> c = cursoRepository.findByPeriodoAndAsignaturaNombreAndDocenteCedula(periodo, asignatura, cedulaDocente);
        if (c.isPresent()) {
            return this.modelMapper.map(c.get(),new TypeToken<CursoRespuestaDTO>() {}.getType());
        }
        
        throw new CursoNotFoundException("No se encontró un curso que coincida con la informacion ingresada");        

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
        throw new CursoNotFoundException("No se encontró un curso con id = " + id);  
    }
    
    public ResponseEntity findById(String id){
        Optional<Curso> c = cursoRepository.findById(id);
        if(c.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(c);
        }
        throw new CursoNotFoundException("No se encontró un curso con id = " + id);  
    }
    
    public ResponseEntity CursoExist(String id){
        Optional<Curso> c = cursoRepository.findById(id);
        if(c.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
        throw new CursoNotFoundException("No se encontró un curso con id = " + id);  
    }
    
    public List<Curso> findByYear(int year){
    return cursoRepository.findByPeriodoAnio(year);
    }
}
