import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError, catchError } from 'rxjs';
import { CompetenciaAprendizajeA } from '../../../Modelos/competencia-aprendizaje-a';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class CompetenciaAsignaturaService {

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  private urlEndPoint: string = 'http://localhost:8079/api/competenciasAsignatura';

  constructor(private http: HttpClient) { }

  getCompetenciasAsignatura(): Observable<CompetenciaAprendizajeA[]> {
    console.log("Listando competencias de asignatura desde el servicio...");
    return this.http.get<CompetenciaAprendizajeA[]>(`${this.urlEndPoint}/listar`);
  }

  create(competenciaA: CompetenciaAprendizajeA): Observable<CompetenciaAprendizajeA> {
    competenciaA.estado = "activo";
    console.log("Creando compentencia de asignatura desde el servicio...");
    console.log(competenciaA);
    return this.http.post<CompetenciaAprendizajeA>(`${this.urlEndPoint}/guardar`, competenciaA, { headers: this.httpHeaders }).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 400 || error.status === 404) {
      const codigoError = error.error.codigoError;
      const mensajeError = error.error.mensaje;
      const codigoHttp = error.error.codigoHttp;
      const url = error.error.url;
      const metodo = error.error.metodo;

      console.log(`Error ${codigoHttp} en ${metodo} ${url}: ${mensajeError} (Código: ${codigoError})`);

      Swal.fire({
        icon: 'error',
        title: '!Error!',
        text: mensajeError,
        confirmButtonText: 'Cerrar'
      });

      return throwError(() => new Error(mensajeError));
    } else {
      return throwError(() => new Error('Ocurrió un error inesperado.'));
    }
  }

}
