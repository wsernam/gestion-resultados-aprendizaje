package co.unicauca.servicioracompetencias.fachadaServices.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.CompetenciaPrograma;
import co.unicauca.servicioracompetencias.capaAccesoAdatos.repository.CompetenciaAsignaturaRepository;
import co.unicauca.servicioracompetencias.capaAccesoAdatos.repository.CompetenciaProgramaRepository;
import co.unicauca.servicioracompetencias.capaAccesoAdatos.repository.RAProgramaRepository;
import co.unicauca.servicioracompetencias.capaControladores.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.unicauca.servicioracompetencias.capaControladores.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaProgramaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaProgramaDTORespuesta;
import co.unicauca.servicioracompetencias.fachadaServices.mapper.MapeadorCompetenciaPrograma;

@Service
public class CompetenciaProgramaServiceImpl implements ICompetenciaProgramaService {

    @Autowired
    private CompetenciaProgramaRepository competenciaProgramaRepository;
    @Autowired
    private CompetenciaAsignaturaRepository competenciaAsignaturaRepository;
    @Autowired
    private RAProgramaRepository resultadoAprendizajeProgramaRepository;
    @Autowired
    private MapeadorCompetenciaPrograma mapeador;

    @Override
    public CompetenciaProgramaDTORespuesta crear(CompetenciaProgramaDTOPeticion dto) {
        CompetenciaPrograma entity = mapeador.convertirPeticionAEntity(dto);
        return mapeador.convertirEntityARespuesta(competenciaProgramaRepository.save(entity));
    }

    @Override
    public List<CompetenciaProgramaDTORespuesta> listarTodos() {
        System.out.println("Listado competencias de programa");   
        return competenciaProgramaRepository.findAll().stream()
            .map(mapeador::convertirEntityARespuesta)
            .collect(Collectors.toList());
    }

    @Override
    public CompetenciaProgramaDTORespuesta buscarPorId(String id) {
        return competenciaProgramaRepository.findById(id)
            .map(mapeador::convertirEntityARespuesta)
            .orElseThrow(() -> new ReglaNegocioExcepcion("No se encontró  CompetenciaPrograma con ID: " + id));
    }

    @Override
    public void eliminar(String id) {
        boolean usadaEnRA = resultadoAprendizajeProgramaRepository.existsByCompetenciaProgramaId(id);
        boolean usadaEnAsignatura = competenciaAsignaturaRepository.existsByCompetenciaProgramaId(id);

        if (usadaEnRA || usadaEnAsignatura) {
            throw new ReglaNegocioExcepcion("No se puede eliminar la competencia porque está asociada a un RA o asignatura.");
        }
        if (!competenciaAsignaturaRepository.existsById(id)) {
            throw new EntidadNoExisteException("Error: el evaluador externo a eliminar no existe.");
        }
        competenciaAsignaturaRepository.deleteById(id);
    }

    @Override
    public CompetenciaProgramaDTORespuesta actualizar(String id, CompetenciaProgramaDTOPeticion dto) {
        if (!competenciaProgramaRepository.existsById(id)) {
            throw new ReglaNegocioExcepcion("La competencia de programa a actualizar no existe.");
        }

        // Convertir DTO a entidad con el mapeador
        CompetenciaPrograma actualizado = mapeador.convertirPeticionAEntity(dto);
        actualizado.setId(id); // mantener el ID original

        CompetenciaPrograma guardado = competenciaProgramaRepository.save(actualizado);
        return mapeador.convertirEntityARespuesta(guardado);
    }

}
