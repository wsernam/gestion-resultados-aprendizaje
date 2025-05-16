package co.edu.co.servicio_ra_asignatura.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.co.servicio_ra_asignatura.model.CompetenciaAsignatura;
import co.edu.co.servicio_ra_asignatura.service.CompetenciaAsignaturaService;

import java.util.List;

@RestController
@RequestMapping("/api/competencia-asignatura")
public class CompetenciaAsignaturaController {

    private final CompetenciaAsignaturaService service;

    public CompetenciaAsignaturaController(CompetenciaAsignaturaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CompetenciaAsignatura> crear(@RequestBody CompetenciaAsignatura comp) {
        return ResponseEntity.ok(service.crear(comp));
    }

    @GetMapping
    public List<CompetenciaAsignatura> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/asignatura/{asignaturaId}")
    public List<CompetenciaAsignatura> listarPorAsignatura(@PathVariable String asignaturaId) {
        return service.listarPorAsignatura(asignaturaId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}