import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login } from '../../Modelos/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  private url = 'http://localhost:8079/api/login';

  constructor(private http:HttpClient) { }

  login(login: Login): Observable<any> {
    console.log("Iniciando sesión desde el servicio");
    return this.http.post(this.url, login, { headers: this.httpHeaders });
  }
}
