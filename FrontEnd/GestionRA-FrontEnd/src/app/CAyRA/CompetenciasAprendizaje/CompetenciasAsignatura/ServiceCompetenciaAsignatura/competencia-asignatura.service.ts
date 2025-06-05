import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CompetenciaAprendizajeA } from '../../../Modelos/competencia-aprendizaje-a';

@Injectable({
  providedIn: 'root'
})
export class CompetenciaAsignaturaService {

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  private urlEndPoint: string = 'http://localhost:8079/api/competenciasAsignatura';

  constructor(private http: HttpClient) { }

  getCompetenciasAsignatura(): Observable<CompetenciaAprendizajeA[]>
  {
    console.log("Listando competencias de asignatura desde el servicio...");
    return this.http.get<CompetenciaAprendizajeA[]>(`${this.urlEndPoint}/listar`);
  }

  create(competenciaA: CompetenciaAprendizajeA): Observable<CompetenciaAprendizajeA>
  {
    competenciaA.estado = "activo";
    console.log("Creando compentencia de asignatura desde el servicio...");
    console.log(competenciaA);
    return this.http.post<CompetenciaAprendizajeA>(`${this.urlEndPoint}/guardar`, competenciaA, { headers: this.httpHeaders });
  }

}
