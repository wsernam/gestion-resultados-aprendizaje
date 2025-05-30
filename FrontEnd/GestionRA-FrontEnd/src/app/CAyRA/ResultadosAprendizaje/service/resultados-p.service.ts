import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { ResultadoP } from '../../Modelos/resultado-p';


@Injectable({
  providedIn: 'root'
})

export class ResultadoPService {

  private httpHeader = new HttpHeaders({'Content-Type': 'application/json'});
  private urlEndPoint: string = "http://localhost_5000/api/resultados-programa";

  constructor(private http: HttpClient) { }

  getResultadoP(): Observable<ResultadoP[]> {

    console.log("Listando resultados de aprendizaje de programa desde el servicio");
    return this.http.get<ResultadoP[]>(this.urlEndPoint);

  }

  create(resultadoP: ResultadoP): Observable<ResultadoP> {

    console.log("Creando resultados de aprendizaje de programa desde el servicio");
    return this.http.post<ResultadoP>(this.urlEndPoint, resultadoP, {headers: this.httpHeader});

  }

  getCompenteciasP(): Observable<any[]> {

    return of();

  }

}
