package co.unicauca.ra.controller;
import co.unicauca.ra.model.Asignatura;
import co.unicauca.ra.model.AsignaturaCurso;
import co.unicauca.ra.service.AsignaturaService;
import co.unicauca.ra.service.DTO.AsignaturaRespuestaDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/asignatura")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaCursoService;

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody Asignatura asignatura) {
        return asignaturaCursoService.save(asignatura);
    }

    @GetMapping("/listar")
    public List<AsignaturaRespuestaDTO> findAll() {
        return asignaturaCursoService.findAll();
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> findByNombre(@PathVariable String nombre) {
        return asignaturaCursoService.findByNombre(nombre);
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<?> deleteByNombre(@PathVariable String nombre) {
        return asignaturaCursoService.deleteByNombre(nombre);
    }
}
