package co.unicauca.ra.servicio_rubricas.fachadaServices.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.unicauca.ra.servicio_rubricas.capaAcesoAdatos.model.Rubrica;
import co.unicauca.ra.servicio_rubricas.capaAcesoAdatos.repository.RubricaRepository;
import co.unicauca.ra.servicio_rubricas.capaControlladores.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.unicauca.ra.servicio_rubricas.fachadaServices.DTO.RubricaDTOPeticion;
import co.unicauca.ra.servicio_rubricas.fachadaServices.DTO.RubricaDTORespuesta;
import co.unicauca.ra.servicio_rubricas.fachadaServices.mapper.MapeadorRubrica;
/**
 *
 * @author ashle
 */
@Service
public class RubricaServiceImpl implements IRubricaService{
    
    @Autowired
    private RubricaRepository repository;

    @Autowired
    private MapeadorRubrica mapeador;
    
    @Override
    public RubricaDTORespuesta crear(RubricaDTOPeticion dto) {
        Rubrica entity = mapeador.convertirPeticionAEntity(dto);
        Rubrica guardada = repository.save(entity);
        return mapeador.convertirEntityARespuesta(guardada);
    }

    @Override
    public List<RubricaDTORespuesta> listarPorIdCurso(String idCurso) {
        List<Rubrica> lista = repository.findByIdCurso(idCurso);
        return lista.stream()
                .map(mapeador::convertirEntityARespuesta)
                .collect(Collectors.toList());
    }

    @Override
    public RubricaDTORespuesta buscarPorId(String id) {
        return repository.findById(id)
                .map(mapeador::convertirEntityARespuesta)
                .orElseThrow(() -> new EntidadNoExisteException("Error: la rúbrica no existe."));
    }

    @Override
    public void eliminar(String id) {
        if (!repository.existsById(id)) {
            throw new EntidadNoExisteException("Error: la rúbrica a eliminar no existe.");
        }
        repository.deleteById(id);
    }

    @Override
    public RubricaDTORespuesta actualizar(String id, RubricaDTOPeticion dto) {
        if (!repository.existsById(id)) {
            throw new EntidadNoExisteException("Error: la rúbrica no existe.");
        }

        Rubrica existente = repository.findById(id).get();
        existente.setDescripcion(dto.getDescripcion());
        existente.setIdCurso(dto.getIdCurso());
        existente.setIdRaAsignatura(dto.getIdRaAsignatura());
        existente.setPonderado(dto.getPonderado());
        existente.setCriterios(mapeador.convertirPeticionAEntity(dto).getCriterios());

        Rubrica guardada = repository.save(existente);
        return mapeador.convertirEntityARespuesta(guardada);
    }
}
