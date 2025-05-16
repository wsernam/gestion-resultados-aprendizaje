package co.edu.co.servicio_ra_asignatura.controller;

import co.edu.co.servicio_ra_asignatura.model.RAasignatura;
import co.edu.co.servicio_ra_asignatura.service.RAasignaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ra-asignatura")
public class RAasignaturaController {

    private final RAasignaturaService service;

    public RAasignaturaController(RAasignaturaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RAasignatura> crear(@RequestBody RAasignatura ra) {
        return ResponseEntity.ok(service.crear(ra));
    }

    @GetMapping
    public List<RAasignatura> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/asignatura/{asignaturaId}")
    public List<RAasignatura> listarPorAsignatura(@PathVariable String asignaturaId) {
        return service.listarPorAsignatura(asignaturaId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}