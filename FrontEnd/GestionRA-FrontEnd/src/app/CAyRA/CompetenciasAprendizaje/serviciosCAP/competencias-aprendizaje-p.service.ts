import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CompetenciasAprendizajeP } from '../../Modelos/competencias-aprendizaje-p';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompetenciasAprendizajePService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlEndPoint: string = 'http://localhost:8079/api/competenciasAsignatura';
  
  constructor(private http: HttpClient) { }

  getCompetenciasAprendizajeP(): Observable<CompetenciasAprendizajeP[]> {
    //return this.http.get<CompetenciasAprendizajeP[]>(`${this.urlEndPoint}/listar`);
    return this.http.get<CompetenciasAprendizajeP[]>(`${this.urlEndPoint}`);
  }

  create(competenciasAprendizajeP: CompetenciasAprendizajeP): Observable<CompetenciasAprendizajeP> {
    competenciasAprendizajeP.estado = 'activo';
    return this.http.post<CompetenciasAprendizajeP>(`${this.urlEndPoint}/guardar`, competenciasAprendizajeP, { headers: this.httpHeaders });
  }
}
