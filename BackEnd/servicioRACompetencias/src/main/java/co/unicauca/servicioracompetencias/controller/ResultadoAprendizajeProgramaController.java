package co.unicauca.servicioracompetencias.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.servicioracompetencias.model.ResultadoAprendizajePrograma;
import co.unicauca.servicioracompetencias.service.ResultadoAprendizajeProgramaService;

@RestController
@RequestMapping("/api/resultados-aprendizaje")
@CrossOrigin(origins = "*") // Permitir acceso desde el frontend Angular
public class ResultadoAprendizajeProgramaController {

    @Autowired
    private ResultadoAprendizajeProgramaService service;

    // Registrar un RAP
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody ResultadoAprendizajePrograma resultado) {
        if (resultado.getDescripcion() == null || resultado.getDescripcion().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La descripción del resultado de aprendizaje no puede estar vacía");
        }
        if (resultado.getCompetenciaId() == null || resultado.getCompetenciaId().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Debe especificarse el ID de la competencia asociada");
        }
        return ResponseEntity.ok(service.save(resultado));
    }

    // Listar todos los RAP
    @GetMapping
    public List<ResultadoAprendizajePrograma> listar() {
        return service.findAll();
    }

    // Buscar RAP por ID
    @GetMapping("/{id}")
    public Optional<ResultadoAprendizajePrograma> buscarPorId(@PathVariable String id) {
        return service.findById(id);
    }

    // Eliminar RAP por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        service.deleteById(id);
    }
}

