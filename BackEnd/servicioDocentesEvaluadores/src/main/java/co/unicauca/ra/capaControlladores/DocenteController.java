package co.unicauca.ra.capaControlladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.unicauca.ra.fachadaServices.DTO.DocenteDTOPeticion;
import co.unicauca.ra.fachadaServices.DTO.DocenteDTORespuesta;
import co.unicauca.ra.fachadaServices.DTO.EvaluadorExternoDTORespuesta;
import co.unicauca.ra.fachadaServices.services.IDocenteService;
import co.unicauca.ra.fachadaServices.services.IEvaluadorExternoService;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    @Autowired
    private IDocenteService docenteService;
    
    @Autowired
    private IEvaluadorExternoService evaluadorService; 
    // Registrar docente
    @PostMapping("/guardar")
    public ResponseEntity<DocenteDTORespuesta> guardar(@Valid @RequestBody DocenteDTOPeticion dto) {
        DocenteDTORespuesta creado = docenteService.crear(dto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    // Listar todos los docentes
    @GetMapping("/listar")
    public List<DocenteDTORespuesta> listarTodos() {
        return docenteService.listarTodos();
    }

    // Buscar docente por ID
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DocenteDTORespuesta> actualizar(@PathVariable String id,
                                                          @Valid @RequestBody DocenteDTOPeticion dto) {
        DocenteDTORespuesta actualizado = docenteService.actualizar(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<DocenteDTORespuesta> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(docenteService.buscarPorId(id));
    }

    // Buscar por cédula
    @GetMapping("/buscar-cedula/{cedula}")
    public ResponseEntity<DocenteDTORespuesta> buscarPorCedula(@PathVariable int cedula) {
        return ResponseEntity.ok(docenteService.buscarPorCedula(cedula));
    }

    // Buscar por correo
    @GetMapping("/buscar-correo/{correo}")
    public ResponseEntity<DocenteDTORespuesta> buscarPorCorreo(@PathVariable String correo) {
        return ResponseEntity.ok(docenteService.buscarPorCorreo(correo));
    }

    // Eliminar docente por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) {
        docenteService.eliminar(id);
        return ResponseEntity.ok("Docente eliminado correctamente.");
    }
    
    @PutMapping("/invitar-evaluador/{correoEvaluador}")
    public ResponseEntity invitarEvaluadorACurso(@PathVariable String correoEvaluador, @RequestBody String cursoId){
        EvaluadorExternoDTORespuesta  e = evaluadorService.agregarIdCurso(correoEvaluador, cursoId); 
        return ResponseEntity.status(HttpStatus.OK).body(e); 
    }
}

