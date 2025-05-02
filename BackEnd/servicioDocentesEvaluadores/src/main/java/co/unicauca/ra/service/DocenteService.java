package co.unicauca.ra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import co.unicauca.ra.model.Docente;
import co.unicauca.ra.repository.DocenteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder; 
    // Crear o actualizar un docente
    public ResponseEntity save(Docente docente) {
        try{
            if(docenteRepository.findByCorreo(docente.getCorreo()).isPresent()){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo ya se encuentra registrado"); 
            }
            if(docenteRepository.findByCedula(docente.getCedula()).isPresent()){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("La cedula ya se encuentra registrada"); 
            }
            
            docente.setContrasenia(passwordEncoder.encode(docente.getContrasenia()));
            Docente guardado = docenteRepository.save(docente);
            return ResponseEntity.ok(HttpStatus.CREATED); 
        }catch(Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage()); 
        }
        
    }

    // Listar todos los docentes
    public List<Docente> findAll() {
        return docenteRepository.findAll();
    }

    // Buscar un docente por ID
    public Optional<Docente> findById(String id) {
        return docenteRepository.findById(id);
    }

    // Eliminar un docente por ID
    public void deleteById(String id) {
        docenteRepository.deleteById(id);
    }
    
    public Optional<Docente> findByCorreo(String correo) {
        return docenteRepository.findByCorreo(correo);
    }
    
    public Optional<Docente> findByCedula(int cedula) {
        return docenteRepository.findByCedula(cedula);
    }
}
