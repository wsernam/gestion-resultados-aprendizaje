/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package co.unicauca.ra.controller;

import co.unicauca.ra.model.AsignaturaCurso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/asignaturaCurso")
public class AsignaturaController {

    @Autowired
    private AsignaturaController asignaturaCursoService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody AsignaturaCurso asignaturaCurso) {
        return asignaturaCursoService.save(asignaturaCurso);
    }

    @GetMapping
    public List<AsignaturaCurso> findAll() {
        return asignaturaCursoService.findAll();
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> findByNombre(@PathVariable String nombre) {
        return asignaturaCursoService.findByNombre(nombre);
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<?> deleteByNombre(@PathVariable String nombre) {
        return asignaturaCursoService.deleteByNombre(nombre);
    }
}
