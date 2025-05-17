package co.unicauca.servicioracompetencias.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.servicioracompetencias.model.CompetenciaPrograma;
import co.unicauca.servicioracompetencias.service.CompetenciaProgramaService;

@RestController
@RequestMapping("/api/competenciasPrograma")
@CrossOrigin(origins = "*")
public class CompetenciaProgramaController {

    @Autowired
    private CompetenciaProgramaService service;

    // Crear nueva competencia
    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody CompetenciaPrograma competencia) {
        if (competencia.getDescripcion() == null || competencia.getDescripcion().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La descripción no puede estar vacía");
        }
        if (competencia.getNivel() == null || competencia.getNivel().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nivel es obligatorio");
        }
        return ResponseEntity.ok(service.save(competencia));
    }

    // Listar todas las competencias
    @GetMapping("/listar")
    public List<CompetenciaPrograma> listar() {
        return service.listarTodos();
    }

    // Buscar competencia por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<CompetenciaPrograma> buscarPorId(@PathVariable String id) {
        Optional<CompetenciaPrograma> competencia = service.buscarPorId(id);
        return competencia.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar competencia por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
