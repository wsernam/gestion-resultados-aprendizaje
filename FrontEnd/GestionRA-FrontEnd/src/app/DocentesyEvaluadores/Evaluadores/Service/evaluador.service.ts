import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Evaluador } from '../../Modelos/evaluador';
import Swal from 'sweetalert2';
import { ConsultarCurso } from '../../../AsignaturasyCursos/modelos/consultar-curso';

@Injectable({
  providedIn: 'root'
})
export class EvaluadorService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlEndPoint: string = "http://localhost:8079/api/evaluadores";

  constructor(private http: HttpClient) { }

  getEvaluadores(): Observable<Evaluador[]> {
    console.log("Listando docentes desde el servicio");
    return this.http.get<Evaluador[]>(`${this.urlEndPoint}/listar`);
  }

  getEvaluador(id: string): Observable<Evaluador> {
    console.log("Listando evaluador con id: ", id);
    return this.http.get<Evaluador>(`${this.urlEndPoint}/buscar/${id}`);
  }

  createEvaluador(evaluador: Evaluador): Observable<Evaluador> {
    console.log("Creando evaluador desde el servicio");
    return this.http.post<Evaluador>(`${this.urlEndPoint}/guardar`, evaluador, { headers: this.httpHeaders }).pipe(
      catchError(this.handlerError)
    );
  }

  invitarEvaluador(correo: string): Observable<any> {
    console.log("Invitando evaluador con correo: ", correo);
    return this.http.post<any>(`${this.urlEndPoint}/invitar`, { correo }, { headers: this.httpHeaders }).pipe(
      catchError(this.handlerError)
    );
  }

  getEvaluadorByEmail(correo: string): Observable<Evaluador> {
    console.log("Buscando evaluador por correo: ", correo);
    return this.http.get<Evaluador>(`${this.urlEndPoint}/buscar-correo/${correo}`).pipe(
      catchError(this.handlerError)
    );
  }

  getCursosEvaluador(correo: string): Observable<string[]> {
    console.log("Listando cursos del evaluador con correo: ", correo);
    return this.http.get<string[]>(`${this.urlEndPoint}/buscar-cursos/${correo}`).pipe(
      catchError(this.handlerError)
    );
  }

  private handlerError(error: HttpErrorResponse) {
    if (error.status === 400 || error.status === 404) {
      const codigoError = error.error.codigoError;
      const mensajeError = error.error.mensaje;
      const codigoHttp = error.error.codigoHttp;
      const url = error.error.url;
      const metodo = error.error.metodo;

      console.error(`Error ${codigoHttp} en ${metodo} ${url}: ${mensajeError} (Código: ${codigoError})`);

      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: mensajeError,
        confirmButtonText: 'Cerrar'
      });

      return throwError(() => new Error(mensajeError));
    } else {
      return throwError(() => new Error('Ocurrió un error inesperado'));
    }
  }

}
