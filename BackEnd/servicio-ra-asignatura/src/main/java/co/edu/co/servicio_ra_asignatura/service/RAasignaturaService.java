package co.edu.co.servicio_ra_asignatura.service;

import co.edu.co.servicio_ra_asignatura.model.RAasignatura;
import co.edu.co.servicio_ra_asignatura.repository.RAasignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RAasignaturaService {

    private final RAasignaturaRepository repository;

    public RAasignaturaService(RAasignaturaRepository repository) {
        this.repository = repository;
    }

    public RAasignatura crear(RAasignatura ra) {
        return repository.save(ra);
    }

    public List<RAasignatura> listarTodos() {
        return repository.findAll();
    }

    public List<RAasignatura> listarPorAsignatura(String asignaturaId) {
        return repository.findByAsignaturaId(asignaturaId);
    }

    public Optional<RAasignatura> buscarPorId(String id) {
        return repository.findById(id);
    }

    public void eliminar(String id) {
        repository.deleteById(id);
    }
}