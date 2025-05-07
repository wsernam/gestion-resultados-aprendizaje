package co.unicauca.ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.unicauca.ra.model.Docente;
import co.unicauca.ra.service.DocenteService;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/docentes")
@CrossOrigin(origins = "*") // Para permitir peticiones desde Angular
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    // Registrar docente
    @PostMapping
    public ResponseEntity crearDocente(@RequestBody Docente docente) {
        return docenteService.save(docente);
    }

    // Listar todos los docentes
    @GetMapping
    public List<Docente> listarDocentes() {
        return docenteService.findAll();
    }

    // Buscar docente por ID
    @GetMapping("/{id}")
    public Optional<Docente> buscarDocenteId(@PathVariable String id) {
        return docenteService.findById(id);
    }

    @GetMapping("buscar-cedula/{cedula}")
    public ResponseEntity buscarDocenteCedula(@PathVariable int cedula) {
        return docenteService.findByCedula(cedula); 
    }
    
    @GetMapping("buscar-correo/{correo}")
    public ResponseEntity buscarDocenteCorreo(@PathVariable String correo) {
        return docenteService.findByCorreo(correo);
    }
    // Eliminar docente por ID
    @DeleteMapping("/{id}")
    public void eliminarDocente(@PathVariable String id) {
        docenteService.deleteById(id);
    }
}
