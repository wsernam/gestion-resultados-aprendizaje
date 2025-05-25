package co.unicauca.servicioracompetencias.service;

import org.springframework.stereotype.Service;

import co.unicauca.servicioracompetencias.model.ResultadoAprendizajeAsignatura;
import co.unicauca.servicioracompetencias.repository.ResultadoAprendizajeAsignaturaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadoAprendizajeAsignaturaService {

    private final ResultadoAprendizajeAsignaturaRepository repository;

    public ResultadoAprendizajeAsignaturaService(ResultadoAprendizajeAsignaturaRepository repository) {
        this.repository = repository;
    }

    public ResultadoAprendizajeAsignatura crear(ResultadoAprendizajeAsignatura ra) {
        return repository.save(ra);
    }

    public List<ResultadoAprendizajeAsignatura> findAll() {
        return repository.findAll();
    }

    public List<ResultadoAprendizajeAsignatura> listarPorAsignatura(String asignaturaId) {
        return repository.findByCompetenciaAsignaturaId(asignaturaId);
    }

    public Optional<ResultadoAprendizajeAsignatura> findById(String id) {
        return repository.findById(id);
    }

    public void eliminar(String id) {
        repository.deleteById(id);
    }
}