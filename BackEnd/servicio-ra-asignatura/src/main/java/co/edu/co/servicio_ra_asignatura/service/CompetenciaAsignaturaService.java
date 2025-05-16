package co.edu.co.servicio_ra_asignatura.service;

import org.springframework.stereotype.Service;

import co.edu.co.servicio_ra_asignatura.model.CompetenciaAsignatura;
import co.edu.co.servicio_ra_asignatura.repository.CompetenciaAsignaturaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenciaAsignaturaService {

    private final CompetenciaAsignaturaRepository repository;

    public CompetenciaAsignaturaService(CompetenciaAsignaturaRepository repository) {
        this.repository = repository;
    }

    public CompetenciaAsignatura crear(CompetenciaAsignatura comp) {
        return repository.save(comp);
    }

    public List<CompetenciaAsignatura> listarTodos() {
        return repository.findAll();
    }

    public List<CompetenciaAsignatura> listarPorAsignatura(String asignaturaId) {
        return repository.findByAsignaturaId(asignaturaId);
    }

    public Optional<CompetenciaAsignatura> buscarPorId(String id) {
        return repository.findById(id);
    }

    public void eliminar(String id) {
        repository.deleteById(id);
    }
}