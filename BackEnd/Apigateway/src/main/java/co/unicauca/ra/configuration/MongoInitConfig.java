/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.configuration;

/**
 *
 * @author ashle
 */
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import java.util.Map;

@Configuration
public class MongoInitConfig {

    @Bean
    public ApplicationRunner initMongo(MongoTemplate mongoTemplate) {
        return args -> {

            // Solo ejecuta si una colección clave no existe
            if (!mongoTemplate.collectionExists("programas")) {

                // Insertar documentos
                try {
                    mongoTemplate.insert(Map.of(
                            "nombre", "Ingenieria de sistemas",
                            "facultad", "Facultad de Ingenieria Electronica y Telecomunicaciones"
                    ), "programas");

                    var docente = mongoTemplate.insert(Map.of(
                            "nombres", "Monica Alejandra",
                            "apellidos", "Castellanos Mendez",
                            "coordinador", true,
                            "tipo", "Tiempo completo",
                            "cc", 12345678,
                            "titulo", "Ingeniero de sistemas",
                            "correo", "monica@gmail.com",
                            "contrasenia", 12345678
                    ), "docentes");

                    var evaluador = mongoTemplate.insert(Map.of(
                            "nombres", "Ashlee",
                            "apellidos", "Campaz",
                            "correo", "acampaz@gmail.com",
                            "contrasenia", 12345678
                    ), "evaluadores");

                    var asignatura = mongoTemplate.insert(Map.of(
                            "nombre", "Calculo 1",
                            "creditos", 4,
                            "objetivos", "sufrir",
                            "semestre", 1
                    ), "asignaturas");

                    var curso = mongoTemplate.insert(Map.of(
                            "id_asignatura", asignatura.get("_id"),
                            "id_docente", docente.get("_id"),
                            "periodo", Map.of("anio", 2025, "semestre", 2)
                    ), "cursos");

                    var competenciaPrograma = mongoTemplate.insert(Map.of(
                            "descripcion", "Conocer arquitecturas de software",
                            "pograma", "Ingenieria de sistemas",
                            "estado", "activo"
                    ), "competenciasPrograma");

                    var competenciaAsignatura = mongoTemplate.insert(Map.of(
                            "descripcion", "Conocer los atributos de calidad y como se relacionan con las decisiones de arquitectura",
                            "id_asignatura", asignatura.get("_id"),
                            "id_cprograma", competenciaPrograma.get("_id"),
                            "estado", "activo"
                    ), "competenciasAsignatura");

                    mongoTemplate.insert(Map.of(
                            "descripcion", "El estudiante sabe tomar decisiones de arquitectura",
                            "programa", "ingenieria de sistemas",
                            "id_cprograma", competenciaPrograma.get("_id")
                    ), "rasPrograma");

                    mongoTemplate.insert(List.of(Map.of(
                            "descripcion", "El estudiante reconoce la relacion entre atributos de calidad y arquitecturas de software",
                            "id_casignatura", competenciaAsignatura.get("_id")
                    )), "rasAsignatura");

                    mongoTemplate.insert(Map.of(
                            "descripcion", "Realiza propuestas de arquitectura software relacionadas a un contexto dado",
                            "ponderado", 0.5,
                            "citerios", List.of(
                                    Map.of(
                                            "descripcion", "Identifica atributos de calidad",
                                            "niveles", List.of(
                                                    Map.of("descripcion", "Identifica claramente los atributos de calidad de un sistema software dado un contexto.", "nota", 9),
                                                    Map.of("descripcion", "Identifica algunos  atributos de calidad de un sistema software dado un contexto.", "nota", 7),
                                                    Map.of("descripcion", "No identifica los atributos de calidad de un sistema software dado un contexto.", "nota", 0)
                                            )
                                    ),
                                    Map.of(
                                            "descripcion", "Conoce las arquitecturas de software",
                                            "niveles", List.of(
                                                    Map.of("descripcion", "Identifica arquitecturas de software y conoce su estructuras, ventajas y desventajas", "nota", 9),
                                                    Map.of("descripcion", "Identifica algunas arquitecturas de software y conoce su estructuras, ventajas y desventajas", "nota", 7),
                                                    Map.of("descripcion", "No identifica arquitecturas de software y conoce su estructuras, ventajas y desventajas", "nota", 0)
                                            )
                                    )
                            )
                    ), "rubricas");
                } catch (Exception ex) {

                    System.out.println("error: " + ex.getMessage());
                    ex.printStackTrace();
                }
                System.out.println("Base de datos Mongo inicializada correctamente.");
            } else {
                System.out.println(" Base de datos Mongo ya existente. No se inicializó.");
            }
        };
    }
}
