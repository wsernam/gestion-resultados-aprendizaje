import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ResultadoP } from '../resultado-p';


@Injectable({
  providedIn: 'root'
})

export class ResultadoPService {

  private httpHeader = new HttpHeaders({'Content-Type': 'application/json'});
  private urlEndPoint: string = "http://localhost_5000/api/compentecias-programa";

  constructor(private http: HttpClient) { }

  getCompenteciaP(): Observable<ResultadoP[]> {

    console.log("Listando compentencias de programa desde el servicio");
    return this.http.get<ResultadoP[]>(this.urlEndPoint);

  }

  create(competenciaP: ResultadoP): Observable<ResultadoP> {

    console.log("Creando competencia de programa desde el servicio");
    return this.http.post<ResultadoP>(this.urlEndPoint, competenciaP, {headers: this.httpHeader});

  }

}
