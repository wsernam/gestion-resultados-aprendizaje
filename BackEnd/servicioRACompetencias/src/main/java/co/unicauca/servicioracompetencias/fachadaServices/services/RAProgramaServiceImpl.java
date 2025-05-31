package co.unicauca.servicioracompetencias.fachadaServices.services;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.unicauca.servicioracompetencias.capaAccesoAdatos.model.RAPrograma;
import co.unicauca.servicioracompetencias.capaAccesoAdatos.repository.RAProgramaRepository;
import co.unicauca.servicioracompetencias.capaControladores.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.RAProgramaDTOPeticion;
import co.unicauca.servicioracompetencias.fachadaServices.DTO.RAProgramaDTORespuesta;
import co.unicauca.servicioracompetencias.fachadaServices.mapper.MapeadorRAPrograma;

@Service
public class RAProgramaServiceImpl implements IRAProgramaService {

    @Autowired
    private RAProgramaRepository repository;
    @Autowired
    private MapeadorRAPrograma mapeador;

    @Override
    public RAProgramaDTORespuesta crear(RAProgramaDTOPeticion dto) {
        RAPrograma entity = mapeador.convertirPeticionAEntity(dto);
        return mapeador.convertirEntityARespuesta(repository.save(entity));
    }

    @Override
    public List<RAProgramaDTORespuesta> listarTodos() {
        return repository.findAll().stream()
            .map(mapeador::convertirEntityARespuesta)
            .collect(Collectors.toList());
    }

    @Override
    public RAProgramaDTORespuesta buscarPorId(String id) {
        return repository.findById(id)
            .map(mapeador::convertirEntityARespuesta)
            .orElse(null);
    }

    @Override
    public void eliminar(String id) {
        repository.deleteById(id);
    }

    @Override
    public RAProgramaDTORespuesta actualizar(String id, RAProgramaDTOPeticion dto) {
        if (!repository.existsById(id)) {
            throw new ReglaNegocioExcepcion("El resultado de aprendizaje del programa a actualizar no existe.");
        }

        RAPrograma entity = mapeador.convertirPeticionAEntity(dto);
        entity.setId(id); // asegurar que conserve el ID original

        RAPrograma actualizado = repository.save(entity);
        return mapeador.convertirEntityARespuesta(actualizado);
    }
}