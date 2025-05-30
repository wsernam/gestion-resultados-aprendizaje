package co.unicauca.ra.servicio_rubricas.capaControlladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.unicauca.ra.servicio_rubricas.fachadaServices.DTO.RubricaDTOPeticion;
import co.unicauca.ra.servicio_rubricas.fachadaServices.DTO.RubricaDTORespuesta;
import co.unicauca.ra.servicio_rubricas.fachadaServices.service.IRubricaService;
import jakarta.validation.Valid;
/**
 *
 * @author ashle
 */
@RestController
@RequestMapping("/api/rubricas")
public class RubricaController {
    
    @Autowired
    private IRubricaService service;

    @PostMapping("/guardar")
    public ResponseEntity<RubricaDTORespuesta> guardar(@Valid @RequestBody RubricaDTOPeticion dto) {
        RubricaDTORespuesta creado = service.crear(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @GetMapping("/listar/curso/{idCurso}")
    public ResponseEntity<List<RubricaDTORespuesta>> listarPorCurso(@PathVariable String idCurso) {
        List<RubricaDTORespuesta> lista = service.listarPorIdCurso(idCurso);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<RubricaDTORespuesta> buscarPorId(@PathVariable String id) {
        RubricaDTORespuesta dto = service.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RubricaDTORespuesta> actualizar(@PathVariable String id,
                                                          @Valid @RequestBody RubricaDTOPeticion dto) {
        RubricaDTORespuesta actualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.ok("Rúbrica eliminada correctamente.");
    }
}
