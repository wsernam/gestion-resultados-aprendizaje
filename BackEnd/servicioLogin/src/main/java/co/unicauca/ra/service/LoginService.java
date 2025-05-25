/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.service;

import co.unicauca.ra.configuration.JwtService;
import co.unicauca.ra.model.Credenciales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
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
    
    @Qualifier("docenteAuthenticationManager")
    private AuthenticationManager docentAauthenticationManager;
    
    
    @Autowired
    @Qualifier("evaluadorAuthenticationManager")
    private AuthenticationManager evaluadorAuthenticationManager;
    
    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private DocenteUserDetailsService docenteDetailsService; 
 
    @Autowired
    private EvaluadorUserDetailsService evaluadorDetailsService; 
    
    public String loginDocente(String username, String password){
       Authentication authentication = docentAauthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
       username, password)); 
       if(authentication.isAuthenticated()){
           return jwtService.generateToken(docenteDetailsService.loadUserByUsername(username));
       }else{
           throw new UsernameNotFoundException("Usuario y/o contraseña incorrectos"); 
       }
    }
    
    public String loginEvaluador(String username, String password){
       Authentication authentication = evaluadorAuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
       username, password)); 
       if(authentication.isAuthenticated()){
           return jwtService.generateToken(evaluadorDetailsService.loadUserByUsername(username));
       }else{
           throw new UsernameNotFoundException("Usuario y/o contraseña incorrectos"); 
       }
    }
    
    public String login(Credenciales credenciales){
        if(credenciales.getTipo().equals("DOCENTE")){
            return loginDocente(credenciales.getNombreUsuario(), credenciales.getContrasenia());
        }
        if(credenciales.getTipo().equals("EVALUADOR")){
            return loginEvaluador(credenciales.getNombreUsuario(), credenciales.getContrasenia());
        }
        throw new IllegalArgumentException("El tipo no es valido"); 
    }
    
}
