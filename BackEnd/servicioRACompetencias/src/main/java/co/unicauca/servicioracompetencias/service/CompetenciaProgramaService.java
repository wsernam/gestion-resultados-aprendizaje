package co.unicauca.servicioracompetencias.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.unicauca.servicioracompetencias.model.CompetenciaPrograma;
import co.unicauca.servicioracompetencias.repository.CompetenciaProgramaRepository;

@Service
public class CompetenciaProgramaService {

    @Autowired
    private CompetenciaProgramaRepository repo;

    // Guardar una nueva competencia
    public CompetenciaPrograma save(CompetenciaPrograma competencia) {
        return repo.save(competencia);
    }

    // Listar todas las competencias
    public List<CompetenciaPrograma> findAll() {
        return repo.findAll();
    }

    // Buscar competencia por ID
    public Optional<CompetenciaPrograma> findById(String id) {
        return repo.findById(id);
    }

    // Eliminar competencia por ID
    public void deleteById(String id) {
        repo.deleteById(id);
    }
}