package co.unicauca.servicioracompetencias.fachadaServices.services;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.ResultadoAprendizajePrograma;
import co.unicauca.servicioracompetencias.capaAccesoAdatos.repository.ResultadoAprendizajeProgramaRepository;
import co.unicauca.servicioracompetencias.capaControladores.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeProgramaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.ResultadoAprendizajeProgramaDTORespuesta;
import co.unicauca.servicioracompetencias.fachadaServices.mapper.MapeadorResultadoAprendizajePrograma;

@Service
public class ResultadoAprendizajeProgramaServiceImpl implements IResultadoAprendizajeProgramaService {

    @Autowired
    private ResultadoAprendizajeProgramaRepository repository;
    @Autowired
    private MapeadorResultadoAprendizajePrograma mapeador;

    @Override
    public ResultadoAprendizajeProgramaDTORespuesta crear(ResultadoAprendizajeProgramaDTOPeticion dto) {
        ResultadoAprendizajePrograma entity = mapeador.convertirPeticionAEntity(dto);
        return mapeador.convertirEntityARespuesta(repository.save(entity));
    }

    @Override
    public List<ResultadoAprendizajeProgramaDTORespuesta> listarTodos() {
        return repository.findAll().stream()
            .map(mapeador::convertirEntityARespuesta)
            .collect(Collectors.toList());
    }

    @Override
    public ResultadoAprendizajeProgramaDTORespuesta buscarPorId(String id) {
        return repository.findById(id)
            .map(mapeador::convertirEntityARespuesta)
            .orElse(null);
    }

    @Override
    public void eliminar(String id) {
        repository.deleteById(id);
    }

    @Override
    public ResultadoAprendizajeProgramaDTORespuesta actualizar(String id, ResultadoAprendizajeProgramaDTOPeticion dto) {
        if (!repository.existsById(id)) {
            throw new ReglaNegocioExcepcion("El resultado de aprendizaje del programa a actualizar no existe.");
        }

        ResultadoAprendizajePrograma entity = mapeador.convertirPeticionAEntity(dto);
        entity.setId(id); // asegurar que conserve el ID original

        ResultadoAprendizajePrograma actualizado = repository.save(entity);
        return mapeador.convertirEntityARespuesta(actualizado);
    }
}