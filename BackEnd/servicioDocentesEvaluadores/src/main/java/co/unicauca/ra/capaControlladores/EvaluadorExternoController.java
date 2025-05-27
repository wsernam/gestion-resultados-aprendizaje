package co.unicauca.ra.capaControlladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.ra.fachadaServices.DTO.EvaluadorExternoDTOPeticion;
import co.unicauca.ra.fachadaServices.DTO.EvaluadorExternoDTORespuesta;
import co.unicauca.ra.fachadaServices.services.IEvaluadorExternoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/evaluadores")
public class EvaluadorExternoController {

    @Autowired
    private IEvaluadorExternoService service;

    // Crear un evaluador externo con validaciones manuales
    @PostMapping("/guardar")
    public ResponseEntity<EvaluadorExternoDTORespuesta> guardar(
            @Valid @RequestBody EvaluadorExternoDTOPeticion dto) {
        EvaluadorExternoDTORespuesta creado = service.crear(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }
    // Actualizar evaluadores externos
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EvaluadorExternoDTORespuesta> actualizar(
            @PathVariable String id,
            @Valid @RequestBody EvaluadorExternoDTOPeticion dto) {
        EvaluadorExternoDTORespuesta actualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    // Listar todos los evaluadores externos
    @GetMapping("/listar")
    public List<EvaluadorExternoDTORespuesta> listarTodos() {
        return service.listarTodos();
    }

    // Buscar evaluador externo por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<EvaluadorExternoDTORespuesta> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Eliminar evaluador externo por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.ok("Evaluador externo eliminado correctamente.");
    }
}
