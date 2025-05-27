package co.unicauca.servicioracompetencias.capaControladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaAsignaturaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaAsignaturaDTORespuesta;
import co.unicauca.servicioracompetencias.fachadaServices.services.ICompetenciaAsignaturaService;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/competenciasAsignatura")
public class CompetenciaAsignaturaController {
    @Autowired
    private ICompetenciaAsignaturaService service;
    

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@Valid @RequestBody CompetenciaAsignaturaDTOPeticion dto) {
        CompetenciaAsignaturaDTORespuesta creado = service.crear(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED); // 201
    }

    @GetMapping("/listar")
    public List<CompetenciaAsignaturaDTORespuesta> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<CompetenciaAsignaturaDTORespuesta> buscarPorId(@PathVariable String id) {
        CompetenciaAsignaturaDTORespuesta competenciaAsignatura = service.buscarPorId(id);
        return (competenciaAsignatura != null) ? ResponseEntity.ok(competenciaAsignatura) : ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar/asignatura/{asignaturaId}")
    public List<CompetenciaAsignaturaDTORespuesta> listarPorAsignatura(@PathVariable String asignaturaId) {
        return service.listarPorAsignatura(asignaturaId);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CompetenciaAsignaturaDTORespuesta> actualizar(@PathVariable String id,@Valid @RequestBody CompetenciaAsignaturaDTOPeticion dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }
}
