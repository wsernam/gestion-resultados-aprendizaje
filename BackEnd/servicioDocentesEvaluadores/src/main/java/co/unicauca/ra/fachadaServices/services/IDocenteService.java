package co.unicauca.ra.fachadaServices.services;

import co.unicauca.ra.fachadaServices.DTO.DocenteDTOPeticion;
import co.unicauca.ra.fachadaServices.DTO.DocenteDTORespuesta;

import java.util.List;

public interface IDocenteService {
    DocenteDTORespuesta crear(DocenteDTOPeticion dto);
    DocenteDTORespuesta actualizar(String id, DocenteDTOPeticion dto);
    List<DocenteDTORespuesta> listarTodos();
    DocenteDTORespuesta buscarPorId(String id);
    DocenteDTORespuesta buscarPorCorreo(String correo);
    DocenteDTORespuesta buscarPorCedula(int cedula);
    void eliminar(String id);
}
