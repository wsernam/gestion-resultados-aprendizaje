package co.unicauca.servicioracompetencias.capaControladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeProgramaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeProgramaDTORespuesta;
import co.unicauca.servicioracompetencias.fachadaServices.services.IResultadoAprendizajeProgramaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/RAPrograma")
public class ResultadoAprendizajeProgramaController {
    
    @Autowired
    private IResultadoAprendizajeProgramaService service;

    // Guardar un nuevo resultado de aprendizaje del programa
    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@Valid @RequestBody ResultadoAprendizajeProgramaDTOPeticion dto) {
        ResultadoAprendizajeProgramaDTORespuesta creado = service.crear(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED); // 201
    }

    // Listar todos los resultados de aprendizaje del programa
    @GetMapping("/listar")
    public List<ResultadoAprendizajeProgramaDTORespuesta> listar() {
        return service.listarTodos();
    }

    // Buscar resultado de aprendizaje del programa por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResultadoAprendizajeProgramaDTORespuesta> buscarPorId(@PathVariable String id) {
        ResultadoAprendizajeProgramaDTORespuesta resultadoAprendizajePrograma = service.buscarPorId(id);
        return (resultadoAprendizajePrograma != null) ? ResponseEntity.ok(resultadoAprendizajePrograma) : ResponseEntity.notFound().build();
    }

    // Eliminar resultado por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable String id, @Valid @RequestBody ResultadoAprendizajeProgramaDTOPeticion dto) {
        ResultadoAprendizajeProgramaDTORespuesta actualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}