import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { of } from 'rxjs';
import { ResultadoP } from '../../Modelos/resultado-p';
import Swal from 'sweetalert2';


@Injectable({
  providedIn: 'root'
})

export class ResultadoPService {

  private httpHeader = new HttpHeaders({'Content-Type': 'application/json'});
  private urlEndPoint: string = "http://localhost:8079/api/RAPrograma";

  constructor(private http: HttpClient) { }

  getResultadoP(): Observable<ResultadoP[]> {

    console.log("Listando resultados de aprendizaje de programa desde el servicio");
    return this.http.get<ResultadoP[]>(`${this.urlEndPoint}/listar`);

  }

  create(resultadoP: ResultadoP): Observable<ResultadoP> {

    console.log("Creando resultados de aprendizaje de programa desde el servicio");
    return this.http.post<ResultadoP>(`${this.urlEndPoint}/guardar`, resultadoP, { headers: this.httpHeader }).pipe(
      catchError(this.handleError)
    );


  }

  getCompenteciasP(): Observable<any[]> {

    return of();

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
