package co.unicauca.ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.unicauca.ra.model.Docente;
import co.unicauca.ra.service.DocenteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/docentes")
@CrossOrigin(origins = "*")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    // Registrar docente
    @PostMapping("/guardar")
    public ResponseEntity<?> crearDocente(@RequestBody Docente docente) {
        if (docente.getNombres() == null || docente.getNombres().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre del docente no puede estar vacío");
        }
        if (docente.getCorreo() == null || docente.getCorreo().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El correo del docente no puede estar vacío");
        }
        if (docente.getCedula() <= 0) {
            return ResponseEntity.badRequest().body("La cédula del docente no es válida");
        }

        return docenteService.save(docente);
    }

    // Listar todos los docentes
    @GetMapping("/listar")
    public List<Docente> listarDocentes() {
        return docenteService.findAll();
    }

    // Buscar docente por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarDocenteId(@PathVariable String id) {
        Optional<Docente> docente = docenteService.findById(id);
        return docente.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // Buscar por cédula
    @GetMapping("/buscar-cedula/{cedula}")
    public ResponseEntity<?> buscarDocenteCedula(@PathVariable int cedula) {
        return docenteService.findByCedula(cedula); 
    }

    // Buscar por correo
    @GetMapping("/buscar-correo/{correo}")
    public ResponseEntity<?> buscarDocenteCorreo(@PathVariable String correo) {
        return docenteService.findByCorreo(correo);
    }


    // Eliminar docente por ID
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable String id) {
        docenteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

