package co.unicauca.servicioracompetencias.capaControladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaProgramaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaProgramaDTORespuesta;
import co.unicauca.servicioracompetencias.fachadaServices.services.ICompetenciaProgramaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/competenciasPrograma")
public class CompetenciaProgramaController {

    @Autowired
    private ICompetenciaProgramaService service;

    // Crear nueva competencia
    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@Valid @RequestBody CompetenciaProgramaDTOPeticion dto) {
        CompetenciaProgramaDTORespuesta creado = service.crear(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED); // 201
    }

    // Listar todas las competencias
    @GetMapping("/listar")
    public List<CompetenciaProgramaDTORespuesta> listar() {
        return service.listarTodos();
    }

    // Buscar competencia por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<CompetenciaProgramaDTORespuesta> buscarPorId(@PathVariable String id) {
        CompetenciaProgramaDTORespuesta competenciaPrograma = service.buscarPorId(id);
        return (competenciaPrograma != null) ? ResponseEntity.ok(competenciaPrograma) : ResponseEntity.notFound().build();
    }

    // Eliminar competencia por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CompetenciaProgramaDTORespuesta> actualizar(@PathVariable String id,@Valid @RequestBody CompetenciaProgramaDTOPeticion dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }
}
