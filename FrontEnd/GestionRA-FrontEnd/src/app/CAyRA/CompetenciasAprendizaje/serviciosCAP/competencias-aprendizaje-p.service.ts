import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { CompetenciasAprendizajeP } from '../../Modelos/competencias-aprendizaje-p';
import { Observable, throwError, catchError } from 'rxjs';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class CompetenciasAprendizajePService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlEndPoint: string = 'http://localhost:8079/api/competenciasPrograma';

  constructor(private http: HttpClient) { }

  getCompetenciasAprendizajeP(): Observable<CompetenciasAprendizajeP[]> {
    return this.http.get<CompetenciasAprendizajeP[]>(`${this.urlEndPoint}/listar`);
    //return this.http.get<CompetenciasAprendizajeP[]>(`${this.urlEndPoint}`);
  }

  create(competenciasAprendizajeP: CompetenciasAprendizajeP): Observable<CompetenciasAprendizajeP> {
    competenciasAprendizajeP.estado = 'activo';
    return this.http.post<CompetenciasAprendizajeP>(`${this.urlEndPoint}/guardar`, competenciasAprendizajeP, { headers: this.httpHeaders }).pipe(
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
