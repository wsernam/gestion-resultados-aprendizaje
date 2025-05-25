package co.unicauca.servicioracompetencias.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.servicioracompetencias.model.ResultadoAprendizajePrograma;
import co.unicauca.servicioracompetencias.service.CompetenciaProgramaService;
import co.unicauca.servicioracompetencias.service.ResultadoAprendizajeProgramaService;

@RestController
@RequestMapping("/api/RAPrograma")
public class ResultadoAprendizajeProgramaController {

    @Autowired
    private ResultadoAprendizajeProgramaService RAPservice;
    @Autowired
    private CompetenciaProgramaService competenciaService;


    // Guardar un nuevo resultado de aprendizaje del programa
    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ResultadoAprendizajePrograma resultado) {
        if (resultado.getDescripcion() == null || resultado.getDescripcion().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La descripción del resultado de aprendizaje no puede estar vacía");
        }
        if (resultado.getCompetenciaId() == null || resultado.getCompetenciaId().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Debe especificarse el ID de la competencia asociada");
        }
        if (!competenciaService.buscarPorId(resultado.getCompetenciaId()).isPresent()) {
            return ResponseEntity.badRequest().body("La competencia con ID '" + resultado.getCompetenciaId() + "' no existe.");
        }
        return ResponseEntity.ok(RAPservice.save(resultado));
    }

    // Listar todos los resultados de aprendizaje del programa
    @GetMapping("/listar")
    public List<ResultadoAprendizajePrograma> listar() {
        return RAPservice.findAll();
    }

    // Buscar resultado de aprendizaje del programa por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResultadoAprendizajePrograma> buscarPorId(@PathVariable String id) {
        Optional<ResultadoAprendizajePrograma> resultado = RAPservice.findById(id);
        return resultado.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar resultado por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        RAPservice.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}