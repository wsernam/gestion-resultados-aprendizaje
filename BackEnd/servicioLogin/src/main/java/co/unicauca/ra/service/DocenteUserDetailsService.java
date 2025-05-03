/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.service;

import co.unicauca.ra.model.Docente;
import co.unicauca.ra.repository.DocenteRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ashle
 */
@Service
public class DocenteUserDetailsService implements UserDetailsService {
    
    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Docente> docente = docenteRepository.findByCorreo(username.toLowerCase());
        if (!docente.isPresent()) {
            throw new UsernameNotFoundException(username);
            
        } else {
            if(docente.get().isCoordinador()){
                return User.builder()
                        .username(docente.get().getCorreo())
                        .password(docente.get().getContrasenia())
                        .roles("DOCENTE","COORDINADOR")
                        .build();
            }
            else{
                return User.builder()
                        .username(docente.get().getCorreo())
                        .password(docente.get().getContrasenia())
                        .roles("DOCENTE")
                        .build();
            }
        }
    }
}
