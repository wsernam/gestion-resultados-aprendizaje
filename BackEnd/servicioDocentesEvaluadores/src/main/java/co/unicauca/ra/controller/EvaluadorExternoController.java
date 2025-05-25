package co.unicauca.ra.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.ra.model.EvaluadorExterno;
import co.unicauca.ra.service.EvaluadorExternoService;

@RestController
@RequestMapping("/api/evaluadores")
public class EvaluadorExternoController {

    @Autowired
    private EvaluadorExternoService service;

    // Crear un evaluador externo con validaciones manuales
    @PostMapping("/guardar")
    public ResponseEntity<?> crear(@RequestBody EvaluadorExterno evaluador) {
        if (evaluador.getNombres() == null || evaluador.getNombres().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo 'nombres' es obligatorio");
        }
        if (evaluador.getApellidos() == null || evaluador.getApellidos().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo 'apellidos' es obligatorio");
        }
        if (evaluador.getCorreo() == null || evaluador.getCorreo().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El correo institucional es obligatorio");
        }
        if (evaluador.getContrasenia() == null || evaluador.getContrasenia().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La contraseña es obligatoria");
        }
        return ResponseEntity.ok(service.save(evaluador)+"Evaluador registrado correctamente");
    }

    // Listar todos los evaluadores externos
    @GetMapping("/listar")
    public List<EvaluadorExterno> listar() {
        return service.findAll();
    }

    // Buscar evaluador externo por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable String id) {
        Optional<EvaluadorExterno> evaluador = service.findById(id);
        return evaluador.isPresent() ? ResponseEntity.ok(evaluador.get())
                                     : ResponseEntity.notFound().build();
    }

    // Eliminar evaluador externo por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable String id) {
        Optional<EvaluadorExterno> evaluador = service.findById(id);
        if (evaluador.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok("Evaluador eliminado correctamente");
        } else {
            return ResponseEntity.status(404).body("Evaluador no encontrado");
        }
    }
}
