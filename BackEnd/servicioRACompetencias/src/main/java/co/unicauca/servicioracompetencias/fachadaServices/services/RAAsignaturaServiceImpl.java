package co.unicauca.servicioracompetencias.fachadaServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.RAAsignatura;
import co.unicauca.servicioracompetencias.capaAccesoAdatos.repository.RAAsignaturaRepository;
import co.unicauca.servicioracompetencias.capaControladores.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.RAAsignaturaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.RAAsignaturaDTORespuesta;
import co.unicauca.servicioracompetencias.fachadaServices.mapper.MapeadorRAAsignatura;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RAAsignaturaServiceImpl implements IRAAsignaturaService {

    @Autowired
    private RAAsignaturaRepository repository;
    @Autowired
    private MapeadorRAAsignatura mapeador;

    @Override
    public RAAsignaturaDTORespuesta crear(RAAsignaturaDTOPeticion dto) {
        RAAsignatura entity = mapeador.convertirPeticionAEntity(dto);
        return mapeador.convertirEntityARespuesta(repository.save(entity));
    }

    @Override
    public List<RAAsignaturaDTORespuesta> listarTodos() {
        return repository.findAll().stream()
            .map(mapeador::convertirEntityARespuesta)
            .collect(Collectors.toList());
    }

    @Override
    public List<RAAsignaturaDTORespuesta> listarPorAsignatura(String asignaturaId) {
        return repository.findByCompetenciaAsignaturaId(asignaturaId).stream()
            .map(mapeador::convertirEntityARespuesta)
            .collect(Collectors.toList());
    }

    @Override
    public RAAsignaturaDTORespuesta buscarPorId(String id) {
        return repository.findById(id)
            .map(mapeador::convertirEntityARespuesta)
            .orElse(null);
    }

    @Override
    public void eliminar(String id) {
        repository.deleteById(id);
    }

    @Override
    public RAAsignaturaDTORespuesta actualizar(String id, RAAsignaturaDTOPeticion dto) {
        if (!repository.existsById(id)) {
            throw new ReglaNegocioExcepcion("El resultado de aprendizaje a actualizar no existe.");
        }

        RAAsignatura entity = mapeador.convertirPeticionAEntity(dto);
        entity.setId(id); // conservar el ID original

        RAAsignatura guardado = repository.save(entity);
        return mapeador.convertirEntityARespuesta(guardado);
    }

}