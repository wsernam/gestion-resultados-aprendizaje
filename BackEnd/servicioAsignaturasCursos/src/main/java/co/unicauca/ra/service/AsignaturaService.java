package co.unicauca.ra.service;

import co.unicauca.ra.model.Asignatura;
import co.unicauca.ra.model.AsignaturaCurso;
import co.unicauca.ra.repository.AsignaturaRepository;
import co.unicauca.ra.service.DTO.AsignaturaRespuestaDTO;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;
    
    @Autowired
    private ModelMapper mapper; 

    public ResponseEntity<?> save(Asignatura asignatura) {
        asignaturaRepository.save(asignatura);
        return ResponseEntity.status(HttpStatus.CREATED).body("Asignatura registrada correctamente.");
    }

    public List<AsignaturaRespuestaDTO> findAll() {
        List<Asignatura> asignaturas = asignaturaRepository.findAll();

        return this.mapper.map(asignaturas, new TypeToken<List<AsignaturaRespuestaDTO>>() {}.getType()); 
    }

    private AsignaturaCurso convertToDTO(Asignatura asignatura) {
        return new AsignaturaCurso(
                asignatura.getNombre(),
                asignatura.getCreditos(),
                asignatura.getObjetivos(),
                asignatura.getSemestre()
        );
    }

    public ResponseEntity<?> deleteByNombre(String nombre) {
        Optional<Asignatura> asignatura = asignaturaRepository.findAll().stream()
                .filter(a -> a.getNombre().equalsIgnoreCase(nombre))
                .findFirst();

        if (asignatura.isPresent()) {
            asignaturaRepository.delete(asignatura.get());
            return ResponseEntity.ok("Asignatura eliminada correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Asignatura no encontrada.");
        }
    }

    public ResponseEntity<?> findByNombre(String nombre) {
        Optional<Asignatura> asignatura = asignaturaRepository.findAll().stream()
                .filter(a -> a.getNombre().equalsIgnoreCase(nombre))
                .findFirst();

        return asignatura
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Asignatura no encontrada."));
    }
}

