import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CompetenciasAprendizajeP } from '../../Modelos/competencias-aprendizaje-p';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CompetenciasAprendizajePService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlEndPoint: string = 'http://localhost:8081/api/competenciasPrograma';
  
  constructor(private http: HttpClient) { }

  getCompetenciasAprendizajeP(): Observable<CompetenciasAprendizajeP[]> {
    return this.http.get<CompetenciasAprendizajeP[]>(`${this.urlEndPoint}/listar`);
  }

  create(competenciasAprendizajeP: CompetenciasAprendizajeP): Observable<CompetenciasAprendizajeP> {
    return this.http.post<CompetenciasAprendizajeP>(`${this.urlEndPoint}/guardar`, competenciasAprendizajeP, { headers: this.httpHeaders });
  }
}
