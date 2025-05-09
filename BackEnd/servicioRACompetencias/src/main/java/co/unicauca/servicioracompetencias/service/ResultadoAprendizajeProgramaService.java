package co.unicauca.servicioracompetencias.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.unicauca.servicioracompetencias.model.ResultadoAprendizajePrograma;
import co.unicauca.servicioracompetencias.repository.ResultadoAprendizajeProgramaRepository;

@Service
public class ResultadoAprendizajeProgramaService {

    @Autowired
    private ResultadoAprendizajeProgramaRepository repository;

    public ResultadoAprendizajePrograma save(ResultadoAprendizajePrograma resultado) {
        return repository.save(resultado);
    }

    public List<ResultadoAprendizajePrograma> findAll() {
        return repository.findAll();
    }

    public Optional<ResultadoAprendizajePrograma> findById(String id) {
        return repository.findById(id);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
