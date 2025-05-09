package co.unicauca.servicioracompetencias.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.servicioracompetencias.model.CompetenciaPrograma;
import co.unicauca.servicioracompetencias.service.CompetenciaProgramaService;

@RestController
@RequestMapping("/api/competencias")
@CrossOrigin(origins = "*") // Permitir conexión desde Angular u otro frontend
public class CompetenciaProgramaController {

    @Autowired
    private CompetenciaProgramaService service;

    // Crear una nueva competencia
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody CompetenciaPrograma competencia) {
        if (competencia.getDescripcion() == null || competencia.getDescripcion().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La descripción no puede estar vacía");
        }
        if (competencia.getNivel() == null || competencia.getNivel().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nivel es obligatorio");
        }
        return ResponseEntity.ok(service.save(competencia));
    }

    // Listar todas las competencias
    @GetMapping
    public List<CompetenciaPrograma> listar() {
        return service.findAll();
    }

    // Buscar competencia por ID
    @GetMapping("/{id}")
    public Optional<CompetenciaPrograma> buscarPorId(@PathVariable String id) {
        return service.findById(id);
    }

    // Eliminar competencia por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.deleteById(id);
    }
}