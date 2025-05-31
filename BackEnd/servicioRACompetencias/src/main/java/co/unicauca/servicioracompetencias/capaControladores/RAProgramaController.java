package co.unicauca.servicioracompetencias.capaControladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.RAProgramaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.RAProgramaDTORespuesta;
import co.unicauca.servicioracompetencias.fachadaServices.services.IRAProgramaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/RAPrograma")
public class RAProgramaController {
    
    @Autowired
    private IRAProgramaService service;

    // Guardar un nuevo resultado de aprendizaje del programa
    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@Valid @RequestBody RAProgramaDTOPeticion dto) {
        RAProgramaDTORespuesta creado = service.crear(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED); // 201
    }

    // Listar todos los resultados de aprendizaje del programa
    @GetMapping("/listar")
    public List<RAProgramaDTORespuesta> listar() {
        return service.listarTodos();
    }

    // Buscar resultado de aprendizaje del programa por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<RAProgramaDTORespuesta> buscarPorId(@PathVariable String id) {
        RAProgramaDTORespuesta resultadoAprendizajePrograma = service.buscarPorId(id);
        return (resultadoAprendizajePrograma != null) ? ResponseEntity.ok(resultadoAprendizajePrograma) : ResponseEntity.notFound().build();
    }

    // Eliminar resultado por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable String id, @Valid @RequestBody RAProgramaDTOPeticion dto) {
        RAProgramaDTORespuesta actualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }
}