/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.unicauca.ra.servicio_rubricas.controller;
import co.unicauca.ra.servicio_rubricas.service.RubricaService;
import co.unicauca.ra.servicio_rubricas.model.Rubrica;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author ashle
 */
@RestController
@RequestMapping("/api/rubricas")
public class RubricaController {
    
    @Autowired 
    private RubricaService rubricaService; 
    
    @PostMapping
    public ResponseEntity crearRubrica(@RequestBody Rubrica rubrica){
        return rubricaService.save(rubrica);
    }
    
    @GetMapping("/curso/{id_curso}")
    public List<Rubrica> encontrarRubricasIdCurso(@PathVariable String id_curso){
        return rubricaService.findByIdCurso(id_curso);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity actualizarRubrica(@PathVariable String id, @RequestBody Rubrica rubrica){
        return rubricaService.updateById(id, rubrica); 
    
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarRubrica(@PathVariable String id){
        return rubricaService.deleteById(id);
    
    }
    
}
