package co.unicauca.servicioracompetencias.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.servicioracompetencias.model.CompetenciaAsignatura;
import co.unicauca.servicioracompetencias.service.CompetenciaAsignaturaService;
import java.util.List;

@RestController
@RequestMapping("/api/competenciasAsignatura")
@CrossOrigin(origins = "*")
public class CompetenciaAsignaturaController {

    private final CompetenciaAsignaturaService service;

    public CompetenciaAsignaturaController(CompetenciaAsignaturaService service) {
        this.service = service;
    }

    @PostMapping("/guardar")
    public ResponseEntity<CompetenciaAsignatura> guardar(@RequestBody CompetenciaAsignatura comp) {
        return ResponseEntity.ok(service.crear(comp));
    }

    @GetMapping("/listar")
    public List<CompetenciaAsignatura> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<CompetenciaAsignatura> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id)
                     .map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/asignatura/{asignaturaId}")
    public List<CompetenciaAsignatura> listarPorAsignatura(@PathVariable String asignaturaId) {
        return service.listarPorAsignatura(asignaturaId);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
