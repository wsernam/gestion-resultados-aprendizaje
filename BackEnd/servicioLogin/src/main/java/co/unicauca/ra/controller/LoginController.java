/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.controller;

import co.unicauca.ra.configuration.JwtService;
import co.unicauca.ra.model.Credenciales;
import co.unicauca.ra.service.DocenteUserDetailsService;
import co.unicauca.ra.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ashle
 */
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public ResponseEntity login(@RequestBody Credenciales credenciales) {
        try {
            if (credenciales.getTipo().equals("DOCENTE")) {
                String token =  loginService.loginDocente(credenciales.getNombreUsuario(), credenciales.getContrasenia());
                return ResponseEntity.status(HttpStatus.OK).body(token); 
            }
            if (credenciales.getTipo().equals("EVALUADOR EXTERNO")) {
               return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body("Login evaluador externo no ha sido implementado");
            }
        } catch (Exception ex) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario y/o contraseña incorrectos");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario y/o contraseña incorrectos");
    }
}
