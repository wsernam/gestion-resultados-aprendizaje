/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.fachadaServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ashle
 */
@Service
public class CursoService {
    @Autowired 
    private CursoFeignClient clienteCurso; 
    
    public Boolean existeCurso(String id) {
        try{
            return clienteCurso.existeCurso(id); 
        }catch(Exception ex){
            System.out.println("Error al consultar servicio cursos");
            return null; 
        }
    }
}
