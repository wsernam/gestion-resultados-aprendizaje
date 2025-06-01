/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ashle
 */
@Configuration
public class Mapper {
    @Bean 
    public ModelMapper genearMapper() {
        ModelMapper objMapper= new ModelMapper();
        return objMapper;//El objeto retornado se almacena en el contenedor de Spring
    }
}
