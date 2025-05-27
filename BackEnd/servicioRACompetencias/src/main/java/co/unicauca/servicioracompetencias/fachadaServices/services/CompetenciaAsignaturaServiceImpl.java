package co.unicauca.servicioracompetencias.fachadaServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.CompetenciaAsignatura;
import co.unicauca.servicioracompetencias.capaAccesoAdatos.repository.CompetenciaAsignaturaRepository;
import co.unicauca.servicioracompetencias.capaControladores.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaAsignaturaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.CompetenciaAsignaturaDTORespuesta;
import co.unicauca.servicioracompetencias.fachadaServices.mapper.MapeadorCompetenciaAsignatura;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetenciaAsignaturaServiceImpl implements ICompetenciaAsignaturaService {

    @Autowired
    private CompetenciaAsignaturaRepository repository;
    @Autowired
    private MapeadorCompetenciaAsignatura mapeador;

    @Override
    public CompetenciaAsignaturaDTORespuesta crear(CompetenciaAsignaturaDTOPeticion dto) {
        CompetenciaAsignatura entity = mapeador.convertirPeticionAEntity(dto);
        return mapeador.convertirEntityARespuesta(repository.save(entity));
    }

    @Override
    public List<CompetenciaAsignaturaDTORespuesta> listarTodos() {
        return repository.findAll().stream()
            .map(mapeador::convertirEntityARespuesta)
            .collect(Collectors.toList());
    }

    @Override
    public List<CompetenciaAsignaturaDTORespuesta> listarPorAsignatura(String asignaturaId) {
        return repository.findByAsignaturaId(asignaturaId).stream()
            .map(mapeador::convertirEntityARespuesta)
            .collect(Collectors.toList());
    }

    @Override
    public CompetenciaAsignaturaDTORespuesta buscarPorId(String id) {
        return repository.findById(id)
            .map(mapeador::convertirEntityARespuesta)
            .orElse(null);
    }

    @Override
    public void eliminar(String id) {
        repository.deleteById(id);
    }

    @Override
    public CompetenciaAsignaturaDTORespuesta actualizar(String id, CompetenciaAsignaturaDTOPeticion dto) {
        //Verificar si existe la entidad por ID
        if (!repository.existsById(id)) {
            throw new EntidadNoExisteException("Error: la competencia asignatura a actualizar no existe");
        }

        //Convertir DTO a entidad (usando mapeador) y mantener el ID
        CompetenciaAsignatura actualizado = mapeador.convertirPeticionAEntity(dto);
        actualizado.setId(id);

        //Guardar y retornar
        CompetenciaAsignatura guardado = repository.save(actualizado);
        return mapeador.convertirEntityARespuesta(guardado);
    }


}