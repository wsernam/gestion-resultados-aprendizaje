package co.unicauca.ra.servicio_rubricas.capaControlladores.controladorExcepciones.excepcionesPropias;

import co.unicauca.ra.servicio_rubricas.capaControlladores.controladorExcepciones.estructuraExcepciones.CodigoError;
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
