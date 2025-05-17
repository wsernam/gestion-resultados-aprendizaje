package co.unicauca.servicioracompetencias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.servicioracompetencias.model.ResultadoAprendizajeAsignatura;
import co.unicauca.servicioracompetencias.service.CompetenciaAsignaturaService;
import co.unicauca.servicioracompetencias.service.ResultadoAprendizajeAsignaturaService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/RAAsignatura")
@CrossOrigin(origins = "*")
public class ResultadoAprendizajeAsignaturaController {
    @Autowired
    private CompetenciaAsignaturaService competenciaAsignaturaService;
    private final ResultadoAprendizajeAsignaturaService service;
    public ResultadoAprendizajeAsignaturaController(ResultadoAprendizajeAsignaturaService service) {
        this.service = service;
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ResultadoAprendizajeAsignatura ra) {
        if (ra.getDescripcion() == null || ra.getDescripcion().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La descripción no puede estar vacía");
        }

        if (ra.getId() == null || ra.getCompetenciaAsignaturaId().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Debe especificarse el ID de la competencia asignatura");
        }
        if (!competenciaAsignaturaService.buscarPorId(ra.getCompetenciaAsignaturaId()).isPresent()) {
            return ResponseEntity.badRequest().body("La competencia asignatura con ID '" + ra.getCompetenciaAsignaturaId() + "' no existe.");
        }
        return ResponseEntity.ok(service.crear(ra));
    }

    @GetMapping("/listar")
    public List<ResultadoAprendizajeAsignatura> listarTodos() {
        return service.findAll();
    }

    @GetMapping("/buscar/asignatura/{asignaturaId}")
    public List<ResultadoAprendizajeAsignatura> listarPorAsignatura(@PathVariable String asignaturaId) {
        return service.listarPorAsignatura(asignaturaId);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResultadoAprendizajeAsignatura> buscarPorId(@PathVariable String id) {
        Optional<ResultadoAprendizajeAsignatura> ra = service.findById(id);
        return ra.map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
