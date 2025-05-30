import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login } from '../Modelo/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  private url = 'http://localhost:8079/api/login';

  constructor(private http:HttpClient) { }

  login(login: Login): Observable<String> {
    console.log("Iniciando sesión desde el servicio");
    return this.http.post(this.url, login, { headers: this.httpHeaders, responseType: 'text'});
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
}
