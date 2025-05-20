package co.unicauca.ra.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import co.unicauca.ra.model.EvaluadorExterno;
import co.unicauca.ra.repository.EvaluadorExternoRepository;

@Service
public class EvaluadorExternoService {

    @Autowired
    private EvaluadorExternoRepository repository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> save(EvaluadorExterno evaluador) {
        try {
            // Validar si ya existe por correo
            Optional<EvaluadorExterno> existente = repository.findByCorreoInstitucional(evaluador.getCorreoInstitucional());
            if (existente.isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo ya se encuentra registrado");
            }

            // Encriptar contraseña
            evaluador.setContrasenia(passwordEncoder.encode(evaluador.getContrasenia()));

            // Guardar en la base de datos
            EvaluadorExterno guardado = repository.save(evaluador);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardado);

        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body("Error al guardar: " + ex.getMessage());
        }
    }

    public List<EvaluadorExterno> findAll() {
        return repository.findAll();
    }

    public Optional<EvaluadorExterno> findById(String id) {
        return repository.findById(id);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
