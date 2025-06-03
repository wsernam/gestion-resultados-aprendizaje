import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Criterio } from '../Modelos/criterio';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CriterioService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlEndPoint: string = 'http://localhost:8079/api/rubricas';

  constructor(private http: HttpClient) { }

  getCriterios(): Observable<Criterio[]>
  {
    console.log("Obteniendo criterios desde el servicio...");
    return this.http.get<Criterio[]>(this.urlEndPoint);
  }

  createCriterio(criterio: Criterio): Observable<Criterio>
  {
    console.log("Creando criterio desde el servicio...");
    return this.http.post<Criterio>(this.urlEndPoint, criterio, {headers: this.httpHeaders});
  }
}
