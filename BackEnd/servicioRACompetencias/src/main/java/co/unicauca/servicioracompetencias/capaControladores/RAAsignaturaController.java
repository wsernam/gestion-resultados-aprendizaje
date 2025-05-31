package co.unicauca.servicioracompetencias.capaControladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeAsignaturaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeAsignaturaDTORespuesta;
import co.unicauca.servicioracompetencias.fachadaServices.services.IRAAsignaturaService;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/RAAsignatura")
public class RAAsignaturaController {
    
    @Autowired
    private IRAAsignaturaService service;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@Valid @RequestBody ResultadoAprendizajeAsignaturaDTOPeticion dto) {
        ResultadoAprendizajeAsignaturaDTORespuesta creado = service.crear(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED); // 201
    }

    @GetMapping("/listar")
    public List<ResultadoAprendizajeAsignaturaDTORespuesta> listar() {
        return service.listarTodos();
    }

    @GetMapping("/buscar/asignatura/{asignaturaId}")
    public List<ResultadoAprendizajeAsignaturaDTORespuesta> listarPorAsignatura(@PathVariable String asignaturaId) {
        return service.listarPorAsignatura(asignaturaId);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResultadoAprendizajeAsignaturaDTORespuesta> buscarPorId(@PathVariable String id) {
        ResultadoAprendizajeAsignaturaDTORespuesta ResultadoAprendizajeAsignatura = service.buscarPorId(id);
        return (ResultadoAprendizajeAsignatura != null) ? ResponseEntity.ok(ResultadoAprendizajeAsignatura) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable String id, @Valid @RequestBody ResultadoAprendizajeAsignaturaDTOPeticion dto) {
        ResultadoAprendizajeAsignaturaDTORespuesta actualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }

}
