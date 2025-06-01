/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.controller.ExceptionController;

import co.unicauca.ra.controller.ExceptionController.Exceptions.AsignaturaNotFoundException;
import co.unicauca.ra.controller.ExceptionController.Exceptions.CursoAlreadyCreatedException;
import co.unicauca.ra.controller.ExceptionController.Exceptions.CursoNotFoundException;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author ashle
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", ex.getMessage()));
    }
    
     @ExceptionHandler(CursoAlreadyCreatedException.class)
    public ResponseEntity<?> handleCursoAlreadyCreated(CursoAlreadyCreatedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", ex.getMessage()));
    }
    
     @ExceptionHandler(CursoNotFoundException.class)
    public ResponseEntity<?> handleCursoNotFound(CursoNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", ex.getMessage()));
    }
    
     @ExceptionHandler(AsignaturaNotFoundException.class)
    public ResponseEntity<?> handleAsignaturaNotFound(AsignaturaNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", ex.getMessage()));
    }
}
