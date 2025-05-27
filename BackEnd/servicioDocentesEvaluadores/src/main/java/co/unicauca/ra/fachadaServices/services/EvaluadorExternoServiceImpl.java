package co.unicauca.ra.fachadaServices.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import co.unicauca.ra.capaAcesoAdatos.model.EvaluadorExterno;
import co.unicauca.ra.capaAcesoAdatos.repository.EvaluadorExternoRepository;
import co.unicauca.ra.capaControlladores.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.unicauca.ra.capaControlladores.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import co.unicauca.ra.fachadaServices.DTO.EvaluadorExternoDTOPeticion;
import co.unicauca.ra.fachadaServices.DTO.EvaluadorExternoDTORespuesta;
import co.unicauca.ra.fachadaServices.mapper.MapeadorEvaluadorExterno;

@Service
public class EvaluadorExternoServiceImpl implements IEvaluadorExternoService{

    @Autowired
    private EvaluadorExternoRepository repository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MapeadorEvaluadorExterno mapeador;

    @Override
    public EvaluadorExternoDTORespuesta crear(EvaluadorExternoDTOPeticion dto) {
        if (repository.findByCorreo(dto.getCorreo()).isPresent()) {
            throw new ReglaNegocioExcepcion("El correo ya se encuentra registrado.");
        }

        EvaluadorExterno entity = mapeador.convertirPeticionAEntity(dto);
        entity.setContrasenia(passwordEncoder.encode(dto.getContrasenia()));
        return mapeador.convertirEntityARespuesta(repository.save(entity));
    }

    @Override
    public EvaluadorExternoDTORespuesta actualizar(String id, EvaluadorExternoDTOPeticion dto) {
        if (!repository.existsById(id)) {
            throw new ReglaNegocioExcepcion("El evaluador externo a actualizar no existe.");
        }

        EvaluadorExterno actualizado = mapeador.convertirPeticionAEntity(dto);
        actualizado.setId(id);
        actualizado.setContrasenia(passwordEncoder.encode(dto.getContrasenia()));

        return mapeador.convertirEntityARespuesta(repository.save(actualizado));
    }

    @Override
    public List<EvaluadorExternoDTORespuesta> listarTodos() {
        return repository.findAll().stream()
                .map(mapeador::convertirEntityARespuesta)
                .collect(Collectors.toList());
    }

     @Override
    public EvaluadorExternoDTORespuesta buscarPorId(String id) {
        return repository.findById(id)
                .map(mapeador::convertirEntityARespuesta)
                .orElseThrow(() -> new ReglaNegocioExcepcion("No se encontró el evaluador externo con ID: " + id));
    }

    @Override
    public void eliminar(String id) {
        if (!repository.existsById(id)) {
            throw new EntidadNoExisteException("Error: el evaluador externo a eliminar no existe.");
        }
        repository.deleteById(id);
    }

}
