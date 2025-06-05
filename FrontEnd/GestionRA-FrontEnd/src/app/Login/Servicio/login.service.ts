import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError, catchError } from 'rxjs';
import { Login } from '../Modelo/login';
import Swal from 'sweetalert2';
import { ErrorRetornado } from '../../Excepciones/error-retornado';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private url = 'http://localhost:8079/api/login';

  constructor(private http: HttpClient) { }

  login(login: Login): Observable<String> {
    console.log("Iniciando sesión desde el servicio");
    return this.http.post(this.url, login, { headers: this.httpHeaders, responseType: 'text' }).pipe(
      catchError(this.handleError)
    );
  }

  logout(): void {
    console.log("Cerrando sesión");
    sessionStorage.clear();
  }

  estaAutenticado(): boolean {
    if (typeof window !== 'undefined' && !!window.sessionStorage && !!sessionStorage.getItem('token')) {
      //console.log("Usuario autenticado");
      //console.log("Token: " + sessionStorage);
      return true;
    }
    return false;
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
