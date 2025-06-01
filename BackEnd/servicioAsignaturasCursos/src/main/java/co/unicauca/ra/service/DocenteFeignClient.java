/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.unicauca.ra.service;

import co.unicauca.ra.model.Docente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author ashle
 */
@FeignClient(name="docente-service", url="http://localhost:8080/api/docentes")
public interface DocenteFeignClient {
    
    @GetMapping("/buscar-correo/{correo}")
    public Docente findDocenteByCorreo(@PathVariable("correo") String correo);
}
