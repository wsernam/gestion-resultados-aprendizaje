import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError, catchError } from 'rxjs';
import { Docente } from '../Modelos/docente';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})

export class DocenteService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlEndPoint: string = "http://localhost:8079/api/docentes";

  constructor(private http: HttpClient) { }

  getDocentes(): Observable<Docente[]> {
    console.log("Listando Docentes desde el servicio");
    return this.http.get<Docente[]>(`${this.urlEndPoint}/listar`);
    //return this.http.get<Docente[]>(this.urlEndPoint);
  }

  create(docente: Docente): Observable<Docente> {
    console.log("Creando docente desde servicio");
    return this.http.post<Docente>(`${this.urlEndPoint}/guardar`, docente, { headers: this.httpHeaders }).pipe(
      catchError(this.handleError)
    );
    //return this.http.post<Docente>(this.urlEndPoint, docente, {headers: this.httpHeaders});
  }

  getDocenteByEmail(correo: string): Observable<Docente> {
    console.log("Obteniendo docente por correo desde servicio");
    return this.http.get<Docente>(`${this.urlEndPoint}/buscar-correo/${correo}`);
  }

  invitarEvaluador(correo: string, cursoId: string): Observable<any> {
    console.log("Invitando evaluador con correo: ", correo);
    return this.http.put<any>(`${this.urlEndPoint}/invitar-evaluador/${correo}`, cursoId, { headers: { 'Content-Type': 'text/plain' } });
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
