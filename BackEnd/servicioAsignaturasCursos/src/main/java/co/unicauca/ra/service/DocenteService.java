/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.service;

import co.unicauca.ra.model.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ashle
 */
@Service
public class DocenteService {
    
    @Autowired 
    private DocenteFeignClient docenteCliente; 
    
    public Docente findDocenteByCorreo(String correo) {
        try{
            return docenteCliente.findDocenteByCorreo(correo); 
        }catch(Exception ex){
            System.out.println("Error al consultar servicio docente");
            return null; 
        }
    }
    
}
