/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.ra.controller.ExceptionController.Exceptions;

import co.unicauca.ra.controller.ExceptionController.Structure.CodigoError;
import lombok.Getter;

/**
 *
 * @author ashle
 */
@Getter
public class AsignaturaNotFoundException extends RuntimeException {
    private final String llaveMensaje;
    private final String codigo;

    public AsignaturaNotFoundException(CodigoError codigo) {
       super(codigo.getCodigo());
       
       this.llaveMensaje = codigo.getLlaveMensaje();
       this.codigo = codigo.getCodigo();
    }
    
    public AsignaturaNotFoundException(String mensaje) {
       super(mensaje);
       
       this.llaveMensaje = CodigoError.ASIGNATURA_NO_ENCONTRADO.getLlaveMensaje();
       this.codigo = CodigoError.ASIGNATURA_NO_ENCONTRADO.getCodigo();
    }
}
