import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CompetenciaP } from '../competencia-p';


@Injectable({
  providedIn: 'root'
})

export class CompetenciaPService {

  private httpHeader = new HttpHeaders({'Content-Type': 'application/json'});
  private urlEndPoint: string = "http://localhost_5000/api/compentecias-programa";

  constructor(private http: HttpClient) { }

  getCompenteciaP(): Observable<CompetenciaP[]> {

    console.log("Listando compentencias de programa desde el servicio");
    return this.http.get<CompetenciaP[]>(this.urlEndPoint);

  }

  create(competenciaP: CompetenciaP): Observable<CompetenciaP> {

    console.log("Creando competencia de programa desde el servicio");
    return this.http.post<CompetenciaP>(this.urlEndPoint, competenciaP, {headers: this.httpHeader});

  }

}
