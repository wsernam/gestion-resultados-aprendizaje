package co.unicauca.servicioracompetencias.fachadaServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.ResultadoAprendizajeAsignatura;
import co.unicauca.servicioracompetencias.capaAccesoAdatos.repository.ResultadoAprendizajeAsignaturaRepository;
import co.unicauca.servicioracompetencias.capaControladores.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeAsignaturaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeAsignaturaDTORespuesta;
import co.unicauca.servicioracompetencias.fachadaServices.mapper.MapeadorResultadoAprendizajeAsignatura;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultadoAprendizajeAsignaturaServiceImpl implements IResultadoAprendizajeAsignaturaService {

    @Autowired
    private ResultadoAprendizajeAsignaturaRepository repository;
    @Autowired
    private MapeadorResultadoAprendizajeAsignatura mapeador;

    @Override
    public ResultadoAprendizajeAsignaturaDTORespuesta crear(ResultadoAprendizajeAsignaturaDTOPeticion dto) {
        ResultadoAprendizajeAsignatura entity = mapeador.convertirPeticionAEntity(dto);
        return mapeador.convertirEntityARespuesta(repository.save(entity));
    }

    @Override
    public List<ResultadoAprendizajeAsignaturaDTORespuesta> listarTodos() {
        return repository.findAll().stream()
            .map(mapeador::convertirEntityARespuesta)
            .collect(Collectors.toList());
    }

    @Override
    public List<ResultadoAprendizajeAsignaturaDTORespuesta> listarPorAsignatura(String asignaturaId) {
        return repository.findByCompetenciaAsignaturaId(asignaturaId).stream()
            .map(mapeador::convertirEntityARespuesta)
            .collect(Collectors.toList());
    }

    @Override
    public ResultadoAprendizajeAsignaturaDTORespuesta buscarPorId(String id) {
        return repository.findById(id)
            .map(mapeador::convertirEntityARespuesta)
            .orElse(null);
    }

    @Override
    public void eliminar(String id) {
        repository.deleteById(id);
    }

    @Override
    public ResultadoAprendizajeAsignaturaDTORespuesta actualizar(String id, ResultadoAprendizajeAsignaturaDTOPeticion dto) {
        if (!repository.existsById(id)) {
            throw new ReglaNegocioExcepcion("El resultado de aprendizaje a actualizar no existe.");
        }

        ResultadoAprendizajeAsignatura entity = mapeador.convertirPeticionAEntity(dto);
        entity.setId(id); // conservar el ID original

        ResultadoAprendizajeAsignatura guardado = repository.save(entity);
        return mapeador.convertirEntityARespuesta(guardado);
    }

}