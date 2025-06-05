import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ResultadoA } from '../../Modelos/resultado-a';
import { Observable, throwError, catchError } from 'rxjs';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class ResultadosAService {

  private httpHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlEndPoint: string = "http://localhost:8079/api/RAAsignatura";

  constructor(private http: HttpClient) { }

  create(resultadoA: ResultadoA): Observable<ResultadoA> {
    console.log("Creando resultado de aprendizaje de asignatura desde el servicio");
    return this.http.post<ResultadoA>(`${this.urlEndPoint}/guardar`, resultadoA, { headers: this.httpHeader }).pipe(
      catchError(this.handleError)
    );
  }

  getResultadosA(): Observable<ResultadoA[]> {
    console.log("Listando resultados de aprendizaje de asignatura desde el servicio");
    return this.http.get<ResultadoA[]>(`${this.urlEndPoint}/listar`);
  }

  getResultadosAPorAsignatura(asignaturaId: string): Observable<ResultadoA[]> {
    console.log("Listando resultados de aprendizaje de asignatura por asignatura desde el servicio con ID: ", asignaturaId);
    return this.http.get<ResultadoA[]>(`${this.urlEndPoint}/buscar/asignatura/${asignaturaId}`);
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
