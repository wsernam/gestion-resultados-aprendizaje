/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.service;

import co.unicauca.ra.configuration.JwtService;
import co.unicauca.ra.model.Credenciales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ashle
 */
@Service
public class LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private DocenteUserDetailsService docenteDetailsService; 
 
    public String loginDocente(String username, String password){
       Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
       username, password)); 
       if(authentication.isAuthenticated()){
           return jwtService.generateToken(docenteDetailsService.loadUserByUsername(username));
       }else{
           throw new UsernameNotFoundException("Usuario y/o contraseña incorrectos"); 
       }
    }
}
