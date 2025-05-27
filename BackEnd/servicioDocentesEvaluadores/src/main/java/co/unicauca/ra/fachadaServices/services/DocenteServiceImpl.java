package co.unicauca.ra.fachadaServices.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.unicauca.ra.capaAcesoAdatos.repository.DocenteRepository;
import co.unicauca.ra.capaControlladores.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.unicauca.ra.capaControlladores.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import co.unicauca.ra.fachadaServices.DTO.DocenteDTOPeticion;
import co.unicauca.ra.fachadaServices.DTO.DocenteDTORespuesta;
import co.unicauca.ra.fachadaServices.mapper.MapeadorDocente;
import co.unicauca.ra.capaAcesoAdatos.model.Docente;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class DocenteServiceImpl implements IDocenteService{

    @Autowired
    private DocenteRepository repository;
    @Autowired
    private  PasswordEncoder passwordEncoder; 
    @Autowired
    private MapeadorDocente mapeador;
    // Crear o actualizar un docente
    @Override
    public DocenteDTORespuesta crear(DocenteDTOPeticion dto) {
        if (repository.findByCorreo(dto.getCorreo()).isPresent()) {
            throw new ReglaNegocioExcepcion("El correo ya se encuentra registrado.");
        }
        if (repository.findByCedula(dto.getCedula()).isPresent()) {
            throw new ReglaNegocioExcepcion("La cédula ya se encuentra registrada.");
        }

        Docente docente = mapeador.convertirPeticionAEntity(dto);
        docente.setContrasenia(passwordEncoder.encode(docente.getContrasenia()));
        return mapeador.convertirEntityARespuesta(repository.save(docente));
    }

    // Listar todos los docentes
    @Override
    public List<DocenteDTORespuesta> listarTodos() {
        return repository.findAll().stream()
                .map(mapeador::convertirEntityARespuesta)
                .collect(Collectors.toList());
    }

    // Buscar un docente por ID
    @Override
    public DocenteDTORespuesta buscarPorId(String id) {
        return repository.findById(id)
                .map(mapeador::convertirEntityARespuesta)
                .orElseThrow(() -> new ReglaNegocioExcepcion("No se encontró el docente con ID: " + id));
    }


    // Eliminar un docente por ID
    @Override
    public void eliminar(String id) {
        if (!repository.existsById(id)) {
            throw new EntidadNoExisteException("Error: el evaluador externo a eliminar no existe.");
        }
        repository.deleteById(id);
    }
    // buscar un docente por correo
   @Override
    public DocenteDTORespuesta buscarPorCorreo(String correo) {
        return repository.findByCorreo(correo)
                .map(mapeador::convertirEntityARespuesta)
                .orElseThrow(() -> new ReglaNegocioExcepcion("No se encontró el docente con correo: " + correo));
    }
    // buscar un docente por cedula
    @Override
    public DocenteDTORespuesta buscarPorCedula(int cedula) {
        return repository.findByCedula(cedula)
                .map(mapeador::convertirEntityARespuesta)
                .orElseThrow(() -> new ReglaNegocioExcepcion("No se encontró el docente con cédula: " + cedula));
    }
    // Actualizar un docente
    @Override
    public DocenteDTORespuesta actualizar(String id, DocenteDTOPeticion dto) {
        if (!repository.existsById(id)) {
            throw new ReglaNegocioExcepcion("El docente a actualizar no existe.");
        }

        Docente actualizado = mapeador.convertirPeticionAEntity(dto);
        actualizado.setId(id);
        actualizado.setContrasenia(passwordEncoder.encode(dto.getContrasenia()));

        return mapeador.convertirEntityARespuesta(repository.save(actualizado));
    }
}
