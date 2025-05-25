/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.service;

import co.unicauca.ra.model.Docente;
import co.unicauca.ra.model.EvaluadorExterno;
import co.unicauca.ra.repository.DocenteRepository;
import co.unicauca.ra.repository.EvaluadorRepository;
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
public class EvaluadorUserDetailsService implements UserDetailsService {

    @Autowired
    private EvaluadorRepository evaluadorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<EvaluadorExterno> evaluador = evaluadorRepository.findByCorreo(username.toLowerCase());
        if (!evaluador.isPresent()) {
            throw new UsernameNotFoundException(username);
        } else {

            return User.builder()
                    .username(evaluador.get().getCorreo())
                    .password(evaluador.get().getContrasenia())
                    .roles("EVALUADOR")
                    .build();
        }

    }
}
