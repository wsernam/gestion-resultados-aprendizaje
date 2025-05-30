package co.unicauca.ra.servicio_rubricas.capaControlladores.controladorExcepciones.excepcionesPropias;

import co.unicauca.ra.servicio_rubricas.capaControlladores.controladorExcepciones.estructuraExcepciones.CodigoError;

public class ReglaNegocioExcepcion extends GestionClientesRuntimeException {

  private static final String FORMATO_EXCEPCION = "%s - Violación a regla de negocio: %s";

  private final String reglaNegocio;

  public ReglaNegocioExcepcion(final String reglaNegocio) {
    super(CodigoError.VIOLACION_REGLA_DE_NEGOCIO);
    this.reglaNegocio = reglaNegocio;
  }

  @Override
  public String formatException() {
    return String.format(FORMATO_EXCEPCION, codigoError.getCodigo(), reglaNegocio);
  }
}
