package co.unicauca.ra.service;

import co.unicauca.ra.model.Asignatura;
import co.unicauca.ra.model.AsignaturaCurso;
import co.unicauca.ra.repository.AsignaturaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {

    // Lista temporal para simular persistencia
    private List<AsignaturaCurso> asignaturasCursos = new ArrayList<>();
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public ResponseEntity<?> save(AsignaturaCurso asignaturaCurso) {
        asignaturasCursos.add(asignaturaCurso);
        return ResponseEntity.status(HttpStatus.CREATED).body("AsignaturaCurso registrada correctamente.");
    }

       public List<AsignaturaCurso> findAll() {
        List<Asignatura> asignaturas = asignaturaRepository.findAll();

        return asignaturas.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
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
        boolean removed = asignaturasCursos.removeIf(a -> a.getNombre().equalsIgnoreCase(nombre));
        if (removed) {
            return ResponseEntity.ok("AsignaturaCurso eliminada correctamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("AsignaturaCurso no encontrada.");
    }

    public ResponseEntity<?> findByNombre(String nombre) {
        return asignaturasCursos.stream()
            .filter(a -> a.getNombre().equalsIgnoreCase(nombre))
            .findFirst()
            .<ResponseEntity<?>>map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("No encontrada."));
    }
}
