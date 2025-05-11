/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package co.unicauca.ra.repository;

import co.unicauca.ra.model.Curso;
import co.unicauca.ra.model.Periodo;
import java.util.List;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author ashle
 */
public interface CursoRepository extends MongoRepository<Curso, String>{
    List<Curso> findByPeriodo(Periodo periodo);
     List<Curso> findByPeriodoAnio(int anio);
    List<Curso> findByAsignaturaNombre(String nombre);
    List<Curso> findByDocenteCedula(int cedula);
    Optional<Curso> findByPeriodoAndAsignaturaNombreAndDocenteCedula(
    Periodo periodo,
    String nombreAsignatura,
    int cedulaDocente
    );
}
