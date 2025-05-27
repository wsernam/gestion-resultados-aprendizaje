package co.unicauca.ra.capaControlladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.ra.fachadaServices.DTO.DocenteDTOPeticion;
import co.unicauca.ra.fachadaServices.DTO.DocenteDTORespuesta;
import co.unicauca.ra.fachadaServices.services.IDocenteService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    @Autowired
    private IDocenteService service;

    // Registrar docente
    @PostMapping("/guardar")
    public ResponseEntity<DocenteDTORespuesta> guardar(@Valid @RequestBody DocenteDTOPeticion dto) {
        DocenteDTORespuesta creado = service.crear(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    // Listar todos los docentes
    @GetMapping("/listar")
    public List<DocenteDTORespuesta> listarTodos() {
        return service.listarTodos();
    }

    // Buscar docente por ID
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DocenteDTORespuesta> actualizar(@PathVariable String id,
                                                          @Valid @RequestBody DocenteDTOPeticion dto) {
        DocenteDTORespuesta actualizado = service.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<DocenteDTORespuesta> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // Buscar por cédula
    @GetMapping("/buscar-cedula/{cedula}")
    public ResponseEntity<DocenteDTORespuesta> buscarPorCedula(@PathVariable int cedula) {
        return ResponseEntity.ok(service.buscarPorCedula(cedula));
    }

    // Buscar por correo
    @GetMapping("/buscar-correo/{correo}")
    public ResponseEntity<DocenteDTORespuesta> buscarPorCorreo(@PathVariable String correo) {
        return ResponseEntity.ok(service.buscarPorCorreo(correo));
    }

    // Eliminar docente por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) {
        service.eliminar(id);
        return ResponseEntity.ok("Docente eliminado correctamente.");
    }
}

