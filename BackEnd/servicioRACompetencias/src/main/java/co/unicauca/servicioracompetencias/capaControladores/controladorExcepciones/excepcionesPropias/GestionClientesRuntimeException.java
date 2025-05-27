package co.unicauca.servicioracompetencias.capaControladores.controladorExcepciones.excepcionesPropias;

import co.unicauca.servicioracompetencias.capaControladores.controladorExcepciones.estructuraExcepciones.CodigoError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class GestionClientesRuntimeException extends RuntimeException {

  protected CodigoError codigoError;

  public abstract String formatException();
}
