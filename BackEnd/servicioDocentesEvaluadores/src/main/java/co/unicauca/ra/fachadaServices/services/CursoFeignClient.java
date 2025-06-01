/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.ra.fachadaServices.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author ashle
 */
@FeignClient(name="docente-service", url="http://localhost:8085/api/cursos")
public interface CursoFeignClient {
    @GetMapping("/existe-curso/{id}")
    public boolean existeCurso(@PathVariable("id") String id);
}
