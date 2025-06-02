/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package co.unicauca.ra.controller.ExceptionController.Structure;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author ashle
 */
@RequiredArgsConstructor
@Getter
public enum CodigoError {
        ERROR_GENERICO("GC-0001", "ERROR GENERICO"),
        CURSO_YA_EXISTE("GC-0002", "ERROR EL CURSO YA EXISTE"),
        CURSO_NO_ENCONTRADO("GC-0003", "Curso no encontrado"),
        ASIGNATURA_NO_ENCONTRADO("GC-0004", "Asignatura no encontrado"),
        DOCENTE_NO_ENCONTRADO("GC-0005", "Docente no encontrado"),
        VIOLACION_REGLA_DE_NEGOCIO("GC-0006", "Regla de negocio violada");

        private final String codigo;
        private final String llaveMensaje;
}
