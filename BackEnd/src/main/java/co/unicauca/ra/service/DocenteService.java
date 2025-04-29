package co.unicauca.ra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.unicauca.ra.model.Docente;
import co.unicauca.ra.repository.DocenteRepository;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    // Crear o actualizar un docente
    public Docente save(Docente docente) {
        return docenteRepository.save(docente);
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
}
